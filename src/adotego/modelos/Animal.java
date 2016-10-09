 
package adotego.modelos;
 
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Animal {
        private int id;
        private String nome;
	
        private Calendar data_entrada;
	private Porte_enum porte;
	private String descricao;
	private int idPessoa;
	private Situacao_enum situacao;
        private Especie especie;
        private Raca  raca;

        public Animal() {

        }

        public Animal(String nome, Calendar instance, Especie especie, Raca raca,
                String descricao, Porte_enum porte) {
            this.nome = nome;
            this.porte = porte;
            this.descricao = descricao;
            this.data_entrada = instance;
            this.especie =especie;
            this.raca =raca;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Porte_enum getPorte() {
            return porte;
        }

        public void setPorte(Porte_enum porte) {
            this.porte = porte;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getIdPessoa() {
            return idPessoa;
        }

        public void setIdPessoa(int idPessoa) {
            this.idPessoa = idPessoa;
        }

        public Situacao_enum getSituacao() {
            return situacao;
        }

        public void setSituacao(Situacao_enum situacao) {
            this.situacao = situacao;
        }

        public Calendar getData_entrada() {
            return data_entrada;
        }

        public void setData_entrada(Calendar data_entrada) {
            this.data_entrada = data_entrada;
        }

        public Especie getEspecie() {
            return especie;
        }

        public void setEspecie(Especie especie) {
            this.especie = especie;
        }

        public Raca getRaca() {
            return raca;
        }

        public void setRaca(Raca raca) {
            this.raca = raca;
        }

      

        
        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return "Animal{" + "id=" + id + ", nome=" + nome + ", data_entrada="
                    + sdf.format(getData_entrada().getTime()) 
                    + ", porte=" + porte.toString() + 
                    ", descricao=" + descricao + ", idPessoa=" + idPessoa 
                    + ", situacao=" + situacao.toString()
                    + "\nEspecie = "+especie+'}';
        }
        
        
        
        public java.sql.Date getData_entradaSQL() {
            return new java.sql.Date(this.getData_entrada().getTime().getTime());
        }
	
        public void setData_nascimento_from_SQL(java.sql.Date date){
            java.util.Date date_util = new java.util.Date(date.getTime());                  
            Calendar cal = Calendar.getInstance();
            cal.setTime(date_util);
            this.setData_entrada(cal);
        }
        
        public void setPorte_com_string(String porte){
            switch(porte){
                case "PEQUENO": this.setPorte(Porte_enum.PEQUENO);
                case "MEDIO": this.setPorte(Porte_enum.MEDIO);
                case "GRANDE": this.setPorte(Porte_enum.GRANDE);
                
//nao deveria acontecer
                default: this.setPorte(Porte_enum.MEDIO);
            }
        }

    private void setSituacao_com_string() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
