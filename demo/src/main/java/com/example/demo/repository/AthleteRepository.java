package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Athlete;

@Repository
public interface AthleteRepository  extends JpaRepository<Athlete,Long>{
    // any additional functions you want to make
}