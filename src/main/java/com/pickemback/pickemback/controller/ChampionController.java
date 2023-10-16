package com.pickemback.pickemback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickemback.pickemback.entity.Champion;
import com.pickemback.pickemback.service.ChampionService;

@RestController
@RequestMapping("/champion")
public class ChampionController {
    private final ChampionService championService;

    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping
    public List<Champion> getAllChampions() {
        return championService.getAllChampions();
    }
}
