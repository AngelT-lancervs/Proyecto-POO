package g05.controlador;

import g05.App;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

/**
 * Controlador para el sonido el bingo
 */
public class SoundController extends Thread {
    MediaPlayer mp;
    Bingo_soundtrack bs = new Bingo_soundtrack();
    /**
     * Sonidos para javafx media
     */
    public void button_hoverSound() {
        File file = new File(App.pathSound + "button-hover.mp3");
        Media media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        run();
    }

    /**
     * Sonidos para el juego del bingo
     */
    public void bingo_correctSound() {
        File file = new File(App.pathSound + "/sonidosJuego/correcto.mp3");
        Media media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        run();
    }

    /**
     * Sonido de error
     */
    public void bingo_errorSound() {

        File file = new File(App.pathSound + "/sonidosJuego/error.mp3");
        Media media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        run();

    }

    /**
     * Sonido de fin del juego
     */
    public void bingo_congratulationsSound() {

        File file = new File(App.pathSound + "/sonidosJuego/congratulations.mp3");
        Media media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        run();

    }

    public void bingo_soundtrackSound(boolean b) {

        if(b) {
            bs.start();
        } else if (!b) {
            bs.stopMedia();
        }
}

    @Override
    public void run() {
        try {
            Thread.sleep(20);
            mp.play();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Bingo_soundtrack extends Thread {

    Media media = new Media(new File(App.pathSound+"/sonidosJuego/juego-soundtrack.mp3").toURI().toString());
    MediaPlayer mps = new MediaPlayer(media);

    @Override
    public void run() {
        try {
            mps.setCycleCount(MediaPlayer.INDEFINITE);
            mps.play();
            Thread.sleep(500);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void stopMedia(){
        mps.stop();
    }
}
