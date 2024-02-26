package services;

import models.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> listaDeContas;

    public Banco(){
        this.listaDeContas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        listaDeContas.add(conta);
    }

    public void  excluirConta(Conta conta){
        listaDeContas.remove(conta);
    }

    public void atualizarConta(Conta conta){
        int index = listaDeContas.indexOf(conta);

        if(index != -1){
            Conta contaAtualizada = listaDeContas.get(index);
            contaAtualizada.setNome(conta.getNome());
            contaAtualizada.setCpf(conta.getCpf());
        }
    }

    public Conta encontrarConta(String numeroConta){
        for(Conta conta : listaDeContas){
            if(conta.getNumeroConta().equals(numeroConta)){
                return conta;
            }
        }
        return null;
    }

    public void exibirContas(){
        for (Conta conta : listaDeContas){
            System.out.println(conta);
        }
    }
}
