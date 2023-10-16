package com.pickemback.pickemback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.BO;

public interface BORepository extends JpaRepository<BO, Long> {
    BO findTopByOrderByIdDesc();
}
