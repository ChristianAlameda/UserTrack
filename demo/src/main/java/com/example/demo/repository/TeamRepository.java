package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Team;
import com.example.demo.entity.TeamMember;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long>{
    // any additional functions you want to make

    @Query(value = "SELECT t.* " +
                   "FROM team_members tm " +
                   "JOIN teams t ON tm.team_id = t.id " +
                   "WHERE tm.user_id = :userId", nativeQuery = true)
    Team getTeamNameById(@Param("userId") Long userId);

}   