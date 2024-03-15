package com.fatecrl.ContaCorrente.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatecrl.ContaCorrente.bean.Conta;
import com.fatecrl.ContaCorrente.service.ContaService;

import ch.qos.logback.core.status.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired // auto injeção de dependencia
    private ContaService _service;

    @GetMapping("/id")
    public String healthCheck() {
        return "Healthy";
    }

    @GetMapping(value = "/{id}") // define o nome da rota e o parametro que ela receb |
    // o value (pathParameter) e o @PathVariable("id") (queryParameter) precisam ser
    // iguais para idicar que o parametro da rota é o mesmo que o parametro da query
    public ResponseEntity<Conta> getConta(@PathVariable("id") Long id) {
        Conta conta = _service.find(id);

        if (conta == null) {
            return ResponseEntity.notFound().build(); // http 404
        }

        // ResponseEntity serve para retornar status code
        return ResponseEntity.ok(conta); // http 200
    }

    @PostMapping
    public ResponseEntity<Conta> post(Conta conta) {
        _service.create(conta);
        return ResponseEntity.ok(conta);
    }

}
