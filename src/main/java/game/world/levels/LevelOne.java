package game.world.levels;

import game.gameplay.actors.*;

/**
 * First Level of the game
 */
public class LevelOne extends LevelGenerator {

    public LevelOne(int level) {
        super(level);

        double Log1_Speed = -SpeedGenerator.getSpeed(level);
        double Log2_Speed = SpeedGenerator.getSpeed(level);
        double Log3_Speed = -SpeedGenerator.getSpeed(level);
        double WetTurtle_Speed = SpeedGenerator.getSpeed(level);
        double Turtle_Speed = -SpeedGenerator.getSpeed(level);
        double Car1_Speed = -SpeedGenerator.getSpeed(level);
        double Car2_Speed = -SpeedGenerator.getSpeed(level);
        double Car3_Speed = -SpeedGenerator.getSpeed(level);
        double Truck1_Speed = SpeedGenerator.getSpeed(level);
        double Truck2_Speed = SpeedGenerator.getSpeed(level);

        add(new Digit(level, 25, 210, 29));
        add(new Log("short", 0, ROW1 + LOG_PADDING, Log1_Speed));
        add(new Log("short", 250, ROW1 + LOG_PADDING, Log1_Speed));
        add(new Log("short", 440, ROW1 + LOG_PADDING, Log1_Speed));

        add(new WetTurtle(150, ROW2, WetTurtle_Speed));
        add(new WetTurtle(400, ROW2, WetTurtle_Speed));
        add(new WetTurtle(575, ROW2, WetTurtle_Speed));

        add(new Log("long", 0, ROW3 + LOG_PADDING, Log2_Speed));
        add(new Log("long", 400, ROW3 + LOG_PADDING, Log2_Speed));

        add(new Log("medium", 0, ROW4 + LOG_PADDING, Log3_Speed));
        add(new Log("medium", 250, ROW4 + LOG_PADDING, Log3_Speed));
        add(new Log("medium", 555, ROW4 + LOG_PADDING, Log3_Speed));

        add(new Turtle(70, ROW5, Turtle_Speed));
        add(new Turtle(322, ROW5, Turtle_Speed));
        add(new Turtle(505, ROW5, Turtle_Speed));

        add(new Car(0, ROW6 + CAR_PADDING, Car1_Speed));
        add(new Car(150, ROW6 + CAR_PADDING, Car1_Speed));
        add(new Car(400, ROW6 + CAR_PADDING, Car1_Speed));

        add(new Car(75, ROW7 + CAR_PADDING, Car2_Speed));
        add(new Car(231, ROW7 + CAR_PADDING, Car2_Speed));
        add(new Car(400, ROW7 + CAR_PADDING, Car2_Speed));

        add(new Truck("short", 50, ROW8 + CAR_PADDING, Truck1_Speed));
        add(new Truck("short", 300, ROW8 + CAR_PADDING, Truck1_Speed));

        add(new Car(0, ROW9 + CAR_PADDING, Car3_Speed));
        add(new Car(150, ROW9 + CAR_PADDING, Car3_Speed));
        add(new Car(400, ROW9 + CAR_PADDING, Car3_Speed));

        add(new Truck("long", 500, ROW10 + CAR_PADDING, Truck2_Speed));
        add(new Truck("long", 230, ROW10 + CAR_PADDING, Truck2_Speed));

    }
}
