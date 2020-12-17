package game.controllers;

import game.Main;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * {@code mp3Player} handles all media Playing instances.
 */
public class mp3Player {
    /**
     * Path directory to etc files.
     */
    public static final String ETC_PATH = Main.RESOURCES + "etc/";
    /**
     * Stores an instance of JavaFX {@link MediaPlayer}.
     */
    private MediaPlayer mediaPlayer;

    /**
     * Creates an mp3Player.
     */
    public mp3Player() {

    }

    /**
     * Plays the music that is passed in.
     *
     * @param mp3 the name of the file of the song to be used.
     */
    public void playMusic(String mp3) {
        String mp3File = ETC_PATH.replace("file:", "") + mp3 + ".mp3";
        Media sound = new Media(new File(mp3File).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * Stops playing the music.
     */
    public void stopMusic() {
        mediaPlayer.stop();
    }
}
