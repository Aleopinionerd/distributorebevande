package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class BevandaFredda {
	//ATTRIBUTI
	private String nome;
	private double prezzo;
	private int quantita = 3;
	private int bevandaOttenuta;
	private double totaleIncassato;
	private boolean esaurita = false;

	//COSTRUTTORI
	public BevandaFredda() {
		
	}
	
	public BevandaFredda(String nome, double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	//METODI GET E SET
	public String getNome() {
		return nome;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public double getTotaleIncassato() {
		return this.totaleIncassato;
	}
	
	public int getBevandaOttenuta() {
		return bevandaOttenuta;
	}
	
	public boolean getEsaurita () {
		return esaurita;
		
	}
	
	//ALTRI METODI
	
	public boolean effettuaVendita(double credito, int qt) {
		if (credito >= prezzo && quantita > 0) {
			quantita = (quantita - qt);
			totaleIncassato += (prezzo * qt);
			bevandaOttenuta += qt; //conteggio bevande ottenute
			if (quantita == 0) {
			esaurita = true;
			}// Aggiunge l'importo alla vendita totale
			return true; // Vendita riuscita
		} else {
			return false; // Vendita non riuscita
		}
	}
	
	public ArrayList <BevandaFredda> inserisciCredito(ArrayList <BevandaFredda> bevande) {
		//VARIABILI		
		double resto = 0;
		
		Scanner scannerContinua = new Scanner(System.in);
		int continua = 1; //scanner e variabile per continuare a scegliere bevande
		
		Scanner scannerCodice = new Scanner(System.in);
		int codiceInserito = 0; //scanner e variabile per il codice inserito

		Scanner scannerCredito = new Scanner(System.in);
		double creditoInserito = 0; //scanner e variabile per il credito inserito
		
		Scanner scannerQuantita = new Scanner(System.in);
		int qtDaAcquistare = 1;
		
		//INIZIO ISTRUZIONI
		System.out.print("\ninserire credito [1-10]: ");
		creditoInserito = scannerCredito.nextDouble(); //legge numero double (variabile per il credito inserito)
			if(creditoInserito >= 1 && creditoInserito <= 10) { //se il credito inserito è compreso tra 1 euro e 10 euro esegue il blocco
				System.out.print("Credito: " + creditoInserito);	
				do {
					System.out.println("\nSeleziona una bevanda: ");
					System.out.println(String.format("1. %s (€ %.2f)", bevande.get(0).nome, bevande.get(0).prezzo));
					System.out.println(String.format("2. %s (€ %.2f)", bevande.get(1).nome, bevande.get(1).prezzo));
					System.out.println(String.format("3. %s (€ %.2f)", bevande.get(2).nome, bevande.get(2).prezzo));
					if(bevande.size() > 3) {
						System.out.println(String.format("4. %s (€ %.2f)", bevande.get(3).nome, bevande.get(3).prezzo)); //stampa se ci sono più di tre bevande
					} else System.out.println("4. Non disponibile"); //altrimenti non disponibile
					
					codiceInserito = scannerCodice.nextInt(); //legge numero intero (variabile per il codice inserito)
					
					System.out.println("Quante bottiglie vuoi acquistare?");
					qtDaAcquistare = scannerQuantita.nextInt();		
					
					switch(codiceInserito) {
						case 1:
								for(BevandaFredda b : bevande) {
						           if (b.nome.equals("Acqua")) {
						        	   	if(creditoInserito >= (b.prezzo * qtDaAcquistare) && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
							        	   	System.out.print("hai scelto l'acqua.");
											System.out.print("\nBevanda erogata.");
											b.effettuaVendita(creditoInserito, qtDaAcquistare);
											resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda
											creditoInserito = resto; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											System.out.println("Resto: " + resto + "€"); //stampa resto
											break;
										}else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
							       	}
								}
							break;
							
						case 2:
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Cocacola")) {
									if(creditoInserito >= (b.prezzo * qtDaAcquistare) && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto la Coca-Cola.");
										System.out.print("\nBevanda erogata.");
										b.effettuaVendita(creditoInserito, qtDaAcquistare);
										resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda
										creditoInserito = resto; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta *= qtDaAcquistare; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										break;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									}
					            }
							}
							break;
							
						case 3:	
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Te")) {
									if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto il Tè.");
										System.out.print("\nBevanda erogata.");
										b.effettuaVendita(creditoInserito, qtDaAcquistare);
										resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda
										creditoInserito = resto; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta *= qtDaAcquistare; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										break;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									}
					            }
							}
							break;
						case 4:	
							if(bevande.size() > 3) {
								for(BevandaFredda b : bevande) {
						            if (b.nome.equals(bevande.get(3).nome)) {
										if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
											System.out.print("hai scelto il " + bevande.get(3).nome);
											System.out.print("\nBevanda erogata.");
											b.effettuaVendita(creditoInserito, qtDaAcquistare);
											resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda
											creditoInserito = resto; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											bevandaOttenuta *= qtDaAcquistare; //conteggio bevande ottenute
											System.out.println("Resto: " + resto + "€"); //stampa resto
											break;
										} else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
						            }
								}
							} else {
								System.out.print("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito; //restituisce il credito inserito non utilizzato
								continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
							}
							break;
						default:
							System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
							continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
					}
					System.out.println ("\nGrazie per aver usato il nostro distributore. Buona giornata");
				} while (continua == 0); //ripete finche "continua" è uguale a 0
			} else {
				resto = creditoInserito; //restituisce il credito inserito non utilizzato
				System.out.println("Resto: " + resto + "€"); //stampa resto
			}
			
		return bevande;
	}	
}