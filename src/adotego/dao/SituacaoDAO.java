
package adotego.dao;

import adotego.modelos.Situacao_enum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SituacaoDAO {
    private Connection conn;

    public SituacaoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public Situacao_enum find(int id) throws SQLException{
        String sql = "select * from Situacao";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    switch(rs.getString("descricao")){
                        case "Diponivel": return Situacao_enum.DISPONIVEL;
                        case "Enfermo": return Situacao_enum.ENFERMO;
                        case "Adotado": return Situacao_enum.ADOTADO;
                        default:return Situacao_enum.DISPONIVEL;
                    }
                }
            }
        }
        return Situacao_enum.DISPONIVEL;
    }
}
