package game.gameplay.actors;

import game.gameplay.Obstacle;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

/**
 * {@code Truck} provides a Truck image obstacle in either {@code short} trucks or {@code long} trucks.
 */
public class Truck extends Obstacle {
    /**
     * Path directory to all Truck Images.
     */
    private static final String TRUCK_PATH = RESOURCES + "obstacle/truck_";
    /**
     * A constant for the Short Truck size.
     */
    private static final double TRUCK_SIZE_S = 116.746875;
    /**
     * A constant for the Long Truck size.
     */
    private static final double TRUCK_SIZE_L = 201.93;

    /**
     * Creates a {@code Truck} at the specified coordinates with the specified speed.
     *
     * @param type The type of Truck: {@code short, long}.
     * @param xpos The x-position of the Truck.
     * @param ypos The y-position of the Truck.
     * @param speed The speed of the Truck.
     */
    public Truck(String type, int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        switch (type) {
            case "short" -> setImage(new Image(TRUCK_PATH + "short.png", TRUCK_SIZE_S, TRUCK_SIZE_S, true, true));
            case "long" -> setImage(new Image(TRUCK_PATH + "long.png", TRUCK_SIZE_L, TRUCK_SIZE_L, true, true));
        }
    }
}
