package game.world.levels;

import game.controllers.Director;
import game.gameplay.actors.Animal;
import game.gameplay.actors.Bg;
import game.gameplay.actors.Digit;
import game.gameplay.actors.End;
import game.hiscore.DisplayHiScore;
import game.world.World;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static game.Main.RESOURCES;

/**
 * {@code LevelGenerator} is an abstract class that holds all of the child nodes for different levels.
 * Calls whatever is needed for every levels.
 *
 * @see World
 */
public abstract class LevelGenerator extends World {
    /**
     * Padding for the {@code Log} measured in pixels.
     */
    protected static final int LOG_PADDING = 9;
    /**
     * Padding for the {@code Car} measured in pixels.
     */
    protected static final int CAR_PADDING = 10;
    /**
     * Specifies the First Row measured in pixels.
     */
    protected static final int ROW1 = 155;
    /**
     * Specifies the Second Row measured in pixels.
     */
    protected static final int ROW2 = 210;
    /**
     * Specifies the Third Row measured in pixels.
     */
    protected static final int ROW3 = 265;
    /**
     * Specifies the Fourth Row measured in pixels.
     */
    protected static final int ROW4 = 320;
    /**
     * Specifies the Fifth Row measured in pixels.
     */
    protected static final int ROW5 = 375;
    /**
     * Specifies the Sixth Row measured in pixels.
     */
    protected static final int ROW6 = 475;
    /**
     * Specifies the Seventh Row measured in pixels.
     */
    protected static final int ROW7 = 530;
    /**
     * Specifies the Eighth Row measured in pixels.
     */
    protected static final int ROW8 = 585;
    /**
     * Specifies the Ninth Row measured in pixels.
     */
    protected static final int ROW9 = 640;
    /**
     * Specifies the Tenth Row measured in pixels.
     */
    protected static final int ROW10 = 695;
    /**
     * A reference to the Animal instance. The Character that player controls.
     */
    private final Animal animal;
    /**
     * An ArrayList that holds all references of {@code End}.
     */
    private final List<End> ends = new ArrayList<>(5);
    /**
     * An ArrayList that holds all references of {@code Digit}.
     */
    private final List<Digit> num = new ArrayList<>(5);

    /**
     * The constructor that calls in the background and initializes a sprite in the display.
     *
     * @param level is passed in as an indication of which level it is currently on.
     */
    public LevelGenerator(int level) {
        CurrentLevel currentLevel = new CurrentLevel();
        currentLevel.setLevel(level);

        add(new Bg("frogger_bg.png"));

        animal = new Animal();
        add(animal);

        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Director.MainMenu();
            }
        });

    }

    /**
     * Act method. Every frame is called by AnimationTimer.
     * <ul>
     *     <li>Changes the digits on displayed whenever the score is changed.</li>
     *     <li>Triggers {@code win()} if all ends are filled.</li>
     * </ul>
     *
     *
     *
     * @param now Time in nanoseconds, it is passed in as argument from {@link AnimationTimer}.
     */
    @Override
    public void act(long now) {
        if (animal.changeScore()) {
            setNumber(animal.getPoints());
        }
        if (animal.getEndsActivated() == 5) {
            win();
        }
    }

    /**
     * Is called when all {@code ends} are filled and a popup would appear.
     */
    public void win() {
        stop();
        TextInputDialog textInputDialog = new TextInputDialog();
        Stage stage = (Stage) textInputDialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(RESOURCES + "icon.png"));
        textInputDialog.setTitle("NEW HIGHSCORE!");
        textInputDialog.setHeaderText("Your score: " + animal.getPoints());
        textInputDialog.setContentText("Name: ");
        Platform.runLater(() -> textInputDialog.showAndWait().ifPresent(name -> new DisplayHiScore(name, animal.getPoints())));
    }

    /**
     * Sets the number for the current {@code points} to be displayed.
     *
     * @param n is passed in as an integer as the current {@code points} to be displayed.
     */
    public void setNumber(int n) {
        num.forEach(this::remove);
        num.clear();
        int shift = 0;
        do {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            num.add(new Digit(k, 16, 563 - shift, 42));
            shift += 20;
        } while (n > 0);
        num.forEach(this::add);
    }

    /**
     * Initializes the five ends to be displayed and adds it to the ArrayList.
     */
    public void setEnds() {
        animal.resetEndsActivated();
        ends.forEach(this::remove);
        ends.clear();
        for (int i = 0; i < 5; i++) {
            ends.add(new End(10 + 128 * i, 92));
        }
        ends.forEach(this::add);
    }

    /**
     * Starts the {@link AnimationTimer} {@code timer} and calls all the methods that are required for each levels.
     */
    public void start() {
        animal.init();
        setNumber(animal.getPoints());
        setEnds();
        super.start();
    }

}
