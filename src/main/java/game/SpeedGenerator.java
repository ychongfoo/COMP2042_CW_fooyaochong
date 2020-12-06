package game;

import java.util.concurrent.ThreadLocalRandom;

public abstract class SpeedGenerator {

    public SpeedGenerator(){
    }

    public static double getSpeed(int level){
//TODO

        switch (level){
            case 1:
                return ThreadLocalRandom.current().nextDouble(0.4, 1 + 1);
            case 2:
                return ThreadLocalRandom.current().nextDouble(0.4, 2 + 1);
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
