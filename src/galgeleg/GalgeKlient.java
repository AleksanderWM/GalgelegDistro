/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class GalgeKlient 
{
    public static void main(String[] args) throws Exception 
    {
        
        GalgeInterface spil = (GalgeInterface) Naming.lookup("rmi://localhost:1099/GalgeServer");
        //Galgelogik spil = new Galgelogik(); // ændr således at logik udføres fra server
        
        boolean aktiv = true;
        String gæt;
        Scanner tastatur = new Scanner(System.in);
        
        
        
        while (aktiv)
        {
            System.out.println("Indtast bogstav");
            gæt = tastatur.next();
            spil.gætBogstav(gæt);   
            System.out.println(spil.outputTilKlient());
            spil.logStatus();       
            System.out.println(spil.outputTilKlient());    
            if (spil.erSpilletSlut()) aktiv = false;
        }
      
        System.out.println("Spillet afsluttes/Forbindelse til server lukkes");
       
    }
}
