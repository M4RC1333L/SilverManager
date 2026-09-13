package silver.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import silver.model.Cliente;
import silver.model.Produto;
import silver.view.TelaSelecionarProduto;
import com.silvermanager.dao.PedidoDAO;
import com.silvermanager.dao.VendaDAO;
import java.util.List;
import silver.model.Pedidos;

public class TelaPDV extends javax.swing.JFrame {

    private ArrayList<Produto> listaItens = new ArrayList<>();
    private Cliente clienteAtual;

    private ArrayList<Produto> listaProdutosOriginal;
    private ArrayList<Cliente> listaClientesOriginal;

    private DefaultTableModel modeloCarrinho;
    private double valorTotalVenda = 0.0;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPDV.class.getName());

    public TelaPDV(ArrayList<Produto> produtos, ArrayList<Cliente> clientes) {
        initComponents();
        this.listaProdutosOriginal = produtos;
        this.listaClientesOriginal = clientes;

        this.modeloCarrinho = (DefaultTableModel) tblCarrinho.getModel();
        this.modeloCarrinho.setNumRows(0);

        this.setLocationRelativeTo(null);
    }

    public void adicionarProdutoAoCarrinho(Produto p) {

        listaItens.add(p);

        DefaultTableModel modelo = (DefaultTableModel) tblCarrinho.getModel();
        modelo.addRow(new Object[]{
            p.getNome(),
            1,
            p.getValorVenda(),
            p.getCodigoBarra()
        });

        calcularTotal();
    }

    public void definirClienteNoFormulario(Cliente c) {
        txtNomeCliente.setText(c.getNome());
        txtCpfCliente.setText(c.getCpf());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblProdutos = new javax.swing.JLabel();
        lblPdv = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSelecionarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtCpfCliente = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnFinalizarPedido = new javax.swing.JButton();
        totalField = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAddProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ponto de Venda");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel1.setText("SilverManager");

        lblClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblClientes.setText("Clientes");
        lblClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClientesMouseClicked(evt);
            }
        });

        lblProdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProdutos.setText("Produtos");
        lblProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProdutosMouseClicked(evt);
            }
        });

        lblPdv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPdv.setText("PDV");
        lblPdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPdvMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPdv)
                            .addComponent(lblProdutos)
                            .addComponent(lblClientes))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(lblClientes)
                .addGap(18, 18, 18)
                .addComponent(lblProdutos)
                .addGap(18, 18, 18)
                .addComponent(lblPdv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Ponto de Venda(PDV)");

        btnSelecionarCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnSelecionarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelecionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnSelecionarCliente.setText("Selecionar Cliente");
        btnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClienteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nome");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("CPF");

        try {
            txtCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Unitário", "Código Barra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);

        btnExcluir.setBackground(new java.awt.Color(102, 102, 102));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFinalizarPedido.setBackground(new java.awt.Color(102, 102, 102));
        btnFinalizarPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        totalField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalField.setText("TOTAL:");

        lblTotal.setText("00.00");

        btnAddProduto.setBackground(new java.awt.Color(102, 102, 102));
        btnAddProduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduto.setText("Add Produto");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSelecionarCliente)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnExcluir)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddProduto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFinalizarPedido)))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(totalField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(btnSelecionarCliente)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTotal)
                    .addComponent(totalField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnAddProduto))
                    .addComponent(btnFinalizarPedido))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClienteActionPerformed
        // TODO add your handling code here:
        TelaSelecionarCliente busca = new TelaSelecionarCliente(this, listaClientesOriginal);
        busca.setVisible(true);
        busca.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSelecionarClienteActionPerformed

    private void lblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClientesMouseClicked
        // TODO add your handling code here:
        TelaPrincipal telaCli = new TelaPrincipal();
        telaCli.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_lblClientesMouseClicked

    private void lblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutosMouseClicked
        // TODO add your handling code here:
        new TelaProdutos(listaProdutosOriginal, listaClientesOriginal).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblProdutosMouseClicked

    private void lblPdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPdvMouseClicked
        // TODO add your handling code here:
        TelaPDV telaPdv = new TelaPDV(listaProdutosOriginal, listaClientesOriginal);
        telaPdv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblPdvMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:                                           
        int linha = tblCarrinho.getSelectedRow();

        if (linha != -1) {
            // 1. Remove da lista lógica
            listaItens.remove(linha);
            // 2. Remove da linha da tabela
            ((javax.swing.table.DefaultTableModel) tblCarrinho.getModel()).removeRow(linha);
            // 3. Recalcula o total
            calcularTotal();

            javax.swing.JOptionPane.showMessageDialog(this, "Item removido.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um item na tabela.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        // TODO add your handling code here:

        try {
    // 1. Verificação de segurança: Carrinho vazio?
    DefaultTableModel modelo = (DefaultTableModel) tblCarrinho.getModel();
    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "O carrinho está vazio!");
        return;
    }

    // 2. Grava o Pedido (Cabeçalho da venda)
    silver.model.Pedidos p = new silver.model.Pedidos();
    p.setIdCliente(clienteAtual.getId());
    double total = Double.parseDouble(lblTotal.getText());
    p.setTotal(total);
    p.setStatus("Finalizado");

    com.silvermanager.dao.PedidoDAO dao = new com.silvermanager.dao.PedidoDAO();
    dao.salvarPedido(p); 

    // 3. Grava os Itens da Venda (O LOOP DEVE FICAR AQUI NO TRY)
    VendaDAO vdao = new VendaDAO();
    com.silvermanager.dao.ProdutoDAO pdao = new com.silvermanager.dao.ProdutoDAO();
    for (int i = 0; i < modelo.getRowCount(); i++) {
        
        Object valorCodigo = modelo.getValueAt(i, 3); // Coluna do Código de Barras
        Object valorQtd = modelo.getValueAt(i, 1);    // Coluna da Quantidade real
        Object valorPreco = modelo.getValueAt(i, 2);  // Coluna do Preço

        if (valorCodigo != null) {
            String codigoLinha = valorCodigo.toString().trim();
            int qtdReal = Integer.parseInt(valorQtd.toString());
            double precoLinha = Double.parseDouble(valorPreco.toString());

            // Grava cada item individualmente no banco
            vdao.cadastrarVenda(codigoLinha, qtdReal, precoLinha);
            pdao.atualizarEstoque(codigoLinha, qtdReal);
        }
    }

    // 4. Sucesso total
    javax.swing.JOptionPane.showMessageDialog(this, "Vendas registradas com sucesso!");
    limparPDV();

} catch (Exception e) {
    // O catch serve para te avisar se ALGO deu errado, não para processar dados
    JOptionPane.showMessageDialog(this, "Erro ao finalizar venda: " + e.getMessage());
    e.printStackTrace(); 
}

    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed

        // 1. Verifica se o clienteAtual é nulo (ou se os campos de texto estão vazios)
        if (clienteAtual == null) {
            // Exibe a mensagem de erro para o usuário
            JOptionPane.showMessageDialog(this,
                    "Erro: Você precisa selecionar um cliente antes de adicionar produtos!",
                    "Cliente não selecionado",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            TelaSelecionarProduto telaSel = new TelaSelecionarProduto(this, true, this, this.listaProdutosOriginal);
            telaSel.setLocationRelativeTo(null);
            telaSel.setVisible(true);

        }
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaPDV(new ArrayList<>(), new ArrayList<>()).setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblPdv;
    private javax.swing.JLabel lblProdutos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JLabel totalField;
    private javax.swing.JFormattedTextField txtCpfCliente;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration//GEN-END:variables

    public void setClienteSelecionado(Cliente clienteEscolhido) {
        if (clienteEscolhido != null) {
            this.clienteAtual = clienteEscolhido; // Salva o objeto cliente na tela

            txtNomeCliente.setText(clienteEscolhido.getNome());
            txtCpfCliente.setText(clienteEscolhido.getCpf());
        }
    }

    private void recarregarTabelaVenda() {
        DefaultTableModel modelo = (DefaultTableModel) tblCarrinho.getModel();
        modelo.setNumRows(0);
        for (Produto p : listaItens) {
            modelo.addRow(new Object[]{p.getNome(), p.getValorVenda()});
        }
    }

    private void limparPDV() {
        listaItens.clear();
        clienteAtual = null;
        txtNomeCliente.setText("");
        txtCpfCliente.setValue(null);
        recarregarTabelaVenda();
        lblTotal.setText("0.00");
        DefaultTableModel modelo = (DefaultTableModel) tblCarrinho.getModel();
        modelo.setNumRows(0);
    }

    private void calcularTotal() {
        double total = 0;

        for (silver.model.Produto p : listaItens) {
            total += p.getValorVenda();
        }

        lblTotal.setText(String.format("%.2f", total).replace(",", "."));
    }

}
