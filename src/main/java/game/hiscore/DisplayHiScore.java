package game.hiscore;

import game.controllers.Director;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static game.controllers.mp3Player.ETC_PATH;

public class DisplayHiScore {
    private final SetHiScore newHiScore;

    public DisplayHiScore(String name, int score) {
        newHiScore = new SetHiScore(name, score);
        showScores(score);
    }

    public void showScores(int score) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(ETC_PATH + "icon-frogger-pixel-512x512.png"));
        alert.setTitle("NEW HIGHSCORE!");
        alert.setHeaderText("Your Score: " + score);
        alert.setContentText("Previous Highscores: \n" + formattedScores());
        alert.setOnHidden(e -> Director.nextLevel());
        alert.show();
    }

    public String formattedScores() {
        String text = "";
        for (HighScore highscore : newHiScore.hList) {
            text = text.concat(highscore.toString(" : ") + "\n");
        }
        return text;
    }
}
