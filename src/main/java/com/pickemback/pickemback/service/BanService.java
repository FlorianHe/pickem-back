package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Ban;
import com.pickemback.pickemback.entity.Pick;
import com.pickemback.pickemback.repository.BanRepository;

@Service
public class BanService {
    private final BanRepository banRepository;

    public BanService(BanRepository banRepository) {
        this.banRepository = banRepository;
    }

    public List<Ban> getAllBans() {
        return banRepository.findAll();
    }

    public Ban show(Long id) {
        return banRepository.findById(id).get();
    }

    public List<Ban> getBansByGameAndTeam(Long gameId, Long teamId) {
        return banRepository.getByGameIdAndTeamId(gameId, teamId);
    }

    public Ban create(Ban ban) {
        return banRepository.save(ban);
    }

    public Ban update(Long id, Ban ban) {
        Ban banToUpdate = banRepository.findById(id).get();
        return banRepository.save(banToUpdate);
    }

    public boolean delete(Long id) {
        banRepository.deleteById(id);
        return true;
    }
}
