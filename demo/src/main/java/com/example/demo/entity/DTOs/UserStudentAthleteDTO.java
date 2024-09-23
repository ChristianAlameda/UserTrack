package com.example.demo.entity.DTOs;

public class UserStudentAthleteDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String flag; // adding it

    private String className;
    private String grade;
    private String studentSchedule; 

    private Long userId; // Adding userId
    private int speed;
    private int height;
    private int weight;
    private int starRating;
    private String athleteSchedule;

    public UserStudentAthleteDTO() {}

    public UserStudentAthleteDTO(
        String email,
        String firstName,
        String lastName,
        String flag,
        
        String className,
        String grade,
        String studentSchedule,

        Long userId, // Added userId
        int speed,
        int height,
        int weight,
        int starRating,
        String athleteSchedule
    ) {
        this.userId = userId; // Initialize userId
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flag = flag;
        this.className = className;
        this.grade = grade;
        this.studentSchedule = studentSchedule;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(String studentSchedule) {
        this.studentSchedule = studentSchedule;
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
