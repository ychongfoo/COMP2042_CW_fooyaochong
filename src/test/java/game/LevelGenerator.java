package game;

public class LevelGenerator extends World{
    private static myButton nextLevel;

    @Override
    public void act(long now) {
    }

    public LevelGenerator(int level){
        //TODO
        double Level1_Log_Speed= SpeedGenerator.getSpeed(1);
        double Level1_WetTurtle_Speed= SpeedGenerator.getSpeed(1);
        double Level1_Turtle_Speed= SpeedGenerator.getSpeed(1);
        double Level1_Car_Speed= SpeedGenerator.getSpeed(1);
        double Level1_Truck_Speed= SpeedGenerator.getSpeed(1);


        add(new Bg("frogger_bg.png"));
        switch (level){
            case 1:
                nextLevel= new myButton("arrow", 41, 550,10);
                nextLevel.setOnMouseClicked(event ->{
                    Director.level2();
                });

                add(nextLevel);


                add(new Log("short", 0, 160, Level1_Log_Speed));
                add(new Log("short", 250, 160, Level1_Log_Speed));
                add(new Log("short", 440, 160, Level1_Log_Speed));

                add(new WetTurtle(150, 210,Level1_WetTurtle_Speed));
                add(new WetTurtle(400, 210,Level1_WetTurtle_Speed));
                add(new WetTurtle(575, 210,Level1_WetTurtle_Speed));

                add(new Log("long", 250, 275, Level1_Log_Speed));
                break;
            case 2:
                //TODO finish the cases
                add(new Log("short", 300, 160, 1));
                add(new WetTurtle(150, 220,-2));
                add(new Log("long", 250, 280, SpeedGenerator.getSpeed(2)));
                break;
            case 3:
            case 4:
            case 5:

        }
        start();
    }
}
