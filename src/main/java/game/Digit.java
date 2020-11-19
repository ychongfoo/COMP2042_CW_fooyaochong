package game;

import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Digit extends Actor {
    private static final String NUM_PATH = RESOURCES + "num/";
    private static final int imgSize =30;
    Image view;

    public Digit(int n, int dim, int x, int y) {
        view = new Image(NUM_PATH + n + ".png", imgSize, imgSize, true, true);
        setImage(view);
        setX(x);
        setY(y);
    }

    @Override
    public void act(long now) {
        // TODO Auto-generated method stub

    }

}
