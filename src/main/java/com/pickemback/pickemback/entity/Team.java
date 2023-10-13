package com.pickemback.pickemback.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Player> listPlayers;

    @OneToMany(mappedBy = "teamHome", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Game> listGamesHome;

    @OneToMany(mappedBy = "teamWinner", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Game> listGamesWinner;

    @OneToMany(mappedBy = "teamAway", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Game> listGamesAway;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Ban> listBans;

    public Team() {
    }
    
    public Team(String name) {
        this.name = name;
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
}
