package com.pickemback.pickemback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickemback.pickemback.entity.Pick;

public interface PickRepository extends JpaRepository<Pick, Long> {

    List<Pick> getByGameIdAndTeamId(Long gameId, Long teamId);
}
