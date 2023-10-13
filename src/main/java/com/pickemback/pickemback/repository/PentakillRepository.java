package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pickemback.pickemback.entity.Pentakill;
import com.pickemback.pickemback.entity.PentakillAmount;

public interface PentakillRepository extends JpaRepository<Pentakill, Long> {
    @Query("SELECT p.player, COUNT(p) AS amount FROM Pentakill p GROUP BY p.player ORDER BY count(p) DESC")
    List<Object[]> findAllGroupByAmount();

}
