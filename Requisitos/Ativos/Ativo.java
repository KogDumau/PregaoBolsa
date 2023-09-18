package Requisitos.Ativos;


public abstract class Ativo {
    private String nome;
    private double preco;
    private int quantidade;

    public Ativo(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ativo: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}