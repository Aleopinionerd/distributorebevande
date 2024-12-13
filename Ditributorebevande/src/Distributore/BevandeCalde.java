package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class BevandeCalde {

	private String nome;
	private double prezzo;
	private int quantita;
	private double totaleIncassato;
	
	public String getNome() {
	return nome;
	
}
	public int getQuantita() {
		return quantita;
		
	}
	public double getPrezzo() {
		return prezzo;
	}

	

	// Costruttore
	public BevandeCalde(String nome, double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.totaleIncassato = 0;
	}

	public BevandeCalde() {
	}

	// Metodo per effettuare la vendita della bevanda
	public boolean effettuaVendita(double credito) {
		if (credito >= prezzo && quantita > 0) {
			quantita--; // Riduce la quantità disponibile della bevanda
			totaleIncassato += prezzo; // Aggiunge l'importo alla vendita totale
			return true; // Vendita riuscita
		} else {
			return false; // Vendita non riuscita
		}
	}

	// Metodo per stampare i dettagli della bevanda calda
	public void stampaDettagli() {
		System.out.println("\nBevanda: " + nome);
		System.out.println("Prezzo: €" + prezzo);
		System.out.println("Quantità disponibile: " + quantita);
		System.out.println("Con bicchiere e bastoncino inclusi.");
	}

	// Metodo per inserire il credito e scegliere una bevanda
	public void inserisciCreditoCalda(ArrayList <BevandeCalde> bevande) {
        Scanner scannerCodice = new Scanner(System.in);
        Scanner scannerCredito = new Scanner(System.in);
        Scanner scannerContinua = new Scanner(System.in);

        double creditoInserito;
        int scelta = 0, continua = 0;
        double resto = 0;

        // Crea le bevande disponibili
  

        System.out.println("\nInserire credito [1-10]:");
        creditoInserito = scannerCredito.nextDouble();

        if (creditoInserito >= 1 && creditoInserito <= 10) {
            do {
                System.out.println("\nSeleziona una bevanda: ");
                System.out.println("1. " + nome + " (€" + prezzo + ")");
                System.out.println("2. " + nome + " (€" + prezzo + ")");
                System.out.println("3. " + nome + " (€" + prezzo + ")");
                System.out.print("Inserisci il numero corrispondente: ");
                scelta = scannerCodice.nextInt();

                // Selezione della bevanda in base alla scelta
                switch (scelta) {
                    case 1:
                    	for (BevandeCalde b : bevande) {
                    		if (b.nome.equalsIgnoreCase("Caffe")) {
                        if (creditoInserito >= b.prezzo && b.quantita > 0) {
                            b.effettuaVendita(creditoInserito);
                            resto = creditoInserito - b.prezzo;
                            System.out.println("Hai scelto il Caffè.");
                            b.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= b.prezzo;
                            System.out.print("\n" + b.quantita + " rimanenti...");
                            System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
							continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
							System.out.println("Resto: " + resto + "€"); //stampa resto
							b.totaleIncassato += b.prezzo;
                            
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                            continua = 1;
                        }
                    		}
                    	else System.out.println ("Bevanda non disponibile");
                }
                        break;

                    case 2:
                    	for (BevandeCalde b : bevande) {
                    		if (b.nome.equalsIgnoreCase("Cappuccino")) {
                        if (creditoInserito >= b.prezzo && b.quantita > 0) {
                            b.effettuaVendita(creditoInserito);
                            resto = creditoInserito - b.prezzo;
                            System.out.println("Hai scelto il Cappuccino.");
                            b.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= b.prezzo;
                            System.out.print("\n" + b.quantita + " rimanenti...");
                            System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
							continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
							System.out.println("Resto: " + resto + "€"); //stampa resto
							b.totaleIncassato += b.prezzo;
                            
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                            continua = 1;
                        }
                    		}
                    		else System.out.println ("Bevanda non disponibile");
            }
                        break;

                    case 3:
                    	for (BevandeCalde b : bevande) {
                    		if (b.nome.equalsIgnoreCase("TeCaldo")) {
                        if (creditoInserito >= b.prezzo && b.quantita > 0) {
                            b.effettuaVendita(creditoInserito);
                            resto = creditoInserito - b.prezzo;
                            System.out.println("Hai scelto il Tè caldo.");
                            b.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= b.prezzo;
                            System.out.print("\n" + b.quantita + " rimanenti...");
                            System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
							continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
							System.out.println("Resto: " + resto + "€"); //stampa resto
							b.totaleIncassato += b.prezzo;
                            
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                            continua = 1;
                        }
                    		}
                    		else System.out.println ("Bevanda non disponibile");
        }
                        break;
                    case 4:
                    	if (bevande.size ()>3) {
                    		for (BevandeCalde b : bevande) {
                    			 if (b.nome.equals(bevande.get(3).nome)) {
                    				 if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
											System.out.print("hai scelto" + bevande.get(3).getNome());
											System.out.print("\nBevanda erogata.");
											resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
											creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
											b.quantita--; //decremento quantita bevanda
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											System.out.println("Resto: " + resto + "€"); //stampa resto
											b.totaleIncassato += b.prezzo;
										} else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
                    			 }
                    		}
                    	}
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }

	// Chiedi se l'utente vuole continuare
	System.out.print("\nVuoi continuare? (0 per continuare, 1 per uscire): ");continua=scannerContinua.nextInt();
}
            while(continua==0); // Ripete finché l'utente vuole continuare
}else{
	System.out.println("Credito non valido.");
	}
        System.out.println("Resto finale: "+resto+"€");}}
