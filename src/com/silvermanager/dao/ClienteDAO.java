package com.silvermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.silvermanager.conexao.Conexao;
import silver.model.Cliente;

public class ClienteDAO {

    public void cadastrar(Cliente c) {
        
        String sql = "INSERT INTO cadastro_clientes (Nome, telefone, email, CPF, id_endereco) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getCpf());
            stmt.setInt(5, c.getIdEndereco());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente " + c.getNome() + " salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar no banco: " + e.getMessage());
        }
    }
    
    public java.util.List<silver.model.Cliente> listarTodos() {
    String sql = "SELECT * FROM cadastro_clientes";
    java.util.List<silver.model.Cliente> lista = new java.util.ArrayList<>();

    try (Connection conn = com.silvermanager.conexao.Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         java.sql.ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            
            silver.model.Cliente c = new silver.model.Cliente();
            c.setIdCliente(rs.getInt("id_cliente"));
            c.setNome(rs.getString("Nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setCpf(rs.getString("CPF"));
            c.setIdEndereco(rs.getInt("id_endereco"));
            lista.add(c);
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Erro ao listar clientes: " + e.getMessage());
    }
    return lista;
}

    public void excluir(int idCliente) {

    String sql = "DELETE FROM cadastro_clientes WHERE id_cliente = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idCliente);

        stmt.executeUpdate();

    } catch (SQLException e) {

        if (e.getMessage().contains("foreign key")) {

            JOptionPane.showMessageDialog(null,
                "Não é possível excluir este cliente.\n"
              + "Ele possui pedidos cadastrados.");

        } else {

            JOptionPane.showMessageDialog(null,
                "Erro ao excluir cliente: "
                + e.getMessage());
        }
    }

}
    public void atualizar(Cliente c) {

    String sql = "UPDATE cadastro_clientes "
               + "SET Nome = ?, telefone = ?, email = ?, CPF = ? "
               + "WHERE id_cliente = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getTelefone());
        stmt.setString(3, c.getEmail());
        stmt.setString(4, c.getCpf());
        stmt.setInt(5, c.getIdCliente());

        stmt.executeUpdate();

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(null,
                "Erro ao atualizar cliente: "
                + e.getMessage());

    }
}
}