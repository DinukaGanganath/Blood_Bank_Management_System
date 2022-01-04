package com.teambeta.bloodbank;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterView extends Application {

    String newName ;
    String newEmail ;
    String newPassword;
    String newConfirmPassword;
    String newNIC ;
    String newPhone;

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void registerAdmin(String name,String email,String password,String confirmPassword,String nic,String phone){
        newName = name;
        newEmail = email;
        newPassword = password;
        newConfirmPassword = confirmPassword;
        newNIC =nic;
        newPhone = phone;

        String query = "Insert into admins (name,email,password,nic,phone) values (?,?,?,?,?)";

        if(checkValidate()){

            try {
                DatabaseConnection dbCon = new DatabaseConnection();
                PreparedStatement ps = dbCon.getConnection().prepareStatement(query);

                ps.setString(1,newName);
                ps.setString(2,newEmail);
                ps.setString(3,newPassword);
                ps.setString(4,newNIC);
                ps.setString(5,newPhone);

                if(ps.executeUpdate()>0)
                {

                    RegisterController rc = new RegisterController();
                    rc.loginWindow();

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error occurred");
                    alert.show();

                }
            } catch (SQLException e) {e.printStackTrace();} catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public Boolean checkValidate(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(newName.equals("")){
            alert.setContentText("Please Enter Name");
            alert.show();
            return false;

        }
        else if(newNIC.equals("")){
            alert.setContentText("Please Enter NIC Number");
            alert.show();
            return false;

        }
        else if(!isValidNic(newNIC)){
            alert.setContentText("Please Enter Valid NIC Number");
            alert.show();
            return false;
        }
        else if(newPhone.equals("")){
            alert.setContentText("Please Enter Mobile Number");
            alert.show();
            return false;

        }
        else if(!isValidPhone(newPhone)){
            alert.setContentText("Please Enter Valid Mobile Number");
            alert.show();
            return false;
        }
        else if(newEmail.equals("")){
            alert.setContentText("Please Enter Email");
            alert.show();
            return false;

        }
        else if(!isValidEmail(newEmail)){
            alert.setContentText("Please Enter Valid Email");
            alert.show();
            return false;
        }
        else if(newPassword.equals("")){
            alert.setContentText("Please Enter Password");
            alert.show();
            return false;

        }else if(newConfirmPassword.equals("")){
            alert.setContentText("Please Enter Confirm Password");
            alert.show();
            return false;

        }
        else if(!newPassword.equals(newConfirmPassword)){
            alert.setContentText("Please enter correct password");
            alert.show();
            return false;

        }
        else {
            return true;
        }
    }

    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public  boolean isValidPhone(String phone)
    {
        String regex = "^\\d{10}$";
        return phone.matches(regex);
    }

    public  boolean isValidNic(String nic)
    {
        String regex = "\\d+";
        return nic.matches(regex);
    }


}
