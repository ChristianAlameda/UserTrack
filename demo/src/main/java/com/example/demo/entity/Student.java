package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "class_name", length = 255, nullable = false)
    private String class_name;

    @Column(name = "grade", length = 2, nullable = true)
    private String grade;

    @Column(name = "schedule", length = 255, nullable = true)
    private String schedule;

    // Getters and Setters
    public Long getId(){ return this.id;}
    public void setId(Long id){this.id = id;}

    public Long getUserId(){ return this.user_id;}
    public void setUserId(Long user_id){this.user_id = user_id;}

    public String getClassName(){ return this.class_name;}
    public void setClassName(String class_name){ this.class_name = class_name;}

    public String getGrade(){ return this.grade;}
    public void setGrade(String grade){ this.grade = grade;}

    public String getSchedule(){ return this.schedule;}
    public void setSchedule(String schedule){this.schedule = schedule;}
}
