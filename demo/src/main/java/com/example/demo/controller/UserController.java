package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Athlete;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.entity.DTOs.UserAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentDTO;
import com.example.demo.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // adds user: good
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.printf("user", user, 1);
        return userService.addUser(user);
    }

    // adds user student: good
    @PostMapping("/addUserStudent") 
    public String addUserStudent(@RequestBody UserStudentDTO userStudentDTO) {
        // Create User and Student objects from DTO
        User user = new User();
        user.setEmail(userStudentDTO.getEmail());
        user.setFirstName(userStudentDTO.getFirstName());
        user.setLastName(userStudentDTO.getLastName());
        // user.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));


        Student student = new Student();
        student.setClassName(userStudentDTO.getClassName());
        student.setGrade(userStudentDTO.getGrade());
        student.setStudentSchedule(userStudentDTO.getStudentSchedule());//"MWF 2-4" // userStudentDTO.getStudentSchedule() 
        
        System.out.println("xx");

        // Call the service to add user and student
        userService.addUserStudent(user, student);

        return "User and Student added successfully";
    }

    // add user athlete
    @PostMapping("/addUserAthlete")
    public String addUserAthlete(@RequestBody UserAthleteDTO userAthleteDTO) {

        User user = new User();
        user.setEmail(userAthleteDTO.getEmail());
        user.setFirstName(userAthleteDTO.getFirstName());
        user.setLastName(userAthleteDTO.getLastName());

        Athlete athlete = new Athlete();
        athlete.setSpeed(userAthleteDTO.getSpeed());
        athlete.setHeight(userAthleteDTO.getHeight());
        athlete.setWeight(userAthleteDTO.getWeight());
        athlete.setStarRating(userAthleteDTO.getStarRating());
        athlete.setAthleteSchedule(userAthleteDTO.getAthleteSchedule()); //"MWF 2-4" //userAthleteDTO.getAthleteSchedule()

        System.out.printf("userAthleteDTO", userAthleteDTO.getAthleteSchedule(), 3);

        // Save the user and athlete
        userService.addUserAthlete(user, athlete);
        return "User and Athlete added successfully";
    }


    
    // adds User Student Athlete
    @PostMapping("/addUserStudentAthlete") // change this
    public String addUserStudentAthlete(@RequestBody UserStudentAthleteDTO userStudentAthleteDTO) {

        User user = new User();
        user.setEmail(userStudentAthleteDTO.getEmail());
        user.setFirstName(userStudentAthleteDTO.getFirstName());
        user.setLastName(userStudentAthleteDTO.getLastName());
        // user.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        Student student = new Student();
        student.setClassName(userStudentAthleteDTO.getClassName());
        student.setGrade(userStudentAthleteDTO.getGrade());
        student.setStudentSchedule("MWF 2-4");//"MWF 2-4"//userStudentAthleteDTO.getAthleteSchedule()

        Athlete athlete = new Athlete();
        athlete.setSpeed(userStudentAthleteDTO.getSpeed());
        athlete.setHeight(userStudentAthleteDTO.getHeight());
        athlete.setWeight(userStudentAthleteDTO.getWeight());
        athlete.setStarRating(userStudentAthleteDTO.getStarRating());
        athlete.setAthleteSchedule("MWF 2-4");//"MWF 2-4"//userStudentAthleteDTO.getAthleteSchedule()

        // Call the service to add user and student
        userService.addUserStudentAthlete(user, student, athlete);

        return "User Student Athlete added successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Get a user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> getUserByEmail(@PathVariable String email){
        List<User> user = userService.findByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    } 

    // Get a user by name
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName){
        List<User> user = userService.findByFirstName(firstName);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    } 

    // Get a user by firstName and LastName
    @GetMapping("/firstNameAndlastName/{firstName}/{lastName}")
    public ResponseEntity<User> getUserByFirstNameAndLastName(
        @PathVariable String firstName, 
        @PathVariable String lastName){
        User user = userService.findByFirstNameAndLastName(firstName, lastName);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Get a user by email
    @GetMapping("/byEmail")
    public ResponseEntity<List<User>> getUsersByPartialEmail(@RequestParam String email) {
        List<User> users = userService.findByEmailLike(email);
        return users != null && !users.isEmpty() ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }

    // Get users registered after a certain date
    @GetMapping("/date")
    public ResponseEntity<List<User>> getUsersByDate(@RequestParam String date) {
        // Parse the date string to LocalDateTime
        LocalDateTime parsedDate = LocalDateTime.parse(date);
        List<User> users = userService.findUsersRegisteredAfter(parsedDate);
        return users != null && !users.isEmpty() ? ResponseEntity.ok(users) : ResponseEntity.notFound().build();
    }

    // Count the number of users that have the same last name
    @GetMapping("/lastNameCount/{lastName}")
    public ResponseEntity<Long> getCountOfLastName(@PathVariable String lastName){
        long numUsers = userService.countByLastName(lastName);
        return ResponseEntity.ok(numUsers);
    }

    // @DeleteMapping("/deleteByEmail")
    // public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
    //     userService.deleteByEmail(email);
    //     return ResponseEntity.noContent().build();
    // }


    
}
