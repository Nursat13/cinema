package sample;

import dataBase.DBManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Connection connection = null;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    DBManager dbManager;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSignin;

    @FXML
    private Label btnForgot;

    @FXML
    private Button btnFB;

    @FXML
    private Button btnSignup;

    @FXML
    private Label lblErrors;

    @FXML
    private Button btnexit;

    @FXML
    public void exit(){
        Stage stage = (Stage)btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void signup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/signup_page.fxml"));
            Stage stage = (Stage) btnSignup.getScene().getWindow();
            stage.setScene(new Scene(root, 854, 503));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signin(){
        connection = dbManager.connect();

        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login=? AND password=?");
            preparedStatement.setString(1, txtUsername.getText());
            preparedStatement.setString(2, txtPassword.getText());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                resultSet.close();
                preparedStatement.close();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_page.fxml"));
                Stage stage = (Stage)btnSignin.getScene().getWindow();
                stage.setScene(new Scene(root, 854, 503));
                stage.show();
            }
        }catch (Exception et) {
            et.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }
}
