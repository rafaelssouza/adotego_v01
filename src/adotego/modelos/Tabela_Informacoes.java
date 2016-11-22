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

    public Tabela_Informacoes() {
        atualizar();
    }
    
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
            case 1: return Math.round(info.getValor());
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
         int totalDoacoes = new adotego.controller.DoacaoController().getTotalDoacoes();
        Informacao info_adocoes = new Informacao("Total de doações", totalDoacoes);
        
        int qtnd_animais_disponiveis = new adotego.controller.AnimalController().contarPorSituacao("disponivel");
        Informacao info_qntd_animais_disponiveis = new Informacao("Quantidade de animais disponíveis", qtnd_animais_disponiveis);
        
 //       Rafael Souza: Retidao pois a quantidade de animais adotados é a mesma da quantidade de adoções, pq uma adoção não existe sem um animal          
 //       int qtnd_animais_adotados = new adotego.controller.AnimalController().contarPorSituacao("adotado");
 //       Informacao info_qntd_animais_adotados = new Informacao("Quantidade de animais adotados", qtnd_animais_adotados);
        
        
        lista_informacoes.removeAll(lista_informacoes);
        this.fireTableDataChanged();
        
 //       inserirInformacao(info_qntd_animais_adotados);
        inserirInformacao(info_adocoes);
        inserirInformacao(info_qntd_animais_disponiveis);
        this.fireTableDataChanged();
    }
    
}

