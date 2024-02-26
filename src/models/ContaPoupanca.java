package models;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

    private LocalDate dataAniversario;

    public ContaPoupanca() {

    }
    public ContaPoupanca(String numeroConta, String agencia, String nome, String cpf, String tipoConta, Double saldo, LocalDate dataAniversario) {
        super(numeroConta, agencia, nome, cpf, tipoConta, saldo);
        this.dataAniversario = dataAniversario;

    }


    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    @Override
    public void saque(Double valorSaque){
        Double valorComDesconto = valorSaque*0.98;
        if(valorComDesconto > getSaldo()){
            System.out.println("Saldo insuficiente para o saque de R$" + valorSaque);
        }else {
            setSaldo(getSaldo() - valorComDesconto);
            System.out.println("Saque de "+valorComDesconto+" realizado com sucesso!");
            System.out.println("Saldo atualizado: "+getSaldo());
        }
    }


    @Override
    public String toString() {
        return super.toString() +
                ", data Aniversario=" + dataAniversario +
                '}';
    }

}
