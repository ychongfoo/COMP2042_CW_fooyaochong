package game.hiscore;

/**
 * Provides the name and score of the Player who won and sorts it so that the Highest Score would appear at the top.
 */
@SuppressWarnings("rawtypes")
public class HighScore implements Comparable {

    /**
     * Name of player
     */
    private final String playerName;

    /**
     * Score of player
     */
    private final int playerScore;

    /**
     * Constructor that sets the instance variables playerName and playerScore      *  to the arguments name and score
     *
     * @param score the score of the player won just won
     * @param name  the name of the player who just won
     */
    public HighScore(String name, int score) {
        playerScore = score;
        playerName = name;
    }

    /**
     * getPlayerScore() returns the score of the player who won
     *
     * @return int player score
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * getPlayerName() returns the name of the player who just won
     *
     * @return String player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * toString() returns a combination of the player's score and name in a single string
     *
     * @param first first
     * @return String toString method
     */
    public String toString(String first) {
        return (getPlayerName() + first + getPlayerScore());
    }

    /***
     * Highest playerScore is given priority.
     * @param o object
     * @return int compared
     */
    @Override
    public int compareTo(Object o) {
        HighScore otherScore = (HighScore) o;
        return Integer.compare(otherScore.playerScore, this.playerScore);
    }
}

