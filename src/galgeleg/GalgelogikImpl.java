package galgeleg;

import brugerautorisation.transport.rmi.Brugeradmin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@WebService(endpointInterface = "galgeleg.GalgelogikI")
public class GalgelogikImpl implements GalgelogikI {
    
    

    private galgeObject galObj;
    
    public GalgelogikImpl() {
        
        galObj = new galgeObject();
        nulstil();
    }
    

    @Override
    public int getPoints(){
        return galObj.getPoints();
    }
    public void clearPoints(){
        galObj.clearPoints();
    }
    
    @Override
    public void nulstil() {
        getWordsFromDR();
        galObj.getBrugteBogstaver().clear();
        galObj.setAntalForkerteBogstaver(0);
        //Nulstiller points i terminal version.
        galObj.setPoints(0);
        galObj.setErSpilletVundet(false);
        galObj.setErSpilletTabt(false);
        galObj.setOrdet(galObj.getMuligeOrd().get(new Random().nextInt(galObj.getMuligeOrd().size())));
        opdaterSynligtOrd();
    }
    
    
    @Override
    public void opdaterSynligtOrd() { 
        galObj.clearSynligtOrd();
        galObj.setErSpilletVundet(true);
        for (int n = 0; n < getOrdet().length(); n++) {
            String bogstav = getOrdet().substring(n, n + 1);
            if (galObj.getBrugteBogstaver().contains(bogstav)) {
                galObj.setSynligtOrd(bogstav);
            } else {
                galObj.setSynligtOrd("*");
                galObj.setErSpilletVundet(false);
            }
        }
    }
    
    @Override
    public void gætBogstav(String bogstav) {
        if (bogstav.length() != 1) return;
        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (getOrdet().contains(bogstav)) return;
        if (erSpilletVundet() || erSpilletTabt()) return;
        
        galObj.setBrugteBogstaver(bogstav);
        
        if (getOrdet().contains(bogstav)) {
            galObj.setErSidsteBogstavKorrekt(true);
            System.out.println("Bogstavet var korrekt: " + bogstav);
            galObj.setPoints(1);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            galObj.setErSidsteBogstavKorrekt(false);
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            galObj.setAntalForkerteBogstaver(1);
            if (galObj.getAntalForkerteBogstaver() > 6) {
                galObj.setErSpilletTabt(true);
            }
        }
        opdaterSynligtOrd();
    }
    
    @Override
    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + galObj.getOrdet());
        System.out.println("- synligtOrd = " + galObj.getSynligtOrd());
        System.out.println("- forkerteBogstaver = " + galObj.getAntalForkerteBogstaver());
        System.out.println("- brugeBogstaver = " + galObj.getBrugteBogstaver());
        if (galObj.getErSpilletTabt()) System.out.println("- SPILLET ER TABT");
        if (galObj.getErSpilletVundet()) System.out.println("- SPILLET ER VUNDET");
        System.out.println("---------- ");
    }
    
    
    
    public String hentUrl(String url) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            StringBuilder sb = new StringBuilder();
            String linje = br.readLine();
            while (linje != null) {
                sb.append(linje + "\n");
                linje = br.readLine();
            }
            return sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(GalgelogikImpl.class.getName()).log(Level.SEVERE, "Error reading from URL", ex);
        }
        return "Error";
    }
    
    @Override
    public ArrayList<String> getBrugteBogstaver() {
        return galObj.getBrugteBogstaver();
    }
    
    @Override
    public String getSynligtOrd() {
        return galObj.getSynligtOrd();
    }
    
    @Override
    public String getOrdet() {
        return galObj.getOrdet();
        
    }
    
    public int getAntalForkerteBogstaver() {
        return galObj.getAntalForkerteBogstaver();
    }
    
    public boolean erSidsteBogstavKorrekt() {
        return galObj.getErSidsteBogstavKorrekt();
    }
    
    @Override
    public boolean erSpilletVundet() {
        return galObj.getErSpilletVundet();
    }
    
    @Override
    public boolean erSpilletTabt() {
        return galObj.getErSpilletTabt();
    }

    @Override
    public boolean erSpilletSlut() {
        return galObj.getErSpilletTabt() || galObj.getErSpilletVundet();
    }
    
    public void getWordsFromDR() {
        String data = hentUrl("https://dr.dk");
        data = data.substring(data.indexOf("<body")). // fjern headere
                replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                replaceAll("&#198;", "æ"). // erstat HTML-tegn
                replaceAll("&#230;", "æ"). // erstat HTML-tegn
                replaceAll("&#216;", "ø"). // erstat HTML-tegn
                replaceAll("&#248;", "ø"). // erstat HTML-tegn
                replaceAll("&oslash;", "ø"). // erstat HTML-tegn
                replaceAll("&#229;", "å"). // erstat HTML-tegn
                replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                replaceAll(" [a-zæøå] "," "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] "," "); // fjern 2-bogstavsord
        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        galObj.getMuligeOrd().clear();
        HashSet<String> set = new HashSet<String>(Arrays.asList(data.split(" ")));
        galObj.getMuligeOrd().addAll(set);
        //Fjernet element på index 0 da dette er " ".
        galObj.getMuligeOrd().remove(0);
        System.out.println("muligeOrd = " + galObj.getMuligeOrd());
        
    }
    
    
    @Override
    public Boolean login(String username, String password) throws RemoteException{
        Brugeradmin ba;
        try {
            ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
            ba.hentBruger(username, password);
            return true;
        } catch (NotBoundException ex) {
            Logger.getLogger(GalgelogikImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GalgelogikImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
	}

    



    }

   
    

