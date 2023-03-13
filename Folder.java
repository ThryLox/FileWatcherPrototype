import java.util.Observable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Folder extends Observable {


      public File file;
      public long size;

      Folder(String dir){

       file  = new File(dir);

       long length = 0;
      for (File file : file.listFiles()) {
          if (file.isFile())
              length += file.length();     
     
      }
         this.size = length;

      }

      public File getFile(){
        return this.file;
      }

      public long getSize() {
        
        
        return this.size;}

     
     public void add(String a){   
      
      
      try {
         File myObj = new File(a);
         if (myObj.createNewFile()) {
           

        setChanged();  
        notifyObservers("File" + a + "Added");
       
         } else {
           System.out.println("File already exists.");

           
         }
       } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }       
        
       this.folderSize(file);

     } 

     public void delete(){   
      
      

       File f = file.listFiles()[0]; 
  if (f.delete()) { 
   setChanged();  
      notifyObservers("File" + f + "Deleted");

     
  } else {
   System.out.println("Failed to delete the file.");
  } 
  this.folderSize(this.file); 
}        
        
   
     
  public void folderSize(File directory) {
      
      long length = 0;
      for (File file : directory.listFiles()) {
          if (file.isFile())
              length += file.length();     
     
      }

      if(length != size){
         size = length;
         setChanged();
         notifyObservers("Folder Size Changed" );
      }
      
    
   }

   public void copyContent(File sour,File dest) throws IOException {
    Files.copy(sour.toPath(), dest.toPath());
    folderSize(this.file);

}
}


