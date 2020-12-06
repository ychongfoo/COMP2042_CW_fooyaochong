package game.Models;

import game.Controllers.Actor;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Digit extends Actor {
    private static final String NUM_PATH = RESOURCES + "num/";
    private static final int imgSize =30;

    public Digit(int n, int xpos, int ypos) {
        setImage(new Image(NUM_PATH + n + ".png", imgSize, imgSize, true, true));
        setX(xpos);
        setY(ypos);
    }

    @Override
    public void act(long now) {
        // TODO Auto-generated method stub

    }

}
