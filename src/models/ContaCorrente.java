package models;

public class ContaCorrente extends Conta{

    private Double limiteCredito;


    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public ContaCorrente() {
        super();
    }
    public ContaCorrente(String numeroConta, String agencia, String nome, String cpf, String tipoConta, Double saldo, Double limiteCredito) {
        super(numeroConta, agencia, nome, cpf, tipoConta, saldo);
        this.limiteCredito = limiteCredito;

    }

    @Override
    public String toString() {
        return super.toString() +
                ", Limite de credito" + limiteCredito +
                '}';
    }
}
