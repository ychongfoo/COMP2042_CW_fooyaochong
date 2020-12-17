package game.gameplay.actors;

import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 * {@code Turtle} provides a Turtle image platform that swims for the Frogger to jump on in the game.
 */
public class Turtle extends Platform {
    /**
     * Path directory to all the platform images.
     */
    public static final String PLATFORM = RESOURCES + "platform/";
    /**
     * A constant of the turtle size.
     */
    public static final double TURTLE_SIZE = 143;

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
     * Creates a {@code Turtle} at the specified coordinates with the specified speed.
     *
     * @param xpos the x-position of the turtle.
     * @param ypos the y-position of the turtle.
     * @param speed the speed of the turtle.
     */
    public Turtle(int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        turtle1 = new Image(PLATFORM + "TurtleAnimation1.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle2 = new Image(PLATFORM + "TurtleAnimation2.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        turtle3 = new Image(PLATFORM + "TurtleAnimation3.png", TURTLE_SIZE, TURTLE_SIZE, true, true);
        setImage(turtle2);
    }

    /**
     * Plays the animation of the turtle instances by setting the display image.
     * Called every frame.
     *
     * @param now Time measured in nanoseconds.
     */
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
