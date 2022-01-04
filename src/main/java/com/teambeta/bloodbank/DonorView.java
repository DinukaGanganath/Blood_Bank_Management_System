package com.teambeta.bloodbank;

import javafx.scene.control.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DonorView extends User {

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

    public void registerDonor(String weight,String previousDonations, String healthIssues, String lastDonationDate){


        String query = "Insert into donors (full_name,nic,gender,blood_group,date_of_birth,weight,phone,health_issues,previous_donation_status,date_of_last_blood_donate,date) values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            DatabaseConnection dbCon = new DatabaseConnection();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            PreparedStatement ps = dbCon.getConnection().prepareStatement(query);
            ps.setString(1,fullName);
            ps.setString(2,nic);
            ps.setString(3,gender);
           ps.setString(4,bloodGroup);
            ps.setString(5,dateOfBirth);
            ps.setString(6,weight);
            ps.setString(7,phone);
            ps.setString(8,healthIssues);
            ps.setString(9,previousDonations);
            ps.setString(10,lastDonationDate);
            ps.setString(11,dateFormat.format(cal.getTime()));


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
