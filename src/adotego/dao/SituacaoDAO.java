package adotego.dao;

import adotego.modelos.Situacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SituacaoDAO {
    private Connection conn;

    public SituacaoDAO(Connection conn) {
        this.conn = conn;
    }
    

    public  List<Situacao> findAll() throws SQLException {
        String sql = "select * from situacao";
        List<Situacao> situacoes = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    situacoes.add(new Situacao(rs.getInt("idSituacao"),
                                        rs.getString("descricao")));
                }
            }
        }
        return situacoes;
    }

    public Situacao find(int id) throws SQLException {
        String sql = "select * from situacao";        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    return new Situacao(rs.getInt("idSituacao"),
                                        rs.getString("descricao"));
                }
            }
        }
        return null;
    }
    
    public int getIdByName(String nome_situacao) throws SQLException{
        String sql = "select descricao from situacao where descricao = ?";
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(0, nome_situacao);
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    return rs.getInt("idSituacao");
                }
            }
        
        }
        return 0;
        
    }
}
