package game;

import game.controllers.Director;
import game.controllers.mp3Player;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * Main is the entry point in which the Application can perform what a JavaFX application does.
 *
 * @author Yao Chong
 * @version 2.0
 */
public class Main extends Application {
    /**
     * Path directory to all the resources stored.
     */
    public static final String RESOURCES = "file:src/main/resources/";
    /**
     * The width of the window/stage.
     */
    public static final double CANVAS_WIDTH = 600;
    /**
     * The height of the window/stage.
     */
    public static final double CANVAS_HEIGHT = 800;
    /**
     * The origin of the window/stage, represented at the top left hand corner of the screen as origin.
     */
    public static final double XYORIGIN = 0;
    /**
     * Instance of mp3Player for playing music indefinitely.
     */
    private mp3Player mp3Player;


    /**
     * Main method that starts the Application.
     * @param args JVM argument
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the application.
     *
     * @param window The stage for the game.
     */
    @Override
    public void start(Stage window) {
        mp3Player = new mp3Player();

        Director.setWindow(window);
        Director.MainMenu();
        window.setTitle("Frogger");
        window.getIcons().add(new Image(RESOURCES + "icon.png"));
        window.setResizable(false);
        window.show();
        start();
    }

    /**
     * Plays the Frogger Main Theme Song.
     */
    public void start() {
        mp3Player.playMusic("Frogger Main Song Theme (loop)");
    }
    /**
     * Stops playing the Frogger Main Theme Song.
     */
    public void stop() {
        mp3Player.stopMusic();
    }


}
