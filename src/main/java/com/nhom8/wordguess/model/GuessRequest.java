package com.nhom8.wordguess.model;

/**
 * Model để nhận request đoán từ từ client
 */
public class GuessRequest {
    // ID của phiên chơi
    private String sessionId;

    // Từ đoán
    private String guessWord;

    // Tên người chơi
    private String playerName;


    public GuessRequest(String sessionId, String guessWord, String playerName) {
        this.sessionId = sessionId;
        this.guessWord = guessWord;
        this.playerName = playerName;

    }

    public String getSessionId() {
        return sessionId;
    }

    public String getGuessWord() {
        return guessWord;
    }

    public String getPlayerName() {
        return playerName;
    }

}