package com.teambeta.bloodbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController extends LoginView {

    @FXML
    public TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login() throws IOException
    {
        LoginView loginView = new LoginView();
        loginView.checkAuth(txtEmail.getText(),txtPassword.getText());
    }

    @FXML
    public void cancel() throws IOException
    {
        txtEmail.setText(null);
        txtPassword.setText(null);
    }

    @FXML
    public void register() throws Exception{

            Parent root =  FXMLLoader.load(getClass().getResource("register-view.fxml"));
            Stage stage = (Stage) txtEmail.getScene().getWindow();
            stage.setScene(new Scene(root,525,687));
            stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
            stage.setTitle("Register");

    }

}
