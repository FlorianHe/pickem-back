package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pickemback.pickemback.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT g FROM Game g ORDER BY FUNCTION('TIME_TO_SEC', g.duration) DESC LIMIT :limit")
    List<Game> findGameWithLongestDuration(Integer limit);

    @Query("SELECT g FROM Game g ORDER BY FUNCTION('TIME_TO_SEC', g.duration) ASC LIMIT :limit")
    List<Game> findGameWithShortestDuration(Integer limit);
}
