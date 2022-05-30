package com.example.lubetrackapp.Utils;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("Id") private int Id;
    @SerializedName("UserId") private int UserId;
    @SerializedName("FirstName") private String FirstName;
    @SerializedName("LastName") private String LastName;
    @SerializedName("UserName") private String UserName;
    @SerializedName("EmailId") private String EmailId;
    @SerializedName("ContactNo1") private String ContactNo1;
    @SerializedName("Address") private String Address;
    @SerializedName("ClientName") private String ClientName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getContactNo1() {
        return ContactNo1;
    }

    public void setContactNo1(String contactNo1) {
        ContactNo1 = contactNo1;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }
}
