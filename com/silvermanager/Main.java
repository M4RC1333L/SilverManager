package com.silvermanager;

import com.silvermanager.service.ClienteService;
import com.silvermanager.service.ProdutoService;
import silver.model.Cliente;
import silver.model.Produto;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== EXECUTANDO TESTES DE REGRAS DE NEGÓCIO - SILVER MANAGER ===");

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();

        // 1. Teste de Validação de Nome Obrigatório
        try {
            Cliente c1 = new Cliente("", "(11) 99999-8888", "teste@email.com", "123.456.789-00");
            clienteService.salvarCliente(c1);
        } catch (IllegalArgumentException e) {
            System.out.println(" [TESTE PASSO - NOME CLIENTE]: " + e.getMessage());
        }

        // 2. Teste de Validação de CPF Inválido
        try {
            Cliente c2 = new Cliente("João da Silva", "(11) 99999-8888", "teste@email.com", "123");
            clienteService.salvarCliente(c2);
        } catch (IllegalArgumentException e) {
            System.out.println(" [TESTE PASSO - CPF]: " + e.getMessage());
        }

        // 3. Teste de Validação de Estoque Negativo
        try {
            Produto p1 = new Produto("Cadeira Office", -50.0, -2, "789123456");
            produtoService.salvarProduto(p1);
        } catch (IllegalArgumentException e) {
            System.out.println(" [TESTE PASSO - ESTOQUE PRODUTO]: " + e.getMessage());
        }

        System.out.println("=== TODOS OS TESTES FORAM EXECUTADOS COM SUCESSO ===");
    }
}