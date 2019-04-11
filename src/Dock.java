public class Dock {
    boolean isFree;
    String ID;

    public Dock(String ID) {
        this.isFree = true;
        this.ID = ID;
    }

    void PMA(Passanger p) {


    }

    void getPassanger(Passanger p) {

    }

    void dockShip(SpaceShip s) {
        s.isDocked = true;
        System.out.println("itt");
    }
}
