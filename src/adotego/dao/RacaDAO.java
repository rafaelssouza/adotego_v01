 
package adotego.dao;
 
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RacaDAO {

    private final Connection connection;
    
    public RacaDAO(Connection c) {
        this.connection = c;
    }

    
    public List<Raca> findAll() throws SQLException {
        String sql = "select * from Raca";
        List<Raca> lista_racas = new ArrayList<>();
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    int id = rs.getInt("idRaca");
                    String nome = rs.getString("nome");                    
                    lista_racas.add(new Raca(id, nome));
                    
                }
            }
        }
        return lista_racas;
    }

    public List<Raca> findByEspecie(int idEspecie) throws SQLException {
        String sql = "select * from Raca where Especie_idEspecie = ? ";
        List<Raca> lista_racas = new ArrayList<>();
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setInt(1, idEspecie);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    lista_racas.add(new Raca(rs.getInt("idRaca"), rs.getString("nome")));
                    
                }
            }
        }
        return lista_racas;
    }

    public Raca getByName(String name) throws SQLException {
        String sql = "select idRaca ,nome from Raca where nome = ?";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, name);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    return new Raca(rs.getInt("idRaca"), rs.getString("nome"));
                    
                }
            }
        }
        return null;
    }

    public Raca find(int aInt) throws SQLException {
        String sql = "select * from Raca where idRaca = ?";
        List<Raca> lista_racas = new ArrayList<>();
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setInt(1, aInt);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    return new Raca(rs.getInt("idRaca"), rs.getString("nome"));
                    
                }
            }
        }
       return null;
    }
    
    
    
}
