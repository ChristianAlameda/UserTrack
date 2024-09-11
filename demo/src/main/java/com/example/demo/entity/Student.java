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

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "class_name")
    private String className;

    private String grade;

    @Column(name = "student_schedule", nullable = false)
    private String studentSchedule;

    // Constructors, getters, and setters
    public Student() {}

    public Student(Long userId, String className, String grade, String studentSchedule) {
        this.userId = userId;
        this.className = className; 
        this.grade = grade;
        this.studentSchedule = studentSchedule;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getStudentSchedule() { return studentSchedule; }
    public void setStudentSchedule(String studentSchedule) { this.studentSchedule = studentSchedule; }
}
