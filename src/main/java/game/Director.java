package game;

import javafx.scene.Scene;
import javafx.stage.Stage;

import static game.Main.CANVAS_HEIGHT;
import static game.Main.CANVAS_WIDTH;

public abstract class Director {

    private static Stage Window;
    private static Scene MainMenu = new Scene(new MenuScene(), CANVAS_WIDTH, CANVAS_HEIGHT);
    private static Scene LevelOne = new Scene(new LevelOne(), CANVAS_WIDTH, CANVAS_HEIGHT);



    public static void setWindow(Stage Window) {
        Director.Window = Window;
    }
    public static void playNow(){
        ((World) LevelOne.getRoot()).start();
        Window.setScene(LevelOne);
    }

/*    public static void level2(){
        Window.setScene(LevelTwo);
    }
        public static void level3(){
        Window.setScene(LevelThree);
    }
        public static void level4(){
        Window.setScene(LevelFour);
    }
        public static void level5(){
        Window.setScene(LevelFive);
    }*/

    public static void MainMenu(){
        Window.setScene(MainMenu);
    }
    public static void exit(){
        Window.close();
    }

}
