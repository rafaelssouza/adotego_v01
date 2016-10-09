package adotego.modelos;

public class Especie {
    private int id;
    private String nome;

    public Especie() {
    }
    public Especie(String nome){
        this.nome = nome;
    }
    public Especie(int idR, String nomeR) {
        this.id = idR;
        this.nome = nomeR;
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

    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nome=" + nome + '}';
    }

    
    
}
