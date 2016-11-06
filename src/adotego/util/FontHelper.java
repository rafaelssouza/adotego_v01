/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adotego.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmichelini
 */
public class FontHelper {
  
  
    public Font getLatoRegular(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Regular.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Regular.ttf")));
            
            return novaFonte;
        } catch (FontFormatException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
      public Font getLatoLight(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Light.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Light.ttf")));
            
            return novaFonte;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
      
      public Font getLatoBold(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Bold.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/Lato-Bold.ttf")));
            
            return novaFonte;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
      
      
    public Font getRobotoSlabLight(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Light.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Light.ttf")));
            
            return novaFonte;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
      
    public Font getRobotoSlabThin(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Thin.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Thin.ttf")));
            
            return novaFonte;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }  
    
     public Font getRobotoSlabRegular(float size) {
        
    
        try {
            Font novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Regular.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fontes/RobotoSlab-Regular.ttf")));
            
            return novaFonte;
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(FontHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }  
    
}
