package com.fatecrl.ContaCorrente.service;

import org.springframework.stereotype.Service;

import com.fatecrl.ContaCorrente.bean.Conta;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {
    private List<Conta> contas = new ArrayList<>();

    public ContaService() {

    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Conta find(Conta conta) {
        for (Conta c : this.contas) {
            if (c.equals(conta)) {
                return c;
            }
        }

        return null;
    }

    public Conta find(Long id) {
        return this.find(new Conta(id));
    }

}
