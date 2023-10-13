package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Long> {
    
}
