package game.gameplay.actors;

import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 *{@code Log} provides a Log image platform of different types/sizes for the Frogger to jump on in the game.
 *
 * @see Platform
 */
public class Log extends Platform {
    /**
     * Path directory to the png files of logs.
     */
    private static final String LOG_PATH = RESOURCES + "platform/log_";
    /**
     * Short Log size measured in pixels.
     */
    private static final double LOG_SHORT = 151.2;
    /**
     * Medium Log size measured in pixels.
     */
    private static final double LOG_MEDIUM = 210.6;
    /**
     * Long Log size measured in pixels.
     */
    private static final double LOG_LONG = 320.4;

    /**
     * Creates a Log at the specified coordinate with the specified speed and displays the corresponding image.
     *
     * @param type the Type of Logs: {@code short, medium, long}.
     * @param xpos the x position of the Log.
     * @param ypos the y position of the log.
     * @param speed the speed of the log.
     */
    public Log(String type, int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        switch (type) {
            case "short" -> setImage(new Image(LOG_PATH + "short.png", LOG_SHORT, LOG_SHORT, true, true));
            case "medium" -> setImage(new Image(LOG_PATH + "medium.png", LOG_MEDIUM, LOG_MEDIUM, true, true));
            case "long" -> setImage(new Image(LOG_PATH + "long.png", LOG_LONG, LOG_LONG, true, true));
        }
    }
}
