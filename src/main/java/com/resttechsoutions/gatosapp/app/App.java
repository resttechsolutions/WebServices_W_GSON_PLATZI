package com.resttechsoutions.gatosapp.app;

import com.resttechsoutions.gatosapp.beans.Gatos;
import com.resttechsoutions.gatosapp.services.GatosService;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael Estrella
 */
public class App {

    public static void main(String[] args) throws IOException {
        int opcionMenu = -1;

        String[] botones = {
            "1. Ver gatos",
            "2. Ver favoritos",
            "3. Salir"
        };
        
        do {            
            String opcion = (String) JOptionPane
                    .showInputDialog(null, 
                            "Gaatitos Java", 
                            "Menu Principal", 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, 
                            botones, 
                            botones[0]);
            
            for (int i = 0; i < botones.length; i++) {
                if(opcion.equals(botones[i]))
                    opcionMenu = i;
            }
            
            switch(opcionMenu){
                case 0:
                    GatosService.verGatos();
                    break;
                case 1:
                    
                    GatosService.verFavoritos(new Gatos().getAPIKEY());
                    break;
                default:
                    break;
            }
        } while (opcionMenu != 1);
    }
}
