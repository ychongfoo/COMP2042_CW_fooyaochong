package game.hiscore;

import game.Main;
import game.world.levels.CurrentLevel;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class SetHiScore {
    /**
     * Directory path to all the highscore CSV's
     */
    private static final String CSV_PATH = Main.RESOURCES.replace("file:", "") + "highscores/highscores";
    /**
     * An ArrayList that stores all the HighScores into an ArrayList.
     */
    public final ArrayList<HighScore> hList = new ArrayList<>();
    /**
     * winner holds Highscore object
     */
    public final HighScore winner;

    /**
     * Constructor that identifies the winner, and writes and saves their name      *  and score to a file
     *
     * @param score score of the player who just won
     * @param name  name of the player who just won
     */
    public SetHiScore(String name, int score) {
        winner = new HighScore(name, score);
        readHiScores();
        saveHiScore();
    }

    /**
     * readHiScores() reads the High Scores file
     */
    @SuppressWarnings({"unchecked", "ResultOfMethodCallIgnored"})
    public void readHiScores() {
        CurrentLevel currentLevel = new CurrentLevel();
        int level = currentLevel.getLevel();

        File csvfile = new File(CSV_PATH + level + ".csv");
        try {
            csvfile.createNewFile();
            BufferedReader CSVReader = new BufferedReader(new FileReader(csvfile));
            String line;
            while ((line = CSVReader.readLine()) != null) { //reads the file
                String[] users = line.split(",");
                if (users.length == 2)
                    hList.add(new HighScore(users[0], Integer.parseInt(users[1])));
            }
            Collections.sort(hList);

            CSVReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * saveToFile() saves new file
     */
    @SuppressWarnings("unchecked")
    public void saveHiScore() {
        CurrentLevel currentLevel = new CurrentLevel();
        int level = currentLevel.getLevel();

        File csvfile = new File(CSV_PATH + level + ".csv");
        try {
            BufferedWriter csvwriter = new BufferedWriter(new FileWriter(csvfile));
            String playerScore;
            String winnerScore;
            for (HighScore highscore : hList) {
                playerScore = highscore.getPlayerName() + "," + highscore.getPlayerScore();
                csvwriter.write(playerScore);
                csvwriter.newLine();
            }
            if (winner != null) {
                winnerScore = winner.getPlayerName() + "," + winner.getPlayerScore();
                csvwriter.write(winnerScore);
                csvwriter.newLine();
                hList.add(winner);
            }

            Collections.sort(hList);

            csvwriter.flush();
            csvwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

