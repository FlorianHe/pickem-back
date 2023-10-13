package com.pickemback.pickemback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pickemback.pickemback.entity.Pentakill;
import com.pickemback.pickemback.entity.PentakillAmount;
import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.repository.PentakillRepository;

@Service
public class PentakillService {
    private final PentakillRepository pentakillRepository;

    public PentakillService(PentakillRepository pentakillRepository) {
        this.pentakillRepository = pentakillRepository;
    }

    public List<PentakillAmount> getAllPentakills() {
        List<Object[]> results = pentakillRepository.findAllGroupByAmount();
        List<PentakillAmount> pentakillAmounts = new ArrayList<>();

        for (Object[] result : results) {
            Player player = (Player) result[0];
            Long amount = (Long) result[1];
            pentakillAmounts.add(new PentakillAmount(player, amount.intValue()));
        }

        return pentakillAmounts;
    }

    public Pentakill show(Long id) {
        return pentakillRepository.findById(id).get();
    }

    public Pentakill create(Pentakill pentakill) {
        return pentakillRepository.save(pentakill);
    }

    public Pentakill update(Long id, Pentakill pentakill) {
        Pentakill pentakillToUpdate = pentakillRepository.findById(id).get();
        return pentakillRepository.save(pentakillToUpdate);
    }

    public boolean delete(Long id) {
        pentakillRepository.deleteById(id);
        return true;
    }
}
