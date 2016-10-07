
package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Situacao_enum;
import java.sql.Connection;
import java.sql.SQLException;

public class SituacaoController {
    public Situacao_enum find(int id) throws SQLException{
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.SituacaoDAO(conn).find(id);
        }
    }
}
