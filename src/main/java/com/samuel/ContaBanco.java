package com.samuel;

import java.util.Random;

public class ContaBanco {
    private String titular;
    private String tipo;
    private int numeroConta;
    private float saldo;
    private boolean ativo;


    
    public ContaBanco() {
        Random rd = new Random();
        this.numeroConta = rd.nextInt(99999) + 11111;
        this.saldo = 0f;
    }


    public void sacar(float valor){
        if(!this.ativo){
            throw new IllegalArgumentException("Erro! Conta Inativa");
        }

        if(valor <=0){
            throw new IllegalArgumentException("Erro! Valor de Saque invalido");
        }
        if(valor > this.saldo){
            throw new IllegalArgumentException("Saldo Insuficiente!");
        }

        this.setSaldo(this.getSaldo() - valor);

       
    }

    public void depositar(float valor){
        if(!this.ativo){
            throw new IllegalArgumentException("Erro ao Depositar! Conta Inativa");
        }
        if(valor <= 0){
            throw new IllegalArgumentException("Valor Invalido!!");
        }
        this.setSaldo(this.getSaldo() + valor);
        
    }


    public void criarConta(String titular, String tipo){
        if(this.ativo){
            throw  new IllegalArgumentException("Não é Possivel Abrir Mais de 1 Conta");
        }
        this.setTitular(titular);
        this.setTipo(tipo);
        this.setAtivo(true);
    }

    public String exibirDetalhes(){
        if(!this.ativo){
            throw new IllegalStateException("Conta Inativa");
        }

        String aux, aux2;
        aux = this.ativo ? "Ativa" : "Desativada";
        aux2 = this.tipo.equalsIgnoreCase("CC") ? "Conta Corrente" : "Conta Poupança";
       
        return "Titular da Conta: " + this.getTitular() +
                "\nNumero Da Conta: " + this.getNumeroConta() +
                "\nTipo de Conta: " + aux2 +
                "\nSaldo da Conta: R$" + this.getSaldo() +
                "\nStatus da Conta: " + aux; 
    }


    public void fecharConta(){
        if(!this.ativo){
            throw new IllegalStateException("Conta Já está Inativa");
        }
        this.setAtivo(false);

    }


    //METODOS ESPECIAIS

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if(titular == null || titular.isBlank()){
            throw new IllegalArgumentException("Nome Invalido");
        }
        this.titular = titular;
        
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
    if (tipo == null) {
        throw new IllegalArgumentException("Tipo de conta inválido");
    }

    if (tipo.equalsIgnoreCase("CC")) {
        this.tipo = "CC";
        this.saldo = 50;
    } else if (tipo.equalsIgnoreCase("CP")) {
        this.tipo = "CP";
        this.saldo = 150;
    } else {
        throw new IllegalArgumentException("Tipo de conta inválido (use CC ou CP)");
    }
    }


    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
