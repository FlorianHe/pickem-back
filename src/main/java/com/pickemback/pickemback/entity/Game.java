package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_home_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamHome;

    @ManyToOne
    @JoinColumn(name = "team_away_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamAway;

    @ManyToOne
    @JoinColumn(name = "team_winner_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamWinner;

    private String duration;

    private Integer baronSteals;

    @ManyToOne
    @JoinColumn(name = "bo_id")
    @JsonIdentityReference(alwaysAsId = true)
    private BO bO;

    public Game() {
    }

    public Game(Team teamHome, Team teamAway, Team teamWinner, String duration, Integer baronSteals, BO bO) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.teamWinner = teamWinner;
        this.duration = duration;
        this.baronSteals = baronSteals;
        this.bO = bO;
    }

    public Long getId() {
        return id;
    }

    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getBaronSteals() {
        return baronSteals;
    }

    public void setBaronSteals(Integer baronSteals) {
        this.baronSteals = baronSteals;
    }

    public BO getBO() {
        return bO;
    }

    public void setBO(BO bO) {
        this.bO = bO;
    }

}
