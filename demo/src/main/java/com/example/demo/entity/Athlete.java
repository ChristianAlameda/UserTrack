package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "athletes")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")  // Use camelCase in Java but map to the DB column name
    private Long userId;

    private int speed;

    private int height;

    private int weight;

    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "athlete_schedule", nullable = false)
    private String athleteSchedule;

    public Athlete() {}

    public Athlete(Long userId, int speed, int height, int weight, int starRating, String athleteSchedule) {
        this.userId = userId;
        this.speed = speed;
        this.height = height;
        this.weight = weight;
        this.starRating = starRating;
        this.athleteSchedule = athleteSchedule;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public int getStarRating() { return starRating; }
    public void setStarRating(int starRating) { this.starRating = starRating; }

    public String getAthleteSchedule() { return athleteSchedule; }
    public void setAthleteSchedule(String athleteSchedule) {
        this.athleteSchedule = athleteSchedule;
    }
}
