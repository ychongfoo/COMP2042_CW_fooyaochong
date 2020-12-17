package game.world.menu;

import game.controllers.Director;
import game.gameplay.actors.Bg;
import game.world.World;
import javafx.scene.input.KeyCode;

/**
 * The {@code InfoScene} is a scene to display the info page.
 *
 * @see game.world.World
 * @see Bg
 */
public class InfoScene extends World {
    /**
     * adds an Image of the InfoScene to the parent node.
     */
    public InfoScene() {
        add(new Bg("info.png"));
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Director.MainMenu();
            }
        });
    }

    /**
     * @param now Time in nanoseconds. Passed as argument from AnimationTimer.handle().
     */
    @Override
    public void act(long now) {

    }
}
