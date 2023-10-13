package com.pickemback.pickemback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickemback.pickemback.entity.Team;
import com.pickemback.pickemback.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team show(@PathVariable Long id) {
        return teamService.show(id);
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Long id, @RequestBody Team team) {
        return teamService.update(id, team);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return teamService.delete(id);
    }
}
