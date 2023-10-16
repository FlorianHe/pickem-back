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

import com.pickemback.pickemback.entity.Pick;
import com.pickemback.pickemback.service.PickService;

@RestController
@RequestMapping("/pick")
public class PickController {
    private final PickService pickService;

    public PickController(PickService pickService) {
        this.pickService = pickService;
    }

    @GetMapping
    public List<Pick> getAllPicks() {
        return pickService.getAllPicks();
    }

    @GetMapping("/{id}")
    public Pick show(@PathVariable Long id) {
        return pickService.show(id);
    }

    @GetMapping("/game/{game_id}/team/{team_id}")
    public List<Pick> getPicksByGameAndTeam(@PathVariable Long game_id, @PathVariable Long team_id) {
        return pickService.getPicksByGameAndTeam(game_id, team_id);
    }

    @PostMapping
    public Pick create(@RequestBody Pick pick) {
        return pickService.create(pick);
    }

    @PutMapping("/{id}")
    public Pick update(@PathVariable Long id, @RequestBody Pick pick) {
        return pickService.update(id, pick);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return pickService.delete(id);
    }
}
