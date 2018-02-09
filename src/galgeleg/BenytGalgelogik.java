package galgeleg;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class BenytGalgelogik {

  public static void main(String[] args) throws MalformedURLException{
    URL url = new URL("http://ubuntu4.saluton.dk:9950/Galgelogik?wsdl");
		QName qname = new QName("http://galgeleg/", "GalgelogikImplService");
		Service service = Service.create(url, qname);
		GalgelogikI spil = service.getPort(GalgelogikI.class);
    Scanner scanner = new Scanner(System.in);
    System.out.println("hejsa, og velkommen til galgespillet.");
   
    spil.nulstil();
    
    while(!spil.erSpilletSlut()){
        String bogstav = scanner.nextLine();
        spil.gætBogstav(bogstav);
        System.out.println(spil.getSynligtOrd());
    }
    
    System.out.println(spil.getOrdet());
    
    }
}
