package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Especie;
import java.sql.Connection;
import java.sql.SQLException;

public class EspecieController {
    public void save(Especie e) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            new adotego.dao.EspecieDAO(conn).save(e);
        }
    }
}
