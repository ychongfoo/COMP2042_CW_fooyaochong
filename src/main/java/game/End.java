package game;

import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class End extends Actor {
    private static final String END_PATH = RESOURCES + "end/";
    private static final int imgSize = 60;
    boolean activated = false;

    public End(int x, int y) {
        setX(x);
        setY(y);
        setImage(new Image(END_PATH + "End.png", imgSize, imgSize, true, true));
    }

    @Override
    public void act(long now) {
        // TODO Auto-generated method st
    }

    public void setEnd() {
        setImage(new Image(END_PATH + "FrogEnd.png", imgSize, imgSize, true, true));
        activated = true;
    }

    public boolean isActivated() {
        return activated;
    }


}
