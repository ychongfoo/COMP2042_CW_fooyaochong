package game.gameplay.actors;

import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Log extends Platform {
    private static final String LOG_PATH = RESOURCES + "platform/log_";
    private static final double LOG_SHORT = 151.2;
    private static final double LOG_MEDIUM = 210.6;
    private static final double LOG_LONG = 320.4;

    public Log(String type, int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        switch (type) {
            case "short" -> setImage(new Image(LOG_PATH + "short.png", LOG_SHORT, LOG_SHORT, true, true));
            case "medium" -> setImage(new Image(LOG_PATH + "medium.png", LOG_MEDIUM, LOG_MEDIUM, true, true));
            case "long" -> setImage(new Image(LOG_PATH + "long.png", LOG_LONG, LOG_LONG, true, true));
        }
    }
}
