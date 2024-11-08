package com.learn.spring.service;

import com.learn.spring.entity.Game;
import com.learn.spring.entity.GameLive;
import com.learn.spring.repository.GameLiveRepository;
import com.learn.spring.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameLiveRepository gameLiveRepository;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Method to create live entries from active games
    @Scheduled(fixedRate = 500) // Check every 10 seconds for new active games
    public void createLiveEntries() {
        createLiveGame();
        deactivateLiveGame();
    }

    private void createLiveGame() {

        List<Game> activeGames = gameRepository.findAll(); // Fetch all active games

        for (Game game : activeGames) {

            List<GameLive>  liveGameList = gameLiveRepository.findByGameIdAndActive(game.getId(), 1);
            if(!liveGameList.isEmpty()){
                for(GameLive gameLiveCurrent : liveGameList) {
                    if (game.getActive() && !LocalDateTime.now().isBefore(gameLiveCurrent.getEndDateTime()) && gameLiveCurrent.getActive()==0) {
                        GameLive gameLive = new GameLive();
                        gameLive.setStartDateTime(LocalDateTime.now());
                        gameLive.setEndDateTime(LocalDateTime.now().plusSeconds(game.getActiveTime()));
                        gameLive.setActiveTime(game.getActiveTime());
                        gameLive.setActive(1);
                        gameLive.setPrice(game.getPrice());
                        gameLive.setPrizePole(game.getPrizePole());
                        gameLive.setGameId(game.getId());

                        gameLiveRepository.save(gameLive); // Save live game entry
                    }
                }
            }
            else if (game.getActive()) {
                GameLive gameLive = new GameLive();
                gameLive.setStartDateTime(LocalDateTime.now());
                gameLive.setEndDateTime(LocalDateTime.now().plusSeconds(game.getActiveTime()));
                gameLive.setActiveTime(game.getActiveTime());
                gameLive.setActive(1);
                gameLive.setPrice(game.getPrice());
                gameLive.setPrizePole(game.getPrizePole());
                gameLive.setGameId(game.getId());

                gameLiveRepository.save(gameLive); // Save live game entry

                // Schedule removal of the entry after active time
              //  scheduleRemoval(gameLive, game.getActiveTime());
            }
        }
    }

    private void deactivateLiveGame() {
        List<GameLive>  liveGameList = gameLiveRepository.findByActive(1);
        if(!liveGameList.isEmpty()){

            for(GameLive gameLiveCurrent : liveGameList) {
                if (LocalDateTime.now().isAfter(gameLiveCurrent.getEndDateTime()) && gameLiveCurrent.getActive()>0) {
                    gameLiveCurrent.setActive(0);
                    gameLiveRepository.save(gameLiveCurrent); // Save live game entry

                }
            }
        }
    }

}