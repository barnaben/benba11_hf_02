import java.util.Random;

public class runSpaceX {

    public static void main(String[] args) {
        ISS iss = new ISS();
        CentralComp cc = CentralComp.getInstance();
        cc.setIss(iss);
        String name = "Ship";
        int number = 0;
        long timer = 0;

        while (true) {
            Random random = new Random();
            long time = System.currentTimeMillis();
            if ((time - timer) > (random.nextInt(5000) + 5000)) {
                SpaceShip s = new SpaceShip(name + number, random.nextInt(900) + 100, random.nextInt(90) + 10);
                s.run();
                System.out.println("A " + s.ID + " hajó elindult " + s.weight + " sullyal es " + s.capacity + " emberrel");
                timer = time;
                number++;
            }
        }
    }
}
