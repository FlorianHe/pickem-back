package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DrakeKilled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drake_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Drake drake;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Game game;

    public DrakeKilled() {
    }

    public DrakeKilled(Drake drake, Team team, Game game) {
        this.drake = drake;
        this.team = team;
        this.game = game;
    }

    public Drake getDrake() {
        return drake;
    }

    public void setDrake(Drake drake) {
        this.drake = drake;
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
