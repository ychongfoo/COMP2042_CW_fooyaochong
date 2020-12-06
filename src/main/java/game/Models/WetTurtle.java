package game.Models;

import javafx.scene.image.Image;

import static game.Models.Turtle.*;

public class WetTurtle extends Platform {

    private static Image turtle1;
    private static Image turtle2;
    private static Image turtle3;
    private static Image turtle4;

    boolean sunk = false;

    public WetTurtle(int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        turtle1 = new Image(PLATFORM + "TurtleAnimation1.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle2 = new Image(PLATFORM + "TurtleAnimation2Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle3 = new Image(PLATFORM + "TurtleAnimation3Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle4 = new Image(PLATFORM + "TurtleAnimation4Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        setImage(turtle2);
    }

    @Override
    public void act(long now) {
        super.act(now);
        if (now / 900000000 % 4 == 0) {
            setImage(turtle2);
            sunk = false;
        } else if (now / 900000000 % 4 == 1) {
            setImage(turtle1);
            sunk = false;
        } else if (now / 900000000 % 4 == 2) {
            setImage(turtle3);
            sunk = false;
        } else if (now / 900000000 % 4 == 3) {
            setImage(turtle4);
            sunk = true;
        }
    }

    public boolean isSunk() {
        return sunk;
    }
}
