package com.silvermanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.silvermanager.conexao.Conexao;

public class VendaDAO {

    // Método principal para gravar a venda no banco de dados
    public void cadastrarVenda(String codigoBarra, int qtd, double total) {
    String sql = "INSERT INTO vendas (codigo_barra, quantidade, valor_total, data_venda) VALUES (?, ?, ?, NOW())";
    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, codigoBarra);
        stmt.setInt(2, qtd);
        stmt.setDouble(3, total);

        int linhasAfetadas = stmt.executeUpdate(); 
        //System.out.println("Linhas inseridas no banco: " + linhasAfetadas);

    } catch (SQLException e) {
        System.out.println("ERRO NO DAO: " + e.getMessage());
    }
}
}