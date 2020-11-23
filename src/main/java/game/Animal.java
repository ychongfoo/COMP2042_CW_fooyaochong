package game;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static game.Main.*;

public class Animal extends Actor {
    private static final String ANIM = RESOURCES + "anim/";
    private static final String SPRITE_PATH = ANIM + "frog/";
    private static final String DEATH_ANIM = ANIM + "death/";

    private static int points = 0;
    int end = 0;
    boolean noMove = false;
    boolean carDeath = false;
    boolean waterDeath = false;
    boolean changeScore = false;

    private static final double movementY = 13.3333333 * 2;
    private static final double movementX = 10.666666 * 2;

    private static final double FROG_INITXPOS = 300;
    private static final double FROG_INITYPOS = 754;
    private static final int FROGSIZE = 40;
    private static final int WATER = 430;
    private static  List<Image> SpriteAnim;
    private int SpriteFrame;
    int DeathCounter = 0;
    double currentY;
    ArrayList<End> inter = new ArrayList<End>();


    public Animal() {
        setX(FROG_INITXPOS);
        setY(FROG_INITYPOS);

        if (SpriteAnim == null){//Should check it just in case it has been instantiated.
            SpriteAnim = new ArrayList<>(2); //call the class, can't call List because it is an Abstract class.
            SpriteAnim.add(new Image(SPRITE_PATH + "frog.png", FROGSIZE, FROGSIZE, true, true));
            SpriteAnim.add(new Image(SPRITE_PATH + "frogJump.png", FROGSIZE, FROGSIZE, true, true));
        }

        setOnKeyPressed(this::handle);
        setOnKeyReleased(this::handle);

    }
    private void handle(KeyEvent e) {
        if (!noMove && Arrays.asList(KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D).contains(e.getCode())) {
            SpriteFrame = e.getEventType() == KeyEvent.KEY_RELEASED ? 0 : (++SpriteFrame) % SpriteAnim.size();
            setImage(SpriteAnim.get(SpriteFrame));
            switch (e.getCode()) {
                case W:
                    if (getY() <= currentY) {
                        changeScore = true;
                        currentY = getY();
                        points += 10;
                    }
                    move(0, -movementY);
                    setRotate(0);
                    break;
                case A:
                    move(-movementX, 0);
                    setRotate(-90);
                    break;
                case S:
                    move(0, movementY);
                    setRotate(180);
                    break;
                case D:
                    move(movementX, 0);
                    setRotate(90);
                    break;
                default:
            }
        }
    }

    @Override
    public void act(long now) {
        boundaries();
        if (carDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                DeathCounter++;
            }
            if (DeathCounter == 1) {
                setImage(new Image(DEATH_ANIM + "cardeath1.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 2) {
                setImage(new Image(DEATH_ANIM + "cardeath2.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 3) {
                setImage(new Image(DEATH_ANIM + "cardeath3.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 4) {
                reset();
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }

        }
        if (waterDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                DeathCounter++;
            }
            if (DeathCounter == 1) {
                setImage(new Image(DEATH_ANIM + "waterdeath1.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 2) {
                setImage(new Image(DEATH_ANIM + "waterdeath2.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 3) {
                setImage(new Image(DEATH_ANIM + "waterdeath3.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 4) {
                setImage(new Image(DEATH_ANIM + "waterdeath4.png", FROGSIZE, FROGSIZE, true, true));
            }
            if (DeathCounter == 5) {
                reset();
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }
        }


        if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        } else if (getIntersectingObjects(Platform.class).size() >=1 && !noMove){
            Platform PlatformNow = getIntersectingObjects(Platform.class).get(0);
            move(PlatformNow.getSpeed(), 0);
            if (PlatformNow.getClass() == WetTurtle.class && ((WetTurtle) PlatformNow).isSunk()){
                waterDeath = true;
            }
        } else if (getIntersectingObjects(End.class).size() >= 1) {
            End EndNow = getIntersectingObjects(End.class).get(0);
            reset();
            if (EndNow.isActivated()) {
                end--;
                points -= 50;
            }
            else{
                points += 50;
                changeScore = true;
                EndNow.setEnd();
                end++;
                setX(FROG_INITXPOS);
                setY(FROG_INITYPOS);
            }
        } else if (getY() + FROGSIZE < WATER) {
            waterDeath = true;
        }
    }

    public boolean getStop() {
        return end == 5;
    }

    public int getPoints() {
        return points;
    }

    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;
    }

    private void boundaries(){
        if (getY() < XYORIGIN || getY() > CANVAS_HEIGHT - FROGSIZE){
            setY(FROG_INITYPOS);
        }
        if(getX() < XYORIGIN) {
            setX(XYORIGIN);
        }
        else if (getX() > CANVAS_WIDTH - FROGSIZE){
            setX(CANVAS_WIDTH- FROGSIZE);
        }
    }

    public void reset(){
        DeathCounter = 0;
        SpriteFrame = 0;
        waterDeath=false;
        carDeath=false;
        noMove = false;
        setImage(SpriteAnim.get(SpriteFrame));
        setX(FROG_INITXPOS);
        setY(FROG_INITYPOS);
        setRotate(0);
    }

    public void init(){
        points = 0;
        changeScore = true;
        toFront();
        reset();
    }
}
