/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.view;

import adotego.modelos.Adocao;
import adotego.modelos.Animal;
import adotego.modelos.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tmichelini
 */
public class Nova_Adocao extends javax.swing.JFrame {

    private static Usuario usuario;
    private static Animal animal;
    private static Modelo_tabela_animal_adocao modelo_animal_adocao;
    private static Modelo_tabela_usuario_adocao modelo_usuario_adocao;
   
    /**
     * Creates new form Nova_Adocao
     */
    public Nova_Adocao() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo_animal_adocao = new Modelo_tabela_animal_adocao();
        modelo_usuario_adocao = new Modelo_tabela_usuario_adocao();
        jTable_animal_adocao.setModel(modelo_animal_adocao);
        jTable_usuario_adocao.setModel(modelo_usuario_adocao);
        usuario = new Usuario();
        animal = new Animal();
        
        
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_selecionar_usuario = new javax.swing.JButton();
        btn_gerar_adocao = new javax.swing.JButton();
        btn_selecionar_animal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_animal_adocao = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_usuario_adocao = new javax.swing.JTable();
        txt_doacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerar Adoção");

        jPanel1.setBackground(new java.awt.Color(241, 243, 244));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nova Adoção");

        btn_selecionar_usuario.setText("Selecionar Usuario");
        btn_selecionar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionar_usuarioActionPerformed(evt);
            }
        });

        btn_gerar_adocao.setText("Gerar");
        btn_gerar_adocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerar_adocaoActionPerformed(evt);
            }
        });

        btn_selecionar_animal.setText("Selecionar Animal");
        btn_selecionar_animal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecionar_animalActionPerformed(evt);
            }
        });

        jTable_animal_adocao.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_animal_adocao);

        jTable_usuario_adocao.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_usuario_adocao);

        jLabel1.setText("Doação R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_gerar_adocao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_doacao, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_selecionar_usuario)
                    .addComponent(btn_selecionar_animal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_selecionar_usuario))
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_selecionar_animal))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_doacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_gerar_adocao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selecionar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionar_usuarioActionPerformed
        new Lista_usuarios().setVisible(true);
        
    }//GEN-LAST:event_btn_selecionar_usuarioActionPerformed

    private void btn_gerar_adocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerar_adocaoActionPerformed
        Adocao adocao = new Adocao();
            adocao.setAnimal(this.animal);
            adocao.setUsuario(this.usuario);
            adocao.setData(Calendar.getInstance());
           new adotego.controller.AdocaoController().salvar(adocao);
           this.dispose();
    }//GEN-LAST:event_btn_gerar_adocaoActionPerformed

    private void btn_selecionar_animalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecionar_animalActionPerformed
        new Lista_animal().setVisible(true);
    }//GEN-LAST:event_btn_selecionar_animalActionPerformed

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
            java.util.logging.Logger.getLogger(Nova_Adocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nova_Adocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nova_Adocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nova_Adocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nova_Adocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gerar_adocao;
    private javax.swing.JButton btn_selecionar_animal;
    private javax.swing.JButton btn_selecionar_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_animal_adocao;
    private javax.swing.JTable jTable_usuario_adocao;
    private javax.swing.JTextField txt_doacao;
    // End of variables declaration//GEN-END:variables

    public static void setUsuario(Usuario u){
        Nova_Adocao.usuario = u;
        modelo_usuario_adocao.inserirUsuario(usuario); 
    }
    public static void setAnimal(Animal a){
        Nova_Adocao.animal = a;
        modelo_animal_adocao.inserirAnimal(animal);
    }        
}

class Modelo_tabela_animal_adocao extends AbstractTableModel{
    List<Animal> animais;
    String [] colunas = new String[]{"Código", "Nome"};

    public Modelo_tabela_animal_adocao() {
        animais = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return animais.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal a = animais.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getId();
            case 1: return a.getNome();
            default: return "--";
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
    
    public void removeAll(){
        this.animais = new ArrayList<>();
        this.fireTableDataChanged();
    }
    public void inserirAnimal(Animal animal){
        if(animais.isEmpty()){
            animais.add(animal);
            this.fireTableDataChanged();
        }else{
            this.removeAll();
            animais.add(animal);
            this.fireTableDataChanged();
        }
    }
    
}


class Modelo_tabela_usuario_adocao extends AbstractTableModel{
    List<Usuario> usuarios;
    String [] colunas = new String[]{"Código", "Nome"};

    public Modelo_tabela_usuario_adocao() {
        usuarios = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario a = usuarios.get(rowIndex);
        switch(columnIndex){
            case 0: return a.getId();
            case 1: return a.getNome();
            default: return "--";
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
    
    public void inserirUsuario(Usuario usuario){
        if(usuarios.isEmpty()){
            usuarios.add(usuario);
            this.fireTableDataChanged();
        }else{
            this.removeAll();
            usuarios.add(usuario);
            this.fireTableDataChanged();
        }    
    }
        

   public void removeAll(){
       usuarios  = new ArrayList<>();
       this.fireTableDataChanged();
   }
    
}