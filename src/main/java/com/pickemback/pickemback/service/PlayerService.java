package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.entity.Team;
import com.pickemback.pickemback.repository.PlayerRepository;
import com.pickemback.pickemback.repository.TeamRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player show(Long id) {
        return playerRepository.findById(id).get();
    }

    public List<Player> getPlayersByTeam(Long id) {
        Team team = this.teamRepository.findById(id).get();
        return playerRepository.findByTeam(team);
    }

    public Player create(Player player) {
        return playerRepository.save(player);
    }

    public Player update(Long id, Player player) {
        Player playerToUpdate = playerRepository.findById(id).get();
        playerToUpdate.setName(player.getName());
        return playerRepository.save(playerToUpdate);
    }

    public boolean delete(Long id) {
        playerRepository.deleteById(id);
        return true;
    }
}
