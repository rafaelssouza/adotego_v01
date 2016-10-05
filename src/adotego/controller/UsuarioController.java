 
package adotego.controller;
 
import adotego.dao.UsuarioDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/*
    Classe responsável por criar umm objeto Connection.sql e envia-lo para o dao
    respectivo. Possui praticamente os mesmos metodos na classe DAO 
*/

public class UsuarioController {
    /*
        Metodos responsável por criar uma conexao e chamar o metodo salvar() do
        DAO Usuario, 
    */
    public void salvar(Usuario p) {
        try(Connection c = new ConnectionPool().getConnection()){
                new UsuarioDAO(c).save(p);
        } catch (SQLException e) {
        }
    }
    
    /*
        Metodos responsável por criar uma conexao e chamar o metodo find() do
        DAO Usuario, retorna um objeto com o mesmo id passado como parametro. 
    */
    public Usuario find(int id) {
        try(Connection c = new ConnectionPool().getConnection()){
            return new UsuarioDAO(c).find(id);
        } catch (SQLException e) {
        }
        return null;        
    }
	
}
