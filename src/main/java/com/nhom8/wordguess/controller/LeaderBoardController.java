package com.nhom8.wordguess.controller;

import com.nhom8.wordguess.dto.LeaderboardEntryDTO;
import com.nhom8.wordguess.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderBoardController {
    
    @Autowired
    private SessionService sessionService;
    
    @GetMapping
    public ResponseEntity<List<LeaderboardEntryDTO>> getLeaderboard() {
        return ResponseEntity.ok(
            sessionService.getLeaderboard().stream()
                .map(session -> new LeaderboardEntryDTO(
                    session.getPlayerName(),
                    session.getPlayerId(),
                    session.getScore(),
                    session.getRound(),
                    session.getEndTime()
                ))
                .collect(Collectors.toList())
        );
    }
}
