package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Athlete;
import com.example.demo.entity.DTOs.UserAthleteDTO;
import com.example.demo.entity.DTOs.UserStudentAthleteDTO;
import com.example.demo.repository.AthleteRepository;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

    public Athlete getAthleteByUserId(Long id){
        return athleteRepository.findByUserId(id);
    }

    public UserAthleteDTO getUserAthleteById(Long id){
        return athleteRepository.getUserAthleteById(id);
    }

    

}
