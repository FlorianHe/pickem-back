package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.KDA;

public interface KDARepository extends JpaRepository<KDA, Long> {

    KDA getByGameIdAndPlayerId(Long gameId, Long playerId);
}
