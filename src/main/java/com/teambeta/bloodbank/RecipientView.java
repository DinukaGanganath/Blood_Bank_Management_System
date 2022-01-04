package com.teambeta.bloodbank;

import javafx.scene.control.Alert;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RecipientView extends User{

    @Override
    public void setUserDetails(String nic, String fullName, String gender, String bloodGroup, String dateOfBirth, String city, String phone) {

        this.nic = nic;
        this.fullName = fullName;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.phone = phone;

    }

    public void registerRecipient(){

        String query = "Insert into recipients (nic,name,gender,blood_group,date_of_birth,city,phone,date) values (?,?,?,?,?,?,?,?)";


            try {
                DatabaseConnection dbCon = new DatabaseConnection();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();

                PreparedStatement ps = dbCon.getConnection().prepareStatement(query);
                ps.setString(1,nic);
                ps.setString(2,fullName);
                ps.setString(3,gender);
                ps.setString(4,bloodGroup);
                ps.setString(5,dateOfBirth);
                ps.setString(6,city);
                ps.setString(7,phone);
                ps.setString(8,dateFormat.format(cal.getTime()));


                if(ps.executeUpdate()>0)
                {
                    System.out.println("Successfully Add");

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Error occurred");
                    alert.show();


                    System.out.println("no");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

}
