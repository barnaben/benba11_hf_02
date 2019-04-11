import java.util.LinkedList;

public class SpaceShip extends Thread {
    String ID;
    int weight;
    int capacity;
    boolean isDocked;
    LinkedList<Passanger> passangers = new LinkedList<>();

    public SpaceShip(String ID, int weight, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
        this.weight = weight;
        this.isDocked = false;
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
            System.out.println(dockID);
            while (dockID.equals("denied")) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dockID = CentralComp.getInstance().requestDock(this.ID, this.weight, this.capacity);

                System.out.println("whileban " + dockID);
            }
            CentralComp.getInstance().toDock(dockID, this);

            //CentralComp.getInstance().toDock(this);
        }

    }


}
