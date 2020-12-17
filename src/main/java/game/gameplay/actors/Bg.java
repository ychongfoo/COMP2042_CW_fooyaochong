package game.gameplay.actors;

import game.gameplay.Actor;
import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.Main.*;

/**
 *{@code Bg} provides a background image that fits the application window.
 *
 * @see Actor
 */
public class Bg extends Actor {
    /**
     * Path directory of all the Backgrounds.
     */
    private static final String BG = RESOURCES + "bg/";

    /**
     * Creates a new background image to display in the scene.
     *
     * @param imgName name of the image to be displayed. File extension should be included.
     */
    public Bg(String imgName) {
        setImage(new Image(BG + imgName, CANVAS_WIDTH, CANVAS_HEIGHT, true, true));
        setX(0);
        setY(0);
    }

    /**
     * A method that calls every frame.
     *
     * @param now Time measured in nanosecond.
     */
    @Override
    public void act(long now) {
    }
}
