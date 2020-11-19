package game;

import javafx.scene.image.Image;

import static game.Main.*;

public class Obstacle extends Actor {
    private static final String CAR_PNG = RESOURCES + "obstacle/car.png";
    private static final String TRUCK_PATH = RESOURCES + "obstacle/truck_";
    private double speed;
    private static final int CAR_SIZE = 50;
    private static final int TRUCK_SIZE_S = 120;
    private static final int TRUCK_SIZE_L = 200;

    public Obstacle() {
    }

    public void Car(int xpos, int ypos, double speed) {
        setImage(new Image(CAR_PNG, CAR_SIZE, CAR_SIZE, true, true));
        setX(xpos);
        setY(ypos);
        this.speed = speed;
    }

    public void Truck(String type, int xpos, int ypos, double speed) {
        switch (type) {
            case "short":
                setImage(new Image(TRUCK_PATH + "short.png", TRUCK_SIZE_S, TRUCK_SIZE_S, true, true));
                break;
            case "long":
                setImage(new Image(TRUCK_PATH + "long.png", TRUCK_SIZE_L, TRUCK_SIZE_L, true, true));
                break;
            default:
        }
        setX(xpos);
        setY(ypos);
        this.speed = speed;
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
