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

import com.pickemback.pickemback.entity.Pentakill;
import com.pickemback.pickemback.entity.PentakillAmount;
import com.pickemback.pickemback.service.PentakillService;

@RestController
@RequestMapping("/pentakill")
public class PentakillController {
    private final PentakillService pentakillService;

    public PentakillController(PentakillService pentakillService) {
        this.pentakillService = pentakillService;
    }

    @GetMapping
    public List<PentakillAmount> getAllPentakills() {
        return pentakillService.getAllPentakills();
    }

    @GetMapping("/{id}")
    public Pentakill show(@PathVariable Long id) {
        return pentakillService.show(id);
    }

    @PostMapping
    public Pentakill create(@RequestBody Pentakill pentakill) {
        return pentakillService.create(pentakill);
    }

    @PutMapping("/{id}")
    public Pentakill update(@PathVariable Long id, @RequestBody Pentakill pentakill) {
        return pentakillService.update(id, pentakill);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return pentakillService.delete(id);
    }
}
