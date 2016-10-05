 
package adotego.modelos;
 
public class Animal {
        private int id;
        private String nome;
	private String especie;
	private String raca;
	private String observacoes;
	private int idPessoa;
	private Situacao_enum situacao;
        
	public Animal() {
		
	}
	public Animal(int id, String especie, String raca, String observacao) {
		super();
		this.id = id;
		this.especie = especie;
		this.raca = raca;
		this.observacoes = observacao;
	}

	public Animal(int id,String nome, String especie, String raca, String observacao, int idP, Situacao_enum situacao) {
		super();
		this.id = id;
                this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.observacoes = observacao;
		this.idPessoa = idP;
                this.situacao = situacao;
	}

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
