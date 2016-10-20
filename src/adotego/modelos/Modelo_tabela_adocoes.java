package adotego.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_tabela_adocoes extends AbstractTableModel{
    private List<Adocao> adocoes;
    private String[] colunas  = new String[]{"Código", "Pessoa", "Animal", "Valor"};

    public Modelo_tabela_adocoes() {
        adocoes = new adotego.controller.AdocaoController().findAll();
    }

    @Override
    public int getRowCount() {
        return adocoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Adocao ad = adocoes.get(rowIndex);
        switch(columnIndex){
            case 0: return ad.getId();
            case 1: return ad.getUsuario().getNome();
            case 2: return ad.getAnimal().getNome();
            case 3: return "R$"+ad.getValor();
            default: return "--";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void atualiza() {
        adocoes = new adotego.controller.AdocaoController().findAll();
    }
    
    
}
