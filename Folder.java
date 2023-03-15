import java.util.Observable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Folder extends Observable {


      public File file;
      public long size;

      Folder(String dir){

       file  = new File(dir);
       // getting original folder size
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
        
        return this.size;
      }

      // add a file to the folder being observed, the observer will be notified 

     public void add(String a){ 
      
      
      try {
         File myObj = new File(a);
         if (myObj.createNewFile()) {           

        setChanged(); // setting the change before notifyng the observer  
        notifyObservers("File "  + a + " Added");
       
         } else {
           System.out.println("File already exists.");

           
         }
       } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }       
        
       this.folderSize(file); // checking the size after file addition so that a size change can be notified

     } 
 // delete teh first file in the folder 
     public void delete(){    
      

       File f = file.listFiles()[0]; 
       if (f.delete()) { 
        // set chaneg and notify
       setChanged();  
       notifyObservers("File " + f + " Deleted ");

     
      } else {
       System.out.println("Failed to delete the file.");
      } 
      this.folderSize(this.file); 
}        
        
   
     
  public void folderSize(File directory) {

    // measure forlder size
      
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
   // to test if the folder size change notification works I used this method to add text to a file

   public void copyContent(File sour,File dest) throws IOException {

    Files.copy(sour.toPath(), dest.toPath());
    folderSize(this.file);

}
}


