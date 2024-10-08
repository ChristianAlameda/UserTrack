package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Athlete;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.entity.DTOs.UserAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentDTO;
import com.example.demo.repository.AthleteRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    //============= GETTING ===================// 
    // USING
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Using
    public List<UserStudentDTO> getAllStudents(){
        return userRepository.getAllStudents();
    }

    // Using
    public List<UserAthleteDTO> getAllAthletes(){
        return userRepository.getAllAthletes();
    }

    // Using
    public List<UserStudentAthleteDTO> getAllStudentAthletes(){
        return userRepository.getAllStudentAthletes();
    }

    // USING
    public List<User> findByEmail(String email){        
        return userRepository.findByEmail(email);
    }
    
    // USING
    public List<User> findByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    // USING
    public List<User> findUsersRegisteredAfter(LocalDateTime date) {
        return userRepository.findUsersRegisteredAfter(date);
    }
    
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User findByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
    
    public List<User> findByEmailLike(String email) {
        return userRepository.findByEmailLike(email);
    }



    //============== Adding Users, Students, StudentAthletes ==============//
    // USING
    public User addUser(User user){
        return userRepository.save(user);
    }

    // USING
    @Transactional  
    public void addUserStudent(User user, Student student) {
        User savedUser = userRepository.save(user);
        student.setUserId(savedUser.getId());
        studentRepository.save(student);
    }

    // USING
    @Transactional  
    public void addUserAthlete(User user, Athlete athlete) {
        User savedUser = userRepository.save(user);
        athlete.setUserId(savedUser.getId());
        athleteRepository.save(athlete);
    }

    // USING
    @Transactional  
    public void addUserStudentAthlete(User user, Student student, Athlete athlete) {
        User savedUser = userRepository.save(user);
        student.setUserId(savedUser.getId());
        studentRepository.save(student);
        athlete.setUserId(savedUser.getId());
        athleteRepository.save(athlete);
    }

    // =================== Delete Users ===================//
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // USING
    public void deleteUserByEmail(String email){
        userRepository.deleteUserByEmail(email);
    }

    //==================== ETC ============================//
    public long countByLastName(String lastName){
        return userRepository.countByLastName(lastName);
    }
    

}
