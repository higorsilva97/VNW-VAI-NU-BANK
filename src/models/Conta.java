package models;

import services.Banco;

public abstract class Conta {

    private String numeroConta;
    private String agencia;
    private String nome;
    private String cpf;

    private String tipoConta;
    
    private Double saldo;

    public Conta(){

    }

    public Conta(String numeroConta, String agencia, String nome, String cpf, String tipoConta, Double saldo) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nome = nome;
        this.cpf = cpf;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void saque(Double valorSaque){
        if(valorSaque > getSaldo()){
            System.out.println("Saldo insuficiente para o saque de R$" + valorSaque);
        }else {
            setSaldo(getSaldo() - valorSaque);
            System.out.println("Saque de "+valorSaque+" realizado com sucesso!");
            System.out.println("Saldo atualizado: "+getSaldo());
        }
    }

    public void depositar(Double valorDeposito){
        if(valorDeposito > 0){
            setSaldo(getSaldo() + valorDeposito);
            System.out.println("Deposito de "+ valorDeposito +" realizado com sucesso!");
        }else {
            System.out.println("Valor menor que 0");
        }
    }

    public void transferencia(Conta contaDestino, Double valorTransferencia) {
        if (valorTransferencia > 0 && this.saldo >= valorTransferencia) {
            this.saldo -= valorTransferencia;
            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
            System.out.println("Transferência de " + valorTransferencia + " realizada para " + contaDestino.getNome() + " com sucesso");
        } else {
            System.out.println("Valor inválido ou saldo insuficiente");
        }
    }




    @Override
    public String toString() {
        return "Conta - " +
                "Número da conta: '" + numeroConta + '\'' +
                ", Agência: " + agencia + '\'' +
                ", Nome: " + nome + '\'' +
                ", CPF: " + cpf + '\'' +
                ", Tipo de conta'" + tipoConta + '\'' +
                ", Saldo: " + saldo +
                '}';
    }
}
