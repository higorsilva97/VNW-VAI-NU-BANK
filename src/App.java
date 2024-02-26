import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;
import services.Banco;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;


public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static Banco banco = new Banco();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao VAI NU BANK");

        int opcao;

        do{
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    criarConta();
                    break;
                case 2:
                    exibirContas();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarDeposito();
                    break;
                case 5:
                    realizarTransferencia();
                    break;
                case 6:
                    excluirConta();
                    break;
                case 7:
                    atualizarConta();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }

        }while (opcao != 0);

    }
    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Criar Conta");
        System.out.println("2. Exibir Contas");
        System.out.println("3. Realizar Saque");
        System.out.println("4. Realizar Depósito");
        System.out.println("5. Realizar Transferência");
        System.out.println("6. Excluir conta");
        System.out.println("7. Atualizar conta");
        System.out.println("8. Sair");
    }

    private static void criarConta() {
        System.out.println("Criar conta");
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int escolhaTipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Agencia: ");
        String agencia = scanner.nextLine();
        System.out.println("Saldo inicial: ");
        Double saldoInicial = scanner.nextDouble();

        Conta contaNova;

        if(escolhaTipo == 1){
            Double limiteCredito = 0.0;
            String tipoConta = "CC";
            String numeroConta = tipoConta + gerarNumeroAleatorio(6);
            contaNova = new ContaCorrente(numeroConta, agencia, nome, cpf, tipoConta, saldoInicial, limiteCredito);
            banco.adicionarConta(contaNova);
            System.out.println("Conta corrente criada com sucesso: " + contaNova);
        }else {
            String tipoConta = "CP";
            LocalDate dataAniversario = LocalDate.of(2024, 2, 20);
            String numeroConta = tipoConta + gerarNumeroAleatorio(6);
            contaNova = new ContaPoupanca(numeroConta, agencia, nome, cpf, tipoConta, saldoInicial, dataAniversario);
            banco.adicionarConta(contaNova);
            System.out.println("Conta poupança criada com sucesso: " + contaNova);
        }
    }

    private static void excluirConta(){
        System.out.println("Excluir conta");
        System.out.println("Número da sua conta: ");
        String numeroConta = scanner.next();

        Conta conta = banco.encontrarConta(numeroConta);

        if(conta != null ){
            banco.excluirConta(conta);
            System.out.println("Conta excluida com sucesso!");
        }else {
            System.out.println("Conta não encontrada");
        }
    }

    private static void  atualizarConta(){
        System.out.println("Atualizar conta");
        System.out.println("Número da sua conta: ");
        String numeroConta = scanner.next();
        scanner.nextLine();

        Conta conta = banco.encontrarConta(numeroConta);

        if(conta != null ){
            System.out.println("Nome: ");
            String novoNome = scanner.nextLine();
            System.out.println("CPF: ");
            String novoCPF = scanner.nextLine();

            conta .setNome(novoNome);
            conta.setCpf(novoCPF);

            banco.atualizarConta(conta);


            System.out.println("Conta atualiza com sucesso!");
        }else {
            System.out.println("Conta não encontrada");
        }

    }

    private static void exibirContas() {
        banco.exibirContas();
    }
    private static void realizarTransferencia() {
        System.out.println("Transferencia");
        System.out.println("Número da sua conta: ");
        String numeroContaOrigem = scanner.next();

        System.out.println("Numero da conta destino: ");
        String numeroContaDestino = scanner.next();

        System.out.println("Valor da transferencia: ");
        Double valorTransferencia = scanner.nextDouble();


        Conta contaOrigem = banco.encontrarConta(numeroContaOrigem);
        Conta contaDestino = banco.encontrarConta(numeroContaDestino);


        if(contaDestino != null && contaOrigem != null){
            contaOrigem.transferencia(contaDestino, valorTransferencia);
        }else {
            System.out.println("Conta origem ou destino não encontrada!");
        }


    }

    private static void realizarDeposito() {
        System.out.println("Deposito");
        System.out.println("Numero da conta:");
        String numeroConta = scanner.next();
        System.out.println("Valor do deposito: ");
        Double valorDeposito = scanner.nextDouble();

        Conta conta = banco.encontrarConta(numeroConta);
        if(conta != null){
            conta.depositar(valorDeposito);
        }else {
            System.out.println("Conta nao encontrada! ");
        }
    }

    private static void realizarSaque() {
        System.out.println("Saque");
        System.out.println("Numero da conta:");
        String numeroConta = scanner.next();
        System.out.println("Valor do saque: ");
        Double valorSaque = scanner.nextDouble();

        Conta conta = banco.encontrarConta(numeroConta);
        if(conta != null){
            conta.saque(valorSaque);
        }else {
            System.out.println("Conta nao encontrada! ");
        }
    }

    private static String gerarNumeroAleatorio(int comprimento) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < comprimento; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


}
