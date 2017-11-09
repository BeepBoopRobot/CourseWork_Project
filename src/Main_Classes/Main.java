package Main_Classes;

import Models.*;
import Services.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


public class Main {

    public static DatabaseConnectionService database;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(Main::launch);
    }


    private static void launch() {
        database = new DatabaseConnectionService("src/Workspace.db");

        Stage stage = new Stage();
        stage.setTitle("Avoid Death");
        stage.setResizable(false);
        stage.show();

        String soundFile = "src/Sounds/Half - Life 2 Soundtrack- Intro.mp3";
        String imageBak = "images/City17.jpg";
        Group group = new Group();
        Scene menuScene = new Scene(group, 500, 312, Color.FORESTGREEN);
        GridPane menuPane = new GridPane();
        Image image = new Image(imageBak);

        ArrayList<ScreenSize> testList = new ArrayList<>();
        ScreenService.selectAll(testList, database);
        for(ScreenSize d:testList) System.out.println(d);

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
