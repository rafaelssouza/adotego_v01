package adotego;

import adotego.modelos.Animal;
 
import adotego.modelos.Porte_enum;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)   {
        try {
            new adotego.controller.AnimalController().delete(1);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
}
