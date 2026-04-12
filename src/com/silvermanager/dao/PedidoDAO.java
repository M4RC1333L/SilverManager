package com.silvermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import silver.model.Pedidos; 
import com.silvermanager.conexao.Conexao;

public class PedidoDAO {

    public void salvarPedido(Pedidos p) {
        String sql = "INSERT INTO pedidos (id_cliente, valor_total, status_pedido) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdCliente());
            stmt.setDouble(2, p.getTotal());
            stmt.setString(3, p.getStatus());

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar pedido no banco: " + e.getMessage());
        }
    }

    public List<Pedidos> listarPorCliente(int idCliente) {
        List<Pedidos> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pedidos p = new Pedidos();
                    p.setId(rs.getInt("id")); 
                    p.setTotal(rs.getDouble("valor_total"));
                    p.setDataPedido(rs.getTimestamp("data_pedido"));
                    p.setStatus(rs.getString("status_pedido"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos no DAO: " + e.getMessage());
        }
       
        return lista; 
    }
}