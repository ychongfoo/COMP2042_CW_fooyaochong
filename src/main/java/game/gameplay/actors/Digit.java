package game.gameplay.actors;

import game.gameplay.Actor;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 * {@code Digit} provides the image of numbers in the game.
 *
 * @see Actor
 */
public class Digit extends Actor{
    /**
     * Path directory to all the digit images.
     */
    private static final String NUM_PATH = RESOURCES + "num/";

    /**
     * Creates a {@code Digit} at the specified coordinates with the specified Sizes.
     *
     * @param n the number to be displayed.
     * @param imgSize the Size of the image to be displayed.
     * @param xpos the x-position of the image to be displayed.
     * @param ypos the y-position of the image to be displayed.
     */
    public Digit(int n,int imgSize, int xpos, int ypos) {
        setImage(new Image(NUM_PATH + n + ".png", imgSize, imgSize, true, true));
        setX(xpos);
        setY(ypos);
    }

    /**
     * @param now Time measured in nanosecond.
     */
    @Override
    public void act(long now) {
    }

}
