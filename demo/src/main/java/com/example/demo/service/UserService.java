package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    // public User addUser(User user){
    //     return userRepository.save(user);
    // }

    @Transactional  // Ensures both user and student are saved together or rolled back in case of an error
    public void addUserAndStudent(User user, Student student) {
        // Step 1: Save the user
        User savedUser = userRepository.save(user);

        // Step 2: Set the userId for the student
        student.setUserId(savedUser.getId());

        // Step 3: Save the student
        studentRepository.save(student);
    }

    

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // additional
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public User findByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<User> findUsersByPartialEmail(String email) {
        return userRepository.findByEmailLike(email);
    }

    public List<User> findUsersRegisteredAfter(LocalDateTime date) {
        return userRepository.findUsersRegisteredAfter(date);
    }

    public long countByLastName(String lastName){
        return userRepository.countByLastName(lastName);
    }
    

}
