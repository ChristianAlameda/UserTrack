package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TeamMember;
import com.example.demo.entity.DTOs.UserAthleteDTO;
import com.example.demo.repository.TeamMemberRepository;

import jakarta.transaction.Transactional;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    // ========== GETTING ================//

    public List<TeamMember> getAllTeamMembers(){
        System.out.println(teamMemberRepository.findAll());
        return teamMemberRepository.findAll();
    }
    
    @Transactional
    public void addTeamMember(Long teamId, Long userId){
        teamMemberRepository.addTeamMember(teamId, userId);
    }

    public List<UserAthleteDTO> getTeamMembersWithDetailsOfTeamId(Long teamId){
        return teamMemberRepository.getTeamMembersWithDetailsOfTeamId(teamId);
    }

}
