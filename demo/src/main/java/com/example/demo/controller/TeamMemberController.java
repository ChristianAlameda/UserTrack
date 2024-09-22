package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TeamMemberService;
import com.example.demo.entity.TeamMember;
import com.example.demo.entity.DTOs.UserAthleteDTO;

@RestController
@RequestMapping("api/teamMembers")
public class TeamMemberController {
    @Autowired
    private TeamMemberService teamMemberService;

    @GetMapping
    public List<TeamMember> getAllTeamMembers(){
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("/{teamId}/{userId}")
    public void addTeamMember(@PathVariable Long teamId, @PathVariable Long userId){
        teamMemberService.addTeamMember(teamId, userId);
    }

    @GetMapping("/{teamId}")
    public List<UserAthleteDTO> getTeamMembersWithDetailsOfTeamId(@PathVariable Long teamId){  
        return teamMemberService.getTeamMembersWithDetailsOfTeamId(teamId);
    }
}
