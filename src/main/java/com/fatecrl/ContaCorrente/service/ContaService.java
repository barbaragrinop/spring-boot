package com.fatecrl.ContaCorrente.service;

import org.springframework.stereotype.Service;

import com.fatecrl.ContaCorrente.bean.Conta;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {
    private static List<Conta> contas = new ArrayList<>();

    public ContaService() {
        contaFake();
    }

    private void contaFake() {
        Conta conta1 = new Conta(0L);
        conta1.setTitular("Diego");
        conta1.setSaldo(1000.0);
        contas.add(conta1);
    }

    public Conta find(Conta conta) {
        for (Conta c : contas) {
            if (c.equals(conta)) {
                return c;
            }
        }
        return null;
    }

    public List<Conta> findAll() {
        return contas;
    }

    public Conta find(Long id) {
        return find(new Conta(id));
    }

    public void create(Conta conta) {
        conta.setId(conta.generateId());
        contas.add(conta);
    }

    public Boolean update(Conta conta) {
        Conta _conta = this.find(conta);

        if (conta == null) {
            return false;
        }

        // da pra melhorar aqu
        _conta.setAgencia(conta.getAgencia());
        _conta.setNumero(conta.getNumero());
        _conta.setTitular(conta.getTitular());
        _conta.setSaldo(conta.getSaldo());

        return true;
    }

    public Boolean delete(Long id) {
        Conta _conta = this.find(id);

        if (_conta == null) {
            return false;
        }

        contas.remove(_conta);

        return true;

    }
}