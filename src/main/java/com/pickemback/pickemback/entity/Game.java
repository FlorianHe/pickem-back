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
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_blue_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamBlue;

    @ManyToOne
    @JoinColumn(name = "team_red_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamRed;

    @ManyToOne
    @JoinColumn(name = "team_winner_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team teamWinner;

    private String duration;

    private Integer baronSteals;

    @ManyToOne
    @JoinColumn(name = "bo_id")
    @JsonIdentityReference(alwaysAsId = true)
    private BO bo;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Pick> listPicks;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Ban> listBans;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<DrakeKilled> listDrakes;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<Pentakill> listPentakills;

    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JsonIgnore
    private List<KDA> listKDAs;

    public Game() {
    }

    public Game(Team teamBlue, Team teamRed, Team teamWinner, String duration, Integer baronSteals, BO bO) {
        this.teamBlue = teamBlue;
        this.teamRed = teamRed;
        this.teamWinner = teamWinner;
        this.duration = duration;
        this.baronSteals = baronSteals;
        this.bo = bO;
    }

    public Long getId() {
        return id;
    }

    public Team getTeamBlue() {
        return teamBlue;
    }

    public void setTeamBlue(Team teamBlue) {
        this.teamBlue = teamBlue;
    }

    public Team getTeamRed() {
        return teamRed;
    }

    public void setTeamRed(Team teamRed) {
        this.teamRed = teamRed;
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
        return bo;
    }

    public void setBO(BO bo) {
        this.bo = bo;
    }

    public Team getTeamWinner() {
        return teamWinner;
    }

    public void setTeamWinner(Team teamWinner) {
        this.teamWinner = teamWinner;
    }


}
