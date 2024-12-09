package Distributore;

import java.util.Scanner;

public class BevandaFredda {
	//ATTRIBUTI
	protected String nome;
	protected double prezzo;
	protected int quantita;

	//COSTRUTTORE
	public BevandaFredda() {
		
	}
	
	public BevandaFredda(String nome, double prezzo, int quantita) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	
	
	public double inserisciCredito() {
		//VARIABILI
		int bevandaOttenuta = 0;
		
		BevandaFredda acqua = new BevandaFredda("Acqua", 1.00, 3);
		BevandaFredda cocacola = new BevandaFredda("Acqua", 2.00, 3);
		BevandaFredda te = new BevandaFredda("Acqua", 1.50, 3);
		
		double resto = 0;
		
		Scanner scannerContinua = new Scanner(System.in);
		int continua = 1; //scanner e variabile per continuare a scegliere bevande
		
		Scanner scannerCodice = new Scanner(System.in);
		int codiceInserito = 0; //scanner e variabile per il codice inserito

		Scanner scannerCredito = new Scanner(System.in);
		double creditoInserito = 0; //scanner e variabile per il credito inserito
		
		//INIZIO ISTRUZIONI
		System.out.print("\ninserire credito: ");
		creditoInserito = scannerCredito.nextDouble(); //legge numero intero (variabile per il credito inserito)
			if(creditoInserito >= 1 && creditoInserito <= 10) { //se il credito inserito è compreso tra 1 euro e 10 euro esegue il blocco
				System.out.print("Credito: " + creditoInserito);	
				do {
					System.out.print("\ninserire un codice: ");
					codiceInserito = scannerCodice.nextInt(); //legge numero intero (variabile per il codice inserito)
					switch(codiceInserito) {
						case 1:
							if(creditoInserito >= acqua.prezzo && acqua.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
								System.out.print("hai scelto l'acqua.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - acqua.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= acqua.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								acqua.quantita--; //decremento quantita bevanda
								System.out.print("\n" + acqua.quantita + " rimenenti...");
								System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
								continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
								bevandaOttenuta++;
							} else {
								System.out.print("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito; //restituisce il credito inserito non utilizzato
								continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
							}
							break;
							
						case 2:
							if(creditoInserito >= cocacola.prezzo  && cocacola.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
								System.out.print("hai scelto la CocaCola.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - cocacola.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= cocacola.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								cocacola.quantita--; //decremento quantita bevanda
								System.out.print("\n" + cocacola.quantita + " rimenenti...");
								System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
								continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
								bevandaOttenuta++;
							} else {
								System.out.print("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito; //restituisce il credito inserito non utilizzato
								continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
							}
							break;
							
						case 3:
							if(creditoInserito >= te.prezzo  && te.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
								System.out.print("hai scelto il Tè.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - te.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= te.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								te.quantita--; //decremento quantita bevanda
								System.out.print("\n" + te.quantita + " rimenenti...");
								System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
								continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
								bevandaOttenuta++;
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
				} while (continua == 0); //ripete finche "continua" è uguale a 0
			} else {
				resto = creditoInserito; //restituisce il credito inserito non utilizzato
			}
			
			if(bevandaOttenuta != 0) {
				System.out.println("\nResto: " + resto + "€");
				System.exit(0);
			} 
			
		return resto;
	}	
}
