package adotego.controller;

import adotego.dao.AnimalDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Animal;
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
public class AnimalController {

    /*
        Metodos responsável por criar uma conexao e chamar o metodo find() do
        DAO Usuario, retorna um objeto com o mesmo id passado como parametro. 
     */
    public Animal find(int id) {
        try (Connection c = new ConnectionPool().getConnection()) {
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
    public void save(Animal a) throws SQLException {
        try (Connection c = new ConnectionPool().getConnection()) {
            new AnimalDAO(c).save(a);
        }
    }

    public boolean verificaSeAnimalEstaEmUmaAdocao(int id) {
        int verificaID = 0;

        try (Connection c = new ConnectionPool().getConnection()) {
            verificaID = new AnimalDAO(c).verificaAnimalDoacao(id);
            if (verificaID > 0) {
                JOptionPane.showMessageDialog(null, "Animal não pode ser excluído pois já percente a uma adoção");
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Desja excluir o animal selecionado?\nID:" + id);
                if (confirma == 0) {
                    delete(id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int id) {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new AnimalDAO(c).delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Animal> findAll() {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new AnimalDAO(c).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Animal> findByEspecieName(String nome) {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new AnimalDAO(c).findByEspecieName(nome);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int contarPorSituacao(String situacao) {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new adotego.dao.AnimalDAO(c).contarPorSituacao(situacao);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void setarComoAdotado(Animal animal) {
        try (Connection c = new ConnectionPool().getConnection()) {
            new adotego.dao.AnimalDAO(c).setarComoAdotado(animal);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Animal> findAnimaisAdotados() {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new adotego.dao.AnimalDAO(c).findAnimaisAdotados();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Animal animal) {
        try (Connection a = new ConnectionPool().getConnection()) {
            new adotego.dao.AnimalDAO(a).update(animal);
        } catch (Exception ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Animal> listarIdDesc() {
        try (Connection a = new ConnectionPool().getConnection()) {
            return new adotego.dao.AnimalDAO(a).listarIdDesc();
        } catch (Exception ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
