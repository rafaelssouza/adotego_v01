
package adotego.modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tabela_animais extends AbstractTableModel{
    private List<Animal> linhas_animal = new ArrayList<>();
    private final String[] colunas = new String[]{"Código","Nome", "Especie", "Raça","Situação"};

    public Tabela_animais() {
        linhas_animal = new adotego.controller.AnimalController().findAll();
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
                case 0 : return animal.getId();
                case 1 : return animal.getNome();
                case 2: return  animal.getEspecie().getNome();
                case 3: return animal.getRaca().getNome();
                case 4: return animal.getSituacao().toString();
                default: return "-";
            }
        
       
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código";
            case 1: return "Nome";
            case 2: return "Especie";
            case 3: return "Raca";
            case 4: return "Situação";
            default: return "--";
        }
    }
 
    
    public int getIdIntoTheRow(JTable table){
        int row =table.getSelectedRow();
        String val = String.valueOf(table.getValueAt(row, 0));
        return Integer.parseInt(val);
    }
    public void inserirAnimal(Animal animal){
        linhas_animal.add(animal);
        this.fireTableDataChanged();
    }
    
    public void atualizar_tabela(){
        
        linhas_animal = new adotego.controller.AnimalController().findAll();
        this.fireTableDataChanged();
    }
    
    public void atualizar_tabela(List<Animal> lista){
        linhas_animal = lista;
        this.fireTableDataChanged();
    }

    public String getEspecieIntoTheRow(JTable jTable_animais) {
       int row =jTable_animais.getSelectedRow();
       return String.valueOf(jTable_animais.getValueAt(row, 2));
    }
    
    public Animal getAnimalByIndex(int index){
       return  linhas_animal.get(index);
    }
    
    public int getSelectedIndex(JTable jTable_animais){
        return jTable_animais.getSelectedRow();
    }
    
}
