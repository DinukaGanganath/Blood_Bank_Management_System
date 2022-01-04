package com.teambeta.bloodbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController extends RegisterView {


    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtName;

    @FXML
    public TextField txtNIC;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    public Button btnRegister;

    @FXML
    private AnchorPane registerAncor;



    @FXML
    public void register(ActionEvent event) throws Exception {
        RegisterView registerView = new RegisterView();
        registerView.registerAdmin(txtName.getText(),txtEmail.getText(),txtPassword.getText(),txtConfirmPassword.getText(),txtNIC.getText(),txtPhone.getText());
    }

    @FXML
    public void cancel(ActionEvent event) throws Exception {
        txtName.setText(null);
        txtNIC.setText(null);
        txtPhone.setText(null);
        txtEmail.setText(null);
        txtPassword.setText(null);
        txtConfirmPassword.setText(null);
    }

    @FXML
    public void back(ActionEvent event) throws Exception {
        loginWindow();
    }


    public void loginWindow() throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Stage stage = (Stage) registerAncor.getScene().getWindow();
        stage.setScene(new Scene(root,630,522));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Login");
    }



}
