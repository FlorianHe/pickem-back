package com.pickemback.pickemback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Ban;
import com.pickemback.pickemback.entity.KDA;
import com.pickemback.pickemback.repository.KDARepository;

@Service
public class KDAService {
    private final KDARepository kDARepository;

    public KDAService(KDARepository kDARepository) {
        this.kDARepository = kDARepository;
    }

    public List<KDA> getAllKDAs() {
        return kDARepository.findAll();
    }

    public KDA getKDAByGameAndPlayer(Long gameId, Long playerId) {
        return kDARepository.getByGameIdAndPlayerId(gameId, playerId);
    }
    

    public KDA show(Long id) {
        return kDARepository.findById(id).get();
    }

    public KDA create(KDA kDA) {
        int death = (kDA.getDeath() == 0) ? 1 : kDA.getDeath();
        double kda = (double)(kDA.getKills() + kDA.getAssist()) / (double) death;
        kDA.setKda(Double.parseDouble(String.format("%.2f", kda)));
        return kDARepository.save(kDA);
    }

    public KDA update(Long id, KDA kDA) {
        KDA kDAToUpdate = kDARepository.findById(id).get();
        return kDARepository.save(kDAToUpdate);
    }

    public boolean delete(Long id) {
        kDARepository.deleteById(id);
        return true;
    }
}
