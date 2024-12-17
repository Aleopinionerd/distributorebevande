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
	
	//ALTRI METODI
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
					System.out.println("1. Acqua (€1)");
					System.out.println("2. Coca-Cola (€2)");
					System.out.println("3. Tè (€1.50)");
					if(bevande.size() > 3) {
						System.out.println("4. "+ bevande.get(3).nome + " (€" + bevande.get(3).prezzo + ")"); //stampa se ci sono più di tre bevande
					} else System.out.println("4. Non disponibile"); //altrimenti non disponibile
					
					codiceInserito = scannerCodice.nextInt(); //legge numero intero (variabile per il codice inserito)
					switch(codiceInserito) {
						case 1:
							System.out.println("Quante bottiglie di acqua vuoi acquistare?");
							qtDaAcquistare = scannerQuantita.nextInt();		
							for(BevandaFredda b : bevande) {
						           if (b.nome.equals("Acqua") && qtDaAcquistare == 1) {
						        	   	if(creditoInserito >= b.prezzo && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
							        	   	System.out.print("hai scelto l'acqua.");
											System.out.print("\nBevanda erogata.");
											resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
											creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
											b.quantita--; //decremento quantita bevanda
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											bevandaOttenuta++; //conteggio bevande ottenute
											System.out.println("Resto: " + resto + "€"); //stampa resto
											b.totaleIncassato += b.prezzo; //totale incassato incrementato del prezzo della bevanda scelta
											break;
										}else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
							       	} else if(b.nome.equals("Acqua") && qtDaAcquistare != 1){		
							       		if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
								       		System.out.print("hai scelto l'acqua.");
											System.out.print("\n" + qtDaAcquistare + " Bevande erogate.");
											resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda * numero bevande acquistate
											creditoInserito -= (b.prezzo * qtDaAcquistare); //sottrae a creditoInserito il prezzo della bevanda * numero bevande acquistate(utile nel caso successivamente si ricalcoli il resto)
											b.quantita -= qtDaAcquistare; //decremento quantita bevanda
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											bevandaOttenuta += qtDaAcquistare; //conteggio bevande ottenute
											System.out.println("Resto: " + resto + "€"); //stampa resto
											b.totaleIncassato += (b.prezzo * qtDaAcquistare); //totale incassato incrementato del prezzo della bevanda scelta
											break;
							       		} else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
							       	}
								}
							break;
							
						case 2:
							System.out.println("Quante bottiglie di acqua vuoi acquistare?");
							qtDaAcquistare = scannerQuantita.nextInt();		
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Cocacola") && qtDaAcquistare == 1) {
									if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto la Coca-Cola.");
										System.out.print("\nBevanda erogata.");
										resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
										creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										b.quantita--; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta++; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += b.prezzo; //totale incassato incrementato del prezzo della bevanda scelta
										break;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									}
					            } else if(b.nome.equals("Cocacola") && qtDaAcquistare != 1){
					            	if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
							       		System.out.print("hai scelto la Coca-Cola.");
										System.out.print("\n" + qtDaAcquistare + " Bevande erogate.");
										resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda * numero bevande acquistate
										creditoInserito -= (b.prezzo * qtDaAcquistare); //sottrae a creditoInserito il prezzo della bevanda  * numero bevande acquistate (utile nel caso successivamente si ricalcoli il resto)
										b.quantita -= qtDaAcquistare; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta += qtDaAcquistare; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += (b.prezzo * qtDaAcquistare); //totale incassato incrementato del prezzo della bevanda scelta
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
							System.out.println("Quante bottiglie di acqua vuoi acquistare?");
							qtDaAcquistare = scannerQuantita.nextInt();		
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Te") && qtDaAcquistare == 1) {
									if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto il Tè.");
										System.out.print("\nBevanda erogata.");
										resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
										creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										b.quantita--; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta++; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += b.prezzo; //totale incassato incrementato del prezzo della bevanda scelta
										break;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									}
					            } else if(b.nome.equals("Te") && qtDaAcquistare != 1){
					            	if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
							       		System.out.print("hai scelto il Tè.");
										System.out.print("\n" + qtDaAcquistare + " Bevande erogate.");
										resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda * numero bevande acquistate
										creditoInserito -= (b.prezzo * qtDaAcquistare); //sottrae a creditoInserito il prezzo della bevanda  * numero bevande acquistate (utile nel caso successivamente si ricalcoli il resto)
										b.quantita -= qtDaAcquistare; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta += qtDaAcquistare; //conteggio bevande ottenute
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += (b.prezzo * qtDaAcquistare); //totale incassato incrementato del prezzo della bevanda scelta
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
							System.out.println("Quante bottiglie di acqua vuoi acquistare?");
							qtDaAcquistare = scannerQuantita.nextInt();		
							if(bevande.size() > 3) {
								for(BevandaFredda b : bevande) {
						            if (b.nome.equals(bevande.get(3).nome) && qtDaAcquistare == 1) {
										if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
											System.out.print("hai scelto il " + bevande.get(3).nome);
											System.out.print("\nBevanda erogata.");
											resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
											creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
											b.quantita--; //decremento quantita bevanda
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											bevandaOttenuta++; //conteggio bevande ottenute
											System.out.println("Resto: " + resto + "€"); //stampa resto
											b.totaleIncassato += b.prezzo; //totale incassato incrementato del prezzo della bevanda scelta
											break;
										} else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
						            } else if(b.nome.equals(bevande.get(3).nome) && qtDaAcquistare != 1){
						            	if(creditoInserito >= (b.prezzo * qtDaAcquistare)  && b.quantita >= qtDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
								       		System.out.print("hai scelto: " + b.nome);
											System.out.print("\n" + qtDaAcquistare + " Bevande erogate.");
											resto = creditoInserito - (b.prezzo * qtDaAcquistare); //resto = credito inserito - prezzo bevanda  * numero bevande acquistate
											creditoInserito -= (b.prezzo * qtDaAcquistare); //sottrae a creditoInserito il prezzo della bevanda  * numero bevande acquistate (utile nel caso successivamente si ricalcoli il resto)
											b.quantita -= qtDaAcquistare; //decremento quantita bevanda
											System.out.print("\n" + b.quantita + " rimenenti...");
											System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
											continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
											bevandaOttenuta += qtDaAcquistare; //conteggio bevande ottenute
											System.out.println("Resto: " + resto + "€"); //stampa resto
											b.totaleIncassato += (b.prezzo * qtDaAcquistare); //totale incassato incrementato del prezzo della bevanda scelta
											break;
										} else {
											System.out.print("Credito non sufficiente o bevanda non disponibile.");
											resto = creditoInserito; //restituisce il credito inserito non utilizzato
											continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
										}
							       	}
								}
							}
							break;
						default:
							System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
							continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
					}
				} while (continua == 0); //ripete finche "continua" è uguale a 0
			} else {
				resto = creditoInserito; //restituisce il credito inserito non utilizzato
				System.out.println("Resto: " + resto + "€"); //stampa resto
			}
			
		return bevande;
	}	
}