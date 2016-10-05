 
package adotego.controller;
 
import adotego.dao.UsuarioDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioController {
    public void salvar(Usuario p) {
            try(Connection c = new ConnectionPool().getConnection()){
                    new UsuarioDAO(c).save(p);
            } catch (SQLException e) {
            }
    }

    public Usuario find(int id) {
            try(Connection c = new ConnectionPool().getConnection()){
                return new UsuarioDAO(c).find(id);
            } catch (SQLException e) {
            }
        return null;        
    }
	
}
