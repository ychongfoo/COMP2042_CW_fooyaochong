package game.gameplay.actors;

import game.gameplay.Obstacle;
import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Truck extends Obstacle {
    private static final String TRUCK_PATH = RESOURCES + "obstacle/truck_";
    private static final double TRUCK_SIZE_S = 116.746875;
    private static final double TRUCK_SIZE_L = 201.93;

    public Truck(String type, int xpos, int ypos, double speed) {
        super(xpos, ypos, speed);
        switch (type) {
            case "short" -> setImage(new Image(TRUCK_PATH + "short.png", TRUCK_SIZE_S, TRUCK_SIZE_S, true, true));
            case "long" -> setImage(new Image(TRUCK_PATH + "long.png", TRUCK_SIZE_L, TRUCK_SIZE_L, true, true));
        }
    }
}
