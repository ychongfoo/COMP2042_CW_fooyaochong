package game;

public class MenuScene extends World{
    private myButton playButton;
    private myButton HSButton;
    private myButton exitButton;

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
        exitButton = new myButton("EXIT", 72,264,525);
        add(new Bg("mainmenu.png"));
        add(playButton);
        add(HSButton);
        add(exitButton);

    }
}
