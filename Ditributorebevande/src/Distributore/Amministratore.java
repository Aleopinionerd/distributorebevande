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
		if(bevande.size() > 3) {
		System.out.print("\nQuale bevanda vuoi aggiungere?\n1)ACQUA\n2)COCACOLA\n3)TE\n4)" + bevande.get(3).getNome());
			} else System.out.println("Quale bevanda vuoi aggiungere?\n1)Acqua\n2)Cocacola\n3)Te\n4)Non disponibile");
		
		int scelta = scannerScelta.nextInt();

	    switch (scelta) {
	        case 1:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Acqua")) {
		                System.out.print("Quante bottiglie di acqua vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.setQuantita(qt);
		                System.out.println("QUANTITA ACQUA: " + b.getQuantita());
		            }
	        	}
	            break;

	        case 2:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Cocacola")) {
		                System.out.print("Quante lattine di Coca-Cola vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.setQuantita(qt);
		                System.out.println("QUANTITA COCA COLA: " + b.getQuantita());
		            }
	        	}
	            break;

	        case 3:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Te")) {
		                System.out.print("Quante bottiglie di Tè vuoi aggiungere? ");
		                int qt = scannerQt.nextInt();
		                b.setQuantita(qt);
		                System.out.println("QUANTITA TE: " + b.getQuantita());
		            }
	        	}
	            break;
	            
	        case 4:
	        	if(bevande.size() > 3) {
		        	for (BevandaFredda b : bevande) {
			            if (b.getNome().equals("Te")) {
			                System.out.print("Quante bottiglie di Tè vuoi aggiungere? ");
			                int qt = scannerQt.nextInt();
			                b.setQuantita(qt);
			                System.out.println("QUANTITA " + b.getNome() + ": " + b.getQuantita());
			            }
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
		
		if(bevande.size() > 3) {
			System.out.println("Di quale bevanda vuoi cambiare il prezzo?\n1)Acqua\n2)Cocacola\n3)Te\n4)" + bevande.get(3).getNome());
		} else System.out.println("Di quale bevanda vuoi cambiare il prezzo?\n1)Acqua\n2)Cocacola\n3)Te\n4)Non disponibile");
		int scelta = scannerScelta.nextInt();

	    switch (scelta) {
	        case 1:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Acqua")) {
		                System.out.print("Che prezzo vuoi inserire per l'acqua? ");
		                int prezzo = scannerQt.nextInt();
		                b.setPrezzo(prezzo);
		                System.out.println("PREZZO ACQUA: " + b.getPrezzo());
		            }
	        	}
	            break;

	        case 2:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Cocacola")) {
		                System.out.print("Che prezzo vuoi inserire per la Coca-cola? ");
		                int prezzo = scannerQt.nextInt();
		                b.setPrezzo(prezzo);
		                System.out.println("PREZZO COCA COLA: " + b.getPrezzo());
		            }
	        	}
	            break;

	        case 3:
	        	for (BevandaFredda b : bevande) {
		            if (b.getNome().equals("Te")) {
		                System.out.print("Che prezzo vuoi inserire per il Te? ");
		                int prezzo = scannerQt.nextInt();
		                b.setPrezzo(prezzo);
		                System.out.println("PREZZO TE: " + b.getPrezzo());
		            }
	        	}
	            break;
	            
	        case 4:
		        if(bevande.size() > 3) {
		        	for (BevandaFredda b : bevande) {
			            if (b.getNome().equals("Te")) {
			                System.out.print("Che prezzo vuoi inserire per il Te? ");
			                int prezzo = scannerQt.nextInt();
			                b.setPrezzo(prezzo);
			                System.out.println("PREZZO " + b.getNome() + ": " + b.getPrezzo());
			            }
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
		if(bevande.size() < 4) {
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
	}
	
	public void rimuoviBevanda(ArrayList <BevandaFredda> bevande) {
		if(bevande.size() == 4) {
			Scanner scannerScelta = new Scanner(System.in);
			
			if(bevande.size() > 3) {
				System.out.println("Quale bevanda vuoi rimuovere?\n1)Acqua\n2)Cocacola\n3)Te\n4)" + bevande.get(3).getNome());
			} else System.out.println("Quale bevanda vuoi rimuovere?\n1)Acqua\n2)Cocacola\n3)Te\n4)Non disponibile");
			int scelta = scannerScelta.nextInt();

		    switch (scelta) {
		        case 1:
		        	for (int i = 0; i < bevande.size(); i++) {
			            if (bevande.get(i).getNome().equals("Acqua")) {
			            	bevande.remove(bevande.get(i));
			                System.out.println("ACQUA RIMOSSA");
			            }
		        	}
		            break;

		        case 2:
		        	for (int i = 0; i < bevande.size(); i++) {
			            if (bevande.get(i).getNome().equals("Cocacola")) {
			            	bevande.remove(bevande.get(i));
			            	System.out.println("COCA COLA RIMOSSA");
			            }
		        	}
		            break;

		        case 3:
		        	for (int i = 0; i < bevande.size(); i++) {
			            if (bevande.get(i).getNome().equals("Te")) {
			            	bevande.remove(bevande.get(i));
			            	System.out.println("TE RIMOSSO");
			            }
		        	}
		            break;
		            
		        case 4:
			        if(bevande.size() > 3) {
			        	for (int i = 0; i < bevande.size(); i++) {
				            if (bevande.get(3).getNome().equals(bevande.get(i).getNome())) {
				            	bevande.remove(bevande.get(i));
				            	System.out.println(bevande.get(i).getNome() + " RIMOSSA");
				            }
			        	}
			        }
		            break;

		        default:
		            System.out.println("SCELTA ERRATA");
		            break;
		    }
		} else System.out.println("NESSUNA BEVANDA DA RIMUOVERE...");
	}
	
	public void Statistiche(ArrayList <BevandaFredda> bevande) {
		for (BevandaFredda b : bevande) {
                System.out.print("\n[Bevanda: " + b.getNome() + ", prezzo: " + b.getPrezzo() + ", quantita: " + b.getQuantita() + "]");
        		System.out.println("\tTotale incassato: "+ b.getTotaleIncassato() + "€");
    	}
		
		
		
	}
}
