package com.rest.service.farmket.model.dto;

import com.rest.service.farmket.model.User;

public class UserDto {
    
    private String username;
    private String password;
    private String email;
    private String phone;
    private String city;
    private String name;
    private String businessTitle;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public String getCity() {
    	return this.city;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCity(city);
        user.setPhone(phone);
        user.setName(name);
        user.setBusinessTitle(businessTitle);
        
        return user;
    }
    
}