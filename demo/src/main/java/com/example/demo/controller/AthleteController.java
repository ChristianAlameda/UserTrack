package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AthleteService;
import com.example.demo.entity.Athlete;
import com.example.demo.entity.DTOs.UserAthleteDTO;

@RestController
@RequestMapping("api/athletes")
public class AthleteController {
    @Autowired
    private AthleteService athleteService;

    @GetMapping
    public List<Athlete> getAllAthletes(){
        return athleteService.getAllAthletes();
    }

    @GetMapping("/{id}")
    public UserAthleteDTO getUserAthleteById(@PathVariable Long id){
        return athleteService.getUserAthleteById(id);
    }
}
