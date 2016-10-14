package adotego.modelos;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tabela_usuarios extends AbstractTableModel{

    List<Usuario> usuarios;
    private final String[] colunas =new String[]{"Código", "Nome"}; 

    public Tabela_usuarios() {
    
        usuarios = new adotego.controller.UsuarioController().findAll();
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
        Usuario usuario = usuarios.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch(columnIndex){
            case 0: return usuario.getId();
            case 1: return usuario.getNome();                       
            default: throw new IndexOutOfBoundsException("Erro ao identificar coluna");
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
    
    public void atualizarTabela(){
        usuarios = new adotego.controller.UsuarioController().findAll();
        this.fireTableDataChanged();
    }
}
