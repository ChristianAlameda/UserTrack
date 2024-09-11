package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AthleteService;
import com.example.demo.entity.Athlete;

@RestController
@RequestMapping("api/athletes")
public class AthleteController {
    @Autowired
    private AthleteService studentService;

    @GetMapping
    public List<Athlete> getAllAthletes(){
        return studentService.getAllAthletes();
    }
}
