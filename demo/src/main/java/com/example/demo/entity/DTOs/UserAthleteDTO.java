package com.example.demo.entity.DTOs;

public class UserAthleteDTO {
    // User
    private String email;
    private String firstName;
    private String lastName;
    private String flag; // adding it

    // Athlete
    private Long userId; // Adding userId
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
        String flag,
        
        
        Long userId, // Added userId
        int speed,
        int height,
        int weight,
        int starRating,
        String athleteSchedule
    ) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flag = flag;
        
        
        this.userId = userId; // Initialize userId
        this.speed = speed;
        this.height = height;
        this.weight = weight;
        this.starRating = starRating;
        this.athleteSchedule = athleteSchedule;
    }

    // Getters and Setters
    public Long getUserId() { // Added getter for userId
        return userId;
    }

    public void setUserId(Long userId) { // Added setter for userId
        this.userId = userId;
    }

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

    public String getFlag(){
        return flag;
    }

    public void setFlag(String flag){
        this.flag = flag;
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
