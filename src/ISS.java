import java.util.LinkedList;

public class ISS {
    int weightLimit = 2500;
    int currentWeight = 0;
    int guestLimit = 250;
    int currentGuests = 0;
    LinkedList<Passanger> waitRoom = new LinkedList<>();

    void getPassanger(Passanger p) {
        p.run();
    }

    void goHomeRequest(Passanger p) {
        waitRoom.add(p);

    }

    void notifyWaitRoom() {
        waitRoom.notifyAll();
    }

    boolean requestDock(int weight, int pass) {
        return false;
    }
}
