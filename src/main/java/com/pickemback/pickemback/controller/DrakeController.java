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

import com.pickemback.pickemback.entity.Drake;
import com.pickemback.pickemback.service.DrakeService;

@RestController
@RequestMapping("/drake")
public class DrakeController {
    private final DrakeService drakeService;

    public DrakeController(DrakeService drakeService) {
        this.drakeService = drakeService;
    }

    @GetMapping
    public List<Drake> getAllDrakes() {
        return drakeService.getAllDrakes();
    }

    @GetMapping("/{id}")
    public Drake show(@PathVariable Long id) {
        return drakeService.show(id);
    }

    @PostMapping
    public Drake create(@RequestBody Drake drake) {
        return drakeService.create(drake);
    }

    @PutMapping("/{id}")
    public Drake update(@PathVariable Long id, @RequestBody Drake drake) {
        return drakeService.update(id, drake);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return drakeService.delete(id);
    }
}
