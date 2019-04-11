import java.util.Random;

public class runSpaceX {

    public static void main(String[] args) {
        ISS iss = new ISS();
        CentralComp cc = CentralComp.getInstance();
        cc.setIss(iss);
        cc.run();
    }
}
