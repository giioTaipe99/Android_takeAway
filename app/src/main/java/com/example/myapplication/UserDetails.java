package com.example.myapplication;

public class UserDetails {
    private String firstName;
    private String lastName;
    private String mail;
    private String bankDetails;

    public UserDetails(String firstName, String lastName, String mail, String bankDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.bankDetails = bankDetails;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getBankDetails() {
        return bankDetails;
    }
}
