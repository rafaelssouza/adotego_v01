
package adotego.view;

import adotego.controller.AnimalController;
import adotego.controller.EspecieController;
import adotego.controller.RacaController;
import adotego.modelos.Animal;
import adotego.modelos.Especie;
import adotego.modelos.Porte_enum;
import adotego.modelos.Raca;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tmichelini
 */
public class Detalhe_animal extends javax.swing.JFrame {

    Tabela_Animais model_animais;
    private Animal animal;
    /**
     * Creates new form Detalhe_animal
     */
    public Detalhe_animal() {
        try {
            initComponents();
            model_animais = new Tabela_Animais();
            jTable_animal.setModel(model_animais);
            initJComboBox_especie();
            initJComboPorte();
            animal = new Animal();
            animal.setId(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        label_configuracoes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nome_animal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_animal = new javax.swing.JTable();
        btn_add_animal = new javax.swing.JButton();
        jComboBox_especie = new javax.swing.JComboBox<>();
        jComboBox_raca = new javax.swing.JComboBox<>();
        jComboBox_porte = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        btn_salvar_animal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(245, 245, 255));
        jInternalFrame1.setVisible(true);

        label_configuracoes.setFont(new java.awt.Font("Waree", 0, 18)); // NOI18N
        label_configuracoes.setText("Configurações de animal");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Especie");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Raça");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Porte");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descrição");

