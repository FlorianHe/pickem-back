package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Team;
import com.pickemback.pickemback.repository.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team show(Long id) {
        return teamRepository.findById(id).get();
    }

    public Team create(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Long id, Team team) {
        Team teamToUpdate = teamRepository.findById(id).get();
        teamToUpdate.setName(team.getName());
        return teamRepository.save(teamToUpdate);
    }

    public boolean delete(Long id) {
        teamRepository.deleteById(id);
        return true;
    }
}
