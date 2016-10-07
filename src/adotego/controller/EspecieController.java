package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Especie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EspecieController {
    public void save(Especie e) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            new adotego.dao.EspecieDAO(conn).save(e);
        }
    }
    
    public Especie find(int id) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            new adotego.dao.EspecieDAO(conn).find(id);
        }
        return null;
    }
    
    public List<Especie> findAll() throws SQLException{
       try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).findAll();
        }
    }
    
     public Especie getByName(String nome) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.EspecieDAO(conn).findByName(nome);
        }
    }
}
