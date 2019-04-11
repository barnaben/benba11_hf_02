import java.util.Random;

class CentralComp extends Thread {
    ISS iss;

    private CentralComp() {
    }

    private static CentralComp instance = null;

    public static synchronized CentralComp getInstance() {
        if (instance == null) {
            instance = new CentralComp();
        }
        return instance;
    }

    public void setIss(ISS iss) {
        this.iss = iss;
    }

    @Override
    public void run() {
        String name = "Ship";
        int number = 0;
        long timer = 0;

        while (true) {
            Random random = new Random();
            long time = System.currentTimeMillis();
            if ((time - timer) > (random.nextInt(5000) + 5000)) {
                SpaceShip s = new SpaceShip(name + number, random.nextInt(900) + 100, random.nextInt(90) + 10);
                s.run();
                String str = "A " + s.ID + " hajó elindult " + s.weight + " sullyal es " + s.capacity + " emberrel";
                CentralComp.getInstance().eventLog(str);
                timer = time;
                number++;
            }
        }
    }

    void eventLog(String s) {
        synchronized (this) {
            System.out.println(s);
        }
    }

    String requestDock(String ID, int weight, int cap) {
        eventLog(ID + " várakozik dokkoláshoz");
        String str = iss.requestDock(weight, cap);
        return str;
    }

    void toDock(String ID) {

    }
}
