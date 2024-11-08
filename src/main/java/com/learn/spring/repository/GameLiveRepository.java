package com.learn.spring.repository;

import com.learn.spring.entity.GameLive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameLiveRepository extends JpaRepository<GameLive, Long> {

    List<GameLive> findByGameIdAndActive(Long gameId, Integer status);

    List<GameLive> findByActive(Integer status);
}