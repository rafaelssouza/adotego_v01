package adotego.controller;

import adotego.dao.AdocaoDAO;
import adotego.dao.AnimalDAO;
import adotego.dao.UsuarioDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Adocao;
import adotego.modelos.Animal;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdocaoController {

    public void salvar(Adocao a) {
        try (Connection c = new ConnectionPool().getConnection()) {
            new adotego.dao.AdocaoDAO(c).salvar(a);
        } catch (SQLException ex) {
            Logger.getLogger(AdocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Adocao> findAll() {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new adotego.dao.AdocaoDAO(c).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(AdocaoController.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean delete(int id) {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new AdocaoDAO(c).delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Adocao find(int id) {
        try (Connection c = new ConnectionPool().getConnection()) {
            return new AdocaoDAO(c).find(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Adocao adocao) {
        try (Connection a = new ConnectionPool().getConnection()) {
            new adotego.dao.AdocaoDAO(a).update(adocao);
        } catch (Exception ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
