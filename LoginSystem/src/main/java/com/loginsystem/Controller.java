package com.loginsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller extends SQLManager{
    @FXML
    private Button loginBTN, signBTN;
    @FXML
    private PasswordField passField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passFieldCon;

    private Scene scene;
    private Stage stage;

    public Controller()
    {
        create_connection();
    }

    @FXML
    private void LoginPress()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String user = emailField.getText();
        String pass = passField.getText();
        boolean valid_user = exec_cursor("SELECT user_name FROM account_info WHERE user_name = '" + user + "';");
        boolean valid_pass = exec_cursor("SELECT pass_word FROM account_info WHERE pass_word = '" + pass + "';");
        alert.setTitle("Login");
        if (valid_user && valid_pass) {
            alert.setHeaderText("Success");
            alert.setContentText("You have logged in Successfully");
        }
        else {
            alert.setHeaderText("Failure");
            alert.setContentText("You may have entered the wrong information");
        }
        alert.show();

    }

    public void SignUpPress(ActionEvent event) throws IOException {
        signUpScene(event);
    }

    public void signUpScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("SignUp.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void switchLoginScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("Main.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void CreateBTNPress(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String user = emailField.getText();
        String pass = passField.getText();
        String pass2 = passFieldCon.getText();
        boolean length_ok = false;
        boolean pass_ok = false;
        if(user.length() > 2 && pass.length() > 2 && pass2.length() > 2)
        {
            length_ok = true;
        }
        else {
            alert.setHeaderText("Error");
            alert.setContentText("Don't leave any field empty");
            alert.show();
        }
        if(pass.equals(pass2) && !pass.isEmpty())
        {
            pass_ok = true;
        }
        else {
            alert.setHeaderText("Error");
            alert.setContentText("Your passwords do not match");
            alert.show();
        }
        if(length_ok && pass_ok) {
            add_new_info("insert into account_info values ('" + user + "', '" + pass + "');");
            alert.setHeaderText("Success");
            alert.setContentText("Account created!");
            alert.show();
            switchLoginScene(event);
        }
    }
}
