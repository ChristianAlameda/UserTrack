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

    private Long user_id;
    private String class_name;
    private String grade;

    @Column(name = "student_schedule", nullable = false)
    private String student_schedule;

    // Constructors, getters, and setters
    public Student() {}

    public Student(Long user_id, String class_name, String grade, String student_schedule){
        this.user_id = user_id;
        this.class_name = class_name; 
        this.grade = grade;
        this.student_schedule = student_schedule;
    }

    // Getters and Setters
    public Long getId(){ return this.id;}
    public void setId(Long id){this.id = id;}

    public Long getUserId(){ return this.user_id;}
    public void setUserId(Long user_id){this.user_id = user_id;}

    public String getClassName(){ return this.class_name;}
    public void setClassName(String class_name){ this.class_name = class_name;}

    public String getGrade(){ return this.grade;}
    public void setGrade(String grade){ this.grade = grade;}

    public String getStudentSchedule(){ return this.student_schedule;}
    public void setStudentSchedule(String student_schedule){this.student_schedule = student_schedule;}
}
