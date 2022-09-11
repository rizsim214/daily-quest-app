package com.freedev.dailyquest.users;

import java.util.Date;

// This is the Object Model of Users

public class User {
    private Integer userID;
    private String userEmail, userPassword, userAddress, userPhoneNumber,  userName, userStatus;
    private Date createdAt= new Date(), updateAt;

    public User() {}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User [createdAt=" + createdAt + ", updateAt=" + updateAt + ", userAddress=" + userAddress
                + ", userEmail=" + userEmail + ", userID=" + userID + ", userName=" + userName + ", userPassword="
                + userPassword + ", userPhoneNumber=" + userPhoneNumber + ", userStatus=" + userStatus + "]";
    }
    
}
