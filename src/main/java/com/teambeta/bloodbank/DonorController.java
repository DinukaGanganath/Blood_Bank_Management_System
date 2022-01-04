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


public class DonorController extends DonorView {

    @FXML
    private AnchorPane donorAnchor;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private ToggleGroup tgGender;

    @FXML
    private TextField txtPhone;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField txtCity;

    @FXML
    private ComboBox comboBloodGroup;

    @FXML
    private TextField txtWeight;

    @FXML
    private ToggleGroup tgPreviousDonations;

    @FXML
    private DatePicker lastDonateDate;

    @FXML
    private TextArea txtHealthIssues;

    @FXML
    public void initialize(){

        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
        comboBloodGroup.getItems().addAll("A+","A-","B+","B-","O+","O-","AB+","AB-");

    }


    @FXML
    public void back(ActionEvent event) throws Exception{
        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage stage = (Stage) donorAnchor.getScene().getWindow();
        stage.setScene(new Scene(root,530,492));
        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }

    @FXML
    public void cancel(ActionEvent event) throws Exception{
        txtFullName.setText(null);
        txtNic.setText(null);
        dob.setValue(null);
        lastDonateDate.setValue(null);
        txtCity.setText(null);
        txtPhone.setText(null);
        txtWeight.setText(null);
        txtHealthIssues.setText(null);
        comboBloodGroup.getItems().removeAll(comboBloodGroup.getItems());
    }

    @FXML
    public void save(ActionEvent event) throws Exception{

        DonorView donorView = new DonorView();

        RadioButton selectGender = (RadioButton)tgGender.getSelectedToggle();
        String tgGenderValue = selectGender.getText();

        RadioButton selectPreviousDonor = (RadioButton)tgPreviousDonations.getSelectedToggle();
        String tgPreviousDonationValue = selectPreviousDonor.getText();

        donorView.setUserDetails(txtNic.getText(),txtFullName.getText(),tgGenderValue,comboBloodGroup.getSelectionModel().getSelectedItem().toString(),dob.getValue().toString(),txtCity.getText(),txtPhone.getText());
        donorView.registerDonor(txtWeight.getText(),tgPreviousDonationValue,txtHealthIssues.getText(),lastDonateDate.getValue().toString());

    }

}
