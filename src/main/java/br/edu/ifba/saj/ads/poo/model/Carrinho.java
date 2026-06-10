package br.edu.ifba.saj.ads.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;
    private Double soma = 0d;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        soma+= produto.getPreco();
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        soma-= produto.getPreco();
    }

    public Double getSoma() {
        return soma;
    }
}
