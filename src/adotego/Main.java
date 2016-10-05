package adotego;

import adotego.modelos.Animal;
 
import adotego.modelos.Porte_enum;
import adotego.modelos.Situacao_enum;
import adotego.modelos.Usuario;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {
        Animal findById = new adotego.controller.AnimalController().find(1);
        
        System.out.println(findById);
    }
    
    public static void testInsert(){
        Animal animal = new Animal();
            animal.setNome("Nica");
            animal.setDescricao("bem velho e gordo");
            animal.setPorte(Porte_enum.PEQUENO);
            animal.setData_entrada(Calendar.getInstance());
            animal.setSituacao(Situacao_enum.ADOTADO);
            
        try {
            new adotego.controller.AnimalController().save(animal);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
