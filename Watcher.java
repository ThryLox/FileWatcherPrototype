
import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer{   

   
    // implemented the observer class
    @Override
    public void update(Observable o, Object message) {

        System.out.println("FILE CHANGED");
        System.out.println(message);
       
    }


}