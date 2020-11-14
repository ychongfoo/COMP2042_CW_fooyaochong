package game;

import javafx.scene.image.Image;

import static game.Main.resources;

public class Digit extends Actor {
    int dim;
    Image im1;

    @Override
    public void act(long now) {
        // TODO Auto-generated method stub

    }

    public Digit(int n, int dim, int x, int y) {
        im1 = new Image(resources + n + ".png", dim, dim, true, true);
        setImage(im1);
        setX(x);
        setY(y);
    }

}
