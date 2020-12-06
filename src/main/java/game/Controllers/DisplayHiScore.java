package game.Controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class DisplayHiScore {
    private SetHiScore newHiScore;

    public DisplayHiScore(String name, int score) {
        newHiScore = new SetHiScore(name, score);
        showScores(score);
    }

    public void showScores(int score){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NEW HIGHSCORE!");
        alert.setHeaderText("Your Score: "+ score);
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
