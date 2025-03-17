package com.nhom8.wordguess.controller;

import com.nhom8.wordguess.model.Word;
import com.nhom8.wordguess.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller xử lý các request liên quan đến từ vựng
 */
@RestController
@RequestMapping("/api")
public class WordController {

    @Autowired
    private WordService wordService;

    /**
     * API lấy một từ ngẫu nhiên từ cơ sở dữ liệu
     * @return ResponseEntity chứa từ ngẫu nhiên
     */
    @GetMapping("/getnewword")
    public ResponseEntity<Word> getRandomWord() {
        // Lấy từ ngẫu nhiên từ service
        Word randomWord = wordService.getRandomWord();
        return ResponseEntity.ok(randomWord);
    }
} 