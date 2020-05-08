package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPage implements Initializable {

    @FXML
    private Button ik;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ik.setOnMousePressed(event -> {
            ik.setStyle("-fx-background-color: #FFFFFF");
        });
    }
}
