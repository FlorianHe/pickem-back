package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Drake;
import com.pickemback.pickemback.repository.DrakeRepository;

@Service
public class DrakeService {
    private final DrakeRepository drakeRepository;

    public DrakeService(DrakeRepository drakeRepository) {
        this.drakeRepository = drakeRepository;
    }

    public List<Drake> getAllDrakes() {
        return drakeRepository.findAll();
    }

    public Drake show(Long id) {
        return drakeRepository.findById(id).get();
    }

    public Drake create(Drake drake) {
        return drakeRepository.save(drake);
    }

    public Drake update(Long id, Drake drake) {
        Drake drakeToUpdate = drakeRepository.findById(id).get();
        return drakeRepository.save(drakeToUpdate);
    }

    public boolean delete(Long id) {
        drakeRepository.deleteById(id);
        return true;
    }
}
