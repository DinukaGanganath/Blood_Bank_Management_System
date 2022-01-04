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

public class RecipientController extends RecipientView{

    @FXML
    private AnchorPane recipientAnchor;


    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private ToggleGroup tgGender;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtPhone;

    @FXML
    private ComboBox comboBloodGroup;




    @FXML
    public void initialize(){

        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
        comboBloodGroup.getItems().addAll("A+","A-","B+","B-","O+","O-","AB+","AB-");

    }


    @FXML
    public void back(ActionEvent event) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) recipientAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    public void cancel(ActionEvent event) throws Exception {
        txtFullName.setText(null);
        txtNic.setText(null);
        dob.setValue(null);
        txtCity.setText(null);
        txtPhone.setText(null);
        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
    }

    @FXML
    public void save(ActionEvent event) throws Exception {

        RecipientView recipientView = new RecipientView();

        RadioButton selectedGender = (RadioButton) tgGender.getSelectedToggle();
        String tgGenderValue = selectedGender.getText();

        recipientView.setUserDetails(txtNic.getText(),txtFullName.getText(),tgGenderValue,comboBloodGroup.getSelectionModel().getSelectedItem().toString(),dob.getValue().toString(),txtCity.getText(),txtPhone.getText());
        recipientView.registerRecipient();
    }

}
