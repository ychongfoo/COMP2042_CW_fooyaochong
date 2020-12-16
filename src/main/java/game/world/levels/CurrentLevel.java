package game.world.levels;

/**
 * A class that sets and returns the current Level
 */
public class CurrentLevel {
    /**
     * Stores the value of the current level
     */
    private static int level;

    /**
     * An empty constructor
     */
    public CurrentLevel() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        CurrentLevel.level = level;
    }
}
