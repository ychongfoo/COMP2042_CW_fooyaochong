package game.gameplay.actors;

import game.gameplay.Obstacle;
import game.gameplay.Platform;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 *{@code Car} provides a Car image obstacle in the game.
 *
 * @see Obstacle
 */
public class Car extends Obstacle {
    /**
     * Path directory to the car images.
     */
    private static final String CAR_PNG = RESOURCES + "obstacle/car.png";
    /**
     * A constant value for the size of the car measured in pixel.
     */
    private static final double CAR_SIZE = 55.755;

    /**
     * Creates a Car at the specified coordinate with the specified speed and displays the corresponding image.
     *
     * @param xpos sets the x-position of the Car.
     * @param ypos sets the y-position of the Car.
     * @param speed sets the speed of the Car.
     */
    public Car(int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        setImage(new Image(CAR_PNG, CAR_SIZE, CAR_SIZE, true, true));
    }
}
