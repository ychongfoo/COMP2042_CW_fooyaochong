package game.Models;

import javafx.scene.image.Image;

import static game.Main.*;

public class Turtle extends Platform {
    public static final String PLATFORM = RESOURCES + "platform/";
    public static final double TURTLE_SIZE = 143;

    Image turtle1;
    Image turtle2;
    Image turtle3;

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
