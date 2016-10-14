/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.view;

import adotego.controller.EspecieController;
import adotego.controller.UsuarioController;
import adotego.modelos.Animal;
import adotego.modelos.Endereco;
import adotego.modelos.Especie;
import adotego.modelos.Porte_enum;
import adotego.modelos.Raca;
import adotego.modelos.Situacao_enum;
import adotego.modelos.Tabela_animais;
import adotego.modelos.Tabela_usuario_completa;
import adotego.modelos.Usuario;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmichelini
 */
public class PrincipalUI extends javax.swing.JFrame {
    
    private Tabela_usuario_completa model_tabela_usuarios_completa;
    private Tabela_animais model_tabela_animais;
    
    /**
     * Creates new form PrincipalUI
     */
    public PrincipalUI() {
        try {
            
            initComponents();
            init_jCombo_box_especie_pesquisa();
            init_jCombo_box_raca_pesquisa();
            iniciar_tabelas();
            
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        btn_excluir_usuario = new javax.swing.JButton();
        btn_editar_usuario = new javax.swing.JButton();
        txt_pesquisar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCombo_box_opcoes_busca = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_animais = new javax.swing.JTable();
        btn_editar_animal = new javax.swing.JButton();
        btn_excluir_animal = new javax.swing.JButton();
        btn_filtrar_animais = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jCombo_box_especie_pesquisa = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jCombo_box_raca_pesquisa = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jComboBox_situacao_pesquisa = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_nova_especie = new javax.swing.JMenu();
        jMenuItem_nova_raca = new javax.swing.JMenuItem();
        jMenuItem_nova_especie = new javax.swing.JMenuItem();
        btn_novo_usuario = new javax.swing.JMenuItem();
        jMenuItem_novo_animal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Controle FInanceiro", jPanel2);

        jInternalFrame3.setVisible(true);

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_usuarios);

        btn_excluir_usuario.setText("Excluir");
        btn_excluir_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_usuarioActionPerformed(evt);
            }
        });

        btn_editar_usuario.setText("Editar");
        btn_editar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_usuarioActionPerformed(evt);
            }
        });

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Pesquisar por ");

        jCombo_box_opcoes_busca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Email" }));

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(btn_editar_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir_usuario))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCombo_box_opcoes_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCombo_box_opcoes_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluir_usuario)
                    .addComponent(btn_editar_usuario))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel1);

        jInternalFrame1.setVisible(true);

        jTable_animais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable_animais);

        btn_editar_animal.setText("Editar");
        btn_editar_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_animalActionPerformed(evt);
            }
        });

        btn_excluir_animal.setText("Excluir");
        btn_excluir_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_animalActionPerformed(evt);
            }
        });

        btn_filtrar_animais.setText("Filtrar");
        btn_filtrar_animais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrar_animaisActionPerformed(evt);
            }
        });

        jLabel25.setText("Pesquisar");

        jCombo_box_especie_pesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCombo_box_especie_pesquisaItemStateChanged(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel26.setText("Especie");

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel27.setText("Raça");

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel28.setText("Situação");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(btn_excluir_animal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar_animal))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCombo_box_especie_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel26)))
                            .addGap(18, 18, 18)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCombo_box_raca_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jLabel27)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jComboBox_situacao_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(btn_filtrar_animais, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jCombo_box_especie_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombo_box_raca_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtrar_animais)
                    .addComponent(jComboBox_situacao_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar_animal)
                    .addComponent(btn_excluir_animal))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Animais", jPanel3);

        jMenu_nova_especie.setText("Arquivo");

        jMenuItem_nova_raca.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem_nova_raca.setText("Nova Raça");
        jMenuItem_nova_raca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nova_racaActionPerformed(evt);
            }
        });
        jMenu_nova_especie.add(jMenuItem_nova_raca);

        jMenuItem_nova_especie.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem_nova_especie.setText("Nova Especie");
        jMenuItem_nova_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nova_especieActionPerformed(evt);
            }
        });
        jMenu_nova_especie.add(jMenuItem_nova_especie);

        btn_novo_usuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_novo_usuario.setText("Novo Usuario");
        btn_novo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novo_usuarioActionPerformed(evt);
            }
        });
        jMenu_nova_especie.add(btn_novo_usuario);

        jMenuItem_novo_animal.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jMenuItem_novo_animal.setText("Novo Animal");
        jMenuItem_novo_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_novo_animalActionPerformed(evt);
            }
        });
        jMenu_nova_especie.add(jMenuItem_novo_animal);

        jMenuBar1.add(jMenu_nova_especie);

        jMenu2.setText("Pesquisar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciar_tabelas(){
         model_tabela_usuarios_completa = new Tabela_usuario_completa();
        try {
            model_tabela_animais = new Tabela_animais();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTable_usuarios.setModel(model_tabela_usuarios_completa);
        jTable_animais.setModel(model_tabela_animais);
    }
    
    private void jMenuItem_nova_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nova_especieActionPerformed
        new Nova_especie().setVisible(true);
    }//GEN-LAST:event_jMenuItem_nova_especieActionPerformed
   
    private void jMenuItem_nova_racaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nova_racaActionPerformed
        new Nova_raca().setVisible(true);
    }//GEN-LAST:event_jMenuItem_nova_racaActionPerformed

    private void btn_novo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novo_usuarioActionPerformed
        new Detalhe_usuario().setVisible(true);
    }//GEN-LAST:event_btn_novo_usuarioActionPerformed

    private void jCombo_box_especie_pesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCombo_box_especie_pesquisaItemStateChanged

        try {
            if(jCombo_box_especie_pesquisa.getSelectedIndex() != 0){
                String especie_name_selected =  String.valueOf(jCombo_box_especie_pesquisa
                    .getSelectedItem());

                List<Raca> lista_raca = new adotego.controller.RacaController()
                .findRacaByEspecieName(especie_name_selected);
                refresh_JCombo_box_raca_pesquisa(lista_raca);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCombo_box_especie_pesquisaItemStateChanged

    private void btn_filtrar_animaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrar_animaisActionPerformed
        int indexSelecionado = jCombo_box_especie_pesquisa.getSelectedIndex();
        try {
            if(indexSelecionado > 0){

                String especie_name_selected =  String.valueOf(jCombo_box_especie_pesquisa
                    .getSelectedItem());

                List<Animal> animais_lista = new adotego.controller.AnimalController()
                .findByEspecieName(especie_name_selected);

                if(jCombo_box_raca_pesquisa.getSelectedIndex()>0){
                    String raca = String.valueOf(jCombo_box_raca_pesquisa.getSelectedItem());
                    //remover os animais que possuir raca diferente da selecionada
                    Iterator<Animal> iterator = animais_lista.iterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        if(!animal.getRaca().getNome().equalsIgnoreCase(raca)){
                            iterator.remove();
                        }
                    }
                }

                model_tabela_animais.atualizar_tabela(animais_lista);

            }else if(indexSelecionado == 0){
                model_tabela_animais.atualizar_tabela();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_filtrar_animaisActionPerformed

    private void btn_excluir_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_animalActionPerformed
        try {
            int id = model_tabela_animais.getIdIntoTheRow(jTable_animais);

            new adotego.controller.AnimalController().delete(id);
            model_tabela_animais.atualizar_tabela();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_excluir_animalActionPerformed

    private void btn_editar_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_animalActionPerformed

        int id_animal_selected =  model_tabela_animais.getSelectedIndex(jTable_animais);
        Animal animal = model_tabela_animais.getAnimalByIndex(id_animal_selected);
        new Detalhe_animal().build(animal);

    }//GEN-LAST:event_btn_editar_animalActionPerformed

    private void btn_editar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_usuarioActionPerformed
        int id_select = model_tabela_usuarios_completa.getIdIntoTheRow(jTable_usuarios);

        Usuario u = new adotego.controller.UsuarioController().find(id_select);
        new Detalhe_usuario().build(u);
    }//GEN-LAST:event_btn_editar_usuarioActionPerformed

    private void btn_excluir_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_usuarioActionPerformed
        int id_selected = model_tabela_usuarios_completa.getIdIntoTheRow(jTable_usuarios);

        new UsuarioController().delete(id_selected);
        model_tabela_usuarios_completa.atualizarTabela();
    }//GEN-LAST:event_btn_excluir_usuarioActionPerformed

    private void jTable_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_usuariosMouseClicked
        if(evt.getClickCount() ==2){
            int id_clicado = model_tabela_usuarios_completa.getIdIntoTheRow(jTable_usuarios);
            Usuario usuario = new adotego.controller
            .UsuarioController().find(id_clicado);

            new Detalhe_usuario().build(usuario);
        }
    }//GEN-LAST:event_jTable_usuariosMouseClicked

    private void txt_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyPressed
        
        String parametro = String.valueOf(jCombo_box_opcoes_busca.getSelectedItem())
                                            .toLowerCase()
                                                .trim();
        
        String str_pesquisa = txt_pesquisar.getText().trim();
        
        if(str_pesquisa.isEmpty()) 
            model_tabela_usuarios_completa.atualizarTabela();
        else{        
            switch(parametro){
                case "nome": model_tabela_usuarios_completa
                                    .setList(new UsuarioController()
                                        .findLikeName(str_pesquisa));
                                        break;
                case "cpf" :model_tabela_usuarios_completa
                                    .setList(new UsuarioController()
                                        .findLikeCpf(str_pesquisa));
                                        break;
                case "email": model_tabela_usuarios_completa
                                    .setList(new UsuarioController()
                                        .findLikeEmail(str_pesquisa));
                                        break;
                
                default: model_tabela_usuarios_completa.atualizarTabela();
            }
        }
       
    }//GEN-LAST:event_txt_pesquisarKeyPressed

    private void jMenuItem_novo_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_novo_animalActionPerformed
        new Detalhe_animal().setVisible(true);
    }//GEN-LAST:event_jMenuItem_novo_animalActionPerformed
   
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
            java.util.logging.Logger.getLogger(PrincipalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar_animal;
    private javax.swing.JButton btn_editar_usuario;
    private javax.swing.JButton btn_excluir_animal;
    private javax.swing.JButton btn_excluir_usuario;
    private javax.swing.JButton btn_filtrar_animais;
    private javax.swing.JMenuItem btn_novo_usuario;
    private javax.swing.JComboBox<String> jComboBox_situacao_pesquisa;
    private javax.swing.JComboBox<String> jCombo_box_especie_pesquisa;
    private javax.swing.JComboBox<String> jCombo_box_opcoes_busca;
    private javax.swing.JComboBox<String> jCombo_box_raca_pesquisa;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_nova_especie;
    private javax.swing.JMenuItem jMenuItem_nova_raca;
    private javax.swing.JMenuItem jMenuItem_novo_animal;
    private javax.swing.JMenu jMenu_nova_especie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_animais;
    private javax.swing.JTable jTable_usuarios;
    private javax.swing.JTextField txt_pesquisar;
    // End of variables declaration//GEN-END:variables

    private void init_jCombo_box_especie_pesquisa() throws SQLException {
        List<Especie> especies = new adotego.controller.EspecieController().findAll();
        jCombo_box_especie_pesquisa.addItem("Tudo");
        for (Especie especie : especies) {
            jCombo_box_especie_pesquisa.addItem(especie.getNome());
        }
    }

    private void refresh_JCombo_box_raca_pesquisa(List<Raca> lista){
       jCombo_box_raca_pesquisa.removeAllItems();
       jCombo_box_raca_pesquisa.addItem("Tudo");
        for (Raca raca : lista) {
            
            jCombo_box_raca_pesquisa.addItem(raca.getNome());
        }
    }

    private void init_jCombo_box_raca_pesquisa() {
        jCombo_box_raca_pesquisa.addItem("Tudo");
    }

    
    
   

  

    

    
    
}
