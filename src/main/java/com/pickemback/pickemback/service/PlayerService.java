package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.repository.PlayerRepository;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player show(Long id) {
        return playerRepository.findById(id).get();
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
