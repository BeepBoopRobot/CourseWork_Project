import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;

import java.io.*;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


public class Main {

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }


    private static void launch() {
        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.show();

        String soundFile = "D:\\Music\\Yo Noid 2\\Jesse Hamel - Yo! Noid 2- Enter the Void OST - 10 Noid Void 3.mp3";
        String imageBak = "City17.jpg";
        Group group = new Group();
        Scene menuScene = new Scene(group, 500, 312, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        Image image = new Image(imageBak);

        VBox vb = new VBox();
        Button butt = new Button();

        ImagePattern pat = new ImagePattern(image);
        menuScene.setFill(pat);

        Media media = new Media(new File(soundFile).toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mv = new MediaView(mp);

        group.getChildren().add(menuPane);
        stage.setScene(menuScene);
        group.getChildren().add(mv);
    }
}
