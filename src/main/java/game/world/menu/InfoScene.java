package game.world.menu;

import game.controllers.Director;
import game.gameplay.actors.Bg;
import game.world.World;
import javafx.scene.input.KeyCode;

/**
 * The {@code InfoScene} is a scene to display the info page. This class uses the Bg with w
 *
 * @see game.world.World
 * @see Bg
 */
public class InfoScene extends World {
    public InfoScene() {
        add(new Bg("info.png"));
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Director.MainMenu();
            }
        });
    }

    @Override
    public void act(long now) {

    }
}
