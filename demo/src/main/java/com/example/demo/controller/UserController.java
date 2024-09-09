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

import com.example.demo.entity.User;
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

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Get a user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
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
        List<User> users = userService.findUsersByPartialEmail(email);
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
