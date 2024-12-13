package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class Amministratore {
	
	public Amministratore() {
	}
	
	public boolean accessoAdmin() {
		Scanner scannerCode = new Scanner(System.in);
		int code = 1234, codice = 0; //code (codice amministratore) e codice (codice inserito dall'utente)
		boolean amministratore = false;
		
		System.out.print("INSERIRE CODICE ADMIN:");
		codice = scannerCode.nextInt(); //legge un numero intero (codice inserito dall'utente)	

		if(codice == code) amministratore = true; //se i codici corrispondono, amministratore = true	
		return amministratore;
	}
	
	public ArrayList <BevandaFredda> quantitaBevanda(ArrayList <BevandaFredda> bevande) {
		Scanner scannerQt = new Scanner(System.in);
		Scanner scannerScelta = new Scanner(System.in);
		
		System.out.println("AREA AMMINISTRATORE");
		
		System.out.println("Quale bevanda vuoi aggiungere?\n1)Acqua\n2)Cocacola\n3)Te");
		int scelta = scannerScelta.nextInt();

	    switch (scelta) {
	        case 1:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Acqua")) {
		                System.out.print("Quante bottiglie di acqua vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.quantita += qt;
		            }
	        	}
	            break;

	        case 2:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Cocacola")) {
		                System.out.print("Quante lattine di Coca-Cola vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.quantita += qt;
		            }
	        	}
	            break;

	        case 3:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Te")) {
		                System.out.print("Quante bottiglie di Tè vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.quantita += qt;
		            }
	        	}
	            break;

	        default:
	            System.out.println("SCELTA ERRATA");
	            break;
	    }

	    return bevande;
	}
	
	public ArrayList <BevandaFredda> prezzoBevanda(ArrayList <BevandaFredda> bevande) {
		Scanner scannerQt = new Scanner(System.in);
		Scanner scannerScelta = new Scanner(System.in);
		
		System.out.println("AREA AMMINISTRATORE");
		
		System.out.println("Di quale bevanda vuoi cambiare il prezzo?\n1)Acqua\n2)Cocacola\n3)Te");
		int scelta = scannerScelta.nextInt();

	    switch (scelta) {
	        case 1:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Acqua")) {
		                System.out.print("Che prezzo vuoi inserire per l'acqua? ");
		                int prezzo = scannerQt.nextInt();
		                b.prezzo = prezzo;
		            }
	        	}
	            break;

	        case 2:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Cocacola")) {
		                System.out.print("Che prezzo vuoi inserire per la Coca-cola? ");
		                int prezzo = scannerQt.nextInt();
		                b.prezzo = prezzo;
		            }
	        	}
	            break;

	        case 3:
	        	for (BevandaFredda b : bevande) {
		            if (b.nome.equals("Te")) {
		                System.out.print("Che prezzo vuoi inserire per il Te? ");
		                int prezzo = scannerQt.nextInt();
		                b.prezzo = prezzo;
		            }
	        	}
	            break;

	        default:
	            System.out.println("SCELTA ERRATA");
	            break;
	    }
	    return bevande;
	}
	
	public void aggiungiBevanda(ArrayList <BevandaFredda> bevande) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Inserire il nome della bevanda da aggiungere:");
		String nome = scanner.nextLine();
		
		System.out.print("Inserire il prezzo della bevanda da aggiungere:");
		double prezzo = scanner.nextDouble();
		
		System.out.print("Inserire la quantità della bevanda da aggiungere:");
		int quantita = scanner.nextInt();
		
		BevandaFredda bevanda = new BevandaFredda(nome, prezzo, quantita);
		bevande.add(bevanda);	
	}
	
	public void Statistiche(ArrayList <BevandaFredda> bevande) {
		for (BevandaFredda b : bevande) {
                System.out.print("\n[Bevanda: " + b.nome + ", prezzo: " + b.prezzo + ", quantita: " + b.quantita + "]");
        		System.out.println("\tTotale incassato: "+ b.totaleIncassato + "€");
    	}
		
		
		
	}
}
