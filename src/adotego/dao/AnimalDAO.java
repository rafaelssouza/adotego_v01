 
package adotego.dao;
 
import adotego.modelos.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalDAO {
    private final Connection c;

    public AnimalDAO(Connection conn) {
            this.c = conn;
    }

    public void save(Animal a) throws SQLException{
        String sql = "insert into Animal(nome,data_entrada,descricao, porte,"
                + "Situacao_idSituacao, Raca_idRaca,Especie_idEspecie) values" +
                        "(?,?,?,?,?,?,?);";

        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setString(1, a.getNome());
            stmt.setDate(2, a.getData_entradaSQL());
            stmt.setString(3, a.getDescricao());
            stmt.setString(4, a.getPorte().toString());
            stmt.setInt(5, 1);
            stmt.setInt(6, 1);
            stmt.setInt(7, 1);
            stmt.execute();
        }
    }
    
    public Animal find(int id) throws SQLException{
        String sql = "select * from Animal where idAnimal = ?";
         try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setInt(1 ,id);
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){
                    return new Animal(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5)
                            
                    );
                }
            }
        }
         return null;
    }
}
