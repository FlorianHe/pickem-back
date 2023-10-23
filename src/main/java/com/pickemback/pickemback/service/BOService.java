package com.pickemback.pickemback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.BO;
import com.pickemback.pickemback.repository.BORepository;

@Service
public class BOService {
    private final BORepository bORepository;

    public BOService(BORepository bORepository) {
        this.bORepository = bORepository;
    }

    public List<BO> getAllBOs() {
        return bORepository.findAll();
    }

    public BO getLastBO() {
        return bORepository.findTopByOrderByIdDesc();
    }

    public BO show(Long id) {
        return bORepository.findById(id).get();
    }

    public BO create(BO bO) {
        Optional<BO> existingBO = bORepository.findById(bO.getId());

        if (existingBO.isPresent()) {
            return existingBO.get();
        } else {
            BO createdBO = bORepository.save(bO);
            return createdBO;
        }
    }

    public BO update(Long id, BO bO) {
        BO bOToUpdate = bORepository.findById(id).get();
        return bORepository.save(bOToUpdate);
    }

    public boolean delete(Long id) {
        bORepository.deleteById(id);
        return true;
    }
}
