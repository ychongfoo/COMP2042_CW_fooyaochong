package game.Views;

import game.Models.Log;
import game.Models.Turtle;
import game.Models.WetTurtle;
import game.SpeedGenerator;

public class LevelEight extends LevelGenerator {

    public LevelEight(int level) {
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

/*        nextLevel= new myButton("arrow", 41, 550,10);
        nextLevel.setOnMouseClicked(event ->{
//            Director.level2();
        });

        add(nextLevel);*/


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


    }
}
