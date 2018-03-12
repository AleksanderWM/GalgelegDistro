package Brugerautorisation.Rmi;

import Brugerautorisation.data.Diverse;
import Brugerautorisation.data.Bruger;
import java.rmi.Naming;

public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
//		Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

   // ba.sendGlemtAdgangskodeEmail("s114750", "Dette er en test, husk at skifte kode");
		//ba.ændrAdgangskode("s114750", "kode26v0ko", "qwerty12");
		Bruger b = ba.hentBruger("s114750", "qwerty12");
		System.out.println("Fik bruger = " + b);
		System.out.println("Data: " + Diverse.toString(b));
		// ba.sendEmail("jacno", "xxx", "Hurra det virker!", "Jeg er så glad");

		//Object ekstraFelt = ba.getEkstraFelt("s123456", "kode1xyz", "hobby");
		//System.out.println("Brugerens hobby er: " + ekstraFelt);

		//ba.setEkstraFelt("s123456", "kode1xyz", "hobby", "Tennis og programmering"); // Skriv noget andet her

		//String webside = (String) ba.getEkstraFelt("s123456", "kode1xyz", "webside");
		//System.out.println("Brugerens webside er: " + webside);
	}
}
