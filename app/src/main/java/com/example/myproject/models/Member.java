package com.example.myproject.models;

import java.io.Serializable;

public class Member implements Serializable {
    private String fullName;
    private String email;
    private String phone;
    private String travelPlace;
    private String transportationMode;
    private String budget;
    private String duration;
    private String description;

    public Member() {
    }

    public Member(String fullName, String email, String phone, String travelPlace, String transportationMode, String budget, String duration, String description) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.travelPlace = travelPlace;
        this.transportationMode = transportationMode;
        this.budget = budget;
        this.duration = duration;
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(String travelPlace) {
        this.travelPlace = travelPlace;
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
