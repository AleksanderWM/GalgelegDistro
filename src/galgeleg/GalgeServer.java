package galgeleg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class GalgeServer 
{
    public static void main(String[] args) throws RemoteException, MalformedURLException 
    {
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        
        GalgeInterface g = new Galgelogik();
        Naming.rebind("rmi://localhost/GalgeServer", g);
        System.out.println("Galgeserver opstartet");
        
    }
}
