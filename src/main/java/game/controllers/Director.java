package game.controllers;

import game.Main;
import game.world.World;
import game.world.menu.MenuScene;
import game.world.levels.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Director {
    private static final Scene mainMenu = new Scene(new MenuScene(), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
    private static Stage Window;
    private static Scene levelOne;
    private static Scene levelTwo;
    private static Scene levelThree;
    private static Scene levelFour;
    private static Scene levelFive;
    private static Scene levelSix;
    private static Scene levelSeven;
    private static Scene levelEight;
    private static Scene levelNine;
    private static Scene levelTen;

    private Director() {
    }

    public static void setWindow(Stage Window) {
        Director.Window = Window;
    }

    public static void playNow() {
        levelOne = new Scene(new LevelOne(1), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
        startScene(levelOne);
    }

    public static void MainMenu() {
        stopScene(levelOne);
        startScene(mainMenu);
    }

    public static void nextLevel() {
        CurrentLevel currentLevel = new CurrentLevel();
        int level = currentLevel.getLevel();

        switch (level) {
            case 1 -> {
                levelTwo = new Scene(new LevelTwo(2), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelOne);
                startScene(levelTwo);
            }
            case 2 -> {
                levelThree = new Scene(new LevelThree(3), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelTwo);
                startScene(levelThree);
            }
            case 3 -> {
                levelFour = new Scene(new LevelFour(4), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelThree);
                startScene(levelFour);
            }
            case 4 -> {
                levelFive = new Scene(new LevelFive(5), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelFour);
                startScene(levelFive);
            }
            case 5 -> {
                levelSix = new Scene(new LevelSix(6), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelFive);
                startScene(levelSix);
            }
            case 6 -> {
                levelSeven = new Scene(new LevelSeven(7), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelSix);
                startScene(levelSeven);
            }
            case 7 -> {
                levelEight = new Scene(new LevelEight(8), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelSeven);
                startScene(levelEight);
            }
            case 8 -> {
                levelNine = new Scene(new LevelNine(9), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelEight);
                startScene(levelNine);
            }
            case 9 -> {
                levelTen = new Scene(new LevelTen(10), Main.CANVAS_WIDTH, Main.CANVAS_HEIGHT);
                stopScene(levelNine);
                startScene(levelTen);
            }
            default -> {
                stopScene(levelTen);
                startScene(mainMenu);
            }
        }
    }

    public static void exit() {
        Window.close();
    }

    public static void stopScene(Scene scene) {
        try {
            ((World) scene.getRoot()).stop();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void startScene(Scene scene) {
        try {
            ((World) scene.getRoot()).start();
            Window.setScene(scene);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
