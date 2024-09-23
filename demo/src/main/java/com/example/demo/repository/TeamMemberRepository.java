package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TeamMember;
import com.example.demo.entity.DTOs.UserAthleteDTO;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember,Long>{
    // any additional functions you want to make

    @Modifying
    @Query(value = "insert into team_members(team_id, user_id) " + 
                   "values(:teamId, :userId)", nativeQuery = true)
    public void addTeamMember(@Param("teamId") Long teamId, @Param("userId") Long userId);

    @Query("SELECT new com.example.demo.entity.DTOs.UserAthleteDTO(" +
       "u.email, u.firstName, u.lastName, u.flag, " +
       "a.userId, a.speed, a.height, a.weight, a.starRating, a.athleteSchedule) " +
       "FROM TeamMember tm " +
       "JOIN Athlete a ON tm.userId = a.userId " +
       "JOIN User u ON a.userId = u.id " +
       "WHERE tm.teamId = :teamId")
    public List<UserAthleteDTO> getTeamMembersWithDetailsOfTeamId(@Param("teamId") Long teamId);


}   
