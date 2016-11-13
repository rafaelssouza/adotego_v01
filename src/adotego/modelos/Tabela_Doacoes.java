/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rodrigo.Stuani
 */
public class Tabela_Doacoes extends AbstractTableModel{
    
    List<Doacao> listaDoacoes = new ArrayList<>();
    String[] colunas = new String[]{
            "ID", "Valor"
            };

    public Tabela_Doacoes() {
        listaDoacoes = new adotego.controller.DoacaoController().findAll();
    }
    
    

    @Override
    public int getRowCount() {
       return listaDoacoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doacao doacao = listaDoacoes.get(rowIndex);
        switch(columnIndex){
            case 0:
                return doacao.getId();
            case 1:
                return doacao.getValor();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    public void atualizarTabela(){
        listaDoacoes = new adotego.controller.DoacaoController().findAll();
        this.fireTableDataChanged();
    }
     public void atualizarTabela(List<Doacao> listaDoacoes){
        this.listaDoacoes = listaDoacoes;
        this.fireTableDataChanged();
    }
    public void inserirDoacao(Doacao doacao){
        listaDoacoes.add(doacao);
        this.fireTableDataChanged();
    }   
    public int getSelectedIndex(JTable jTableDoacoes){
        return jTableDoacoes.getSelectedRow();
    }
     public int getIdIntoTheRow(JTable table){
        
        int row =table.getSelectedRow();
        String val = String.valueOf(table.getValueAt(row, 0));
        return Integer.parseInt(val);
    }

   /* public int[] getIdsIntoTheRow(JTable jTableDoacoes) {
        int row =table.getSelectedRow();
        String val = String.valueOf(table.getValueAt(row, 0));
        return Integer.parseInt(val);
    }
    */
    
}
