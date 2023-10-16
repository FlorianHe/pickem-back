package com.pickemback.pickemback.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String role;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Pick> listPicks;

    @OneToMany(mappedBy = "player", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<KDA> listKDAs;

    public Player() {
    }

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Player(String name, String role, Team team) {
        this.name = name;
        this.role = role;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
