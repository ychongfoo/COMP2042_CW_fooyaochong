package game.world.levels;

import java.util.concurrent.ThreadLocalRandom;

/**
 * {@code SpeedGenerator} is an abstract class that generates the speed responsible for each level.
 */
public abstract class SpeedGenerator {

    public SpeedGenerator() {
    }

    /**
     * @param level that takes in integer Level as parameter.
     * @return the randomly generated speed in the specified range for each levels.
     */
    public static double getSpeed(int level) {

        return switch (level) {
            case 1 -> ThreadLocalRandom.current().nextDouble(0.4, 1 + 1);
            case 2 -> ThreadLocalRandom.current().nextDouble(0.9, 1.5 + 1);
            case 3 -> ThreadLocalRandom.current().nextDouble(1.1, 1.8 + 1);
            case 4 -> ThreadLocalRandom.current().nextDouble(1.4, 2.0 + 1);
            case 5 -> ThreadLocalRandom.current().nextDouble(1.8, 2.4 + 1);
            case 6 -> ThreadLocalRandom.current().nextDouble(2.0, 3 + 1);
            case 7 -> ThreadLocalRandom.current().nextDouble(2.2, 3.5 + 1);
            case 8 -> ThreadLocalRandom.current().nextDouble(2.2, 4 + 1);
            case 9 -> ThreadLocalRandom.current().nextDouble(2.2, 4.5 + 1);
            case 10 -> ThreadLocalRandom.current().nextDouble(2.2, 5 + 1);
            default -> 0;
        };
    }

}
