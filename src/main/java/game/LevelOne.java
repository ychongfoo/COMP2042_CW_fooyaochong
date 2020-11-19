package game;

public class LevelOne extends World{
    private static final int PADDING = 5;
    @Override
    public void act(long now) {

    }

    public LevelOne(){
        add(new Bg("frogger_bg.png"));
        add(new Log("short", 300, 155+ PADDING, 1));
        add(new WetTurtle(150, 215 +PADDING,-1,130,130));
        add(new Log("long", 250, 275+PADDING, 0.8));
    }
}
