package com.silvermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.silvermanager.conexao.Conexao; 
import silver.model.Produto; 

public class ProdutoDAO {

    public void cadastrar(Produto p) {
    
    String sql = "INSERT INTO produtos (nome, valor_custo, valor_venda, quantidade_estoque, codigo_barra) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getValorCusto());
        stmt.setDouble(3, p.getValorVenda());
        stmt.setInt(4, p.getQuantidadeEstoque());
        stmt.setString(5, p.getCodigoBarra());

        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
    }
}
    public java.util.List<silver.model.Produto> listarTodos() {
    String sql = "SELECT * FROM produtos";
    java.util.List<silver.model.Produto> lista = new java.util.ArrayList<>();

    try (Connection conn = com.silvermanager.conexao.Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         java.sql.ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            silver.model.Produto p = new silver.model.Produto();
            p.setNome(rs.getString("nome"));
            p.setValorVenda(rs.getDouble("valor_venda"));
            p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
            p.setCodigoBarra(rs.getString("codigo_barra"));
            p.setId(rs.getInt("id"));
            lista.add(p);
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Erro ao listar: " + e.getMessage());
    }
    return lista;
}
    
    public void atualizar(silver.model.Produto p) {
    
    String sql = "UPDATE produtos SET nome=?, valor_venda=?, quantidade_estoque=?, codigo_barra=? WHERE id=?";

    try (Connection conn = com.silvermanager.conexao.Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getValorVenda());
        stmt.setInt(3, p.getQuantidadeEstoque());
        stmt.setString(4, p.getCodigoBarra()); 
        stmt.setInt(5, p.getId()); 

        stmt.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
    }
}
    public void excluir(int id) {
    String sql = "DELETE FROM produtos WHERE id = ?";
    try (Connection conn = com.silvermanager.conexao.Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(null, "Produto excluído!");
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
    }
}
   
    public void atualizarEstoque(String codigoBarra, int quantidadeVendida) {
    String sql = "UPDATE produtos SET quantidade_estoque = quantidade_estoque - ? WHERE codigo_barra = ?";
    
    // Certifique-se de que está usando a sua classe de Conexao
    try (Connection conn = new com.silvermanager.conexao.Conexao().conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, quantidadeVendida);
        stmt.setString(2, codigoBarra);
        
        stmt.executeUpdate(); 
    } catch (Exception e) {
        System.out.println("Erro ao atualizar estoque: " + e.getMessage());
    }
}
    
}
