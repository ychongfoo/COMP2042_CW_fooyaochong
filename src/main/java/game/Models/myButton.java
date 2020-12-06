package game.Models;

import game.Controllers.Actor;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class myButton extends Actor {
    private static final String OPTIONS_PATH = RESOURCES + "options/";

    public myButton(String name, double size, double xpos, double ypos) {
        setImage(new Image(OPTIONS_PATH + name + ".png", size, size, true, true));
        setX(xpos);
        setY(ypos);
    }

    @Override
    public void act(long now) {

    }
}
