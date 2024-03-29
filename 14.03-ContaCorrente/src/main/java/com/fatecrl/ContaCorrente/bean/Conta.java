package com.fatecrl.ContaCorrente.bean;

import java.io.Serializable;
import java.util.Objects;

public class Conta {

    private static final long serialVersionUID = -4205156507257923921L;
    private static Long nextId = 1L; // auto incremento static para manter o mesmo valor para todas as instancias
                                     // para incrementar o id correto
    private Long id;
    private Integer agencia;
    private String numero;
    private String titular;
    private Double saldo;

    public Conta() {

    }

    public Conta(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long generateId() {
        return nextId++;
    }

    public Long getId() {
        return id;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", agencia=" + agencia + ", numero=" + numero + ", titular=" + titular + ", saldo="
                + saldo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        return Objects.equals(id, other.id);
    }
}
