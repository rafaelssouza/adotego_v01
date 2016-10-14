package adotego.dao;
 
import adotego.modelos.Endereco;
import adotego.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
    Classe responsável pelo acesso aos dados do objeto Usuario no banco de dados.
    Possui os metodos de CREATE, REMOVE, UPDATE, DELETE
*/
public class UsuarioDAO {
    /*
        Objeto de conexão com todas as propriedades necessárias para o acesso 
        aos dados no banco.
    */  
    private final Connection conn;

    public UsuarioDAO(Connection c) {
            conn = c;
    }
    
    /*
        Metodos responsável por salvar um objeto java do tipo Usuario no banco
        de dados, especificamente na tabela Usuario.
    */
    public void save(Usuario pessoa) throws SQLException {
        String sql = "INSERT INTO Pessoa" +
                        "(nome,email,telefone_fixo,telefone_celular," +
                        "data_nascimento,cpf_cnpj,rua,cidade,bairro,numero ,uf,cep)" +
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
                pstm.setString(10, String.valueOf(pessoa.getEndereco().getNumero()));
                pstm.setString(11, pessoa.getEndereco().getUf());
                pstm.setString(12, pessoa.getEndereco().getCep());
                pstm.execute();
        }

    }

    /*
        Metodos responsável por buscar um usuario no bando de dados de acordo
        com o id passado como parametro
    */
    public Usuario find(int id) throws SQLException{
        Usuario usuario = new Usuario();
        Endereco end = new Endereco();
        String sql = "select * from Pessoa where idPessoa = ? ";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, id);
                ps.executeQuery();                
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    
                    usuario.setId(rs.getInt("idPessoa"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    usuario.setTelefone_celular(rs.getString("telefone_celular"));
                    usuario.setCpf(rs.getString("cpf_cnpj"));                    
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

    /*
        Método responsável por retornar todos os usuarios cadastrados no banco
        de dados
    */
    public List<Usuario> findAll() throws SQLException{
        String sql = "select * from Pessoa order by nome";
        List<Usuario> lista_usuarios = new ArrayList<>();
        try(PreparedStatement st = conn.prepareStatement(sql)){
            st.executeQuery();
            
            try(ResultSet rs = st.getResultSet()){
                while(rs.next()){
                    Usuario usuario = new Usuario();
                        usuario.setId(rs.getInt("idPessoa"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setTelefone_fixo(rs.getString("telefone_fixo"));
                        usuario.setTelefone_celular(rs.getString("telefone_celular"));
                        usuario.setCpf(rs.getString("cpf_cnpj"));   
                        usuario.setData_nascimento_from_SQL(rs.getDate("data_nascimento"));
                            usuario.setEndereco(new Endereco());
                            usuario.getEndereco().setCidade(rs.getString("cidade"));
                            usuario.getEndereco().setCep(rs.getString("cep"));
                            usuario.getEndereco().setBairro(rs.getString("bairro"));
                            usuario.getEndereco().setNumero(Integer
                                    .parseInt(rs.getString("numero")));
                            usuario.getEndereco().setUf(rs.getString("uf"));
                            usuario.getEndereco().setRua(rs.getString("rua"));
                        
                    lista_usuarios.add(usuario);
                }
            }
        }
        return lista_usuarios;
    }
    /*
        Metodos responsável por deletar um usuario no bando de dados de acordo
        com o id passado como parametro
    */
    public void delete(int id) throws SQLException{
        String sql = "delete from Pessoa where idPessoa = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
            
        }
    }

    public List<Usuario> findLikeName(String param) throws SQLException {
        String sql = "select * from Pessoa where nome like ? ";
        List<Usuario> lista = new ArrayList<>();
         try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "%"+param+"%");
            ps.execute();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                Usuario usuario = new Usuario();
                Endereco end = new Endereco();
                    usuario.setId(rs.getInt("idPessoa"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    usuario.setTelefone_celular(rs.getString("telefone_celular"));
                    usuario.setCpf(rs.getString("cpf_cnpj"));                    
                    usuario.setData_nascimento_from_SQL(rs.getDate(5));
                    end.setRua(rs.getString("rua"));
                    end.setCidade(rs.getString("cidade"));
                    end.setBairro(rs.getString("bairro"));
                    end.setNumero(rs.getInt("numero"));
                    end.setUf(rs.getString("uf"));
                    end.setCep(rs.getString("cep"));
                    usuario.setEndereco(end);
                lista.add(usuario);
                }
            }
            
        }
        return lista;
    }

    public List<Usuario> findLikeCpf(String param) throws SQLException {
        
        String sql = "select * from Pessoa where cpf_cnpj like ? ";
        List<Usuario> lista = new ArrayList<>();
         try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, param+"%");
            ps.execute();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                Usuario usuario = new Usuario();
                Endereco end = new Endereco();
                    usuario.setId(rs.getInt("idPessoa"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    usuario.setTelefone_celular(rs.getString("telefone_celular"));
                    usuario.setCpf(rs.getString("cpf_cnpj"));                    
                    usuario.setData_nascimento_from_SQL(rs.getDate(5));
                    end.setRua(rs.getString("rua"));
                    end.setCidade(rs.getString("cidade"));
                    end.setBairro(rs.getString("bairro"));
                    end.setNumero(rs.getInt("numero"));
                    end.setUf(rs.getString("uf"));
                    end.setCep(rs.getString("cep"));
                    usuario.setEndereco(end);
                lista.add(usuario);
                }
            }
            
        }
        return lista;
    }

    public List<Usuario> findLikeEmail(String str_pesquisa) throws SQLException {
         String sql = "select * from Pessoa where email like ? ";
        List<Usuario> lista = new ArrayList<>();
         try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "%"+str_pesquisa+"%");
            ps.executeQuery();
            
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                Usuario usuario = new Usuario();
                Endereco end = new Endereco();
                    usuario.setId(rs.getInt("idPessoa"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    usuario.setTelefone_celular(rs.getString("telefone_celular"));
                    usuario.setCpf(rs.getString("cpf_cnpj"));                    
                    usuario.setData_nascimento_from_SQL(rs.getDate(5));
                    end.setRua(rs.getString("rua"));
                    end.setCidade(rs.getString("cidade"));
                    end.setBairro(rs.getString("bairro"));
                    end.setNumero(rs.getInt("numero"));
                    end.setUf(rs.getString("uf"));
                    end.setCep(rs.getString("cep"));
                    usuario.setEndereco(end);
                lista.add(usuario);
                }
            }
            
        }
        return lista;
    }
    
    
}
