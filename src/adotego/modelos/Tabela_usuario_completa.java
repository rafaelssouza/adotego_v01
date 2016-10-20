/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.modelos;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tmichelini
 */
public class Tabela_usuario_completa extends AbstractTableModel{

    private List<Usuario> lista_usuarios;
    private String [] colunas = new String[]{"Código","Nome","Emai","CPF", "Telefone-Fixo", "Telefone-celular","Data Nascimento"};

    public Tabela_usuario_completa() {
        lista_usuarios = new adotego.controller.UsuarioController().findAll();
    
    }        
    
    @Override
    public int getRowCount() {
        return lista_usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Usuario u = lista_usuarios.get(rowIndex);
        
        String telefone_formatado = formatar_telefone(u.getTelefone_fixo());
        System.out.println(telefone_formatado);
       switch(columnIndex){
           case 0: return u.getId();
           case 1: return u.getNome();
           case 2: return u.getEmail();
           case 3: return u.getCpf();
           case 4: return u.getTelefone_fixo();
           case 5: return u.getTelefone_celular();
           case 6: return  sdf.format(u.getData_nascimento().getTime().getTime());
           default: return "Erro ao identificar colunas";
       }
    }
    public int getIdIntoTheRow(JTable table){
        int row =table.getSelectedRow();
        String val = String.valueOf(table.getValueAt(row, 0));
        return Integer.parseInt(val);
    }
    
    public void atualizarTabela(){
        lista_usuarios = new adotego.controller.UsuarioController().findAll();
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
        
    }
    
    public void setList(List<Usuario> l){
        this.lista_usuarios = l;
        this.fireTableDataChanged();
    }

    private String formatar_telefone(String telefone_fixo) {
        char[] p =telefone_fixo.toCharArray();
        char[] p_format = new char[p.length+2];
        for (int i = 0; i < p.length; i++) {
            switch (i) {
                case 0:
                    p_format[i] = "(".charAt(0);
                    break;
                case 3:
                    p_format[i] = ")".charAt(0);
                    break;
                default:
                    p_format[i] = p[i];
                    break;
            }
        }
        String telefone = "";
        for (int i = 0; i < p_format.length; i++) {
            telefone.concat(String.valueOf(p_format[i]));
        }
        System.out.println(telefone);
        return telefone;
    }
}
