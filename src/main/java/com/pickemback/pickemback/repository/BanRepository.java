package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Ban;

public interface BanRepository extends JpaRepository<Ban, Long> {
    
}
