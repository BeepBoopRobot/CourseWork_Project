import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class testTransition {
    private static Group group;
    private static GridPane boneZone;
    private static GridPane defaultPane;

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

        GridPane monkey = new GridPane();
        Image birb = new Image("birb.gif");
        ImageView ab = new ImageView(birb);
        monkey.getChildren().add(ab);
        Button exitAb = new Button("<");
        exitAb.setOnAction(event -> aa.screenTransition(monkey, defaultPane, group));
        monkey.getChildren().add(exitAb);
        Button enterAb = new Button("birb");
        enterAb.setOnAction(event -> aa.screenTransition(defaultPane, monkey, group));

        Image bone = new Image("skeleton-animated-gif-20.gif");
        ImageView bones = new ImageView(bone);
        Image image = new Image("download.jpg");
        ImageView iv = new ImageView(image);

        Button exit = new Button("<");
        exit.setOnAction(event -> aa.screenTransition(boneZone, defaultPane, group));
        boneZone.getChildren().addAll(bones, exit);
        group2.getChildren().add(boneZone);


        Button enter = new Button();
        enter.setText(">");
        enter.setOnAction(event -> aa.screenTransition(defaultPane, boneZone, group));

        defaultPane = new GridPane();
        defaultPane.setHgap(10);
        defaultPane.setVgap(10);
        defaultPane.add(iv, 1, 0);
        defaultPane.add(enter, 1, 1);
        defaultPane.add(enterAb, 1, 2);


        group.getChildren().add(defaultPane);
        stage.setScene(defaultScene);
    }

}
