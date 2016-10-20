package adotego.controller;

import adotego.jdbc.ConnectionPool;
import adotego.modelos.Adocao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdocaoController {
    public void salvar(Adocao a){
        try(Connection c = new ConnectionPool().getConnection()){
            new adotego.dao.DoacaoDAO(c).salvar(a);
        } catch (SQLException ex) {
            Logger.getLogger(AdocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Adocao> findAll(){
        try(Connection c = new ConnectionPool().getConnection()){
            return new adotego.dao.DoacaoDAO(c).findAll()   ;
        } catch (SQLException ex) {
            Logger.getLogger(AdocaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
