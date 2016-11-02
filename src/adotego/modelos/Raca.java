package adotego.modelos;

public class Raca {
    private int idRaca;
    private String nome;
    private Especie especie;

    public Raca(String nome) {
        this.nome = nome;
    }

    public Raca(String nome, Especie especie) {
        this.nome = nome;
        this.especie = especie;
    }

    
    public Raca(int id,String nome) {
        this.idRaca = id;
        this.nome = nome;
    }

    public Raca(int idRaca, String nome, Especie especie) {
        this.idRaca = idRaca;
        this.nome = nome;
        this.especie = especie;
    }

   
    public Raca() {
    }

    public int getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Raca{" + "idRaca=" + idRaca + ", nome=" + nome + ", especie=" + especie + '}';
    }
    
    
    
    
}
