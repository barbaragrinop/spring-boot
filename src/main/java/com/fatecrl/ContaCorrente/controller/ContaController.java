package com.fatecrl.ContaCorrente.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ContaController {

    @GetMapping("/")
    public String healthCheck() {
        return "Healthy";
    }
}
