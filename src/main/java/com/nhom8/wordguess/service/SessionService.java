package com.nhom8.wordguess.service;

import com.nhom8.wordguess.model.Session;
import com.nhom8.wordguess.model.Word;
import com.nhom8.wordguess.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service xử lý logic phiên chơi game
 */
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private WordService wordService;

    /**
     * Tạo phiên chơi mới cho người chơi
     */
    public Session createNewGame(String playerId) {
        Session newSession = new Session();
        newSession.setPlayerId(playerId);
        newSession.setScore(0);
        newSession.setStatus("PLAYING");
        newSession.setStartTime(LocalDateTime.now());
        newSession.setRemainingGuesses(3);
        newSession.setRound(1);
        // Lấy từ ngẫu nhiên cho phiên chơi
        Word word = wordService.getRandomWord();
        newSession.setCurrentWordId(word.getId());
        newSession.setCurrentWordHint(word.getHint());
        newSession.setCharMissing(hideWord(word.getWord()));

        return sessionRepository.save(newSession);
    }

    /**
     * Xử lý khi người chơi đoán từ
     */
    public Session processGuess(String sessionId, String guessWord) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiên chơi"));

        if (session.getStatus().equals("PLAYING")) {
            // Kiểm tra từ đoán
            String correctWord = wordService.findById(session.getCurrentWordId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy từ"))
                    .getWord();
            if (guessWord.equalsIgnoreCase(correctWord)) {
                // Đoán đúng, cộng điểm, round mới
                session.setScore(session.getScore() + 10);
                session.setRound(session.getRound() + 1);

                // Chuẩn bị từ tiếp theo
                Word word = wordService.getRandomWord();
                session.setCurrentWordId(word.getId());
                session.setCurrentWordHint(word.getHint());
                session.setCharMissing(hideWord(word.getWord()));
            } else {
                // Đoán sai, giảm số lượt đoán còn lại
                session.setRemainingGuesses(session.getRemainingGuesses() - 1);
                if (session.getRemainingGuesses() == 0) {
                    session.setStatus("FINISHED");
                    session.setEndTime(LocalDateTime.now());
                }

                // Kiểm tra các ký tự đã đoán đúng và thay thế dấu _
                String charMissing = session.getCharMissing();
                StringBuilder newCharMissing = new StringBuilder(charMissing);
                for (int i = 0; i < correctWord.length(); i++) {
                    if (correctWord.charAt(i) == guessWord.charAt(0)) {
                        newCharMissing.setCharAt(i, guessWord.charAt(0));
                    }
                }
            }
        }
        return sessionRepository.save(session);
    }

    /**
     * Kết thúc phiên chơi
     */
    public Session endGame(String sessionId, String playerName) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phiên chơi"));

        if (!session.getStatus().equals("FINISHED")) {
            session.setStatus("FINISHED");
            session.setEndTime(LocalDateTime.now());
        }
        session.setPlayerName(playerName);
        return sessionRepository.save(session);
    }
    
    //Lấy danh sách top 10 người chơi có điểm cao nhất
    public List<Session> getLeaderboard() {
        List<Session> topSessions = sessionRepository.findTop10ByStatusOrderByScoreDesc();
        // Giới hạn chỉ lấy 10 kết quả (để đảm bảo)
        return topSessions.stream().limit(10).collect(Collectors.toList());
    }

    // Ẩn một số ký tự trong từ vựng
    public String hideWord(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        StringBuilder hiddenWord = new StringBuilder(word);
        int length = word.length();
        int charsToHide = Math.max(1, (int) Math.ceil(length * 0.4));

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            indices.add(i);
        }

        java.util.Collections.shuffle(indices);

        // Replace characters with underscore
        for (int i = 0; i < charsToHide; i++) {
            if (i < indices.size()) {
                hiddenWord.setCharAt(indices.get(i), '_');
            }
        }

        return hiddenWord.toString();
    }
}