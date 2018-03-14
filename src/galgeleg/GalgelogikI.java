/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
@WebService
/**
 *
 * @author aleks
 */
public interface GalgelogikI extends java.rmi.Remote {
  @WebMethod ArrayList<String> getBrugteBogstaver();
  @WebMethod String getSynligtOrd();
  @WebMethod String getOrdet();
          


  @WebMethod boolean erSpilletVundet();

  @WebMethod boolean erSpilletTabt();

  @WebMethod boolean erSpilletSlut();
    
  @WebMethod void nulstil();

  @WebMethod void opdaterSynligtOrd();

  @WebMethod void gætBogstav(String bogstav);
  
  @WebMethod int getPoints();

  @WebMethod void logStatus();
  @WebMethod Boolean login(String name, String pass) throws java.rmi.RemoteException;
  

    
}
