package adotego.dao;

import adotego.modelos.Adocao;
import adotego.modelos.Animal;
import adotego.modelos.Endereco;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDAO {

    private Connection conn;
    private DoacaoDAO doacao = new DoacaoDAO(conn);
    public AdocaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Adocao adocao) throws SQLException {
        
        String sql = "insert into adocao (adocao_IdPessoa ,data_adocao, adocao_idAnimal)";
        sql += "values(?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, adocao.getUsuario().getId());
            ps.setDate(2, adocao.getData_entradaSQL());
            ps.setInt(3, adocao.getAnimal().getId());
            //   ps.setDouble(4, adocao.getValor());
            ps.execute();
        }
    }

    public List<Adocao> findAll() throws SQLException {
        String sql = "select * from adocao order by idadocao desc";
        List<Adocao> adocoes = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeQuery();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Adocao ad = new Adocao();
                    ad.setId(rs.getInt("idAdocao"));
                    ad.setData_from_SQL(rs.getDate("data_adocao"));
                    ad.setAnimal(new adotego.controller.AnimalController().find(rs.getInt("adocao_idAnimal")));
                    ad.setUsuario(new adotego.controller.UsuarioController().find(rs.getInt("adocao_idPessoa")));
//                        ad.setValor(rs.getDouble("valor"));
                    adocoes.add(ad);
                }
            }
        }
        return adocoes;
    }

    public int getTotalAdocoes() throws SQLException {
        String sql = "select count(idAdocao) as total from adocao";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    return rs.getInt("total");
                }
            }
        }
        return 0;
    }

    //atualizacao de situacao do animal para disponivel quando excluir adocao
    public boolean atualizaSituacaoAnimalQuandoExcluiAdocao(int id) throws SQLException {
        String sql = "update animal an set situacao_idsituacao = 1 "
                + "where an.idanimal = (select adocao_idanimal from adocao "
                + "where idAdocao = ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.execute();

        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "delete from adocao where idadocao = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            atualizaSituacaoAnimalQuandoExcluiAdocao(id);
            ps.setInt(1, id);
            return ps.execute();

        }
    }

    public Adocao find(int id) throws SQLException {
        Adocao adocao = new Adocao();

        String sql = "select * from adocao where idAdocao = ? ";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeQuery();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {

                    adocao.setId(rs.getInt("idadocao"));
                }
            }
        }
        return adocao;
    }

    public void update(Adocao adocao) throws SQLException {
        atualizaSituacaoAnimalQuandoExcluiAdocao(adocao.getId());
        
        String sql = "update adocao set adocao_IdPessoa = ? ,data_adocao = ?, adocao_idAnimal = ? where idadocao = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, adocao.getUsuario().getId());
            ps.setDate(2, adocao.getData_entradaSQL());
            ps.setInt(3, adocao.getAnimal().getId());
            ps.setInt(4, adocao.getId());
            //   ps.setDouble(4, adocao.getValor());
            ps.execute();
        }
    }

}
