package com.fatecrl.ContaCorrente.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.ContaCorrente.bean.Conta;
import com.fatecrl.ContaCorrente.service.ContaService;

import ch.qos.logback.core.status.Status;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired // auto injeção de dependencia
    private ContaService _service;

    @GetMapping("/")
    public ResponseEntity<List<Conta>> getAll() {
        List<Conta> res = _service.findAll();

        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(res);
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
    public ResponseEntity<Conta> post(@RequestBody Conta conta) {
        _service.create(conta);

        // cria a uri da nova entidade criada
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(conta.getId())
                .toUri();

        return ResponseEntity.created(location).body(conta);
        // primeiro parametro do created é o path da nova entidade criada (uri)
        // e o body é o corpo da resposta
    }

    @PutMapping
    public ResponseEntity<Conta> put(@RequestBody Conta conta) {

        boolean req = _service.update(conta);

        if (req == false) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Conta> delete(@PathVariable("id") Long id) {
        boolean req = _service.delete(id);

        if (req == false) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }
}
