package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Especie;
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecieController {
    public void save(Especie e) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            new adotego.dao.EspecieDAO(conn).save(e);
        }
    }
    
    public Especie find(int id) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).find(id);
        }
        
    }
    
    public List<Especie> findAll() {
       try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(EspecieController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
     public Especie getByName(String nome) {
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).findByName(nome);
        } catch (SQLException ex) {
            Logger.getLogger(EspecieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Especie findByRaca(Raca raca) {
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).findByRaca(raca);
        } catch (SQLException ex) {
            Logger.getLogger(EspecieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
