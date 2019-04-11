import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ISS {
    int weightLimit = 2500;
    int currentWeight = 0;
    int guestLimit = 250;
    int currentGuests = 0;
    LinkedList<Passanger> waitRoom = new LinkedList<>();
    Dock[] docks;

    void ISS() {
        for (int i = 0; i < 5; i++) {
            String str = "Dock" + (i + 1);
            docks[i] = new Dock(str);
        }
    }

    void getPassanger(Passanger p) {
        p.run();
    }

    void goHomeRequest(Passanger p) {
        waitRoom.add(p);

    }

    void notifyWaitRoom() {
        waitRoom.notifyAll();
    }

    String requestDock(int weight, int pass) {
        String dock = checkDocks();
        if ((weightLimit - currentWeight) >= weight && (guestLimit - currentGuests) >= pass && dock != null) {
            return dock;
        }
        return null;
    }

    String checkDocks() {
        for (int i = 0; i < 5; i++) {
            if (docks[i].isFree == true) {
                {
                    return docks[i].ID;
                }

            }
        }
        return null;
    }
}
