package game.hiscore;

import game.controllers.Director;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static game.Main.RESOURCES;

/**
 * Creates a popup window with the name of the Player and their highscore along with the previous Highscores of different PLayers.
 */
public class DisplayHiScore {
    /**
     * A SetHiScore instance that stores the value of a newHiScore reference.
     */
    private final SetHiScore newHiScore;

    /**
     * Passes the name and the score to set it in the records and displays the Highscores.
     *
     * @param name the name of the Current Player
     * @param score the score that the player has achieved.
     */
    public DisplayHiScore(String name, int score) {
        newHiScore = new SetHiScore(name, score);
        showScores(score);
    }

    /**
     * Shows the highscore in a popup window with previous Highscores of different player if there's any.
     *
     * @param score the score that the current Player has achieved.
     */
    public void showScores(int score) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(RESOURCES + "icon.png"));
        alert.setTitle("NEW HIGHSCORE!");
        alert.setHeaderText("Your Score: " + score);
        alert.setContentText("Previous Highscores: \n" + formattedScores());
        alert.setOnHidden(e -> Director.nextLevel());
        alert.show();
    }

    /**
     * @return the formatted HighScores of the previous players.
     */
    public String formattedScores() {
        String text = "";
        for (HighScore highscore : newHiScore.hList) {
            text = text.concat(highscore.toString(" : ") + "\n");
        }
        return text;
    }
}
