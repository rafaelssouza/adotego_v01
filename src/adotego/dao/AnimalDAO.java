 
package adotego.dao;
 
import adotego.modelos.Animal;
import adotego.modelos.Especie;
import adotego.modelos.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
    Classe responsável pelo acesso aos dados do ojeto Animal no banco de dados.
    Possui os metodos de CREATE, REMOVE, UPDATE, DELETE
*/
public class AnimalDAO {
    
    /*
        Objeto de conexão com todas as propriedades necessárias para o acesso 
        aos dados no banco.
    */  
    private final Connection conn;

    public AnimalDAO(Connection conn) {
            this.conn = conn;
    }

    /*
        Metodos responsável por salvar um objeto java do tipo Animal no banco
        de dados, especificamente na tabela Animal.
    */
    public void save(Animal a) throws SQLException{
        String sql = "insert into Animal(nome,data_entrada,descricao, porte,"
                + "Situacao_idSituacao, Raca_idRaca,Especie_idEspecie) values" +
                        "(?,?,?,?,?,?,?);";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, a.getNome());
            stmt.setDate(2, a.getData_entradaSQL());
            stmt.setString(3, a.getDescricao());
            stmt.setString(4, a.getPorte().toString());
            stmt.setInt(5, 1);
            stmt.setInt(6, a.getRaca().getIdRaca());
            stmt.setInt(7, a.getEspecie().getId());
            stmt.execute();
        }
    }
    
    /*
        Metodos responsável por buscar um objeto Animal no bando de dados de acordo
        com o id passado como parametro
    */
    public Animal find(int id) throws SQLException{
        String sql = "select * from Animal where idAnimal = ?";
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1 ,id);
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){
                    return new Animal(
                            rs.getInt("idAnimal"),
                            rs.getString("nome"),
                            rs.getDate("data_entrada"),
                            rs.getString("descricao"),
                            rs.getString("porte"),
                            rs.getInt("Sotuacao_idSituacao"),
                            rs.getInt("Raca_idRaca"),
                            rs.getInt("Especie_idEspecie")
                    );
                }
            }
        }
         return null;
    }
    
     public void delete(int id) throws SQLException{
        String sql = "delete from Animal where idAnimal = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
            
        }
    }

    public List<Animal> findAll() throws SQLException {
         String sql = "select * from Animal ";
         List<Animal> lista_animal = new ArrayList<>();
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){
                    Especie e = new adotego.controller.EspecieController().find(rs.getInt("Especie_idEspecie"));
                    Raca r = new adotego.controller.RacaController().find(rs.getInt("Raca_idRaca"));
                    
                    
                    String porte = rs.getString("porte");
                    
                    lista_animal.add(new Animal(
                            rs.getInt("idAnimal"),
                            rs.getString("nome"),
                            rs.getDate("data_entrada"),
                            rs.getString("descricao"),
                            rs.getString("porte"),
                            rs.getInt("Situacao_idSituacao"),
                            rs.getInt("Raca_idRaca"),
                            rs.getInt("Especie_idEspecie")
                    ));
                           
                            
                   
                }
            }
        }
         return lista_animal;
    }
}
