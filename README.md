# VAI NU BANK 
# Sistema de Cadastro de Contas Bancárias
- Criação de conta corrente ou poupança.
- Conta corrente: permite saques ilimitados e opção de limite de crédito.
- Conta poupança: oferece juros de 2% do valor a cada saque realizado.
- Métodos bancários: saque, depósito e transferência.
  
```mermaid 
classDiagram
    class Conta {
        - String numeroConta
        - String agencia
        - String nome
        - String cpf
        - String tipoConta
        - Double saldo
        --
        + saque(valorSaque: Double): void
        + depositar(valorDeposito: Double): void
        + transferencia(contaDestino: Conta, valorTransferencia: Double): void
        + toString(): String
    }

    class ContaCorrente {
        - Double limiteCredito
              
    }

    class ContaPoupanca {
        - LocalDate dataAniversario
    }

    class Banco {
        - List<Conta> listaDeContas
        --
        + adicionarConta(conta: Conta): void
        + excluirConta(conta: Conta): void
        + atualizarConta(conta: Conta): void
        + encontrarConta(numeroConta: String): Conta
        + exibirContas(): void
    }

    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca

