package game;

import java.util.concurrent.ThreadLocalRandom;

public class SpeedGenerator {

    public SpeedGenerator(){
    }

    public static double getSpeed(int level){
//TODO

        switch (level){
            case 1:
                double level1Speed = /*(double)SignedIntGenerator() **/ ThreadLocalRandom.current().nextDouble(0.4, 1 + 1);
                return level1Speed;
            case 2:
                break;
            default:
                break;
        }
        return 0;
    }

/*    public static int SignedIntGenerator(){
        int SignedNumberGenerator = ThreadLocalRandom.current().nextInt(-2,1 + 1);
        if (SignedNumberGenerator == 0 || SignedNumberGenerator == -2){
            SignedNumberGenerator++;
        }
        return  SignedNumberGenerator;
    }*/
}
