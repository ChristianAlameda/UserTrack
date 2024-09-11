package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Athlete;
import com.example.demo.repository.AthleteRepository;

@Service
public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();
    }

}
