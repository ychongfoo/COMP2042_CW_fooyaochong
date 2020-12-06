package game.Views;

import game.Controllers.Director;
import game.Controllers.World;
import game.Models.Bg;
import game.Models.myButton;

public class MenuScene extends World {

    @Override
    public void act(long now) {

    }

    public MenuScene(){
        //Buttons
        myButton infoButton = new myButton("INFO BUTTON", 50, 527, 19);
        infoButton.setOnMouseClicked(e -> {
            //TODO event to be
        });
        myButton playButton = new myButton("PLAY BUTTON", 140, 230, 423);
        playButton.setOnMouseClicked(e -> Director.playNow());
        myButton HSButton = new myButton("HIGH SCORES", 195, 202.5, 475);
        HSButton.setOnMouseClicked(e -> {
            //TODO event to be
        });
        myButton exitButton = new myButton("EXIT", 72, 264, 525);
        exitButton.setOnMouseClicked(e -> Director.exit());

        add(new Bg("mainmenu.png"));
        add(infoButton);
        add(playButton);
        add(HSButton);
        add(exitButton);

    }
}
