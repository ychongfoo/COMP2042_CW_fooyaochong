package game.gameplay;

import static game.Main.CANVAS_WIDTH;
import static game.Main.XYORIGIN;

public abstract class Obstacle extends Actor {
    private final double speed;

    public Obstacle(double xpos, double ypos, double speed) {
        setX(xpos);
        setY(ypos);
        this.speed = speed;
        setScaleX(speed >= 0 ? -1 : 1);
    }

    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > CANVAS_WIDTH && speed > 0)
            setX(XYORIGIN - getWidth());
        if (getX() < XYORIGIN - getWidth() && speed < 0)
            setX(CANVAS_WIDTH);
    }
}
