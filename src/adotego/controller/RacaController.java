package adotego.controller;

import adotego.dao.RacaDAO;
import adotego.jdbc.ConnectionPool;
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tmichelini
 */
public class RacaController {
    public List<Raca> findAll() throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new RacaDAO(conn).findAll();
        }
    }
}
