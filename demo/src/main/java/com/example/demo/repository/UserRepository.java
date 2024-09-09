package com.example.demo.repository;

import com.example.demo.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom queries here

    //Find a user by email
    User findByEmail(String email);

    //Find all users with a specific first name
    List<User> findByFirstName(String firstName);

    // Find users by both first name and last name
    User findByFirstNameAndLastName(String firstName, String lastName);

    // Custom query to find users by partial email match
    @Query("select u from User u where u.email like %:email%")
    List<User> findByEmailLike(@Param("email") String email);

    // Custom query to find users registered after a specific date
    // 2024-09-07T12:30:00
    @Query("SELECT u FROM User u WHERE u.createdAt > :date")
    List<User> findUsersRegisteredAfter(@Param("date") LocalDateTime date);

    // Count the number of users with a specific last name
    long countByLastName(String lastName);

    // // Delete users by their email
    // void deleteByEmail(String email);
}
