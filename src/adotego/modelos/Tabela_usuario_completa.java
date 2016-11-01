/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.modelos;

import java.text.SimpleDateFormat;
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
        
        String celular_formatado = formatar_telefone(u.getTelefone_celular());
        String fixo_formatado = formatar_telefone(u.getTelefone_fixo());
        
        String cpf_formatado = formatar_cpf(u.getCpf());
       switch(columnIndex){
           case 0: return u.getId();
           case 1: return u.getNome();
           case 2: return u.getEmail();
           case 3: return cpf_formatado;
           case 4: return fixo_formatado;
           case 5: return celular_formatado;
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

    private String formatar_telefone_com_CodArea(String telefone_fixo) {
       String [] telefone_vetor = telefone_fixo.split("");
        StringBuilder sb = new StringBuilder();
       int cont =0 ;
       for(String s: telefone_vetor){
           if(cont == 0)
               sb.append("(");
           
          if(cont == 2)
               sb.append(")");
           
         if(cont == 6)
               sb.append("-");
          
           sb.append(s);
           
           cont++;
           
           
       }
        return sb.toString();
    }

    private String formatar_telefone(String telefone) {
       if(telefone.length() == 8){
          telefone = formatar_telefone_sem_CodArea(telefone); 
       }else if(telefone.length() == 10){
          telefone = formatar_telefone_com_CodArea(telefone);
       }
       
       return telefone;
    }

    private String formatar_telefone_sem_CodArea(String telefone) {
         String [] telefone_vetor = telefone.split("");
        StringBuilder sb = new StringBuilder();
       int cont =0 ;
       for(String s: telefone_vetor){
           if(cont == 4)
               sb.append("-");
       
           
           
           sb.append(s);
           
           cont++;
           
           
       }
        return sb.toString();
    }

    private String formatar_cpf(String cpf) {
         String [] telefone_vetor = cpf.split("");
        StringBuilder sb = new StringBuilder();
       int cont =0 ;
       for(String s: telefone_vetor){
           if((cont == 3) || (cont == 6)|| (cont == 9))
               sb.append(".");
           if(cont == 11)
               sb.append("-");
           
           
           sb.append(s);
           
           cont++;
           
           
       }
        return sb.toString();
    }
}
