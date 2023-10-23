package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pickemback.pickemback.entity.Pick;

public interface PickRepository extends JpaRepository<Pick, Long> {

    List<Pick> getByGameIdAndTeamId(Long gameId, Long teamId);

    @Query("SELECT p.champion, COUNT(p.champion) AS amount FROM Pick p GROUP BY p.champion ORDER BY amount DESC")
    List<Object[]>  findAllChampionsGroupByAmount();

    @Query("SELECT p.champion, SUM(k.death) as amount " +
                "FROM Pick p " +
                "INNER JOIN KDA k " +
                "ON p.game = k.game AND p.player = k.player " +
                "GROUP BY p.champion " +
                "ORDER BY amount DESC")
    List<Object[]> findTotalDeathsByChampion();

    @Query("SELECT p.champion, COUNT(DISTINCT pl.role) as amount, GROUP_CONCAT(DISTINCT pl.role) as roles " + 
                "FROM Pick p " + 
                "INNER JOIN Game g ON g.id = p.game.id " +
                "INNER JOIN player pl ON pl.id = p.player.id " +
                "GROUP BY p.champion ORDER BY amount DESC")
    List<Object[]> findDifferentRoleByChampion();

    @Query("SELECT c, COUNT(p.id) AS total_picks, SUM(CASE WHEN g.teamWinner = pl.team THEN 1 ELSE 0 END) AS wins, " +
                " (SUM(CASE WHEN g.teamWinner = pl.team THEN 1 ELSE 0 END) * 100.0 / COUNT(p.id)) AS win_rate " +
                " FROM Pick p " + 
                " JOIN Player pl ON p.player = pl " + 
                " JOIN Game g ON p.game = g " + 
                " JOIN Champion c ON c = p.champion " + 
                " GROUP BY c.id " +
                " ORDER BY win_rate DESC")
    List<Object[]> findWinRateByChampion();




}
