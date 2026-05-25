package com.realestate.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterUserDto {

    @NotBlank(message = "Name is required")
    private String userName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    private String userEmail;

    @NotBlank(message = "Password is required")
    private String userPassword;
    
    // 👇 ADD THIS FIELD TO MATCH YOUR USER ENTITY ROLE MANAGEMENT
    @NotBlank(message = "Role is required")
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    // 👇 ADD THESE GETTER/SETTER METHODS FOR THE ROLE
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}