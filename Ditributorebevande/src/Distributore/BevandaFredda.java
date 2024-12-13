package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class BevandaFredda {
	//ATTRIBUTI
	protected String nome;
	protected double prezzo;
	protected int quantita = 3;
	protected double totaleIncassato;

	//COSTRUTTORE
	public BevandaFredda() {
		
	}
	
	public BevandaFredda(String nome, double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	public int getQuantita() {
		return this.quantita;
	}
	
	public double getPrezzo() {
		return this.prezzo;
	}
	
	public ArrayList <BevandaFredda> inserisciCredito(ArrayList <BevandaFredda> bevande) {
		//VARIABILI
		int bevandaOttenuta = 0;
		
		double resto = 0;
		
		Scanner scannerContinua = new Scanner(System.in);
		int continua = 1; //scanner e variabile per continuare a scegliere bevande
		
		Scanner scannerCodice = new Scanner(System.in);
		int codiceInserito = 0; //scanner e variabile per il codice inserito

		Scanner scannerCredito = new Scanner(System.in);
		double creditoInserito = 0; //scanner e variabile per il credito inserito
		
		//INIZIO ISTRUZIONI
		System.out.print("\ninserire credito [1-10]: ");
		creditoInserito = scannerCredito.nextDouble(); //legge numero intero (variabile per il credito inserito)
			if(creditoInserito >= 1 && creditoInserito <= 10) { //se il credito inserito è compreso tra 1 euro e 10 euro esegue il blocco
				System.out.print("Credito: " + creditoInserito);	
				do {
					System.out.print("\ninserire un codice:\n1)ACQUA\n2)COCACOLA\n3)TE");
					codiceInserito = scannerCodice.nextInt(); //legge numero intero (variabile per il codice inserito)
					switch(codiceInserito) {
						case 1:
							//BevandaFredda b = new BevandaFredda("Acqua", 1.00, b.getQuantita());
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Acqua")) {
									if(creditoInserito >= b.prezzo && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto l'acqua.");
										System.out.print("\nBevanda erogata.");
										resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
										creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										b.quantita--; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta++;
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += b.prezzo;
									}else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
								}
					        }
					            
							} 
							break;
							
						case 2:
							//b = new BevandaFredda("Cocacola", 2.00, b.getQuantita());
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Cocacola")) {
									if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto la CocaCola.");
										System.out.print("\nBevanda erogata.");
										resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
										creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										b.quantita--; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta++;
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += b.prezzo;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									}
					            }
							}
							break;
							
						case 3:
							//b = new BevandaFredda("Te", 1.50, b.getQuantita());
							for(BevandaFredda b : bevande) {
					            if (b.nome.equals("Te")) {
									if(creditoInserito >= b.prezzo  && b.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
										System.out.print("hai scelto il Tè.");
										System.out.print("\nBevanda erogata.");
										resto = creditoInserito - b.prezzo; //resto = credito inserito - prezzo bevanda
										creditoInserito -= b.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
										b.quantita--; //decremento quantita bevanda
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
										bevandaOttenuta++;
										System.out.println("Resto: " + resto + "€"); //stampa resto
										b.totaleIncassato += b.prezzo;
									} else {
										System.out.print("Credito non sufficiente o bevanda non disponibile.");
										resto = creditoInserito; //restituisce il credito inserito non utilizzato
										continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
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
