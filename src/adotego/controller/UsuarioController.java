 
package adotego.controller;
 
import adotego.dao.UsuarioDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            e.printStackTrace();
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
             e.printStackTrace();
        }
        return null;        
    }
	
    public List<Usuario> findAll(){
         try(Connection c = new ConnectionPool().getConnection()){
            return new UsuarioDAO(c).findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;   
    }
    
        public boolean verificaSePessoaEstaEmUmaAdocao(int id) {
        int verificaID = 0;

        try (Connection c = new ConnectionPool().getConnection()) {
            verificaID = new UsuarioDAO(c).verificaUsuarioDoacao(id);
            if (verificaID > 0) {
                JOptionPane.showMessageDialog(null, "A pessoa selecionada não pode ser excluído pois já percente a uma adoção");
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Desja excluir a pessoa selecionada?\nID:" + id);
                if (confirma == 0) {
                    delete(id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*
        Método responsável por deletar um Usuario de acordo com id passado como
        parametro.
    */
    public boolean delete(int id){
        try(Connection c = new ConnectionPool().getConnection()){
            return new UsuarioDAO(c).delete(id);
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return false;
    }

    public List<Usuario> findLikeName(String parametro) {
        try(Connection c = new ConnectionPool().getConnection()){
            return new adotego.dao.UsuarioDAO(c).findLikeName(parametro.trim());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Usuario> findLikeCpf(String param) {
        try(Connection c = new ConnectionPool().getConnection()){
            return new adotego.dao.UsuarioDAO(c).findLikeCpf(param);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Usuario> findLikeEmail(String str_pesquisa) {
         try(Connection c = new ConnectionPool().getConnection()){
            return new adotego.dao.UsuarioDAO(c).findLikeEmail(str_pesquisa);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Usuario usuario) {
        try (Connection u = new ConnectionPool().getConnection()) {
            new adotego.dao.UsuarioDAO(u).update(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
