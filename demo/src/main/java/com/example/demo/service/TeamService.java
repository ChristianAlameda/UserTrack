package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Team;
import com.example.demo.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    // ========== GETTING ================//

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamNameByUserId(Long userId){
        return teamRepository.getTeamNameById(userId);
    }

}
