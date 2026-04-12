package silver.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import silver.model.Produto;
import javax.swing.table.DefaultTableModel;
import silver.model.Cliente;

public class TelaProdutos extends javax.swing.JFrame {

    private java.util.List<silver.model.Produto> listaLocalProdutos;
    private ArrayList<Produto> listaProdutosOriginal;
    private ArrayList<Cliente> listaClientesOriginal;
    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaProdutos.class.getName());

    public TelaProdutos(ArrayList<Produto> listaProdutosOriginal1, ArrayList<Cliente> listaClientesOriginal1) {
        initComponents();

        this.listaProdutosOriginal = listaProdutosOriginal1;
        this.listaClientesOriginal = listaClientesOriginal1;
        
        if (this.listaProdutosOriginal == null || this.listaProdutosOriginal.isEmpty()) {
        try {
            com.silvermanager.dao.ProdutoDAO pdao = new com.silvermanager.dao.ProdutoDAO();
            this.listaProdutosOriginal = (ArrayList<Produto>) pdao.listarTodos();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar do banco: " + e.getMessage());
        }
        }
        
        this.setLocationRelativeTo(null);
        recarregarTabelaCompleta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovoProduto = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Clientes");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel1.setText("SilverManager");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Produtos");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("PDV");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Gestão de Inventário");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço de Venda", "Qtd Estoque", "Código Barra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        btnExcluir.setBackground(new java.awt.Color(102, 102, 102));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovoProduto.setBackground(new java.awt.Color(102, 102, 102));
        btnNovoProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNovoProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Buscar Produto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnExcluir)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovoProduto))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(btnNovoProduto)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        // TODO add your handling code here:
        try {

            String nome = javax.swing.JOptionPane.showInputDialog("Nome do Produto:");
            if (nome == null || nome.isEmpty()) {
                return;
            }

            double precoVenda = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Preço de Venda:"));
            double precoCusto = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Preço de Custo:")); // Adicionado para seu banco
            int estoque = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Quantidade em Estoque:"));
            String codigo = javax.swing.JOptionPane.showInputDialog("Código de Barras:");

            silver.model.Produto novo = new silver.model.Produto();
            novo.setNome(nome);
            novo.setValorVenda(precoVenda);
            novo.setValorCusto(precoCusto);
            novo.setQuantidadeEstoque(estoque);
            novo.setCodigoBarra(codigo);

            com.silvermanager.dao.ProdutoDAO dao = new com.silvermanager.dao.ProdutoDAO();
            dao.cadastrar(novo);

            recarregarTabelaCompleta();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: Digite apenas números em Preço e Estoque!");
        }
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    int linhaSelecionada = tblProdutos.getSelectedRow();

    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
        return;
    }

    // Pega o produto da lista local (Opção B)
    silver.model.Produto produtoSelecionado = listaLocalProdutos.get(linhaSelecionada);

    try {
        // 1. Abre os inputs com os valores atuais
        String novoNome = javax.swing.JOptionPane.showInputDialog("Novo nome:", produtoSelecionado.getNome());
        if (novoNome == null) return; 

        String novoPreco = javax.swing.JOptionPane.showInputDialog("Novo preço:", produtoSelecionado.getValorVenda());
        String novaQtd = javax.swing.JOptionPane.showInputDialog("Nova quantidade:", produtoSelecionado.getQuantidadeEstoque());
        
        // --- ADICIONADO: Input para o Código de Barras ---
        String novoCodigo = javax.swing.JOptionPane.showInputDialog("Novo Código de Barras:", produtoSelecionado.getCodigoBarra());

        // 2. Atualiza o objeto com os novos valores digitados
        produtoSelecionado.setNome(novoNome);
        produtoSelecionado.setValorVenda(Double.parseDouble(novoPreco));
        produtoSelecionado.setQuantidadeEstoque(Integer.parseInt(novaQtd));
        produtoSelecionado.setCodigoBarra(novoCodigo); // Setando o novo código

        // 3. Manda para o Banco
        com.silvermanager.dao.ProdutoDAO dao = new com.silvermanager.dao.ProdutoDAO();
        dao.atualizar(produtoSelecionado);

        // 4. Recarrega a tabela na tela
        recarregarTabelaCompleta();

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro: Preço e Estoque devem ser números!");
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao processar edição: " + e.getMessage());
    }



    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tblProdutos.getSelectedRow();

    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        return;
    }
  
    silver.model.Produto produtoSelecionado = listaLocalProdutos.get(linhaSelecionada);
  
    int resposta = javax.swing.JOptionPane.showConfirmDialog(this, 
            "Deseja realmente excluir o produto: " + produtoSelecionado.getNome() + "?",
            "Confirmação", 
            javax.swing.JOptionPane.YES_NO_OPTION);

    if (resposta == javax.swing.JOptionPane.YES_OPTION) {
        
        com.silvermanager.dao.ProdutoDAO dao = new com.silvermanager.dao.ProdutoDAO();
        dao.excluir(produtoSelecionado.getId());
   
        recarregarTabelaCompleta();
    }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
        filtrarTabela(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtBuscar.setText(""); // Esvazia o campo de texto
        recarregarTabelaCompleta();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        String termo = txtBuscar.getText();
        filtrarTabela(termo);
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        TelaPrincipal telaCli = new TelaPrincipal();
        telaCli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        TelaPDV telaPdv = new TelaPDV(listaProdutosOriginal, listaClientesOriginal);
        telaPdv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaProdutos(new ArrayList<>(), new ArrayList<>()).setVisible(true);
        });
    }
    //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void recarregarTabelaCompleta() {

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();

        modelo.setNumRows(0);

        try {

            com.silvermanager.dao.ProdutoDAO dao = new com.silvermanager.dao.ProdutoDAO();
            
            listaLocalProdutos = dao.listarTodos();

            for (silver.model.Produto p : dao.listarTodos()) {
                modelo.addRow(new Object[]{
                    p.getNome(),
                    p.getValorVenda(),
                    p.getQuantidadeEstoque(),
                    p.getCodigoBarra()
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e.getMessage());
        }
    }

    private void filtrarTabela(String termoBusca) {
    DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
    modelo.setNumRows(0);
   
    for (Produto p : this.listaProdutosOriginal) { 
        if (p.getNome().toLowerCase().contains(termoBusca.toLowerCase()) 
            || p.getCodigoBarra().contains(termoBusca)) {
            
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getValorVenda(),
                p.getQuantidadeEstoque(),
                p.getCodigoBarra()
            });
        }
    }
}

    private void calcularTotal() {
    double totalGeral = 0; // Criando a variável para somar
    
    DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel(); 

    for (int i = 0; i < modelo.getRowCount(); i++) {
        
        totalGeral += Double.parseDouble(modelo.getValueAt(i, 1).toString());
    }
}
}
