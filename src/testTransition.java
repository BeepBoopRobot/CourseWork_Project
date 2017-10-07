import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class testTransition {
    private static Group group;
    private static GridPane boneZone;
    private static GridPane defaultPane;
    private static Rectangle transitionScreen;

    public static void main(String[] args) {
        new JFXPanel();
        Platform.runLater(testTransition::launch);
    }

    private static void launch() {
        Stage stage = new Stage();
        stage.setTitle("Transition Test");
        stage.setResizable(false);
        stage.show();

        group = new Group();
        Scene defaultScene = new Scene(group, 480, 500, Color.FORESTGREEN);
        Group group2 = new Group();
        boneZone = new GridPane();
        boneZone.setHgap(10);
        boneZone.setVgap(10);
        Image bone = new Image("skeleton-animated-gif-20.gif");
        ImageView bonez = new ImageView(bone);
        Image image = new Image("download.jpg");
        ImageView iv = new ImageView(image);
        Button bobob = new Button("Exit the bone zone");
        bobob.setOnAction(event -> {
            group.getChildren().addAll(transitionScreen);
            FadeTransition ft = new FadeTransition((Duration.millis(2000)), transitionScreen);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ignored) {
                    }
                    return null;
                }
            };
            Task<Void> changeScene = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(event2 -> group.getChildren().removeAll(transitionScreen));
            changeScene.setOnSucceeded((event1 -> exitBone()));
            new Thread(sleeper).start();
            new Thread(changeScene).start();

        });
        boneZone.getChildren().addAll(bonez, bobob);
        group2.getChildren().add(boneZone);


        transitionScreen = new Rectangle(0, 0, 480, 500);
        transitionScreen.toFront();
        transitionScreen.setFill(Color.BLACK);

        Button btnForward = new Button();
        btnForward.setText(">");
        btnForward.setOnAction(event -> {
            group.getChildren().addAll(transitionScreen);
            FadeTransition ft = new FadeTransition((Duration.millis(2000)), transitionScreen);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setCycleCount(2);
            ft.setAutoReverse(true);
            ft.play();
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ignored) {
                    }
                    return null;
                }
            };
            Task<Void> changeScene = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(event2 -> group.getChildren().removeAll(transitionScreen));
            changeScene.setOnSucceeded((event1 -> enterBone()));
            new Thread(sleeper).start();
            new Thread(changeScene).start();

        });

        defaultPane = new GridPane();
        defaultPane.setHgap(10);
        defaultPane.setVgap(10);
        defaultPane.add(iv, 1, 0);
        defaultPane.add(btnForward, 1, 1);


        group.getChildren().add(defaultPane);
        stage.setScene(defaultScene);

    }

    private static void enterBone() {
        group.getChildren().remove(defaultPane);
        group.getChildren().add(boneZone);
        boneZone.toBack();
    }

    private static void exitBone() {
        group.getChildren().remove(boneZone);
        group.getChildren().add(defaultPane);
        defaultPane.toBack();
    }

}
