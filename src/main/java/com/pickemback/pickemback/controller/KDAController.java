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

import com.pickemback.pickemback.entity.Ban;
import com.pickemback.pickemback.entity.KDA;
import com.pickemback.pickemback.service.KDAService;

@RestController
@RequestMapping("/kda")
public class KDAController {
    private final KDAService kDAService;

    public KDAController(KDAService kDAService) {
        this.kDAService = kDAService;
    }

    @GetMapping
    public List<KDA> getAllKDAs() {
        return kDAService.getAllKDAs();
    }

    @GetMapping("/{id}")
    public KDA show(@PathVariable Long id) {
        return kDAService.show(id);
    }

    @GetMapping("/game/{game_id}/player/{player_id}")
    public KDA getKDAByGameAndPlayer(@PathVariable Long game_id, @PathVariable Long player_id) {
        return kDAService.getKDAByGameAndPlayer(game_id, player_id);
    }
    

    @PostMapping
    public KDA create(@RequestBody KDA kDA) {
        return kDAService.create(kDA);
    }

    @PutMapping("/{id}")
    public KDA update(@PathVariable Long id, @RequestBody KDA kDA) {
        return kDAService.update(id, kDA);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return kDAService.delete(id);
    }
}
