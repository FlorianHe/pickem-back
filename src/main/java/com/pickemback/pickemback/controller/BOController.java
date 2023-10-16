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

import com.pickemback.pickemback.entity.BO;
import com.pickemback.pickemback.service.BOService;

@RestController
@RequestMapping("/bo")
public class BOController {
    private final BOService bOService;

    public BOController(BOService bOService) {
        this.bOService = bOService;
    }

    @GetMapping
    public List<BO> getAllBOs() {
        return bOService.getAllBOs();
    }

    @GetMapping("/last")
    public BO getLastBO() {
        return bOService.getLastBO();
    }

    @GetMapping("/{id}")
    public BO show(@PathVariable Long id) {
        return bOService.show(id);
    }

    @PostMapping
    public BO create(@RequestBody BO bO) {
        return bOService.create(bO);
    }

    @PutMapping("/{id}")
    public BO update(@PathVariable Long id, @RequestBody BO bO) {
        return bOService.update(id, bO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return bOService.delete(id);
    }
}
