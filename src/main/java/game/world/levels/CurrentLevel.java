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

    /**
     * @param level set the specified level as the current Level
     */
    public void setLevel(int level) {
        CurrentLevel.level = level;
    }

    /**
     * @return the current Level
     */
    public int getLevel() {
        return level;
    }
}
