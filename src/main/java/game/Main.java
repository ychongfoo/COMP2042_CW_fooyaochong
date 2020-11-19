package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static game.Main.window;
import static game.mp3Player.ETC_PATH;

/**
 *
 *
 * @author Yao Chong
 *
 */

public class Main extends Application {
    //Added constant String resources path
    public static final String RESOURCES = "file:src/main/resources/";

    public static final double CANVAS_WIDTH = 600;
    public static final double CANVAS_HEIGHT = 800;
    public static final double XYORIGIN = 0;

    public static Stage window;
    AnimationTimer timer;
    private mp3Player mp3Player;
    private Scene mainScene;
    Animal frog;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        MenuScene mainmenu= new MenuScene();
        mainScene= new Scene(mainmenu, CANVAS_WIDTH, CANVAS_HEIGHT);

        mp3Player = new mp3Player();
        window.setScene(mainScene);
        Director.setWindow(window);
        window.setTitle("Frogger");
        window.getIcons().add(new Image(ETC_PATH + "icon-frogger-pixel-512x512.png"));
        window.setResizable(false);
        window.show();
        start();
    }

    public void start() {
        mp3Player.playMusic("Frogger Main Song Theme (loop)");
    }

    public void stop() {
        mp3Player.stopMusic();
    }


}
