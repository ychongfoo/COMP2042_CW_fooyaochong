package game;

public class LevelOne extends LevelGenerator{

    private static final int level = 1;
//    private static final myButton nextLevel;

    protected LevelOne(){

        double Log1_Speed= -SpeedGenerator.getSpeed(level);
        double Log2_Speed= SpeedGenerator.getSpeed(level);
        double Log3_Speed= -SpeedGenerator.getSpeed(level);
        double WetTurtle_Speed= SpeedGenerator.getSpeed(level);
        double Turtle_Speed= -SpeedGenerator.getSpeed(level);
        double Car_Speed= -SpeedGenerator.getSpeed(level);
        double Truck_Speed= SpeedGenerator.getSpeed(level);

/*        nextLevel= new myButton("arrow", 41, 550,10);
        nextLevel.setOnMouseClicked(event ->{
//            Director.level2();
        });

        add(nextLevel);*/


        add(new Log("short", 0, 160, Log1_Speed));
        add(new Log("short", 250, 160, Log1_Speed));
        add(new Log("short", 440, 160, Log1_Speed));

        add(new WetTurtle(150, 210 ,WetTurtle_Speed));
        add(new WetTurtle(400, 210 ,WetTurtle_Speed));
        add(new WetTurtle(575, 210 ,WetTurtle_Speed));

        add(new Log("long", 0, 266, Log2_Speed));
        add(new Log("long", 400, 266, Log2_Speed));

        add(new Log("medium", 0, 319, Log3_Speed));
        add(new Log("medium", 250, 319, Log3_Speed));
        add(new Log("medium", 555, 319, Log3_Speed));

        add(new Turtle(70, 372, Turtle_Speed));
        add(new Turtle(322, 372, Turtle_Speed));
        add(new Turtle(505, 372, Turtle_Speed));

        add(new Car(0, 485, Car_Speed));
    }
}
