package br.dipievil.applistacompras;

public class Product {
    private String nome;
    private double qtd;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public Product() {
    }

    public Product(String nome, double qtd) {
        this.nome = nome;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return nome + " | " + qtd;
    }
}
