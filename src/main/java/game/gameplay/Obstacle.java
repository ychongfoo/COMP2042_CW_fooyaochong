package game.gameplay;

import static game.Main.CANVAS_WIDTH;
import static game.Main.XYORIGIN;

/**
 * The parent node for all obstacles (nodes that makes the Frogger die). Obstacles that intersect with the
 * Animal instance will cause the Frogger to 'die'.
 */
public abstract class Obstacle extends Actor {
    private final double speed;

    /**
     * Creates an {@code Obstacle} at the specified coordinates with the specified Speed.
     * Depending on the sign of the speed whether or not it is negative or positive, the image will face left if it is negative
     * and right if it is positive.
     *
     * @param xpos the x-position of the obstacle.
     * @param ypos the y-position of the obstacle.
     * @param speed the speed of the obstacle.
     */
    public Obstacle(double xpos, double ypos, double speed) {
        setX(xpos);
        setY(ypos);
        this.speed = speed;
        setScaleX(speed >= 0 ? -1 : 1);
    }

    /**
     * Moves the obstacle according to it's speed at every frame. If the instance is completely out of bounds
     * of the window, the x-coordinate is reset to the other side of the window.
     *
     * @param now Time measured in nanosecond.
     */
    @Override
    public void act(long now) {
        move(speed, 0);
        if (getX() > CANVAS_WIDTH && speed > 0)
            setX(XYORIGIN - getWidth());
        if (getX() < XYORIGIN - getWidth() && speed < 0)
            setX(CANVAS_WIDTH);
    }
}
