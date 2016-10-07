
package adotego.modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class Tabela_animais extends AbstractTableModel{
    private List<Animal> linhas_animal = new ArrayList<>();
    private final String[] colunas = new String[]{"Nome", "Especie", "Raça","Situação"};

    public Tabela_animais() throws SQLException {
        linhas_animal = new adotego.controller.AnimalController().findAll();
        System.out.println(linhas_animal.size());
    }
    
    
    @Override
    public int getRowCount() {
        return linhas_animal.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
            Animal animal = linhas_animal.get(rowIndex);
           
           
            
            switch(columnIndex){
                case 0 : return animal.getNome();
                case 1: return "corrigir erro kkk";
                case 2: return animal.getRaca().getNome();
                case 3: return animal.getSituacao().toString();
                default: return "-";
            }
        
       
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nome";
            case 1: return "Especie";
            case 2: return "Raca";
            case 3: return "Situação";
            default: return "--";
        }
    }
 
    
}
