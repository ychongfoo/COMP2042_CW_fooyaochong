package game;

import javafx.stage.Stage;
import javafx.stage.Window;

public class MenuScene extends World{
    private static Stage stage;
    private static myButton playButton;
    private static myButton HSButton;
    private static myButton exitButton;

    @Override
    public void act(long now) {

    }

    public MenuScene(){
        //Buttons
        playButton = new myButton("PLAY BUTTON", 140,230,423);
        playButton.setOnMouseClicked(e -> {
            Director.playNow();
        });
        HSButton = new myButton("HIGH SCORES", 195,202.5,475);
        HSButton.setOnMouseClicked(e -> {
            //TODO event to be
        });
        exitButton = new myButton("EXIT", 72,264,525);
        exitButton.setOnMouseClicked(e -> {
            Director.exit();
        });

        add(new Bg("mainmenu.png"));
        add(playButton);
        add(HSButton);
        add(exitButton);

    }
}
