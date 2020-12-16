package game.gameplay.actors;

import game.Main;
import game.gameplay.Actor;
import javafx.scene.image.Image;

/**
 * {@code End} contains all the fr
 */
public class End extends Actor {
    private static final String END_PATH = Main.RESOURCES + "end/";
    private static final int imgSize = 70;

    boolean activated;

    public End(int xpos, int ypos) {
        setImage(new Image(END_PATH + "End.png", imgSize, imgSize, true, true));
        setX(xpos);
        setY(ypos);
        this.activated = false;
    }

    public void setEnd() {
        setImage(new Image(END_PATH + "FrogEnd.png", imgSize, imgSize, true, true));
        this.activated = true;
    }


    public boolean isActivated() {
        return activated;
    }

    @Override
    public void act(long now) {
        // TODO Auto-generated method st
    }
}
