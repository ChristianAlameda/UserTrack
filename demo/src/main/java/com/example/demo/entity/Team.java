package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "num_users")
    private Long numUsers;

    // Constructors, getters, and setters
    public Team() {}

    public Team(String teamName, Long numUsers) {
        this.teamName = teamName;
        this.numUsers = numUsers;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Long getNumUsers() { return numUsers; }
    public void setNumUsers(Long numUsers) { this.numUsers = numUsers; }

}
