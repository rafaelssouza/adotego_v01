package adotego.dao;

import adotego.modelos.Especie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecieDAO {
    private Connection connection ;

    public EspecieDAO(Connection c) {
        this.connection = c;
    }
    
    public void save(Especie e) throws SQLException{
        String sql = "insert into Especie (nome) values(?)";
        try(PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, e.getNome());
            st.execute();
        }
    }
}
