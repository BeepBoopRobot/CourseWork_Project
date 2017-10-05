import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import javax.swing.*;


public class testTransition {
    private static Scene defaultScene;
    private static Scene boneScene;
    private static Stage stage;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(testTransition::launch);
    }

    private static void close(WindowEvent we)
    {
        System.out.println("u fat");
    }

    private static void launch()
    {
        stage = new Stage();
        stage.setTitle("Transition Test");
        stage.setOnCloseRequest(testTransition::close);
        stage.setWidth(480);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();

        Pane transitionPane = new Pane();
        transitionPane.setStyle("-fx-background-color: black");

        GridPane defaultPane = new GridPane();
        defaultPane.setHgap(10);
        defaultPane.setVgap(10);
        defaultPane.setStyle("-fx-background-color: forestgreen");
        Image image = new Image("download.jpg");
        ImageView iv = new ImageView(image);
        defaultPane.add(iv,1,0);

        Button transToBone = new Button("ENTER THE BONE ZONE");
        defaultPane.add(transToBone, 1,1);
        transToBone.setOnAction((ActionEvent se) -> {enterBone();});

        GridPane boneZone = new GridPane();
        boneZone.setHgap(10);
        boneZone.setVgap(10);
        boneZone.setStyle("-fx-background-color: darkred");
        Image bone = new Image("skeleton-animated-gif-20.gif");
        ImageView iv2 = new ImageView(bone);
        boneZone.getChildren().add(iv2);

        Button exitBone = new Button("EXIT THE BONE ZONE");
        exitBone.setOnAction((ActionEvent se) -> {exitBone();});
        boneZone.add(exitBone,1,0);

        boneScene = new Scene(boneZone);
        defaultScene = new Scene(defaultPane);
        stage.setScene(defaultScene);

    }

    private static void enterBone() {
        FadeTransition ft = new FadeTransition(Duration.millis(1500), defaultScene);
        stage.setScene(boneScene);
    }

    private static void exitBone() {

        stage.setScene(defaultScene);
    }
}