        txt_nome_animal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_nome_animal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nome_animalFocusLost(evt);
            }
        });

        txt_descricao.setColumns(20);
        txt_descricao.setRows(5);
        txt_descricao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_descricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_descricaoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txt_descricao);

        jTable_animal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_animal);

        btn_add_animal.setBackground(new java.awt.Color(255, 255, 255));
        btn_add_animal.setIcon(new javax.swing.ImageIcon("/home/tmichelini/NetBeansProjects/adotego/src/icones/left-arrow.png")); // NOI18N
        btn_add_animal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        btn_add_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_animalActionPerformed(evt);
            }
        });

        jComboBox_especie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_especieItemStateChanged(evt);
            }
        });
        jComboBox_especie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_especieFocusLost(evt);
            }
        });

        jComboBox_raca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_racaFocusLost(evt);
            }
        });

        jComboBox_porte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_porteFocusLost(evt);
            }
        });

        jToolBar1.setRollover(true);

        btn_salvar_animal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_salvar_animal.setIcon(new javax.swing.ImageIcon("/home/tmichelini/NetBeansProjects/adotego/src/icones/plus.png")); // NOI18N
        btn_salvar_animal.setText("Salvar");
        btn_salvar_animal.setFocusable(false);
        btn_salvar_animal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_salvar_animal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_salvar_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvar_animalActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_salvar_animal);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("/home/tmichelini/NetBeansProjects/adotego/src/icones/cross.png")); // NOI18N
        jButton1.setText("Excluir");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon("/home/tmichelini/NetBeansProjects/adotego/src/icones/cross.png")); // NOI18N
        jButton2.setToolTipText("Excluir");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                                .addGap(139, 139, 139))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_porte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_raca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox_especie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_nome_animal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_add_animal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(label_configuracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label_configuracoes)
                .addGap(46, 46, 46)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_nome_animal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox_raca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_add_animal, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jComboBox_porte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_animalActionPerformed
        int id_seleted = model_animais.getIdIntoTheRow(jTable_animal);
        Animal animal_selected = null;
        try {
             animal_selected = new AnimalController().find(id_seleted);
             preencherCampos(animal_selected);
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btn_add_animalActionPerformed

    private void btn_salvar_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvar_animalActionPerformed
        try {
           if(animal.getId() == 0){
               animal.setData_entrada(Calendar.getInstance());
                new adotego.controller.AnimalController().save(animal);
                resetCampos();
                model_animais.atualizarTabela();
           }else{
               //fazer update
           }
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_salvar_animalActionPerformed

    private void txt_nome_animalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nome_animalFocusLost
        animal.setNome(txt_nome_animal.getText());
    }//GEN-LAST:event_txt_nome_animalFocusLost

    private void jComboBox_racaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_racaFocusLost
        try {
            Raca raca = new RacaController().getByName(String.valueOf(jComboBox_raca.getSelectedItem()));
            animal.setRaca(raca);
            
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboBox_racaFocusLost

    private void jComboBox_porteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_porteFocusLost
        Porte_enum[] portes = Porte_enum.values();
        for (Porte_enum porte : portes) {
            if(String.valueOf(porte)
                    .equals(String.valueOf(jComboBox_porte.getSelectedItem()))){
                animal.setPorte(porte);
            }
        }
    }//GEN-LAST:event_jComboBox_porteFocusLost

    private void txt_descricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descricaoFocusLost
        animal.setDescricao(txt_descricao.getText());
    }//GEN-LAST:event_txt_descricaoFocusLost

    private void jComboBox_especieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_especieFocusLost
         try {
            String especie_selected = String.valueOf(jComboBox_especie.getSelectedItem());
            Especie especie = new EspecieController().getByName(especie_selected);
            
            animal.setEspecie(especie);
            
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox_especieFocusLost

    private void jComboBox_especieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_especieItemStateChanged
        try {
            String especie_selected = String.valueOf(jComboBox_especie.getSelectedItem());
            List<Raca> lista_raca = new RacaController().findRacaByEspecieName(especie_selected);
            initJComboBox_raca(lista_raca);
        } catch (SQLException ex) {
            Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox_especieItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(animal.getId() == 0){
            
        }else{
            try {
                new AnimalController().delete(animal.getId());
                model_animais.atualizarTabela();
                resetCampos();
            } catch (SQLException ex) {
                Logger.getLogger(Detalhe_animal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Detalhe_animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalhe_animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalhe_animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalhe_animal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalhe_animal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_animal;
    private javax.swing.JButton btn_salvar_animal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox_especie;
    private javax.swing.JComboBox<String> jComboBox_porte;
    private javax.swing.JComboBox<String> jComboBox_raca;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_animal;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel label_configuracoes;
    private javax.swing.JTextArea txt_descricao;
    private javax.swing.JTextField txt_nome_animal;
    // End of variables declaration//GEN-END:variables

   
    
    private void initJComboBox_especie() throws SQLException{
        List<Especie> especies = new EspecieController().findAll();        
        jComboBox_especie.removeAllItems();
        for (Especie especie : especies) {
            jComboBox_especie.addItem(especie.getNome());
        }
        
    }

    private void initJComboBox_raca(List<Raca> lista_raca) {
        jComboBox_raca.removeAllItems();
        for (Raca raca : lista_raca) {
            jComboBox_raca.addItem(raca.getNome());
        }
       
    }

    private void initJComboPorte() {
        Porte_enum[] portes = Porte_enum.values();
        for (Porte_enum porte : portes) {
            jComboBox_porte.addItem(String.valueOf(porte));
        }
    }

    private Porte_enum getPorte(String porte_str) {
        String porte = porte_str.toLowerCase();
        switch(porte){
            case "pequeno": return Porte_enum.PEQUENO;
            case "medio": return Porte_enum.MEDIO;
            case "grande": return Porte_enum.GRANDE;
            default: return Porte_enum.MEDIO;
        }
    }

    private void preencherCampos(Animal animal) {
        this.animal = animal;
        txt_nome_animal.setText(animal.getNome());
        txt_descricao.setText(animal.getDescricao());
        jComboBox_porte.setSelectedItem(String.valueOf(animal.getPorte()));
        jComboBox_especie.setSelectedItem(animal.getEspecie().getNome());
        jComboBox_raca.setSelectedItem(animal.getRaca().getNome());
        
    }

    private void resetCampos() {
        txt_nome_animal.setText("");
        jComboBox_especie.setSelectedIndex(0);
        jComboBox_porte.setSelectedIndex(0);
        jComboBox_raca.setSelectedIndex(0);
        txt_descricao.setText("");
        this.animal = new Animal();
        this.animal.setId(0);
    }
    
    public void build(Animal a){
        this.animal = a;
        preencherCampos(animal);
        this.setVisible(true);
    }
   
}

class Tabela_Animais extends AbstractTableModel{
    private List<Animal> lista_animais;
    private String [] colunas = new String[]{"Código", "Nome", "Situação"};

    public Tabela_Animais() throws SQLException {
        lista_animais = new AnimalController().findAll();
    }
            
    @Override
    public int getRowCount() {
        return lista_animais.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = lista_animais.get(rowIndex);
        
        switch(columnIndex){
            case 0: return animal.getId();
            case 1: return animal.getNome();
            case 2: return animal.getSituacao();
            default:return "Não foi possível identificar a colunas";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public int getIdIntoTheRow(JTable table){
        int row =table.getSelectedRow();
        String val = String.valueOf(table.getValueAt(row, 0));
        return Integer.parseInt(val);
    }

    void atualizarTabela() {
        try {
            lista_animais = new AnimalController().findAll();
            this.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(Tabela_Animais.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}