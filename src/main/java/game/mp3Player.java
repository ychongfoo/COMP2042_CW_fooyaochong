package game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import static game.Main.RESOURCES;

public class mp3Player {
    public static final String ETC_PATH = RESOURCES + "etc/";

    private MediaPlayer mediaPlayer;

    public mp3Player() {
    }

    public void playMusic(String mp3) {
        String mp3File = ETC_PATH.replace("file:", "") + mp3 + ".mp3";
        Media sound = new Media(new File(mp3File).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic() {
        mediaPlayer.stop();
    }
}
