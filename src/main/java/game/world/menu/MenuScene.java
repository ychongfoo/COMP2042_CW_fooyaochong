package game.world.menu;

import game.controllers.Director;
import game.gameplay.actors.Bg;
import game.world.World;

/**
 * The {@code MenuScene} is a scene to display the Main Menu.
 *
 * @see game.world.World
 * @see Bg
 */
public class MenuScene extends World {
    /**
     * Adds an image of the Main Menu and buttons that points to other scenes.
     */
    public MenuScene() {
        myButton infoButton = new myButton("INFO BUTTON", 72, 264, 475);
        infoButton.setOnMouseClicked(e -> Director.infoScene());
        myButton playButton = new myButton("PLAY BUTTON", 140, 230, 423);
        playButton.setOnMouseClicked(e -> Director.playNow());
        myButton exitButton = new myButton("EXIT", 72, 264, 525);
        exitButton.setOnMouseClicked(e -> Director.exit());

        add(new Bg("mainmenu.png"));
        add(infoButton);
        add(playButton);
        add(exitButton);

    }

    /**
     * @param now Time in nanoseconds. Passed as argument from AnimationTimer.handle().
     */
    @Override
    public void act(long now) {

    }
}
