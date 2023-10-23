package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pickemback.pickemback.entity.DrakeKilled;

public interface DrakeKilledRepository extends JpaRepository<DrakeKilled, Long> {
    
    List<DrakeKilled> getByGameIdAndTeamId(Long gameId, Long teamId);

    @Query("SELECT dk.drake, COUNT(dk.drake) AS amount FROM DrakeKilled dk GROUP BY dk.drake")
    List<Object[]>  findAllDrakesGroupByAmount();
}
