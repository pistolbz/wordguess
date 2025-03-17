package com.nhom8.wordguess.controller;

import com.nhom8.wordguess.model.Session;
import com.nhom8.wordguess.model.GuessRequest;
import com.nhom8.wordguess.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Controller xử lý các tin nhắn WebSocket cho game
 */
@Controller
public class GameController {

    @Autowired
    private SessionService sessionService;

    /**
     * Xử lý khi người chơi bắt đầu game mới
     */
    @MessageMapping("/start")
    @SendTo("/topic/session")
    public Session startGame(String playerId) {
        return sessionService.createNewGame(playerId);
    }

    /**
     * Xử lý khi người chơi đoán từ
     */
    @MessageMapping("/guess")
    @SendTo("/topic/session")
    public Session makeGuess(GuessRequest request) {
        return sessionService.processGuess(request.getSessionId(), request.getGuessWord(), request.getPlayerName());
    }

    /**
     * Xử lý khi người chơi kết thúc game
     */
    @MessageMapping("/end")
    @SendTo("/topic/session")
    public Session endGame(String sessionId) {
        return sessionService.endGame(sessionId);
    }
}