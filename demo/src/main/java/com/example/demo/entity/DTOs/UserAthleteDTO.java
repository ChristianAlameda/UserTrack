package com.example.demo.entity.DTOs;

public class UserAthleteDTO {
    // User
    private String email;
    private String firstName;
    private String lastName;

    // Athlete
    private int speed;
    private int height;
    private int weight;
    private int starRating;
    private String athleteSchedule;

    public UserAthleteDTO() {}

    public UserAthleteDTO(
        String email,
        String firstName,
        String lastName,
        int speed,
        int height,
        int weight,
        int starRating,
        String athleteSchedule
    ) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speed = speed;
        this.height = height;
        this.weight = weight;
        this.starRating = starRating;
        this.athleteSchedule = athleteSchedule;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getAthleteSchedule() {
        return athleteSchedule;
    }

    public void setAthleteSchedule(String athleteSchedule) {
        this.athleteSchedule = athleteSchedule;
    }
}
