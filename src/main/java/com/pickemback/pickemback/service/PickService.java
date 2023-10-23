package com.pickemback.pickemback.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Champion;
import com.pickemback.pickemback.entity.ChampionAmount;
import com.pickemback.pickemback.entity.Pick;
import com.pickemback.pickemback.entity.Winrate;
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

    public List<Pick> getPicksByGameAndTeam(Long gameId, Long teamId) {
        return pickRepository.getByGameIdAndTeamId(gameId, teamId);
    }

    public List<ChampionAmount> getPickAmounts() {
        List<Object[]> picks = pickRepository.findAllChampionsGroupByAmount();
        List<ChampionAmount> pickAmount = new ArrayList<>();

        int limit = 5;
        for (int i = 0; i < Math.min(picks.size(), limit); i++) {
            Object[] result = picks.get(i);
            Champion pick = (Champion) result[0];
            Long amount = (Long) result[1];
            pickAmount.add(new ChampionAmount(pick, amount.intValue()));
        }
        return pickAmount;
    }

    public List<ChampionAmount> getTotalDeathsByChampion() {
        List<Object[]> deaths = pickRepository.findTotalDeathsByChampion();
        List<ChampionAmount> deathAmount = new ArrayList<>();

        int limit = 5;
        for (int i = 0; i < Math.min(deaths.size(), limit); i++) {
            Object[] result = deaths.get(i);
            Champion death = (Champion) result[0];
            Long amount = (Long) result[1];
            deathAmount.add(new ChampionAmount(death, amount.intValue()));
        }
        return deathAmount;
    }

    public List<ChampionAmount> getDifferentRoleByChampion() {
        List<Object[]> deaths = pickRepository.findDifferentRoleByChampion();
        List<ChampionAmount> deathAmount = new ArrayList<>();

        Long biggestAmount = (Long) deaths.get(0)[1];
        for (Object[] result : deaths) {
            Long amount = (Long) result[1];
            if (amount == biggestAmount.intValue()) {
                Champion death = (Champion) result[0];
                String rolesString = (String) result[2];
                List<String> roles = Arrays.asList(rolesString.split(","));
                deathAmount.add(new ChampionAmount(death, amount.intValue(), roles));
            }
        }
        return deathAmount;
    }

    public List<Winrate> getWinRateByChampion() {
        List<Object[]> winrateByChampion = pickRepository.findWinRateByChampion();
        List<Winrate> winrates = new ArrayList<>();

        for (Object[] result: winrateByChampion) {
            Long totalGame = (Long) result[1];
            if (totalGame.intValue() >= 5) {
                Champion champion = (Champion) result[0];
                Long victory = (Long) result[2];
                Float winrate = (Float) result[3];
                winrates.add(new Winrate(champion, totalGame.intValue(), victory.intValue(), totalGame.intValue() - victory.intValue(), winrate.floatValue())); 
            }
        }
        return winrates.subList(0, Math.min(5, winrates.size()));
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
