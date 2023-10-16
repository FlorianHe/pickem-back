package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Champion;
import com.pickemback.pickemback.repository.ChampionRepository;

@Service
public class ChampionService {
    private final ChampionRepository championRepository;

    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }
}
