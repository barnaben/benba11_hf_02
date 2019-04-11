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
        super.run();
    }

    void eventLog(String s) {

    }

    void requestDock(SpaceShip s) {
        System.out.println("itt");
        s.notify();
    }

    void toDock(SpaceShip s) {

    }
}
