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
        Window.setScene(LevelOne);
    }
    public static void MainMenu(){
        Window.setScene(MainMenu);
    }
}
