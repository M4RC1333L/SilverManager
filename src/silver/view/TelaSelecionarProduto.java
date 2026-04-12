package silver.view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import silver.model.Produto;


public class TelaSelecionarProduto extends javax.swing.JDialog {

    private TelaPDV telaPdvOrigem;
    private List<Produto> listaProdutos;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaSelecionarProduto.class.getName());

    
    public TelaSelecionarProduto(java.awt.Frame parent, boolean modal, TelaPDV pdv, List<Produto> produtos) {
    super(parent, modal);
    initComponents();
    this.telaPdvOrigem = pdv;
    this.listaProdutos = produtos;
    
    preencherTabela();
}

    private TelaSelecionarProduto(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutosSelecao = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Produtos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Selecione o produto");

        tblProdutosSelecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço de Venda", "Estoque", "Código Barras"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutosSelecao);

        btnAdicionar.setBackground(new java.awt.Color(102, 102, 102));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setText("Add ao Carrinho");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        
    int linha = tblProdutosSelecao.getSelectedRow(); 

    if (linha != -1) {
       
        silver.model.Produto selecionado = listaProdutos.get(linha);

        this.telaPdvOrigem.adicionarProdutoAoCarrinho(selecionado);
        
        
        this.dispose(); 
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione um produto na tabela!");
    }

    }//GEN-LAST:event_btnAdicionarActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaSelecionarProduto dialog = new TelaSelecionarProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutosSelecao;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
    DefaultTableModel modelo = (DefaultTableModel) tblProdutosSelecao.getModel();
    modelo.setNumRows(0); 

    try {
        com.silvermanager.dao.ProdutoDAO dao = new com.silvermanager.dao.ProdutoDAO();
        
        List<silver.model.Produto> listaDoBanco = dao.listarTodos(); 

        if (listaDoBanco != null) {
            
            this.listaProdutos = listaDoBanco; 

            for (silver.model.Produto p : listaDoBanco) {
                
                modelo.addRow(new Object[]{
                    p.getNome(),             // Nome
                    p.getValorVenda(),       // Preço
                    p.getQuantidadeEstoque(),// Estoque 
                    p.getCodigoBarra()       // Código 
                });
            }
        }
    } catch (Exception e) {
        System.err.println("Erro ao carregar tabela: " + e.getMessage());
    }
}
}
