package game;

import javafx.scene.image.Image;

import static game.Main.*;

public class Log extends Actor {
    private static final String LOG_PATH = RESOURCES + "platform/log_";
    private static final int LOG_SHORT = 150;
    private static final int LOG_MEDIUM = 200;
    private static final int LOG_LONG = 300;
    private double speed;

    public Log(String type, int xpos, int ypos, double speed) {
        switch (type){
            case "short":
                setImage(new Image(LOG_PATH + "short.png", LOG_SHORT, LOG_SHORT, true, true));
                break;
                case "medium":
                setImage(new Image(LOG_PATH + "medium.png", LOG_MEDIUM, LOG_MEDIUM, true, true));
                break;
                case "long":
                setImage(new Image(LOG_PATH + "long.png", LOG_LONG, LOG_LONG, true, true));
                break;
        }
        setX(xpos);
        setY(ypos);
        this.speed = speed;
    }

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > CANVAS_WIDTH && speed > 0)
            setX(XYORIGIN - getWidth());
        if (getX() < XYORIGIN - getWidth() && speed < 0)
            setX(CANVAS_WIDTH);
    }
    public boolean getLeft() {
        return speed < 0;
    }
}
