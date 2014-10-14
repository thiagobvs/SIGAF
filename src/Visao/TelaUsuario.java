/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Logico.EncriptaSenha;
import Logico.Usuario;
import dao.DaoUsuario;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUSTAVO
 */
public class TelaUsuario extends javax.swing.JDialog {

    /**
     * Creates new form TelaUsuario
     */
    DefaultTableModel tmUsuario = new DefaultTableModel(null, new String[]{"Nome", "Email"});
    List<Usuario> lista;
    ListSelectionModel lsmUsuario;

    public TelaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        confTela(parent);

    }

    private void confTela(java.awt.Frame parent) {
        this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTPesquisa = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTTabela = new javax.swing.JTable();
        jPFicha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTIdusuario = new javax.swing.JTextField();
        jChAtivo = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDtCadastro = new com.toedter.calendar.JDateChooser();
        jDtNascimento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jCSexo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAObservacao = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jBIncluir = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jBPrimeiro = new javax.swing.JButton();
        jBAnterior = new javax.swing.JButton();
        jBProximo = new javax.swing.JButton();
        jBUltimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPPesquisa.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/clientes.png"))); // NOI18N
        jLabel1.setText("Usuários");

        jTPesquisa.setToolTipText("Para pesquisar digite um Nome e aperte Enter");
        jTPesquisa.setPreferredSize(new java.awt.Dimension(59, 27));
        jTPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPPesquisaLayout = new javax.swing.GroupLayout(jPPesquisa);
        jPPesquisa.setLayout(jPPesquisaLayout);
        jPPesquisaLayout.setHorizontalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPPesquisaLayout.setVerticalGroup(
            jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPesquisaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTTabela.setModel(tmUsuario);
        jTTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTTabela);
        jTTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmUsuario = jTTabela.getSelectionModel();
        lsmUsuario.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    //jTTabelaMouseClicked(e);
                    tabelaLinhaSelecionada(jTTabela);
                    jTabbedPane1.setSelectedIndex(1);}}
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lista", jPanel3);

        jLabel2.setText("Código:");

        jTIdusuario.setEnabled(false);

        jChAtivo.setText("Ativo");
        jChAtivo.setEnabled(false);

        jLabel3.setText("Nome:");

        jTNome.setEnabled(false);

        jLabel4.setText("Data Cadastro:");

        jLabel5.setText("Data Nascimento:");

        jDtCadastro.setEnabled(false);

        jDtNascimento.setEnabled(false);

        jLabel6.setText("Sexo:");

        jCSexo.setEditable(true);
        jCSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jCSexo.setEnabled(false);

        jLabel7.setText("Email:");

        jTEmail.setEnabled(false);

        jLabel8.setText("Senha:");

        jPSenha.setEnabled(false);

        jLabel9.setText("Observação:");

        jTAObservacao.setColumns(20);
        jTAObservacao.setRows(5);
        jTAObservacao.setEnabled(false);
        jScrollPane3.setViewportView(jTAObservacao);

        javax.swing.GroupLayout jPFichaLayout = new javax.swing.GroupLayout(jPFicha);
        jPFicha.setLayout(jPFichaLayout);
        jPFichaLayout.setHorizontalGroup(
            jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFichaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFichaLayout.createSequentialGroup()
                        .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPFichaLayout.createSequentialGroup()
                                .addComponent(jTIdusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jChAtivo))
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPFichaLayout.createSequentialGroup()
                                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFichaLayout.createSequentialGroup()
                        .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPFichaLayout.createSequentialGroup()
                                .addComponent(jPSenha)
                                .addGap(126, 126, 126))
                            .addGroup(jPFichaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(203, 203, 203))))
                    .addGroup(jPFichaLayout.createSequentialGroup()
                        .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPFichaLayout.setVerticalGroup(
            jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFichaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTIdusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDtCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ficha", jPFicha);

        jBIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/add.png"))); // NOI18N
        jBIncluir.setText("Incluir");
        jBIncluir.setPreferredSize(new java.awt.Dimension(81, 24));
        jBIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIncluirActionPerformed(evt);
            }
        });

        jBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/edit.png"))); // NOI18N
        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/save.png"))); // NOI18N
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/cancel.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jBEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 255));

        jBPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/first.png"))); // NOI18N
        jBPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrimeiroActionPerformed(evt);
            }
        });

        jBAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/previous.png"))); // NOI18N
        jBAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnteriorActionPerformed(evt);
            }
        });

        jBProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/next.png"))); // NOI18N
        jBProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProximoActionPerformed(evt);
            }
        });

        jBUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/last.png"))); // NOI18N
        jBUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jBAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jBUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIncluirActionPerformed
        //Inclusao de novo usuario
        BotaoAcao bt = new BotaoAcao(this);
        bt.AtivaCampos();
        jTIdusuario.setEnabled(false);
        jTabbedPane1.setSelectedIndex(1);


    }//GEN-LAST:event_jBIncluirActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // Cancela ação do usuario
        BotaoAcao bt = new BotaoAcao(this);
        bt.DesativaCampos();
        bt.LimpaCampos();
        bt.setNavegacao();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        //Edita os dados do Usuario
        BotaoAcao bt = new BotaoAcao(this);
        bt.AtivaCampos();
        bt.setEdicao();
        jTIdusuario.setEnabled(false);
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        // Grava os dados do Usuario
        Usuario usuario = new Usuario();
        DaoUsuario dao = new DaoUsuario();
        BotaoAcao bt = new BotaoAcao(this);
        if (jTIdusuario.getText().equals("")) {
            usuario.setNome(jTNome.getText());
            usuario.setDtcadastro(jDtCadastro.getDate());
            usuario.setDtnascimento(jDtNascimento.getDate());
            usuario.setEmail(jTEmail.getText());
            usuario.setObservacao(jTAObservacao.getText());
            usuario.setSenha(EncriptaSenha.encripta(new String(jPSenha.getPassword())));
            usuario.setSexo((String) jCSexo.getSelectedItem());
            usuario.setEstado(true);

            try {
                dao.incluir(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Confirmação!", 1);
                bt.LimpaCampos();
                bt.setNavegacao();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar dados!", "Atenção!", 1);
                System.out.println("Gravacao de usuario " + ex);
                bt.LimpaCampos();
                bt.setNavegacao();
                Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("passou aqui");
            AlteraUsuario();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisaKeyPressed
        //PESQUISA USUARIO
      
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ListarUsuario();
        }
    }//GEN-LAST:event_jTPesquisaKeyPressed

    private void jTTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            jTabbedPane1.setSelectedIndex(1);
            tabelaLinhaSelecionada(jTTabela);
            //jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jTTabelaMouseClicked

    private void jBPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrimeiroActionPerformed
        // TODO add your handling code here:
          selecionarLinhaTabela(0);
          
    }//GEN-LAST:event_jBPrimeiroActionPerformed

    private void jBUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUltimoActionPerformed
        // TODO add your handling code here:
        int quantLinha = jTTabela.getRowCount();
        selecionarLinhaTabela(quantLinha-1);
        
    }//GEN-LAST:event_jBUltimoActionPerformed

    private void jBAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnteriorActionPerformed
        // TODO add your handling code here:
        int quantLinha = jTTabela.getSelectedRow();
        selecionarLinhaTabela(quantLinha-1);
    }//GEN-LAST:event_jBAnteriorActionPerformed

    private void jBProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProximoActionPerformed
        // TODO add your handling code here:
        int quantLinha = jTTabela.getSelectedRow();
        selecionarLinhaTabela(quantLinha+1);
    }//GEN-LAST:event_jBProximoActionPerformed

    
     private void selecionarLinhaTabela(int posicao) {
        int quantidadeLinhas = this.jTTabela.getRowCount();
        if ((posicao >= 0) && (posicao < quantidadeLinhas)) {
           this.jTTabela.requestFocus();
           this.jTTabela.clearSelection();
            this.jTTabela.addRowSelectionInterval(posicao, posicao);
        }
     }
    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaUsuario dialog = new TelaUsuario(new javax.swing.JFrame(), true);
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

    public void AlteraUsuario() {
        Usuario usuario = new Usuario();
        BotaoAcao bt = new BotaoAcao(this);
       if(jTTabela.getSelectedRow()!= -1){
        usuario.setNome(jTNome.getText());
        usuario.setDtcadastro(jDtCadastro.getDate());
        usuario.setDtnascimento(jDtNascimento.getDate());
        usuario.setEmail(jTEmail.getText());
        usuario.setObservacao(jTAObservacao.getText());
        usuario.setSenha(EncriptaSenha.encripta(new String(jPSenha.getPassword())));     
        usuario.setSexo((String) jCSexo.getSelectedItem());
        if (jChAtivo.isSelected()) {
            usuario.setEstado(true);
        } else {
            usuario.setEstado(false);
        }
        
        try {
            DaoUsuario dao = new DaoUsuario();
            dao.editar(usuario);
            JOptionPane.showMessageDialog(null, "Registro editado com sucesso!", "Confirmação!", 1);
            bt.LimpaCampos();
            bt.setNavegacao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados!", "Atenção!", 0);
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            bt.LimpaCampos();
            bt.setEdicao();
            bt.setNavegacao();

        }
       }

    }

    public void ListarUsuario() {
        DaoUsuario dao = new DaoUsuario();
        Usuario usuario = new Usuario();

        String pesquisa = "%" + jTPesquisa.getText() + "%";
        usuario.setNome(pesquisa);
        try {
            lista = dao.pesquisar(usuario);
            MostraPesquisa(lista);
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void MostraPesquisa(List<Usuario> usuario) {
        while (tmUsuario.getRowCount() > 0) {
            tmUsuario.removeRow(0);
        }
        if (!usuario.isEmpty()) {
            String[] linha = new String[]{null, null};
            for (int i = 0; i < usuario.size(); i++) {
                tmUsuario.addRow(linha);
                tmUsuario.setValueAt(usuario.get(i).getNome(), i, 0);
                tmUsuario.setValueAt(usuario.get(i).getEmail(), i, 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Atenção!", 0);
        }

    }

    public void tabelaLinhaSelecionada(JTable tabela) {
        BotaoAcao bt = new BotaoAcao(this);
        if (jTTabela.getSelectedRow() != -1) {
            jTIdusuario.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getIdusuario()));
            jTNome.setText(lista.get(tabela.getSelectedRow()).getNome());
            jTEmail.setText(lista.get(tabela.getSelectedRow()).getEmail());
            jTAObservacao.setText(lista.get(tabela.getSelectedRow()).getObservacao());
            jPSenha.setText(lista.get(tabela.getSelectedRow()).getSenha());
            jCSexo.setSelectedItem(lista.get(tabela.getSelectedRow()).getSexo());
            jChAtivo.setSelected(lista.get(tabela.getSelectedRow()).isEstado());
            jDtCadastro.setDate(lista.get(tabela.getSelectedRow()).getDtcadastro());
            jDtNascimento.setDate(lista.get(tabela.getSelectedRow()).getDtnascimento());

            bt.setNavegacao();
        } else {
            bt.LimpaCampos();
        }

    }

    public javax.swing.JButton getjBCancelar() {
        return jBCancelar;
    }

    public javax.swing.JButton getjBEditar() {
        return jBEditar;
    }

    public javax.swing.JButton getjBIncluir() {
        return jBIncluir;
    }

    public javax.swing.JButton getjBSalvar() {
        return jBSalvar;
    }

    public javax.swing.JButton getjBPrimeiro() {
        return jBPrimeiro;
    }

    public javax.swing.JButton getjBProximo() {
        return jBProximo;
    }

    public javax.swing.JButton getjBUltimo() {
        return jBUltimo;
    }

    public javax.swing.JButton getjBAnterior() {
        return jBAnterior;
    }

    public javax.swing.JComboBox getjCSexo() {
        return jCSexo;
    }

    public javax.swing.JCheckBox getjChAtivo() {
        return jChAtivo;
    }

    public com.toedter.calendar.JDateChooser getjDtCadastro() {
        return jDtCadastro;
    }

    public com.toedter.calendar.JDateChooser getjDtNascimento() {
        return jDtNascimento;
    }

    public javax.swing.JTextField getjTEmail() {
        return jTEmail;
    }

    public javax.swing.JTextField getjTIdusuario() {
        return jTIdusuario;
    }

    public javax.swing.JTextField getjTNome() {
        return jTNome;
    }

    public javax.swing.JTextArea getjTAObservacao() {
        return jTAObservacao;
    }

    public javax.swing.JPanel getjPFicha() {
        return jPFicha;
    }

    public javax.swing.JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public javax.swing.JTable getjTTabela() {
        return jTTabela;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAnterior;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBIncluir;
    private javax.swing.JButton jBPrimeiro;
    private javax.swing.JButton jBProximo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBUltimo;
    private javax.swing.JComboBox jCSexo;
    private javax.swing.JCheckBox jChAtivo;
    private com.toedter.calendar.JDateChooser jDtCadastro;
    private com.toedter.calendar.JDateChooser jDtNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPFicha;
    private javax.swing.JPanel jPPesquisa;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTAObservacao;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTIdusuario;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisa;
    private javax.swing.JTable jTTabela;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
