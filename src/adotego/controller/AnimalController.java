 
package adotego.controller;
 
import adotego.dao.AnimalDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Animal;
import java.sql.Connection;
import java.sql.SQLException;

public class AnimalController {
    public Animal find(int id) throws SQLException{
        try(Connection c = new ConnectionPool().getConnection()){
               return new AnimalDAO(c).find(id);
        }
           
    }

    public void save(Animal a) throws SQLException{
            try(Connection c = new ConnectionPool().getConnection()){
                    new AnimalDAO(c).save(a);
            }
    }
}
