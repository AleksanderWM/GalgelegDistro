/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;


import javax.xml.ws.Endpoint;

/**
 *
 * @author aleks
 */
public class GalgeServer {
    public static void main(String[] arg) throws Exception
	{
		GalgelogikImpl g = new GalgelogikImpl();
                
		Endpoint.publish("http://[::]:9952/Galgelogik", g);		
    
}
}
