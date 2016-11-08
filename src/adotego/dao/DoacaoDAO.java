/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.dao;

import adotego.modelos.Doacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo.Stuani
 */
public class DoacaoDAO {
    
    private Connection c;

    public DoacaoDAO(Connection c) {
        this.c = c;
    }
    public Doacao find(int id) throws SQLException{
        String sql = "select * from doacao where idDoacao = ?";
        
        try(PreparedStatement pstm = c.prepareStatement(sql)){
            pstm.setInt(1, id);
            pstm.executeQuery();
            
            try(ResultSet rs = pstm.getResultSet()){
                while(rs.next()){
                    Doacao d = new Doacao();
                    int idr = rs.getInt("idDoacao");
                    double valor = rs.getDouble("valor");
                    d.setId(idr);
                    d.setValor(valor);
                    return d;
                }
            }
        }
        return null;
    }

    public List<Doacao> findAll() throws SQLException {
        String sql = "select * from doacao";
        List<Doacao> listaDoacao = new ArrayList<>();
        
        try(PreparedStatement pstm = c.prepareStatement(sql)){
            
            pstm.executeQuery();
            
            try(ResultSet rs = pstm.getResultSet()){
                while(rs.next()){
                    Doacao d = new Doacao();
                    int idr = rs.getInt("idDoacao");
                    double valor = rs.getDouble("valor");
                    d.setId(idr);
                    d.setValor(valor);
                    listaDoacao.add(d);
                }
            }
        }
        return listaDoacao;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "delete from doacao where idDoacao = ?";
        
        try(PreparedStatement pstm = c.prepareStatement(sql)){
            
            pstm.setInt(1, id);
            return pstm.execute();
        }
    }

    public void update(Doacao doacao) throws SQLException {
        String sql = "update doacao set idDoacao = ?, valor = ?";
        
        try(PreparedStatement pstm = c.prepareStatement(sql)){
            pstm.setDouble(1, doacao.getValor());
            pstm.setInt(2, doacao.getId());
            pstm.execute();
        }
    }
    public void save(Doacao doacao) throws SQLException {
        String sql = "insert into doacao(id, valor) values (?,?)";
        
        try(PreparedStatement pstm = c.prepareStatement(sql)){
            pstm.setInt(1, doacao.getId());
            pstm.setDouble(2, doacao.getValor());
            pstm.execute();
        }
    }
    
    
    
}

