package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Ban;

public interface BanRepository extends JpaRepository<Ban, Long> {
    
    List<Ban> getByGameIdAndTeamId(Long gameId, Long teamId);
}
