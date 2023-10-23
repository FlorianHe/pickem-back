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

import com.pickemback.pickemback.entity.DrakeKilled;
import com.pickemback.pickemback.entity.DrakeKilledNumber;
import com.pickemback.pickemback.service.DrakeKilledService;

@RestController
@RequestMapping("/drakekilled")
public class DrakeKilledController {
    private final DrakeKilledService drakeKilledService;

    public DrakeKilledController(DrakeKilledService drakeKilledService) {
        this.drakeKilledService = drakeKilledService;
    }

    @GetMapping
    public List<DrakeKilled> getAllDrakes() {
        return drakeKilledService.getAllDrakeKilled();
    }

    @GetMapping("/{id}")
    public DrakeKilled show(@PathVariable Long id) {
        return drakeKilledService.show(id);
    }

    @GetMapping("/game/{game_id}/team/{team_id}")
    public List<DrakeKilled> getDrakesKilledByGameAndTeam(@PathVariable Long game_id, @PathVariable Long team_id) {
        return drakeKilledService.getDrakesKilledByGameAndTeam(game_id, team_id);
    }

    @GetMapping("/amount")
    public List<DrakeKilledNumber> getAllDrakesGroupByAmount() {
        return drakeKilledService.getAllDrakesGroupByAmount();
    }

    @PostMapping
    public DrakeKilled create(@RequestBody DrakeKilled drakeKilled) {
        return drakeKilledService.create(drakeKilled);
    }

    @PutMapping("/{id}")
    public DrakeKilled update(@PathVariable Long id, @RequestBody DrakeKilled drakeKilled) {
        return drakeKilledService.update(id, drakeKilled);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return drakeKilledService.delete(id);
    }
}
