package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.DrakeKilled;

public interface DrakeKilledRepository extends JpaRepository<DrakeKilled, Long> {
    
    List<DrakeKilled> getByGameIdAndTeamId(Long gameId, Long teamId);
}
