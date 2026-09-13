package com.silvermanager.service;

import com.silvermanager.dao.ClienteDAO;
import silver.model.Cliente;
import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void salvarCliente(Cliente c) {
        if (c.getNome() == null || c.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório!");
        }
        if (c.getCpf() == null || c.getCpf().replaceAll("[^0-9]", "").length() != 11) {
            throw new IllegalArgumentException("CPF inválido! Deve possuir 11 dígitos numéricos.");
        }
        if (c.getEmail() == null || !c.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail com formato inválido!");
        }

        clienteDAO.cadastrar(c);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }

    public void atualizarCliente(Cliente c) {
        if (c.getIdCliente() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }
        clienteDAO.atualizar(c);
    }

    public void removerCliente(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        clienteDAO.excluir(id);
    }
}
