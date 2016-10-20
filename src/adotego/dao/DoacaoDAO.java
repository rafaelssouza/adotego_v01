package adotego.dao;

import adotego.modelos.Adocao;
import adotego.modelos.Animal;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {
    private Connection conn;

    public DoacaoDAO(Connection conn) {
        this.conn = conn;
    }
    public void salvar(Adocao adocao) throws SQLException{
        String sql = "insert into Adocao ( adocao_IdPessoa ,data_adocao, adocao_idAnimal, valor)";
               sql += "values(?,?,?,?)";
               
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, adocao.getUsuario().getId());
                ps.setDate(2, adocao.getData_entradaSQL());
                ps.setInt(3, adocao.getAnimal().getId());
                ps.setDouble(4, adocao.getValor());
                ps.execute();
            }
    }
    public List<Adocao>  findAll () throws SQLException{
        String sql = "select * from Adocao";
        List<Adocao> adocoes = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while (rs.next()) {
                    Adocao ad = new Adocao();
                        ad.setId(rs.getInt("idAdocao"));
                        ad.setData_from_SQL(rs.getDate("data_adocao"));
                        ad.setAnimal(new adotego.controller
                            .AnimalController().find(rs.getInt("adocao_idAnimal")));
                        ad.setUsuario(new adotego.controller
                            .UsuarioController().find(rs.getInt("adocao_idPessoa")));
                        adocoes.add(ad);
                }
            }
        }
        return adocoes;
    }
}
