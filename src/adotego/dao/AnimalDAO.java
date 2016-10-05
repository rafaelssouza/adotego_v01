 
package adotego.dao;
 
import adotego.modelos.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO {
    private final Connection c;

    public AnimalDAO(Connection conn) {
            this.c = conn;
    }

    public void save(Animal a) throws SQLException{
            String sql = "";
            try(PreparedStatement stmt = c.prepareStatement(sql)){
                
                 

                    stmt.execute();
            }
    }
}
