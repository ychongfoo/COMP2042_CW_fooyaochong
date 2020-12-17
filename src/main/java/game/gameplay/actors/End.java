package game.gameplay.actors;

import game.Main;
import game.gameplay.Actor;
import javafx.scene.image.Image;

/**
 * {@code End} provides the Home images for when the {@link Animal}(Frog) reaches the end point.
 *
 * @see Animal
 * @see Actor
 */
public class End extends Actor {
    private static final String END_PATH = Main.RESOURCES + "end/";
    private static final int imgSize = 60;

    boolean activated;

    /**
     * The constructor {@code End} is instantiated at the beginning for all Ends.
     *
     * @param xpos sets the x position of each End.
     * @param ypos sets the y position of each End.
     */
    public End(int xpos, int ypos) {
        setImage(new Image(END_PATH + "End.png", imgSize, imgSize, true, true));
        setX(xpos);
        setY(ypos);
        this.activated = false;
    }

    /**
     * {@code setEnd} sets the image of the Frog in its Home.
     */
    public void setEnd() {
        setImage(new Image(END_PATH + "FrogEnd.png", imgSize + 10, imgSize + 10, true, true));
        this.activated = true;
    }


    /**
     * @return True when one of the Ends is filled.
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * Empty act method. Used to start animationTimer.
     *
     * @param now Time measured in nanoseconds.
     */
    @Override
    public void act(long now) {
    }
}
