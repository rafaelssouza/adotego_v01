 
package adotego.controller;
 
import adotego.dao.AnimalDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Animal;
import java.sql.Connection;
import java.sql.SQLException;

/*
    Classe responsável por criar umm objeto Connection.sql e envia-lo para o dao
    respectivo. Possui praticamente os mesmos metodos na classe DAO 
*/
public class AnimalController {
    /*
        Metodos responsável por criar uma conexao e chamar o metodo find() do
        DAO Usuario, retorna um objeto com o mesmo id passado como parametro. 
    */
    public Animal find(int id) throws SQLException{
        try(Connection c = new ConnectionPool().getConnection()){
            return new AnimalDAO(c).find(id);
        }
           
    }

     /*
        Metodos responsável por criar uma conexao e chamar o metodo save() do
        DAO Usuario, 
    */
    public void save(Animal a) throws SQLException{
        try(Connection c = new ConnectionPool().getConnection()){
            new AnimalDAO(c).save(a);
        }
    }
    
    public void delete(int id) throws SQLException{
        try(Connection c = new ConnectionPool().getConnection()){
            new AnimalDAO(c).delete(id);
        }
    }
}
