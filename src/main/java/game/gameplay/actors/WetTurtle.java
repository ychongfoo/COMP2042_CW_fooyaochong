package game.gameplay.actors;

import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.gameplay.actors.Turtle.PLATFORM;
import static game.gameplay.actors.Turtle.TURTLE_SIZE;

/**
 * {@code WetTurtle} provides a WetTurtle image platform that swims and sinks for the Frogger to jump on when its floating in the game.
 */
public class WetTurtle extends Platform {
    /**
     * An instance to store the image of the turtle frame.
     */
    private static Image turtle1;
    /**
     * An instance to store the image of the turtle frame.
     */
    private static Image turtle2;
    /**
     * An instance to store the image of the turtle frame.
     */
    private static Image turtle3;
    /**
     * An instance to store the image of the turtle frame.
     */
    private static Image turtle4;

    /**
     * Initialization of sunk to be false.
     */
    private boolean sunk = false;

    /**
     * Creates a {@code WetTurtle} that sinks and rises at the specified coordinate and the specified speed.
     *
     * @param xpos the x-position of the WetTurtle
     * @param ypos the y-position of the WetTurtle
     * @param speed the speed of the WetTurtle
     */
    public WetTurtle(int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        turtle1 = new Image(PLATFORM + "TurtleAnimation1.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle2 = new Image(PLATFORM + "TurtleAnimation2Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle3 = new Image(PLATFORM + "TurtleAnimation3Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle4 = new Image(PLATFORM + "TurtleAnimation4Wet.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        setImage(turtle2);
    }

    /**
     * Plays the animation of the WetTurtle instances by setting the display image.
     * Called every frame.
     *
     * @param now Time measured in nanoseconds.
     */
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

    /**
     * @return true if the Turtle is sunk and false when its not.
     */
    public boolean isSunk() {
        return sunk;
    }
}
