package game.Models;

import game.Controllers.Actor;

import static game.Main.*;

public abstract class Obstacle extends Actor {
    private double speed;

    public Obstacle(double xpos, double ypos, double speed) {
        setX(xpos);
        setY(ypos);
        this.speed = speed;
        setScaleX(speed>=0 ? -1 : 1);
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
