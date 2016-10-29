 
package adotego.controller;
 
import adotego.dao.AnimalDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Animal;
import adotego.modelos.Especie;
import adotego.modelos.Situacao_enum;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Classe responsável por criar umm objeto Connection.sql e envia-lo para o dao
    respectivo. Possui praticamente os mesmos metodos na classe DAO 
*/
public class AnimalController {
    /*
        Metodos responsável por criar uma conexao e chamar o metodo find() do
        DAO Usuario, retorna um objeto com o mesmo id passado como parametro. 
    */
    public Animal find(int id) {
        try(Connection c = new ConnectionPool().getConnection()){
            return new AnimalDAO(c).find(id);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    
    public void delete(int id){
        try(Connection c = new ConnectionPool().getConnection()){
            new AnimalDAO(c).delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Animal> findAll()  {
        try(Connection c = new ConnectionPool().getConnection()){
            return new AnimalDAO(c).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Animal> findByEspecieName(String nome) throws SQLException{
         try(Connection c = new ConnectionPool().getConnection()){
          return new AnimalDAO(c).findByEspecieName(nome);
      }
    }

    public int contarPorSituacao(String situacao){
        try(Connection c = new ConnectionPool().getConnection()){
            return new adotego.dao.AnimalDAO(c).contarPorSituacao(situacao);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
