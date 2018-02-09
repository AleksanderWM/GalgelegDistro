package galgeleg; // skal stå øverst

import java.rmi.*;

/**
 *
 * @author Julian
 */
public interface GalgeInterface extends Remote
{
    void nulstil()              throws java.rmi.RemoteException;
    void logStatus()            throws java.rmi.RemoteException;
    void gætBogstav(String bogstav)  throws java.rmi.RemoteException;
    boolean erSpilletSlut()     throws java.rmi.RemoteException;
    String outputTilKlient()    throws java.rmi.RemoteException;
  
}
