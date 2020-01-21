package com.example.projectdecember.pojo;

public class UserInfo {

    private String fullName;
    private String contactNumber;
    private boolean status;

    public UserInfo(String fullName, String contactNumber, boolean status) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
