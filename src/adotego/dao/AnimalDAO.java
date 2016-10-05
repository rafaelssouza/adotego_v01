 
package adotego.dao;
 
import adotego.modelos.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
    Classe responsável pelo acesso aos dados do ojeto Animal no banco de dados.
    Possui os metodos de CREATE, REMOVE, UPDATE, DELETE
*/
public class AnimalDAO {
    
    /*
        Objeto de conexão com todas as propriedades necessárias para o acesso 
        aos dados no banco.
    */  
    private final Connection c;

    public AnimalDAO(Connection conn) {
            this.c = conn;
    }

    /*
        Metodos responsável por salvar um objeto java do tipo Animal no banco
        de dados, especificamente na tabela Animal.
    */
    public void save(Animal a) throws SQLException{
        String sql = "insert into Animal(nome,data_entrada,descricao, porte,"
                + "Situacao_idSituacao, Raca_idRaca,Especie_idEspecie) values" +
                        "(?,?,?,?,?,?,?);";

        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setString(1, a.getNome());
            stmt.setDate(2, a.getData_entradaSQL());
            stmt.setString(3, a.getDescricao());
            stmt.setString(4, a.getPorte().toString());
            stmt.setInt(5, 1);
            stmt.setInt(6, 1);
            stmt.setInt(7, 1);
            stmt.execute();
        }
    }
    
    /*
        Metodos responsável por buscar um objeto Animal no bando de dados de acordo
        com o id passado como parametro
    */
    public Animal find(int id) throws SQLException{
        String sql = "select * from Animal where idAnimal = ?";
         try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setInt(1 ,id);
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){
                    return new Animal(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5)
                            
                    );
                }
            }
        }
         return null;
    }
}
