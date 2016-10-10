 
package adotego.dao;
 
import adotego.modelos.Animal;
import adotego.modelos.Especie;
import adotego.modelos.Porte_enum;
import adotego.modelos.Raca;
import adotego.modelos.Situacao_enum;
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
                    Especie especie = new adotego.controller.EspecieController().find(rs.getInt("Especie_idEspecie"));
                    Raca raca = new adotego.controller.RacaController().find(rs.getInt("Raca_idRaca"));
                    Situacao_enum situacao = new adotego.controller.SituacaoController().find(rs.getInt("Situacao_idSituacao"));
                    Animal animal =  new Animal();                   
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao"));
                        animal.setId(rs.getInt("idAnimal"));
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                        animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_entrada"));
                        return animal;
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
                    Especie especie = new adotego.controller.EspecieController().find(rs.getInt("Especie_idEspecie"));                    
                    Raca raca = new adotego.controller.RacaController().find(rs.getInt("Raca_idRaca"));
                    Situacao_enum situacao = new adotego.controller.SituacaoController().find(rs.getInt("Situacao_idSituacao"));
                    Animal animal =  new Animal();
                   
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao"));
                        animal.setId(rs.getInt("idAnimal"));
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                        animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_entrada"));
                    lista_animal.add(animal);
                           
                            
                   
                }
            }
        }
         return lista_animal;
    }
    
     public Porte_enum getPorte_com_string(String porte){
            switch(porte){
                case "PEQUENO": return Porte_enum.PEQUENO;
                case "MEDIO": return Porte_enum.MEDIO;
                case "GRANDE": return Porte_enum.GRANDE;              
                default: return Porte_enum.MEDIO;
            }
     }
     
     
     
     public List<Animal> findByEspecieName(String nome) throws SQLException{
         String sql = "select a.idAnimal, a.nome," +
                        "a.porte, a.data_entrada,Especie_idEspecie,Raca_idRaca ," +
                        "a.descricao,Situacao_idSituacao , e.nome from Animal a " +
                        "join Especie e " +
                        "on a.Especie_idEspecie = e.idEspecie" +
                        " where e.nome = ?;"; 
         List<Animal> lista = new ArrayList<>();
         try(PreparedStatement ps = conn.prepareStatement(sql)){
             ps.setString(1, nome);
             ps.executeQuery();
             
             try(ResultSet rs = ps.getResultSet()){
                 while(rs.next()){
                    Especie especie = new adotego.controller.EspecieController().find(rs.getInt("Especie_idEspecie"));
                    Raca raca = new adotego.controller.RacaController().find(rs.getInt("Raca_idRaca"));
                    Situacao_enum situacao = new adotego.controller.SituacaoController().find(rs.getInt("Situacao_idSituacao"));
                    Animal animal =  new Animal();                   
                        
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao"));
                        animal.setId(rs.getInt("idAnimal"));
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                        animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_entrada"));
                        
                        lista.add(animal);
                 }
             }
         }
         return lista;
     }
}
