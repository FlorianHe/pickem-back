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

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Game game;

    public Ban() {
    }

    public Ban(Champion champion, Team team, Game game) {
        this.champion = champion;
        this.team = team;
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
