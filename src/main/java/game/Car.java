package game;

import javafx.scene.image.Image;

import static game.Main.RESOURCES;

public class Car extends Obstacle{
    private static final String CAR_PNG = RESOURCES + "obstacle/car.png";
    private static final int CAR_SIZE = 50;

    public Car(int xpos, int ypos, double speed){
        super(xpos, ypos, speed);
        setImage(new Image(CAR_PNG, CAR_SIZE, CAR_SIZE, true, true));
    }
}
