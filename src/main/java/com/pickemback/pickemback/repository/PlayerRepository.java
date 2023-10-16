package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Player;
import com.pickemback.pickemback.entity.Team;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam(Team team);
}
