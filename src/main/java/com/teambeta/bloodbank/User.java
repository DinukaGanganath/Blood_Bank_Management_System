package com.teambeta.bloodbank;

public abstract class User {

     String nic;
     String fullName;
     String gender;
     String bloodGroup;
     String dateOfBirth;
     String phone;
     String city;
     String status;
     String date;

    abstract void setUserDetails(String nic,String fullName,String gender,String bloodGroup,String dateOfBirth,String city,String phone);

}
