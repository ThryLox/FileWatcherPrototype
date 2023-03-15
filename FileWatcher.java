import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class FileWatcher {

    public static void main(String[] args) {

        Integer rand = new Random().nextInt(25); // a ramdom number that will be used as file name

        String a = "./Test/"+rand+".txt";
        
        File source= new File("./Test/tzdummy.txt"); // file from which i will use the text to be added to an empty file
        File dest = new File(a);
        File file = new File("./Test");
        
        Watcher subject = new Watcher();  // creating an observer      
        Folder view = new Folder("./Test");// folder to be observed
        view.addObserver(subject);// adding observer

        view.add(a); // adding a file

        view.delete();// deleting a file

        try {
            Integer r = new Random().nextInt(25);
        
            view.copyContent(source,new File("./Test/"+r+".txt")); //copying  text to a file to confirm a folder size change

        }catch(IOException e){
            System.out.println(e);
        }

    
    

   
    
}
}
