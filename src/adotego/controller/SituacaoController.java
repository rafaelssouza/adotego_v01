
package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Situacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SituacaoController {
   
    

    public Situacao find(int id)  {
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.SituacaoDAO(conn).find(id);
        } catch (SQLException ex) {
            Logger.getLogger(SituacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Situacao> findAll()  {
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.SituacaoDAO(conn).findAll();
        } catch (SQLException ex) {
            Logger.getLogger(SituacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getIdByName(String nome_situacao){
        try(Connection conn = new ConnectionPool().getConnection()){
            return new adotego.dao.SituacaoDAO(conn).getIdByName(nome_situacao);
        } catch (SQLException ex) {
            Logger.getLogger(SituacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
