import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class FileWatcher {

    public static void main(String[] args) {

        Integer rand = new Random().nextInt(25);

        String a = "./Test/"+rand+".txt";
        
        File source= new File("./Test/tzdummy.txt");
        File dest = new File(a);


        File file = new File("./Test");
        
        Watcher subject = new Watcher();        
        Folder view = new Folder("./Test");
        view.addObserver(subject);
        view.add(a);
        view.delete();

        try {
            Integer r = new Random().nextInt(25);
        
            view.copyContent(source,new File("./Test/"+r+".txt"));
        }catch(IOException e){
            System.out.println(e);
        }

    
    

   
    
}
}
