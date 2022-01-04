package com.teambeta.bloodbank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    private AnchorPane dashboardsAnchor;

    @FXML
    void donate(ActionEvent event) {

    }

    @FXML
    void donorRegister(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("donor-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,525,894));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Donor Details");
        stage.centerOnScreen();
    }

    @FXML
    void recipientRegister(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("recipient-view.fxml"));
        Stage stage = (Stage) dashboardsAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,525,590));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Recipient Details");
        stage.centerOnScreen();
    }

    @FXML
    void request(ActionEvent event) {

    }



}
