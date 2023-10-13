package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Pick;
import com.pickemback.pickemback.repository.PickRepository;

@Service
public class PickService {
    private final PickRepository pickRepository;

    public PickService(PickRepository pickRepository) {
        this.pickRepository = pickRepository;
    }

    public List<Pick> getAllPicks() {
        return pickRepository.findAll();
    }

    public Pick show(Long id) {
        return pickRepository.findById(id).get();
    }

    public Pick create(Pick pick) {
        return pickRepository.save(pick);
    }

    public Pick update(Long id, Pick pick) {
        Pick pickToUpdate = pickRepository.findById(id).get();
        return pickRepository.save(pickToUpdate);
    }

    public boolean delete(Long id) {
        pickRepository.deleteById(id);
        return true;
    }
}
