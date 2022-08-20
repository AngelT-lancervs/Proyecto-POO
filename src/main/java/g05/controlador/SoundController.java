package g05.controlador;

import g05.App;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundController {


    private static File file;
    private static Media media;
    private static MediaPlayer mp;

    /**
     * Sonidos para javafx media
     */
    public static void button_hoverSound(){
        file = new File(App.pathSound+"button-hover.mp3");
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();
    }
}
