package game;

import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Truck extends Obstacle{
    private static final String TRUCK_PATH = RESOURCES + "obstacle/truck_";
    private static final int TRUCK_SIZE_S = 120;
    private static final int TRUCK_SIZE_L = 200;

    public Truck(String type, int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        switch (type) {
            case "short":
                setImage(new Image(TRUCK_PATH + "short.png", TRUCK_SIZE_S, TRUCK_SIZE_S, true, true));
                break;
            case "long":
                setImage(new Image(TRUCK_PATH + "long.png", TRUCK_SIZE_L, TRUCK_SIZE_L, true, true));
                break;
            default:
        }
    }
}
