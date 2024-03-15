package com.fatecrl.ContaCorrente.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatecrl.ContaCorrente.bean.Conta;
import com.fatecrl.ContaCorrente.service.ContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService _service;

    @GetMapping("/id")
    public String healthCheck() {
        return "Estamos no ar!";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> getConta(@PathVariable("id") Long id) {
        Conta conta = _service.find(id);
        if (conta != null) {
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Conta> post(Conta conta) {
        _service.create(conta);
        return ResponseEntity.ok(conta);
    }
}
