package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
