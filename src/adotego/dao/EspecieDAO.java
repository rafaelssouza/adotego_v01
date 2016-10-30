package adotego.dao;

import adotego.modelos.Especie;
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {
    private Connection connection ;

    public EspecieDAO(Connection c) {
        this.connection = c;
    }
    
    public void save(Especie e) throws SQLException{
        String sql = "insert into especie (nome) values(?)";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, e.getNome());
            st.execute();
        }
    }
    
    public Especie find(int id) throws SQLException{
        String sql = "select * from Especie where idEspecie = ?";
        Especie especie = null;
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setInt(1, id);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){                    
                    especie = new Especie(rs.getInt("idEspecie"),
                            rs.getString("nome"));                    
                    return especie;
                }
            }
        }
      return null;
    }
    
    public List<Especie> findAll() throws SQLException{
        String sql = "select * from especie";
        List<Especie> lista_especie = new ArrayList<>();
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    lista_especie.add(new Especie(rs.getInt("idEspecie"), 
                            rs.getString("nome")));
                }
            }
        }
        return lista_especie;
    }

    public Especie findByName(String nome) throws SQLException {
        String sql = "select * from especie e where e.nome = ?";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, nome);
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    return  new Especie(rs.getInt("idEspecie"),rs.getString("nome"));
                }
            }
        }
        return null;
    }

    public Especie findByRaca(Raca raca) throws SQLException {
          String sql = "select * from raca as r  join especie as e on r.raca_idespecie = e.idespecie where idraca = ?";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setInt(1, raca.getIdRaca());
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    return  new Especie(rs.getInt("idEspecie"),rs.getString("nome"));
                }
            }
        }
        return null;
    }
    
    
}
