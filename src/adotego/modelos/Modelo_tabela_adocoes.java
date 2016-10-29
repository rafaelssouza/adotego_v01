package adotego.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Modelo_tabela_adocoes extends AbstractTableModel{
    private List<Adocao> adocoes;
    private String[] colunas  = new String[]{"Código", "Pessoa","IDAnimal",  "Animal", "Doação"};
    private double total_doacoes;

    public Modelo_tabela_adocoes() {
        adocoes = new adotego.controller.AdocaoController().findAll();
        atualizar_total();
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
            case 2: return ad.getAnimal().getId();
            case 3: return ad.getAnimal().getNome();
            case 4: return "R$"+ad.getValor();
            default: return "--";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void atualiza() {
        adocoes = new adotego.controller.AdocaoController().findAll();
        this.fireTableDataChanged();
        atualizar_total(); 
    }
    
    public double getTotal_doacoes() {
        return total_doacoes;
    }

    public void setTotal_doacoes(double total_doacoes) {
        this.total_doacoes = total_doacoes;
    }
    
    public void incremet_doacao(double valor){
        if(valor > 0 )
            this.setTotal_doacoes(this.getTotal_doacoes()+valor);
    }

    private void atualizar_total() {
        setTotal_doacoes(0.0);
        for (Adocao ad: adocoes) {
            incremet_doacao(ad.getValor());
        }
    }
}
