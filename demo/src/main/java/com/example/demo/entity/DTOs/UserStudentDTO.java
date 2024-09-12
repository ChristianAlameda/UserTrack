package com.example.demo.entity.DTOs;

public class UserStudentDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String flag;
    private String className;
    private String grade;
    private String studentSchedule;

    public UserStudentDTO() {}

    public UserStudentDTO(
        String email,
        String firstName,
        String lastName,
        String flag,

        String className,
        String grade,
        String studentSchedule
    ) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flag = flag;
        this.className = className;
        this.grade = grade;
        this.studentSchedule = studentSchedule;
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

    public String getFlag(){
        return flag;
    }

    public void setFlag(String flag){
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
}
