package game.world.levels;

public class CurrentLevel {
    private static int level;

    public CurrentLevel() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        CurrentLevel.level = level;
    }
}
