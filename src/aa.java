import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

class aa {
    static void screenTransition(GridPane pane1, GridPane pane2, Group group) {

        Rectangle transitionScreen = new Rectangle(0, 0, 480, 500);
        transitionScreen.toFront();
        transitionScreen.setFill(Color.BLACK);
        group.getChildren().add(transitionScreen);
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
        sleeper.setOnSucceeded(event2 -> group.getChildren().remove(transitionScreen));
        changeScene.setOnSucceeded((event1 -> swapScreens(pane1, pane2, group)));
        new Thread(sleeper).start();
        new Thread(changeScene).start();
    }

    private static void swapScreens(GridPane pane1, GridPane pane2, Group group)
    {
        group.getChildren().remove(pane1);
        group.getChildren().add(pane2);
        pane2.toBack();
    }
}