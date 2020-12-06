package game.Models;

import game.Controllers.Actor;
import javafx.scene.image.Image;

import static game.Main.*;

public class Bg extends Actor {
    private static final String BG = RESOURCES + "bg/";

    public Bg(String imgName) {
        setImage(new Image(BG + imgName, CANVAS_WIDTH, CANVAS_HEIGHT, true, true));
        setX(0);
        setY(0);
    }

    @Override
    public void act(long now) {


    }

}
