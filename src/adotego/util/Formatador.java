/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.util;

/**
 *
 * @author tmichelini
 */
public class Formatador {
    
    
    public String formatarPrimeiraLetraMaiuscula(String palavra){
        char[] palavraArray = palavra.toCharArray();
        StringBuilder palavraFormatada = new StringBuilder();
        
        for(int c=0; c< palavraArray.length; c++){
            if(c==0)
                palavraFormatada.append(String.valueOf(palavraArray[c]).toUpperCase());
            else
                palavraFormatada.append(String.valueOf(palavraArray[c]).toLowerCase());
        }
        
        return palavraFormatada.toString();
    }
}
