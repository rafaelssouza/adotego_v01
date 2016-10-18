package adotego.modelos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Usuario {
    private Integer id;
	private String nome;
        private String email;
	private String telefone_fixo;
        private String telefone_celular;
        private Calendar data_nascimento;
	private String cpf;
        private Endereco endereco;

        public Usuario() {
        }

        public Usuario(Integer id, String nome, String email, String telefone_fixo, String telefone_celular, Calendar data_nascimento, String cpf) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.telefone_fixo = telefone_fixo;
            this.telefone_celular = telefone_celular;
            this.data_nascimento = data_nascimento;
            this.cpf = cpf; 
        }

        public Usuario(String nome, String email, String telefone_fixo, String telefone_celular, Calendar data_nascimento, String cpf, Endereco endereco) {
            this.nome = nome;
            this.email = email;
            this.telefone_fixo = telefone_fixo;
            this.telefone_celular = telefone_celular;
            this.data_nascimento = data_nascimento;
            this.cpf = cpf;
            this.endereco = endereco;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getData_nascimento_sql() {
        System.out.println(this.getData_nascimento());
        return new java.sql.Date(this.getData_nascimento().getTime().getTime());
    }

    public void setData_nascimento_from_SQL(java.sql.Date date){
        java.util.Date date_util = new java.util.Date(date.getTime());                  
        Calendar cal = Calendar.getInstance();
        cal.setTime(date_util);
        this.setData_nascimento(cal);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Usuario{" + "id=" + id + ", \nnome=" + nome + ", email=" 
                + email + ", \ntelefone_fixo=" + telefone_fixo
                + ", telefone_celular=" + telefone_celular + ", \ndata_nascimento="
                + sdf.format(data_nascimento.getTime()) + ", cpf=" + cpf 
                + ", \nendereco=" + endereco + '}';
    }

    public boolean isValid(){
    
        
        return !(this.getNome() ==null
                ||this.getCpf() == null
                || this.getData_nascimento() == null
                || this.getEmail() == null
                || this.getTelefone_celular() == null
                || this.getTelefone_fixo() == null
                || this.getEndereco().isValid());
    }
      
}
