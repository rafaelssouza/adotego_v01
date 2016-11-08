/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.controller;

import adotego.dao.DoacaoDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Doacao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo.Stuani
 */
public class DoacaoController {
    
    
     public Doacao find(int id) {
        try(Connection c = new ConnectionPool().getConnection()){
            return new DoacaoDAO(c).find(id);
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Doacao> findAll()  {
        try(Connection c = new ConnectionPool().getConnection()){
            return new DoacaoDAO(c).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    public boolean delete(int id){
        try(Connection c = new ConnectionPool().getConnection()){
            return new DoacaoDAO(c).delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(DoacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void update(Doacao doacao){
        try(Connection c = new ConnectionPool().getConnection()){
            new DoacaoDAO(c).update(doacao);
        } catch(SQLException ex){
            Logger.getLogger(DoacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void save(Doacao doacao) throws SQLException{
        try(Connection c = new ConnectionPool().getConnection()){
            new DoacaoDAO(c).save(doacao);
        }
    }
}
