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

    private Long user_Id;

    private int speed;

    private int height;

    private int weight;

    private int star_rating;

    @Column(name="athlete_schedule", nullable = false)
    private String athlete_schedule;

    public Athlete(){}

    public Athlete(Long user_Id, int speed, int height, int weight, int star_rating, String athlete_schedule){
        this.user_Id = user_Id;
        this.speed = speed;
        this.height = height;
        this.weight = weight;
        this.star_rating = star_rating;
        this.athlete_schedule = athlete_schedule;
    }
    


    // Getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Long getUserId() {return user_Id;}
    public void setUserId(Long user_Id) {this.user_Id = user_Id; }
   
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
    
    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height; }

    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}

    public int getStarRating() {return star_rating;}
    public void setStarRating(int star_rating) {this.star_rating = star_rating;}

    public String getAthleteSchedule() {return athlete_schedule;}
    public void setAthleteSchedule(String athlete_schedule) {
        System.out.printf("athlete_schedule", athlete_schedule ,2);
        this.athlete_schedule = athlete_schedule;
        System.out.printf("this.athlete_schedule", this.athlete_schedule ,3);
        
    }
}
