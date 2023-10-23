package com.pickemback.pickemback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Ban;
import com.pickemback.pickemback.entity.Champion;
import com.pickemback.pickemback.entity.ChampionAmount;
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

    public List<ChampionAmount> getBanAmounts() {
        List<Object[]> bans = banRepository.findAllChampionsGroupByAmount();
        List<ChampionAmount> banAmount = new ArrayList<>();

        int limit = 5;
        for (int i = 0; i < Math.min(bans.size(), limit); i++) {
            Object[] result = bans.get(i);
            Champion ban = (Champion) result[0];
            Long amount = (Long) result[1];
            banAmount.add(new ChampionAmount(ban, amount.intValue()));
        }
        return banAmount;
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
