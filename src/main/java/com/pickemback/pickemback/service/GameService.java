package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.BO;
import com.pickemback.pickemback.entity.Game;
import com.pickemback.pickemback.repository.BORepository;
import com.pickemback.pickemback.repository.GameRepository;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final BORepository boRepository;

    public GameService(GameRepository gameRepository, BORepository boRepository) {
        this.gameRepository = gameRepository;
        this.boRepository = boRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public List<Game> getGamesByDuration(String order, Integer limit) {
        if (order.equals("ASC"))
            return gameRepository.findGameWithShortestDuration(limit);
        return gameRepository.findGameWithLongestDuration(limit);
    }

    public List<Game> getGamesByBO(Long id) {
        BO bo = boRepository.findById(id).get();
        return gameRepository.findGamesByBO(bo);
    }

    public Game show(Long id) {
        return gameRepository.findById(id).get();
    }

    public Game create(Game game) {
        return gameRepository.save(game);
    }

    public Game update(Long id, Game game) {
        Game gameToUpdate = gameRepository.findById(id).get();
        return gameRepository.save(gameToUpdate);
    }

    public boolean delete(Long id) {
        gameRepository.deleteById(id);
        return true;
    }

}
