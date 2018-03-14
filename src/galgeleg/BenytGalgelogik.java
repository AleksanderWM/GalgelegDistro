package galgeleg;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class BenytGalgelogik {

  public static void main(String[] args) throws MalformedURLException, RemoteException{
    URL url = new URL("http://ubuntu4.saluton.dk:9952/Galgelogik?wsdl");
		QName qname = new QName("http://galgeleg/", "GalgelogikImplService");
		Service service = Service.create(url, qname);
		GalgelogikI spil = service.getPort(GalgelogikI.class);
    Scanner scanner = new Scanner(System.in);
    System.out.println("hejsa, og velkommen til galgespillet.");
    System.out.println("Log ind for at spille");
    String username = null;
    String password = null;
    Boolean loggedIn = false;
    if(!loggedIn){
        System.out.println("Indtast brugernavn:");
        username = scanner.nextLine();
        System.out.println("Indtast kodeord:");
        password = scanner.nextLine();
        spil.login(username, password);
    }

    
    while(!spil.erSpilletSlut()){
        System.out.println("Gæt på et bogstav, og tryk derefter enter");
        String bogstav = scanner.nextLine();
        spil.gætBogstav(bogstav);
        System.out.println(spil.getSynligtOrd());
    }
    
    System.out.println(spil.getOrdet());
    
    }
}
