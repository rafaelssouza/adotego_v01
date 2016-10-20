package adotego.modelos;

import java.util.Calendar;

public class Adocao {
    private int id;
    private Usuario usuario;
    private Animal animal;
    private double valor;
    private Calendar data;

    public Adocao() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

   

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
     public void setData_from_SQL(java.sql.Date date){
            java.util.Date date_util = new java.util.Date(date.getTime());                  
            Calendar cal = Calendar.getInstance();
            cal.setTime(date_util);
            this.setData(cal);
    }
    
    public java.sql.Date getData_entradaSQL() {
            return new java.sql.Date(this.getData().getTime().getTime());
    }
}
