package game;

import javafx.scene.image.Image;

import static game.Main.*;

public class Turtle extends Platform {
    public static final String PLATFORM = RESOURCES + "platform/";
    private double speed;
    public static final int TURTLE_SIZE = 140;

    Image turtle1;
    Image turtle2;
    Image turtle3;
    int i = 1;
    boolean bool = true;

    public Turtle(int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        turtle1 = new Image(PLATFORM + "TurtleAnimation1.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle2 = new Image(PLATFORM + "TurtleAnimation2.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle3 = new Image(PLATFORM + "TurtleAnimation3.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        setImage(turtle2);
    }

    @Override
    public void act(long now) {
        super.act(now);
        if (now / 900000000 % 3 == 0) {
            setImage(turtle2);
        } else if (now / 900000000 % 3 == 1) {
            setImage(turtle1);
        } else if (now / 900000000 % 3 == 2) {
            setImage(turtle3);
        }
    }
}
