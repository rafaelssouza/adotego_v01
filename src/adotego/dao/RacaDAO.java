 
package adotego.dao;
 
import adotego.modelos.Animal;
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

    public void save(Raca raca) throws SQLException{
        String sql = "insert into Raca (nome, raca_idEspecie)values(?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, raca.getNome());
            ps.setInt(2, raca.getEspecie().getId());
            ps.execute();
            
        }
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
        String sql = "select * from Raca where raca_idEspecie = ? ";
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
    
    public boolean ifExist(Raca r) throws SQLException{
        String sql= "select * from Raca where nome = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, r.getNome());
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()) 
                    return true;
            }
        }
        return false;
    }
    
    public boolean ifExistByName(String nome) throws SQLException{
        String sql= "select * from Raca where nome = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, nome);
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()) 
                    return true;
            }
        }
        return false;
    }
    
    public List<Raca> findRacaByEspecieName(String nome) throws SQLException{
        String sql = "select r.idRaca , r.nome from Raca r " +
                     "join Especie e " +
                     "on r.raca_idEspecie = e.idEspecie " +
                     "where e.nome = ?";
        
        List<Raca> animal_lista = new ArrayList<>();
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, nome);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    animal_lista.add(new Raca(rs.getInt("idRaca"), rs.getString("nome")));
                    
                }
            }
        }
        return animal_lista;
    }
    
}
