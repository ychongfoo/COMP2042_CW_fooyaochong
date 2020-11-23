package game;

import static game.Main.CANVAS_WIDTH;
import static game.Main.XYORIGIN;

public abstract class Platform extends Actor{
    private double speed;

    public Platform(double xpos, double ypos, double speed){
        setX(xpos);
        setY(ypos);
        this.speed=speed;
        setScaleX(speed>=0 ? -1 : 1);
    }

    public double getSpeed(){
        return speed;
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
