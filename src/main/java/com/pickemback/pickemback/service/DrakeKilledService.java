package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.DrakeKilled;
import com.pickemback.pickemback.repository.DrakeKilledRepository;

@Service
public class DrakeKilledService {
    private final DrakeKilledRepository drakeKilledRepository;

    public DrakeKilledService(DrakeKilledRepository drakeKilledRepository) {
        this.drakeKilledRepository = drakeKilledRepository;
    }

    public List<DrakeKilled> getAllDrakeKilled() {
        return drakeKilledRepository.findAll();
    }

    public DrakeKilled show(Long id) {
        return drakeKilledRepository.findById(id).get();
    }

    public List<DrakeKilled> getDrakesKilledByGameAndTeam(Long gameId, Long teamId) {
        return drakeKilledRepository.getByGameIdAndTeamId(gameId, teamId);
    }

    public DrakeKilled create(DrakeKilled drakeKilled) {
        return drakeKilledRepository.save(drakeKilled);
    }

    public DrakeKilled update(Long id, DrakeKilled drakeKilled) {
        DrakeKilled drakeKilledToUpdate = drakeKilledRepository.findById(id).get();
        return drakeKilledRepository.save(drakeKilledToUpdate);
    }

    public boolean delete(Long id) {
        drakeKilledRepository.deleteById(id);
        return true;
    }
}
