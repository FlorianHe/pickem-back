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

import com.pickemback.pickemback.entity.Game;
import com.pickemback.pickemback.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game show(@PathVariable Long id) {
        return gameService.show(id);
    }

    @GetMapping("/duration")
    public List<Game> getGamesByDuration(String order, Integer limit) {
        return gameService.getGamesByDuration(order, limit);
    }

    @GetMapping("/bo/{id}")
    public List<Game> getGamesByBo(@PathVariable Long id) {
        return gameService.getGamesByBO(id);
    }

    @PostMapping
    public Game create(@RequestBody Game game) {
        return gameService.create(game);
    }

    @PutMapping("/{id}")
    public Game update(@PathVariable Long id, @RequestBody Game game) {
        return gameService.update(id, game);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return gameService.delete(id);
    }
}
