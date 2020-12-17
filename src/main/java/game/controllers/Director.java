package game.controllers;

import game.world.World;
import game.world.levels.*;
import game.world.menu.InfoScene;
import game.world.menu.MenuScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static game.Main.CANVAS_HEIGHT;
import static game.Main.CANVAS_WIDTH;

/**
 * The {@code Director} class handles the stage and directs all scenes and points to the necessary scenes.
 */
public abstract class Director {
    /**
     * A scene that points to the MenuScene.
     */
    private static final Scene mainMenu = new Scene(new MenuScene(), CANVAS_WIDTH, CANVAS_HEIGHT);
    /**
     * A scene that points to the infoScene.
     */
    private static final Scene infoScene = new Scene(new InfoScene(), CANVAS_WIDTH, CANVAS_HEIGHT);
    /**
     * A stage that stores the Window reference.
     */
    private static Stage Window;
    /**
     * An instance of a scene that stores LevelOne reference.
     */
    private static Scene levelOne;
    /**
     * An instance of a scene that stores LevelTwo reference.
     */
    private static Scene levelTwo;
    /**
     * An instance of a scene that stores LevelThree reference.
     */
    private static Scene levelThree;
    /**
     * An instance of a scene that stores LevelFour reference.
     */
    private static Scene levelFour;
    /**
     * An instance of a scene that stores LevelFive reference.
     */
    private static Scene levelFive;
    /**
     * An instance of a scene that stores LevelSix reference.
     */
    private static Scene levelSix;
    /**
     * An instance of a scene that stores LevelSeven reference.
     */
    private static Scene levelSeven;
    /**
     * An instance of a scene that stores LevelEight reference.
     */
    private static Scene levelEight;
    /**
     * An instance of a scene that stores LevelNine reference.
     */
    private static Scene levelNine;
    /**
     * An instance of a scene that stores LevelTen reference.
     */
    private static Scene levelTen;

    /**
     * Handles the stage that is passed in so that it can display different scenes.
     *
     * @param Window takes in a {@code Stage} to display a window on the screen.
     */
    public static void setWindow(Stage Window) {
        Director.Window = Window;
    }

    /**
     * Points to the first level of the game.
     */
    public static void playNow() {
        levelOne = new Scene(new LevelOne(1), CANVAS_WIDTH, CANVAS_HEIGHT);
        startScene(levelOne);
    }

    /**
     * Points to the main menu scene.
     */
    public static void MainMenu() {
        startScene(mainMenu);
    }

    /**
     * Points to the info scene.
     */
    public static void infoScene() {
        startScene(infoScene);
    }

    /**
     * Points to the next Level based on what level it is now from {@code CurrentLevel}.
     *
     * @see CurrentLevel
     */
    public static void nextLevel() {
        CurrentLevel currentLevel = new CurrentLevel();
        int level = currentLevel.getLevel();

        switch (level) {
            case 1 -> {
                levelTwo = new Scene(new LevelTwo(2), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelOne);
                startScene(levelTwo);
            }
            case 2 -> {
                levelThree = new Scene(new LevelThree(3), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelTwo);
                startScene(levelThree);
            }
            case 3 -> {
                levelFour = new Scene(new LevelFour(4), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelThree);
                startScene(levelFour);
            }
            case 4 -> {
                levelFive = new Scene(new LevelFive(5), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelFour);
                startScene(levelFive);
            }
            case 5 -> {
                levelSix = new Scene(new LevelSix(6), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelFive);
                startScene(levelSix);
            }
            case 6 -> {
                levelSeven = new Scene(new LevelSeven(7), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelSix);
                startScene(levelSeven);
            }
            case 7 -> {
                levelEight = new Scene(new LevelEight(8), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelSeven);
                startScene(levelEight);
            }
            case 8 -> {
                levelNine = new Scene(new LevelNine(9), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelEight);
                startScene(levelNine);
            }
            case 9 -> {
                levelTen = new Scene(new LevelTen(10), CANVAS_WIDTH, CANVAS_HEIGHT);
                stopScene(levelNine);
                startScene(levelTen);
            }
            default -> {
                stopScene(levelTen);
                startScene(mainMenu);
            }
        }
    }

    /**
     * Closes the window.
     */
    public static void exit() {
        Window.close();
    }

    /**
     * Starts any scene that is passed in.
     *
     * @param scene that you want to start.
     */
    public static void startScene(Scene scene) {
        try {
            ((World) scene.getRoot()).start();
            Window.setScene(scene);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops any scene that is passed in.
     *
     * @param scene that you want to stop.
     */
    public static void stopScene(Scene scene) {
        try {
            ((World) scene.getRoot()).stop();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


}
