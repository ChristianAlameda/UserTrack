package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Athlete;
import com.example.demo.entity.DTOs.UserAthleteDTO;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    // Custom function to find an Athlete by userId
    Athlete findByUserId(Long id);

    @Query("select new com.example.demo.entity.DTOs.UserAthleteDTO(u.email, u.firstName, u.lastName, u.flag, " +
    "a.userId, a.speed, a.height, a.weight, a.starRating, a.athleteSchedule) " +
    "from User u join Athlete a on u.id = a.userId " +
    "where a.userId = :id")
    UserAthleteDTO getUserAthleteById(@Param("id") Long id);

}
