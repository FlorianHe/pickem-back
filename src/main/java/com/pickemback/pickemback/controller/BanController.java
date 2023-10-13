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
import com.pickemback.pickemback.service.BanService;

@RestController
@RequestMapping("/ban")
public class BanController {
    private final BanService banService;

    public BanController(BanService banService) {
        this.banService = banService;
    }

    @GetMapping
    public List<Ban> getAllBans() {
        return banService.getAllBans();
    }

    @GetMapping("/{id}")
    public Ban show(@PathVariable Long id) {
        return banService.show(id);
    }

    @PostMapping
    public Ban create(@RequestBody Ban ban) {
        return banService.create(ban);
    }

    @PutMapping("/{id}")
    public Ban update(@PathVariable Long id, @RequestBody Ban ban) {
        return banService.update(id, ban);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return banService.delete(id);
    }
}
