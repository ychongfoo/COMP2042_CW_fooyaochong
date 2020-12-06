package game.Views;

import game.Controllers.*;
import game.Models.Bg;
import game.Models.Digit;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public abstract class LevelGenerator extends World {
    protected static final int LOG_PADDING = 9;
    protected static final int CAR_PADDING = 10;
    protected static final int ROW1 = 155;
    protected static final int ROW2 = 210;
    protected static final int ROW3 = 265;
    protected static final int ROW4 = 320;
    protected static final int ROW5 = 375;
    protected static final int ROW6 = 475;
    protected static final int ROW7 = 530;
    protected static final int ROW8 = 585;
    protected static final int ROW9 = 640;
    protected static final int ROW10 = 695;
    private final Animal animal;
    private final CurrentLevel currentLevel;
    private final List<End> ends = new ArrayList<>(5);
    private final List<Digit> num = new ArrayList<>(5);
    /**
     * Act method. Every frame is called by AnimationTimer.
     *
     * @param now Time in nanoseconds, it is passed in as argument from {@link AnimationTimer}.
     */
    @Override
    public void act(long now) {
        if (animal.changeScore()) {
            setNumber(animal.getPoints());
        }
        if (animal.getEndsActivated() == 1) {
            win();
        }
    }

    public LevelGenerator(int level) {
        currentLevel = new CurrentLevel();
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

    public void win() {
        stop();
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("NEW HIGHSCORE!");
        textInputDialog.setHeaderText("Your score: " + animal.getPoints());
        textInputDialog.setContentText("Name: ");
        Platform.runLater(() -> textInputDialog.showAndWait().ifPresent(name -> new DisplayHiScore(name, animal.getPoints())));
    }


    public void setNumber(int n) {
        num.forEach(this::remove);
        num.clear();
        int shift = 0;
        do {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            num.add(new Digit(k, 540 - shift, 25));
            shift += 30;
        } while (n > 0);
        num.forEach(this::add);
    }

    public void setEnds() {
        animal.resetEndsActivated();
        ends.forEach(this::remove);
        ends.clear();
        for (int i = 0; i < 5; i++) {
            ends.add(new End(10 + 128 * i, 92));
        }
        ends.forEach(this::add);
    }

    public void start() {
        animal.init();
        setNumber(animal.getPoints());
        setEnds();
        super.start();
    }

}
