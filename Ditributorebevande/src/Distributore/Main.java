package Distributore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//VARIABILI
		Scanner scanner = new Scanner(System.in);
		Scanner scannerCode = new Scanner(System.in);
		//boolean admin = false, ciclo = false;
		
		int continua = 1;
		double resto = 0;
		
		BevandaFredda bevanda = new BevandaFredda(); //oggetto bevanda instanza di BevandaFredda
		
		//INIZIO CODICE		
				do {
					resto = bevanda.inserisciCredito(); //richiama il metodo inserisciCredito()
					System.out.print("\nINSERIRE 0 PER INSERIRE ALTRO CREDITO: ");
					continua = scanner.nextInt();
					System.out.println("Resto: " + resto + "€"); //stampa resto a fine ciclo
				} while (continua == 0); //ripete finché "continua" è uguale a 0
		scanner.close();
		scannerCode.close();
	}//FINE MAIN
	
	
	//METODI

	/*static boolean accessoAdmin() {
		Scanner scannerCode = new Scanner(System.in);
		int code = 4396, codice = 0; //code (codice amministratore) e codice (codice inserito dall'utente)
		boolean amministratore = false;
		
		codice = scannerCode.nextInt(); //legge un numero intero (codice inserito dall'utente)	

		if(codice == code) amministratore = true; //se i codici corrispondono, amministratore = true
		return amministratore;
	}*/
}

/*admin = accessoAdmin(); //richiama il metodo accessoAdmin()
if(admin) { // se admin è uguale a true
	System.out.println("AREA AMMINISTRATORE");
}else {*/
