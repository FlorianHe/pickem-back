package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pickemback.pickemback.entity.Ban;

public interface BanRepository extends JpaRepository<Ban, Long> {
    
    List<Ban> getByGameIdAndTeamId(Long gameId, Long teamId);

    @Query("SELECT b.champion, COUNT(b.champion) AS amount FROM Ban b GROUP BY b.champion ORDER BY amount DESC")
    List<Object[]>  findAllChampionsGroupByAmount();
}
