package adotego.dao;
 
import adotego.modelos.Endereco;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
      
    private final Connection conn;

    public UsuarioDAO(Connection c) {
            conn = c;
    }
    
    public void save(Usuario pessoa) throws SQLException {
        String sql = "INSERT INTO Usuario" +
                        "(nome,email,telefone_fixo,telefone_celular," +
                        "data_nascimento,cpf,rua,cidade,bairro,numero ,uf,cep)" +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try(PreparedStatement pstm = conn.prepareStatement(sql)){	
                pstm.setString(1, pessoa.getNome());
                pstm.setString(2, pessoa.getEmail());
                pstm.setString(3, pessoa.getTelefone_fixo());
                pstm.setString(4, pessoa.getTelefone_celular());
                pstm.setDate(5, pessoa.getData_nascimento_sql());
                pstm.setString(6, pessoa.getCpf());
                pstm.setString(7, pessoa.getEndereco().getRua());
                pstm.setString(8, pessoa.getEndereco().getCidade());
                pstm.setString(9, pessoa.getEndereco().getBairro());
                pstm.setInt(10, pessoa.getEndereco().getNumero());
                pstm.setString(11, pessoa.getEndereco().getUf());
                pstm.setString(12, pessoa.getEndereco().getCep());
                pstm.execute();
        }

    }

    public Usuario find(int id) throws SQLException{
        Usuario usuario = new Usuario();
        Endereco end = new Endereco();
        String sql = "select * from Usuario where idUsuario = ? ";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.executeQuery();                
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone_fixo("telefone_fixo");
                    usuario.setTelefone_celular("telefone_celular");
                    usuario.setCpf("cpf");                    
                    usuario.setData_nascimento_from_SQL(rs.getDate(5));
                    end.setRua(rs.getString("rua"));
                    end.setCidade(rs.getString("cidade"));
                    end.setBairro(rs.getString("bairro"));
                    end.setNumero(rs.getInt("numero"));
                    end.setUf(rs.getString("uf"));
                    end.setCep(rs.getString("cep"));
                    usuario.setEndereco(end);
                        
                
                       
                }
            }    
        }
        return usuario;
    }

}
