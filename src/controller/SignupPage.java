package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupPage implements Initializable {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSignin;

    @FXML
    private Button btnFB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;

    @FXML
    private ChoiceBox<?> txtGender;

    @FXML
    private Button btnexit;

    @FXML
    private Button btnSignup;

    @FXML
    public void exit(){
        Stage stage = (Stage)btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void signup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
            Stage stage = (Stage) btnexit.getScene().getWindow();
            stage.setScene(new Scene(root, 854, 503));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
