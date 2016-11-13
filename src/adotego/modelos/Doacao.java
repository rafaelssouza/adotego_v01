/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.modelos;

/**
 *
 * @author Rodrigo.Stuani
 */
public class Doacao {
    
    private int id;
    private double valor;
    
    public Doacao(){
        this.setId(0);
    }
    public Doacao(Double valor){
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
