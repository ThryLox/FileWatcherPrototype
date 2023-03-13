
import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer{   

   

    @Override
    public void update(Observable o, Object message) {

        System.out.println("File Changed");
        System.out.println(message);
        // TODO Auto-generated method stub

    }


}