package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainContainerViewController extends AbstractController implements Initializable{
    @FXML
    Pane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _mainPane = mainPane;
        pushChild("QuestionView");
    }
}
