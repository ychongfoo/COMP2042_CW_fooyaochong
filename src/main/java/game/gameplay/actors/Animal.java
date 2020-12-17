package game.gameplay.actors;

import game.gameplay.Actor;
import game.gameplay.Obstacle;
import game.gameplay.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import static game.Main.*;

/**
 * {@code Animal} holds a playable character that handle {@code KeyEvents} (WASD or ArrowKeys)
 * from the user. The Animal instance interacts with other nodes that it intersects with. The Animal instance also
 * keeps track of level progress such as CurrentScore.
 *
 * @see Actor
 */
public class Animal extends Actor{
    /**
     * Directory path to all frames of Frogger animations.
     */
    private static final String ANIM = RESOURCES + "anim/";
    /**
     * Directory path to frames of Frogger movements.
     */
    private static final String SPRITE_PATH = ANIM + "frog/";
    /**
     * Directory path to frames of Frogger's Death Animations.
     */
    private static final String DEATH_ANIM = ANIM + "death/";
    /**
     * The amount in pixels of how much the Frogger jumps in the y-axis.
     */
    private static final double movementY = 13.3333333 * 2;
    /**
     * The amount in pixels of how much the Frogger jumps in the x-axis.
     */
    private static final double movementX = 10.666666 * 2;
    /**
     * The initial x position of the Frogger.
     */
    private static final double FROG_INITXPOS = 300;
    /**
     * The initial y position of the Frogger.
     */
    private static final double FROG_INITYPOS = 755;
    /**
     * The size of the Frogger measured in pixels.
     */
    private static final int FROGSIZE = 40;
    /**
     * The position of where the Water begins.
     */
    private static final int WATER = 430;
    /**
     * A List to store references to images of Frogger.
     */
    private static List<Image> SpriteAnim;
    /**
     * Initialization of {@code points} as Zero.
     */
    private int points = 0;
    /**
     * Initialization of the {@code EndsActivated} as Zero.
     */
    private int EndsActivated = 0;
    /**
     * Initialization of the {@code DeathCounter} as Zero.
     */
    private int DeathCounter = 0;
    /**
     * Stores the value of instances for the jump animation. 0 for still, 1 for jump.
     */
    private int SpriteFrame;
    /**
     * Initialization of noMove as false.
     */
    private boolean noMove = false;
    /**
     * Initialization of carDeath as false.
     */
    private boolean carDeath = false;
    /**
     *  Initialization of waterDeath as false.
     */
    private boolean waterDeath = false;
    /**
     * Initialization of changeScore as false.
     */
    private boolean changeScore = false;
    /**
     * Specifies the furthest the Frogger has travelled in terms of the y-axis.
     */
    private double currentY;


    /**
     * {@code Animal} is a constructor that loads all the required images of the Frogger Sprite and sets {@code onKeyPressed} and
     * {@code onKeyReleased EventHandlers}.
     */
    public Animal() {
        if (SpriteAnim == null) {//Should check it just in case it has been instantiated.
            SpriteAnim = new ArrayList<>(2); //call the class, can't call List because it is an Abstract class.
            SpriteAnim.add(new Image(SPRITE_PATH + "frog.png", FROGSIZE, FROGSIZE, true, true));
            SpriteAnim.add(new Image(SPRITE_PATH + "frogJump.png", FROGSIZE, FROGSIZE, true, true));
        }

        setOnKeyPressed(this::handle);
        setOnKeyReleased(this::handle);

    }

    /**
     * Moves the Frogger when the specific keys are pressed and plays the jump animation.
     * {@code EventHandlers} are called for {@code KeyPressed} and {@code KeyReleased} events.
     *
     * @param e KeyEvent that is fired.
     */
    private void handle(KeyEvent e) {
        if (!noMove) {
            SpriteFrame = e.getEventType() == KeyEvent.KEY_RELEASED ? 0 : (++SpriteFrame) % SpriteAnim.size();
            setImage(SpriteAnim.get(SpriteFrame));
            switch (e.getCode()) {
                case UP:
                case W:
                    if (getY() <= currentY - FROGSIZE) {
                        currentY = getY();
                        points += 10;
                        changeScore = true;
                    }
                    move(0, -movementY);
                    setRotate(0);
                    break;

                case LEFT:
                case A:
                    move(-movementX, 0);
                    setRotate(-90);
                    break;

                case DOWN:
                case S:
                    move(0, movementY);
                    setRotate(180);
                    break;

                case RIGHT:
                case D:
                    move(movementX, 0);
                    setRotate(90);
                    break;
                default:
            }
        }
    }

    /**
     * Calls {@link #boundaries()} method and plays the death Animations when necessary.
     * It is being called every frame.
     *
     * @param now Time measured in nanoseconds.
     */
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
                } else {
                    points -= getPoints();
                }
                changeScore = true;
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
                } else {
                    points -= getPoints();
                }
                changeScore = true;
            }
        }


        if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        } else if (getIntersectingObjects(Platform.class).size() >= 1 && !noMove) {
            Platform PlatformNow = getIntersectingObjects(Platform.class).get(0);
            move(PlatformNow.getSpeed(), 0);
            if (PlatformNow.getClass() == WetTurtle.class && ((WetTurtle) PlatformNow).isSunk()) {
                waterDeath = true;
            }
        } else if (getIntersectingObjects(End.class).size() >= 1) {
            if (getIntersectingObjects(End.class).get(0).isActivated()) {
                EndsActivated--;
                points -= 50;
                changeScore = true;
            }
            points += 50;
            changeScore = true;
            currentY = CANVAS_HEIGHT;
            getIntersectingObjects(End.class).get(0).setEnd();
            EndsActivated++;
            reset();
        } else if (getY() + FROGSIZE < WATER) {
            waterDeath = true;
        }
    }

    /**
     * Resets the number of ends activated to zero so the game can be restarted.
     */
    public void resetEndsActivated() {
        this.EndsActivated = 0;
    }

    /**
     * @return the number of ends activated at the moment.
     */
    public int getEndsActivated() {
        return EndsActivated;
    }

    /**
     * @return the points at the moment.
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return true if score is changed and false if score is not changed.
     */
    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;
    }

    /**
     * This method ensures that the Frogger stays within the boundaries of the {@code Stage}.
     */
    private void boundaries() {
        if (getY() < XYORIGIN || getY() > CANVAS_HEIGHT - FROGSIZE) {
            setY(FROG_INITYPOS);
        }
        if (getX() < XYORIGIN) {
            setX(XYORIGIN);
        } else if (getX() > CANVAS_WIDTH - FROGSIZE) {
            setX(CANVAS_WIDTH - FROGSIZE);
        }
    }

    /**
     * Resets everything,
     * returns the Frogger to its starting position and sets all death animations to false.
     */
    public void reset() {
        DeathCounter = 0;
        SpriteFrame = 0;
        waterDeath = false;
        carDeath = false;
        noMove = false;
        setImage(SpriteAnim.get(SpriteFrame));
        setX(FROG_INITXPOS);
        setY(FROG_INITYPOS);
        setRotate(0);
    }

    /**
     * Initializes the points to zero, set CurrentY to {@code CANVAS_HEIGHT} and calls {@code reset()} method.
     */
    public void init() {
        currentY = CANVAS_HEIGHT;
        points = 0;
        changeScore = true;
        toFront();
        reset();
    }
}
