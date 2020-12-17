package game.gameplay;

import static game.Main.CANVAS_WIDTH;
import static game.Main.XYORIGIN;

/**
 * The parent node for all Platforms (nodes that the Frogger can stand on). Platforms that intersect with the
 * Animal instance will cause the Frogger to move together with the platform.
 */
public abstract class Platform extends Actor {
    private final double speed;

    /**
     * Creates an {@code Platform} at the specified coordinates with the specified Speed.
     * Depending on the sign of the speed whether or not it is negative or positive, the image will face left if it is negative
     * and right if it is positive.
     *
     * @param xpos  the x-position of the platform.
     * @param ypos  the y-position of the platform.
     * @param speed the speed of the platform.
     */
    public Platform(double xpos, double ypos, double speed) {
        setX(xpos);
        setY(ypos);
        this.speed = speed;
        setScaleX(speed >= 0 ? -1 : 1);
    }

    /**
     * @return the speed of the Platform.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Moves the Platform according to it's speed at every frame. If the instance is completely out of bounds
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
