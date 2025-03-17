package com.nhom8.wordguess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller để xử lý các request tới trang chủ
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
} 