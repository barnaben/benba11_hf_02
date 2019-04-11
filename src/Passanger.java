import java.util.Random;
import java.util.Timer;

public class Passanger extends Thread {
    Random r = new Random();

    @Override
    public void run() {
        try {
            sleep(r.nextInt(40000) + 20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
