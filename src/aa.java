import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class aa extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 300, Color.BLACK);
        primaryStage.setTitle("JavaFX Scene Graph Demo");

        final DoubleProperty leftEdgeOpacity = new SimpleDoubleProperty(0);
        final DoubleProperty rightEdgeOpacity = new SimpleDoubleProperty(0);

        Pane pane = new Pane();
        Rectangle rec1 = new Rectangle(0, 0, 300, 200);
        rec1.setFill(Color.RED);
        rec1.setOnMousePressed(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(500), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(1500), new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(leftEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.ZERO, new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.ZERO, new KeyValue(leftEdgeOpacity, 1))
            );
            timeline.play();
        });
        Rectangle rec2 = new Rectangle(100, 50, 100, 100);

        rec2.setStyle("-fx-fill: linear-gradient(to right, left-col, right-col);");


        group.styleProperty().bind(
                Bindings.format("left-col: rgba(0,128,0,%f); right-col: rgba(0,128,0,%f);", leftEdgeOpacity, rightEdgeOpacity)
        );

        Button btnForward = new Button();
        btnForward.setText(">");
        btnForward.setOnAction(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(leftEdgeOpacity, 0)),
                    new KeyFrame(Duration.ZERO, new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(500), new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(1500), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2500), new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2500), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(3000), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(3500), new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(4000), new KeyValue(leftEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(4000), new KeyValue(rightEdgeOpacity, 0))
            );

            System.out.println("break");
            Timeline timeline2 = new Timeline(
                    new KeyFrame(Duration.millis(2500), new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2500), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(3000), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(3500), new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(4000), new KeyValue(leftEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(4000), new KeyValue(rightEdgeOpacity, 0))

            );
            timeline.play();
            timeline.play();
        });

        Button btnBackward = new Button();
        btnBackward.setText("<");
        btnBackward.setOnAction(event -> {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(500), new KeyValue(leftEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(1500), new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(leftEdgeOpacity, 0)),
                    new KeyFrame(Duration.millis(2000), new KeyValue(rightEdgeOpacity, 0)),
                    new KeyFrame(Duration.ZERO, new KeyValue(rightEdgeOpacity, 1)),
                    new KeyFrame(Duration.ZERO, new KeyValue(leftEdgeOpacity, 1))
            );
            timeline.play();
        });

        pane.getChildren().addAll(rec1, rec2);
        group.getChildren().addAll(pane);
        group.getChildren().addAll(btnForward);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}