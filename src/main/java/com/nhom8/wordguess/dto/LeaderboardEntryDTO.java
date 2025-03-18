package com.nhom8.wordguess.dto;

import java.time.LocalDateTime;

/**
 * DTO chứa thông tin hiển thị trên bảng xếp hạng
 */
public class LeaderboardEntryDTO {
    private String playerName;
    private String playerId;
    private int score;
    private int round;
    private LocalDateTime playDate;

    public LeaderboardEntryDTO(String playerName, String playerId, int score, int round, LocalDateTime playDate) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.score = score;
        this.round = round;
        this.playDate = playDate;
    }

    // Getters and setters
    public String getPlayerName() {
        return playerName != null && !playerName.isEmpty() ? playerName : "Anonymous";
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDateTime playDate) {
        this.playDate = playDate;
    }
}
