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
		                qt += b.getQuantita();
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
		                qt += b.getQuantita();
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
		                qt += b.getQuantita();
		                b.setQuantita(qt);
		                System.out.println("QUANTITA TE: " + b.getQuantita());
		            }
	        	}
	            break;
	            
	        case 4:
	        	if(bevande.size() > 3) {
	        		for (int i = 0; i < bevande.size(); i++) {
			            if (bevande.get(3).getNome().equals(bevande.get(i).getNome())) {
			            	 int qt = scannerQt.nextInt();
			            	 qt += bevande.get(3).getQuantita();
				             bevande.get(3).setQuantita(qt);
				             System.out.println("QUANTITA: " + bevande.get(3).getQuantita());
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
		        	for (int i = 0; i < bevande.size(); i++) {
			            if (bevande.get(3).getNome().equals(bevande.get(i).getNome())) {
			            	int prezzo = scannerQt.nextInt();
			                bevande.get(3).setPrezzo(prezzo);
			                System.out.println("PREZZO " + bevande.get(3).getNome() +  ": " + bevande.get(3).getPrezzo());
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
	
	public ArrayList <BevandaFredda> aggiungiBevanda(ArrayList <BevandaFredda> bevande) {
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
			
			System.out.println(nome + " AGGIUNTO CON SUCCESSO!");
		}
		return bevande;
	}
	
	public ArrayList <BevandaFredda> rimuoviBevanda(ArrayList <BevandaFredda> bevande) {
		Scanner scannerRimuovi = new Scanner(System.in);
		System.out.println("Sei sicuro di voler rimuovere questa bevanda? (" + bevande.get(3).getNome() + ")\n0 PER RIMUOVERE:");	
		int scelta = scannerRimuovi.nextInt();
		
		if (scelta == 0) {
			System.out.println(bevande.get(3).getNome() + " RIMOSSA");
			bevande.remove(3);
		} else {
			System.out.println("RIMOZIONE FALLITA");
		}
		return bevande;
	}
	
	public void Statistiche(ArrayList <BevandaFredda> bevande) {
		for (BevandaFredda b : bevande) {
                System.out.print("\n[Bevanda: " + b.getNome() + ", prezzo: " + b.getPrezzo() + ", quantita: " + b.getQuantita() + "]");
        		System.out.println("\tTotale incassato: "+ b.getTotaleIncassato() + "€");
    	}
	}
		
		//METODI PER BEVANDE CALDE
		
	
		public ArrayList <BevandeCalde> quantitaBevandaCalda (ArrayList <BevandeCalde> bevande) {
			Scanner scannerQt = new Scanner(System.in);
			Scanner scannerScelta = new Scanner(System.in);
			
			System.out.println("AREA AMMINISTRATORE");
			if(bevande.size() > 3) {
			System.out.print("\nQuale bevanda vuoi aggiungere?\n1)CAFFE'\n2)CAPPUCCINO\n3)TE CALDO\n4)" + bevande.get(3).getNome());
				} else System.out.println("Quale bevanda vuoi aggiungere?\n1)CAFFE'\n2)CAPPUCCINO\n3)TE CALDO\n4)Non disponibile");
			
			int scelta = scannerScelta.nextInt();

		    switch (scelta) {
		        case 1:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("Caffe")) {
			                System.out.print("Quante cialde di caffè vuoi aggiungere? ");
			                int qt = scannerQt.nextInt();
			                qt += b.getQuantita();
			                b.setQuantita(qt);
			                System.out.println("QUANTITA CIALDE CAFFE': " + b.getQuantita());
			            }
		        	}
		            break;

		        case 2:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("Cappuccino")) {
			                System.out.print("Quante cialde di cappuccino vuoi aggiungere? ");
			                int qt = scannerQt.nextInt();
			                qt += b.getQuantita();
			                b.setQuantita(qt);
			                System.out.println("QUANTITA CIALDE CAPPUCCINO: " + b.getQuantita());
			            }
		        	}
		            break;

		        case 3:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("TeCaldo")) {
			                System.out.print("Quante bustine di Tè caldo vuoi aggiungere? ");
			                int qt = scannerQt.nextInt();
			                qt += b.getQuantita();
			                b.setQuantita(qt);
			                System.out.println("QUANTITA BUSTINE TE CALDO: " + b.getQuantita());
			            }
		        	}
		            break;
		            
		        case 4:
		        	if(bevande.size() > 3) {
		        		for (int i = 0; i < bevande.size(); i++) {
				            if (bevande.get(3).getNome().equals(bevande.get(i).getNome())) {
				            	 int qt = scannerQt.nextInt();
				            	 qt += bevande.get(3).getQuantita();
					             bevande.get(3).setQuantita(qt);
					             System.out.println("QUANTITA: " + bevande.get(3).getQuantita());
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
		
		public ArrayList <BevandeCalde> prezzoBevandaCalda (ArrayList <BevandeCalde> bevande) {
			Scanner scannerQt = new Scanner(System.in);
			Scanner scannerScelta = new Scanner(System.in);
			
			System.out.println("AREA AMMINISTRATORE");
			
			if(bevande.size() > 3) {
				System.out.println("Di quale bevanda vuoi cambiare il prezzo?\n1)Caffè\n2)Cappuccino\n3)Te Caldo\n4)" + bevande.get(3).getNome());
			} else System.out.println("Di quale bevanda vuoi cambiare il prezzo?\n1)Caffè\n2)Cappuccino\n3)Te Caldo\n4)Non disponibile");
			int scelta = scannerScelta.nextInt();

		    switch (scelta) {
		        case 1:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("Caffe")) {
			                System.out.print("Che prezzo vuoi inserire per il caffè? ");
			                int prezzo = scannerQt.nextInt();
			                b.setPrezzo(prezzo);
			                System.out.println("PREZZO CAFFE': " + b.getPrezzo());
			            }
		        	}
		            break;

		        case 2:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("Cappuccino")) {
			                System.out.print("Che prezzo vuoi inserire per il Cappuccino? ");
			                int prezzo = scannerQt.nextInt();
			                b.setPrezzo(prezzo);
			                System.out.println("PREZZO CAPPUCCINO: " + b.getPrezzo());
			            }
		        	}
		            break;

		        case 3:
		        	for (BevandeCalde b : bevande) {
			            if (b.getNome().equals("TeCaldo")) {
			                System.out.print("Che prezzo vuoi inserire per il Te caldo? ");
			                int prezzo = scannerQt.nextInt();
			                b.setPrezzo(prezzo);
			                System.out.println("PREZZO TE CALDO: " + b.getPrezzo());
			            }
		        	}
		            break;
		            
		        case 4:
			        if(bevande.size() > 3) {
			        	for (int i = 0; i < bevande.size(); i++) {
				            if (bevande.get(3).getNome().equals(bevande.get(i).getNome())) {
				            	int prezzo = scannerQt.nextInt();
				                bevande.get(3).setPrezzo(prezzo);
				                System.out.println("PREZZO " + bevande.get(3).getNome() +  ": " + bevande.get(3).getPrezzo());
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
		
		public ArrayList <BevandeCalde> aggiungiBevandaCalda (ArrayList <BevandeCalde> bevande) {
			if(bevande.size() < 4) {
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Inserire il nome della bevanda da aggiungere:");
				String nome = scanner.nextLine();
				
				System.out.print("Inserire il prezzo della bevanda da aggiungere:");
				double prezzo = scanner.nextDouble();
				
				System.out.print("Inserire la quantità della bevanda da aggiungere:");
				int quantita = scanner.nextInt();
				
				BevandeCalde bevanda = new BevandeCalde(nome, prezzo, quantita);
				bevande.add(bevanda);	
				
				System.out.println(nome + " AGGIUNTO CON SUCCESSO!");
			}
			return bevande;
		}
		
		public ArrayList <BevandeCalde> rimuoviBevandaCalda(ArrayList <BevandeCalde> bevande) {
			Scanner scannerRimuovi = new Scanner(System.in);
			System.out.println("Sei sicuro di voler rimuovere questa bevanda? (" + bevande.get(3).getNome() + ")\n0 PER RIMUOVERE:");	
			int scelta = scannerRimuovi.nextInt();
			
			if (scelta == 0) {
				System.out.println(bevande.get(3).getNome() + " RIMOSSA");
				bevande.remove(3);
			} else {
				System.out.println("RIMOZIONE FALLITA");
			}
			return bevande;
		}
		
		public void StatisticheCalda(ArrayList <BevandeCalde> bevande) {
			for (BevandeCalde b : bevande) {
	                System.out.print("\n[Bevanda: " + b.getNome() + ", prezzo: " + b.getPrezzo() + ", quantita: " + b.getQuantita() + "]");
	        		System.out.println("\tTotale incassato: "+ b.getTotaleIncassato() + "€");
	    	}
		}
}
