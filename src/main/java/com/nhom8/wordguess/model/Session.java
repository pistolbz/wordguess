package com.nhom8.wordguess.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;

/**
 * Model đại diện cho một phiên chơi game
 */
@Document(collection = "sessions")
public class Session {
    // ID của phiên chơi
    @Id
    private String id;

    // Người đang chơi trong phiên
    @Field("player_id")
    private String playerId;

    // Tên người chơi
    @Field("player_name")
    private String playerName;

    // Trạng thái của phiên chơi (WAITING, PLAYING, FINISHED)
    @Field("status")
    private String status = "WAITING";

    // Số điểm hiện tại của người chơi
    @Field("score")
    private int score;

    // Vòng chơi hiện tại
    @Field("round")
    private int round;

    // Số lượt đoán còn lại
    @Field("remaining_guesses")
    private int remainingGuesses;

    // Thời gian bắt đầu phiên chơi
    @Field("start_time")
    private LocalDateTime startTime;

    // Thời gian kết thúc phiên chơi
    @Field("end_time")
    private LocalDateTime endTime;

    // ID của từ vựng đang chơi
    @Field("current_word_id")
    private String currentWordId;

    // Hint của từ vựng đang chơi
    @Field("current_word_hint")
    private String currentWordHint;

    // Tiến độ đoán từ
    @Field("char_missing")
    private String charMissing;
    
    // Constructors
    public Session() {
    }


    public Session(String id, String playerId, String playerName, String status, int score, int round,
            int remainingGuesses, LocalDateTime startTime, LocalDateTime endTime, String currentWordId,
            String currentWordHint, String charMissing) {
        this.id = id;
        this.playerId = playerId;
        this.playerName = playerName;
        this.status = status;
        this.score = score;
        this.round = round;
        this.remainingGuesses = remainingGuesses;
        this.startTime = startTime;
        this.endTime = endTime;
        this.currentWordId = currentWordId;
        this.currentWordHint = currentWordHint;
        this.charMissing = charMissing;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPlayerId() {
        return playerId;
    }


    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }


    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
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


    public int getRemainingGuesses() {
        return remainingGuesses;
    }


    public void setRemainingGuesses(int remainingGuesses) {
        this.remainingGuesses = remainingGuesses;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }


    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getCurrentWordId() {
        return currentWordId;
    }


    public void setCurrentWordId(String currentWordId) {
        this.currentWordId = currentWordId;
    }


    public String getCurrentWordHint() {
        return currentWordHint;
    }


    public void setCurrentWordHint(String currentWordHint) {
        this.currentWordHint = currentWordHint;
    }


    public String getCharMissing() {
        return charMissing;
    }


    public void setCharMissing(String charMissing) {
        this.charMissing = charMissing;
    }

    
}
