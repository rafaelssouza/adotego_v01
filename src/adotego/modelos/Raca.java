package adotego.modelos;

public class Raca {
    private int idRaca;
    private String nome;

    public Raca(int id,String nome) {
        this.idRaca = id;
        this.nome = nome;
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
    
    
}
