package adotego.controller;

import adotego.dao.RacaDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmichelini
 */
public class RacaController {
    
    public void save(Raca raca) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
          new RacaDAO(conn).save(raca);
        }
    }
    public List<Raca> findAll() throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).findAll();
        }
    }
    
    public Raca find(int aInt) throws SQLException {
       try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).find(aInt);
        }
    }
    
    public List<Raca> findByEspecie(int idEspecie) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).findByEspecie(idEspecie);
        }
    }
    
    public Raca getByName(String name) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).getByName(name);
        }
    }

    public boolean ifExist(Raca raca) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).ifExist(raca);
        }
    }
    
    public boolean ifExistByName(String nome) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).ifExistByName(nome);
        }
    }
    
    public List<Raca> findRacaByEspecieName(String nome){
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).findRacaByEspecieName(nome);
        } catch (SQLException ex) {
            Logger.getLogger(RacaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
