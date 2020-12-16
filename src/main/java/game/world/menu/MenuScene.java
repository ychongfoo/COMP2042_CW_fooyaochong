package game.world.menu;

import game.controllers.Director;
import game.gameplay.actors.Bg;
import game.world.World;

public class MenuScene extends World {
    public MenuScene() {
        //Buttons
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

    @Override
    public void act(long now) {

    }
}
