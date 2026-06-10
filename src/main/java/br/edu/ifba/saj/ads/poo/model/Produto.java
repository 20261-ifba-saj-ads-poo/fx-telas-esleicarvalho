package br.edu.ifba.saj.ads.poo.model;

public class Produto {
    private String nome;
    private String tamanho;
    private String cor;
    private Double preco;
    private String departamento;
    
    public Produto(String nome, String tamanho, String cor, Double preco, String departamento) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getDepartamento() {
        return departamento;
    }

}
