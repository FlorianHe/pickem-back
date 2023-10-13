package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "champion_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Champion champion;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team team;

    public Ban() {
    }

    public Ban(Champion champion, Team team) {
        this.champion = champion;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
