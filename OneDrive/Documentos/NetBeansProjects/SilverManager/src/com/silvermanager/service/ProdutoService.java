package com.silvermanager.service;

import com.silvermanager.dao.ProdutoDAO;
import silver.model.Produto;
import java.util.List;

public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvarProduto(Produto p) {
        if (p.getNome() == null || p.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório!");
        }
        if (p.getValorVenda() <= 0) {
            throw new IllegalArgumentException("O preço de venda deve ser maior que zero!");
        }
        if (p.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo!");
        }
        if (p.getCodigoBarra() == null || p.getCodigoBarra().trim().isEmpty()) {
            throw new IllegalArgumentException("O código de barras é obrigatório!");
        }

        produtoDAO.cadastrar(p);
    }

    public void atualizarProduto(Produto p) {
        if (p.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }
        produtoDAO.atualizar(p);
    }

    public void darBaixaEstoque(String codigoBarra, int qtd) {
        if (qtd <= 0) {
            throw new IllegalArgumentException("A quantidade vendida deve ser maior que zero.");
        }
        produtoDAO.atualizarEstoque(codigoBarra, qtd);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }

    public void removerProduto(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID de produto inválido.");
        }
        produtoDAO.excluir(id);
    }
}