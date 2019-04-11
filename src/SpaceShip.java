import java.util.LinkedList;

public class SpaceShip extends Thread {
    String ID;
    int weight;
    int capacity;
    LinkedList<Passanger> passangers = new LinkedList<>();

    public SpaceShip(String ID, int weight, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
        this.weight = weight;
        getPassanger(capacity);
    }

    public void getPassanger(int n) {
        for (int i = 0; i < n; i++) {
            passangers.add(new Passanger());
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            String dockID = CentralComp.getInstance().requestDock(this.ID, this.weight, this.capacity);
            while (dockID == null) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dockID = CentralComp.getInstance().requestDock(this.ID, this.weight, this.capacity);
            }


            //CentralComp.getInstance().toDock(this);
        }

    }


}
