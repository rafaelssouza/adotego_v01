 
package adotego.dao;
 
import adotego.modelos.Animal;
import adotego.modelos.Especie;
import adotego.modelos.Porte_enum;
import adotego.modelos.Raca;
import adotego.modelos.Situacao;
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
        String sql = "insert into animal(nome,data_registro_entrada,descricao, porte,"
                + "situacao_idSituacao, animal_idRaca) values" +
                        "(?,?,?,?,?,?);";

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, a.getNome());
            stmt.setDate(2, a.getData_entradaSQL());
            stmt.setString(3, a.getDescricao());
            stmt.setString(4, a.getPorte().toString());
            stmt.setInt(5, 1);
            stmt.setInt(6, a.getRaca().getIdRaca());
            stmt.execute();
        }
    }
    
    /*
        Metodos responsável por buscar um objeto Animal no bando de dados de acordo
        com o id passado como parametro
    */
    public Animal find(int id) throws SQLException{
        String sql = "select a.idanimal, a.nome, a.porte, " +
                    "		a.data_registro_entrada,r.nome as nome_raca,r.idraca ," +
                    "        e.idespecie,a.animal_idraca ," +
                    "        a.descricao as descricao_animal,a.situacao_idsituacao ,s.descricao as descricao_situacao, " +
                    "        e.nome as nome_especie " +
                    "        from animal a " +
                    "        join raca r" +
                    "        on r.idraca = a.animal_idraca" +
                    "        join especie e " +
                    "        on r.raca_idespecie = e.idespecie" +
                    "        join situacao s" +
                    "        on s.idsituacao = a.situacao_idsituacao" +
                    "        where a.idanimal = ?";
        
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1 ,id);
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){                    

                   Especie especie = new Especie(rs.getInt("idespecie"), rs.getString("nome_especie"));
                     Raca raca = new Raca(rs.getInt("animal_idraca"),rs.getString("nome_raca"), especie);
                     Situacao situacao = new Situacao(rs.getInt("situacao_idsituacao"), rs.getString("descricao_situacao"));
                    Animal animal =  new Animal();                   
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao_animal"));
                        animal.setId(rs.getInt("idanimal"));
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                         animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_registro_entrada"));
                        return animal;
                }
            }
        }
         return null;
    }
    
     public void delete(int id) throws SQLException{
        String sql = "delete from animal where idAnimal = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
            
        }
    }

    public List<Animal> findAll() throws SQLException {
          String sql = "select a.idanimal, a.nome, a.porte, " +
                    "		a.data_registro_entrada,r.nome as nome_raca,r.idraca ," +
                    "        e.idespecie,a.animal_idraca ," +
                    "        a.descricao as descricao_animal,a.situacao_idsituacao ,s.descricao as descricao_situacao, " +
                    "        e.nome as nome_especie " +
                    "        from animal a " +
                    "        join raca r" +
                    "        on r.idraca = a.animal_idraca" +
                    "        join especie e " +
                    "        on r.raca_idespecie = e.idespecie" +
                    "        join situacao s" +
                    "        on s.idsituacao = a.situacao_idsituacao";                   
         List<Animal> lista_animal = new ArrayList<>();
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.executeQuery();
            
            try(ResultSet rs  = stmt.getResultSet()){
                while(rs.next()){                    
                    
                    Especie especie = new Especie(rs.getInt("idespecie"), rs.getString("nome_especie"));
                     Raca raca = new Raca(rs.getInt("animal_idraca"),rs.getString("nome_raca"), especie);
                     Situacao situacao = new Situacao(rs.getInt("situacao_idsituacao"), rs.getString("descricao_situacao"));
                    Animal animal =  new Animal();
                        
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao_animal"));
                        animal.setId(rs.getInt("idAnimal"));
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                        animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_registro_entrada"));
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
         String sql = "select a.idAnimal, a.nome, a.porte, " +
                    "		a.data_registro_entrada,r.nome as nome_raca,r.idraca ," +
                    "        e.idespecie,a.animal_idraca ," +
                    "        a.descricao as descricao_animal,a.situacao_idsituacao ,s.descricao as descricao_situacao, " +
                    "        e.nome as nome_especie " +
                    "        from animal a " +
                    "        join raca r" +
                    "        on r.idraca = a.animal_idraca" +
                    "        join especie e " +
                    "		on r.raca_idespecie = e.idespecie" +
                    "        join situacao s" +
                    "        on s.idsituacao = a.situacao_idsituacao" +
                    "        where e.nome = ?";
         
         List<Animal> lista = new ArrayList<>();
         try(PreparedStatement ps = conn.prepareStatement(sql)){
             ps.setString(1, nome);
             ps.executeQuery();
             
             try(ResultSet rs = ps.getResultSet()){
                 while(rs.next()){
                     Especie especie = new Especie(rs.getInt("idespecie"), rs.getString("nome_especie"));
                     Raca raca = new Raca(rs.getInt("animal_idraca"),rs.getString("nome_raca"), especie);
                     Situacao situacao = new Situacao(rs.getInt("situacao_idsituacao"), rs.getString("descricao_situacao"));
                    Animal animal =  new Animal();                   
                        animal.setId(rs.getInt("idAnimal"));
                        animal.setNome(rs.getString("nome"));
                        animal.setDescricao(rs.getString("descricao_animal"));                        
                        animal.setPorte(getPorte_com_string(rs.getString("porte")));
                        animal.setEspecie(especie);
                        animal.setSituacao(situacao);
                        animal.setRaca(raca);
                        animal.setData_nascimento_from_SQL(rs.getDate("data_registro_entrada"));
                        
                        System.out.println(animal);
                        lista.add(animal);
                 }
             }
         }
         return lista;
     }
     
     public int contarPorSituacao(String situacao) throws SQLException{
         
         
         String sql = "select count(idAnimal) from animal a \n" +
                "join situacao s on a.Situacao_idSituacao = s.idSituacao \n" +
                "where s.descricao = ? group by s.idSituacao";
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, situacao);
                ps.executeQuery();
                
                try(ResultSet rs = ps.getResultSet()){
                    while(rs.next()){
                        return rs.getInt(1);
                    }
                }
            }
         return 1;
     }
}
