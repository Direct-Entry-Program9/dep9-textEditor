package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TextEditorFormController {
    public HTMLEditor txtEditor;
    public MenuItem mnuNew;
    public MenuItem mnuOpen;
    public MenuItem mnuSave;
    public MenuItem mnuPrint;
    public MenuItem mnuClose;
    public MenuItem mnuAbout;
    public MenuItem mnuSelectAll;
    public MenuItem mnuCut;
    public MenuItem mnuCopy;
    public MenuItem mnuPaste;

    public void initialize(){

        mnuSelectAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        mnuClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.exit(0);
                Platform.exit();
            }
        });

        mnuNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtEditor.setHtmlText("");
            }
        });

        mnuAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/view/AboutForm.fxml"));
                    Scene scene = new Scene(parent);

                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("About");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                    stage.sizeToScene();


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}
