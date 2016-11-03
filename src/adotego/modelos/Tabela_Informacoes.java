/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tmichelini
 */
public class Tabela_Informacoes extends AbstractTableModel{
    List<Informacao> lista_informacoes = new ArrayList<>();
    String [] colunas  = new String[]{"Descrição", ""};

    @Override
    public int getRowCount() {
        return lista_informacoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;               
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Informacao info = lista_informacoes.get(rowIndex);
        switch(columnIndex){
            case 0: return info.getDescricao();
            case 1: return info.getValor();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }    
    
    public void inserirInformacao(Informacao info){
        lista_informacoes.add(info);
        this.fireTableDataChanged();
    }

    public void atualizar() {
         int totalAdocoes = new adotego.controller.AdocaoController().getTotalAdocoes();
        Informacao info_adocoes = new Informacao("Total de doações", totalAdocoes);
        
        int qtnd_animais_disponiveis = new adotego.controller.AnimalController().contarPorSituacao("disponivel");
        Informacao info_qntd_animais_disponiveis = new Informacao("Quantidade de animais disponíveis", qtnd_animais_disponiveis);
        lista_informacoes.removeAll(lista_informacoes);
        
        inserirInformacao(info_adocoes);
        inserirInformacao(info_qntd_animais_disponiveis);
        this.fireTableDataChanged();
    }
    
}

