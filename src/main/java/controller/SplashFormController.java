package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashFormController {
    public Label lblText;

    public void initialize(){
        Timeline timeline = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblText.setText("UI loading...");
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblText.setText("Plugin loading...");
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblText.setText("App loading...");
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblText.setText("Complete...");
            }
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    URL resource = this.getClass().getResource("/view/TextEditorForm.fxml");
                    Parent parent = FXMLLoader.load(resource);
                    Scene editorScene = new Scene(parent);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(editorScene);
                    primaryStage.setTitle("dep9 textEditor");
                    primaryStage.show();
                    primaryStage.centerOnScreen();
                    primaryStage.setMaximized(true);
                    lblText.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5);
        timeline.playFromStart();

    }
}
