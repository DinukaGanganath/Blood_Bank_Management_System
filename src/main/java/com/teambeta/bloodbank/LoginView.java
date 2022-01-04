package com.teambeta.bloodbank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginView extends Application {

    String newEmail;
    String newPassword;

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void checkAuth(String email, String password)
    {

         newEmail = email;
         newPassword = password;
        String query = "Select * from admins where email=? and password=?";

if(checkValidate()) {
    try {
        DatabaseConnection dbCon = new DatabaseConnection();
        PreparedStatement ps = dbCon.getConnection().prepareStatement(query);
        ps.setString(1, newEmail);
        ps.setString(2, newPassword);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
                    try {
                        Parent root =  FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root,530,492));
                        stage.getIcons().add(new Image("https://img.icons8.com/color/48/000000/drop-of-blood.png"));
                        stage.setResizable(false);
                        stage.setTitle("Dashboard");
                        stage.centerOnScreen();
                        stage.show();

                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                 else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Email or Password doesn't match with existing records");
                            alert.show();

                            }

                        }

        catch (SQLException e) {
                                e.printStackTrace();
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("Database Error");
                                alert.show();
                             }

                        }

                else {
                        return;
                }
    }

    public Boolean checkValidate(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(newEmail.equals("")){
            alert.setContentText("Please Enter Email");
            alert.show();
            return false;

        }
        else if(newPassword.equals("")){
            alert.setContentText("Please Enter Password");
            alert.show();
            return false;

        }
        else if(!isValid(newEmail)){
            alert.setContentText("Please Enter Valid Email");
            alert.show();
            return false;
        }
        else {
            return true;
        }
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
