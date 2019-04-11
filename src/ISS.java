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
    ArrayList<Dock> docks = new ArrayList<>();

    void ISS() {
        for (int i = 0; i < 5; i++) {
            String str = ("Dock" + (i + 1));
            docks.add(new Dock(str));
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
        System.out.println(weightLimit - currentWeight + " " + weight);
        System.out.println(guestLimit - currentGuests + " " + pass);
        System.out.println(dock.equals("denied"));
        if (((weightLimit - currentWeight) >= weight) && ((guestLimit - currentGuests) >= pass) && !dock.equals("denied")) {
            System.out.println("van jó");
            return dock;
        }
        return "denied";
    }

    String checkDocks() {
        System.out.println("checkDock");
        for (Dock d : docks
        ) {
            if (d.isFree == true) {
                return d.ID;
            }

        }
            return "denied";
        }


    void toDock(String ID, SpaceShip s) {
        for (Dock d : docks) {
            if (d.ID.equals(ID)) {
                {
                    System.out.println("itt ISS");
                    d.dockShip(s);
                }

            }
        }
    }
}
