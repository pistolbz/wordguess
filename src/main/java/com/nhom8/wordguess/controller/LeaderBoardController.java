package com.nhom8.wordguess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

/**
 * Controller xử lý các request liên quan đến từ vựng
 */
@RestController
@RequestMapping("/api/leaderboard")
@Controller
public class LeaderBoardController {

    @GetMapping("/")
    public String showLeaderBoardPage() {
        return "leaderboard";
    }
}