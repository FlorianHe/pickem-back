package com.pickemback.pickemback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.entity.Team;
import com.pickemback.pickemback.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player show(@PathVariable Long id) {
        return playerService.show(id);
    }

    @GetMapping("/team/{id}")
    public List<Player> getPlayersByTeam(@PathVariable Long id) {
        return playerService.getPlayersByTeam(id);
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playerService.create(player);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        return playerService.update(id, player);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return playerService.delete(id);
    }
}
