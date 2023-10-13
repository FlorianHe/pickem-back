package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
