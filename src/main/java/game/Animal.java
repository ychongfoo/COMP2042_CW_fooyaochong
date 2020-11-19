package game;

import javafx.scene.image.Image;

import java.util.ArrayList;

import static game.Main.RESOURCES;

public class Animal extends Actor {
    private static final String ANIM = RESOURCES + "anim/";
    private static final String FROG_ANIM = ANIM + "frog/";
    private static final String DEATH_ANIM = ANIM + "death/";

    Image imgW1;
    Image imgA1;
    Image imgS1;
    Image imgD1;
    Image imgW2;
    Image imgA2;
    Image imgS2;
    Image imgD2;

    int points = 0;
    int end = 0;
    private boolean second = false;
    boolean noMove = false;
    boolean carDeath = false;
    boolean waterDeath = false;
    boolean stop = false;
    boolean changeScore = false;

    private static final double movementY = 13.3333333 * 2;
    private static final double movementX = 10.666666 * 2;

    private static final int imgSize = 40;

    int carD = 0;
    double w = 800;
    ArrayList<End> inter = new ArrayList<End>();


    public Animal(String imageLink) {
        setImage(new Image(imageLink, imgSize, imgSize, true, true));
        setX(300);
        setY(679.8 + movementY);

        imgW1 = new Image(FROG_ANIM + "froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image(FROG_ANIM + "froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image(FROG_ANIM + "froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image(FROG_ANIM + "froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image(FROG_ANIM + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image(FROG_ANIM + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image(FROG_ANIM + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image(FROG_ANIM + "froggerRightJump.png", imgSize, imgSize, true, true);

        setOnKeyPressed(event -> {
            if (noMove) {

            } else if (second) {
                switch (event.getCode()) {
                    case W:
                        move(0, -movementY);
                        changeScore = false;
                        setImage(imgW1);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgA1);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgS1);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgD1);
                        break;
                }
                second = false;
            } else {
                switch (event.getCode()) {
                    case W:
                        move(0, -movementY);
                        changeScore = false;
                        setImage(imgW2);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgA2);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgS2);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgD2);
                        break;
                }
                second = true;
            }
        });

        setOnKeyReleased(event -> {
            if (noMove) {
            } else {
                switch (event.getCode()) {
                    case W:
                        if (getY() < w) {
                            changeScore = true;
                            w = getY();
                            points += 10;
                        }
                        move(0, -movementY);
                        setImage(imgW1);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgA1);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgS1);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgD1);
                        break;
                }
                second = false;
            }

        });
    }


    @Override
    public void act(long now) {
        int bounds = 0;
        if (getY() < 0 || getY() > 734) {
            setX(300);
            setY(679.8 + movementY);
        }
        if (getX() < 0) {
            move(movementY * 2, 0);
        }
        if (carDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                carD++;
            }
            if (carD == 1) {
                setImage(new Image(DEATH_ANIM + "cardeath1.png", imgSize, imgSize, true, true));
            }
            if (carD == 2) {
                setImage(new Image(DEATH_ANIM + "cardeath2.png", imgSize, imgSize, true, true));
            }
            if (carD == 3) {
                setImage(new Image(DEATH_ANIM + "cardeath3.png", imgSize, imgSize, true, true));
            }
            if (carD == 4) {
                setX(300);
                setY(679.8 + movementY);
                carDeath = false;
                carD = 0;
                setImage(new Image(FROG_ANIM + "froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }

        }
        if (waterDeath) {
            noMove = true;
            if ((now) % 11 == 0) {
                carD++;
            }
            if (carD == 1) {
                setImage(new Image(DEATH_ANIM + "waterdeath1.png", imgSize, imgSize, true, true));
            }
            if (carD == 2) {
                setImage(new Image(DEATH_ANIM + "waterdeath2.png", imgSize, imgSize, true, true));
            }
            if (carD == 3) {
                setImage(new Image(DEATH_ANIM + "waterdeath3.png", imgSize, imgSize, true, true));
            }
            if (carD == 4) {
                setImage(new Image(DEATH_ANIM + "waterdeath4.png", imgSize, imgSize, true, true));
            }
            if (carD == 5) {
                setX(300);
                setY(679.8 + movementY);
                waterDeath = false;
                carD = 0;
                setImage(new Image(FROG_ANIM + "froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
                if (points > 50) {
                    points -= 50;
                    changeScore = true;
                }
            }

        }

        if (getX() > 600) {
            move(-movementY * 2, 0);
        }
        if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        }
        if (getX() == 240 && getY() == 82) {
            stop = true;
        }
        if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if (getIntersectingObjects(Log.class).get(0).getLeft())
                move(-2, 0);
            else
                move(.75, 0);
        } else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            move(-1, 0);
        } else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                waterDeath = true;
            } else {
                move(-1, 0);
            }
        } else if (getIntersectingObjects(End.class).size() >= 1) {
            inter = (ArrayList<End>) getIntersectingObjects(End.class);
            if (getIntersectingObjects(End.class).get(0).isActivated()) {
                end--;
                points -= 50;
            }
            points += 50;
            changeScore = true;
            w = 800;
            getIntersectingObjects(End.class).get(0).setEnd();
            end++;
            setX(300);
            setY(679.8 + movementY);
        } else if (getY() < 413) {
            waterDeath = true;
            //setX(300);
            //setY(679.8+movementY);
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


}
