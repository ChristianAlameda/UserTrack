package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.entity.DTOs.UserAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentDTO;
import com.example.demo.entity.Athlete;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // =============== FIND FUNCTIONS ===============//
    //Find a user by email
    List<User> findByEmail(String email);

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

    @Query("select new com.example.demo.entity.DTOs.UserStudentDTO( "+
        "u.email, u.firstName, u.lastName, u.flag, "+
        "s.userId, s.className, s.grade, s.studentSchedule) " +
        "from User u join Student s on u.id = s.userId")
    List<UserStudentDTO> getAllStudents();


    @Query("select new com.example.demo.entity.DTOs.UserAthleteDTO( " +
        "u.email, u.firstName, u.lastName, u.flag, " +
        "a.userId, a.speed, a.height, a.weight, a.starRating, a.athleteSchedule) " +
        "from User u join Athlete a on u.id = a.userId")
    List<UserAthleteDTO> getAllAthletes();


    @Query("select new com.example.demo.entity.DTOs.UserStudentAthleteDTO( " +
        "u.email, u.firstName, u.lastName, u.flag, "+
        "s.className, s.grade, s.studentSchedule, " +
        "a.userId, a.speed, a.height, a.weight, a.starRating, a.athleteSchedule) " +
        "from User u join Student s on u.id = s.userId " +
        "join Athlete a on u.id = a.userId")
    List<UserStudentAthleteDTO> getAllStudentAthletes();


    // ================== DELETE FUNCTION ===================//
    @Modifying
    @Query("delete from User u where u.email = :email")
    User deleteUserByEmail(@Param("email") String email);
    
}
