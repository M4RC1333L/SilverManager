/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package silver.view;

import com.silvermanager.dao.ClienteDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import silver.model.Cliente;

public class TelaSelecionarCliente extends javax.swing.JFrame {

    private ArrayList<Cliente> listaParaBusca;
    private TelaPDV telaPdvOrigem;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaSelecionarCliente.class.getName());

    public TelaSelecionarCliente(TelaPDV origem, ArrayList<Cliente> listaRecebida) {
        initComponents();
        this.telaPdvOrigem = origem;
        this.listaParaBusca = listaRecebida;

        configurarBusca();

        recarregarTabela();
        atualizarTabela();
    }

    private void recarregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientesSelecao.getModel();
        modelo.setNumRows(0);
        for (Cliente c : listaParaBusca) {
            modelo.addRow(new Object[]{c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientesSelecao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrados");

        tblClientesSelecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Telefone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientesSelecao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesSelecaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientesSelecao);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Clientes Cadastrados");

        btnConfirmar.setBackground(new java.awt.Color(102, 102, 102));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar Seleção");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(138, 138, 138))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnConfirmar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        int linha = tblClientesSelecao.getSelectedRow();

        if (linha != -1) {
            // 1. Pega o cliente da lista correta
            Cliente clienteEscolhido = listaParaBusca.get(linha);

            // 2. Entrega para a tela de origem (PDV)
            if (this.telaPdvOrigem != null) {
                this.telaPdvOrigem.setClienteSelecionado(clienteEscolhido);
                this.dispose(); // Fecha a busca e volta pro PDV
            } else {
                System.out.println("Erro: A tela de origem está nula!");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela!");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        filtrarClientes(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblClientesSelecaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesSelecaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblClientesSelecaoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientesSelecao;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientesSelecao.getModel();

        // FORÇA A TABELA A TER 4 COLUNAS AGORA
        modelo.setColumnCount(0); // Limpa as colunas antigas
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("E-mail");

        modelo.setNumRows(0); // Limpa as linhas

        for (Cliente c : listaParaBusca) {
            // Garantindo que estamos pegando os dados certos
            Object[] linha = {
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getEmail()
            };
            modelo.addRow(linha);
        }
    }

    private void filtrarClientes(String textoBusca) {

    String busca = textoBusca.toLowerCase().trim();

    if (busca.isEmpty()) {
        recarregarTabela();
        return;
    }

    DefaultTableModel modelo = (DefaultTableModel) tblClientesSelecao.getModel();
    modelo.setNumRows(0);

    for (Cliente c : listaParaBusca) {

        String nome = c.getNome().toLowerCase();
        String cpf = c.getCpf().toLowerCase();
        String telefone = c.getTelefone().toLowerCase();
        String email = c.getEmail().toLowerCase();

        if (nome.contains(busca)
                || cpf.contains(busca)
                || telefone.contains(busca)
                || email.contains(busca)) {

            modelo.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getEmail()
            });
        }
    }

        }
    
    

    private void configurarBusca() {
        txtBuscar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        filtrarClientes(txtBuscar.getText());
    }

    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        filtrarClientes(txtBuscar.getText());
    }

    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        filtrarClientes(txtBuscar.getText());
    }

        });
    }
    private void atualizarTabela() {

    DefaultTableModel modelo =
        (DefaultTableModel) tblClientesSelecao.getModel();

    modelo.setRowCount(0);

    try {

        ClienteDAO dao = new ClienteDAO();

        listaParaBusca = (ArrayList<Cliente>) dao.listarTodos();

        for (Cliente c : listaParaBusca) {

            modelo.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getEmail()
            });

        }

    } catch (Exception e) {

        System.out.println(
            "Erro ao atualizar tabela: "
            + e.getMessage()
        );

    }
    
    }
}
