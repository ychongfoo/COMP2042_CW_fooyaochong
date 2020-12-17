package game.world.menu;

import game.gameplay.Actor;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 * Provides a custom Button image.
 */
public class myButton extends Actor {
    private static final String OPTIONS_PATH = RESOURCES + "options/";

    /**
     * Creates a {@code Button} image with the specified size and coordinates.
     *
     * @param name the name of the Button image to display
     * @param size the size of the Button image
     * @param xpos the x-position of the Button
     * @param ypos the y-position of the Button
     */
    public myButton(String name, double size, double xpos, double ypos) {
        setImage(new Image(OPTIONS_PATH + name + ".png", size, size, true, true));
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
