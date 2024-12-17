package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class BevandeCalde {
	//ATTRIBUTI
	private String nome;
	private double prezzo;
	private int quantita;
	private double totaleIncassato;
	private int numeroBicchieri = 10; //numero di bicchieri per tutte le bevande
	private boolean esaurita = false;
	private int bevandaOttenuta;

	public double getTotaleIncassato() { //public per usare get e set 
		return totaleIncassato;
	}
	//GETTER E SETTER
	public String getNome() {
		return nome;

	}

	public int getQuantita() {
		return quantita;

	}

	public double getPrezzo() {
		return prezzo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;

	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;

	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public int getBevandaOttenuta() {
		return bevandaOttenuta;
	}
	
	public boolean getEsaurita () {
		return esaurita;
		
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
	public boolean effettuaVendita(double credito, int qt) {
		if (credito >= prezzo && quantita > 0) {
			quantita = (quantita - qt);
			bevandaOttenuta += qt; //conteggio bevande ottenute
			if (quantita == 0) {
				esaurita = true;
			}
			totaleIncassato += (prezzo * qt); // Aggiunge l'importo alla vendita totale
			return true; // Vendita riuscita
		} else {
			return false; // Vendita non riuscita
		}
	}

	// Metodo per stampare i dettagli della bevanda calda
	public void stampaDettagli(BevandeCalde b) {
		System.out.println("\nBevanda: " + b.nome);
		System.out.println("Prezzo: €" + b.prezzo);
		System.out.println("Quantità disponibile: " + b.quantita);
		System.out.println("Con bicchiere e bastoncino inclusi.");
	}

	// Metodo per inserire il credito e scegliere una bevanda
	public ArrayList<BevandeCalde> inserisciCreditoCalda(ArrayList<BevandeCalde> bevande) {
		Scanner scannerCodice = new Scanner(System.in); //nuovo scanner
		Scanner scannerCredito = new Scanner(System.in);//apertura nuovo scanner
		Scanner scannerContinua = new Scanner(System.in);//apertura nuovo scanner
		Scanner scannerZucchero = new Scanner(System.in); //apertura nuovo scanner

		double creditoInserito; //scanner e variabili per credito, codice inserito
		int scelta = 0, continua = 0;
		double resto = 0; //variabili inizializzate a 0

		//Inizio di cosa deve fare il distributore di bevande calde

		System.out.println("\nInserire credito [1-10]:"); //stampa
		creditoInserito = scannerCredito.nextDouble(); //legge un numero intero più preciso rispetto a int 
		// Metodo principale per la gestione del distributore
		if (creditoInserito >= 1 && creditoInserito <= 10) { 
			do {
				System.out.println("\nSeleziona una bevanda: "); //stampa del menu informativo per l'utente
				System.out.println(String.format("1. %s (€ %.2f)", bevande.get(0).nome, bevande.get(0).prezzo));
				System.out.println(String.format("2. %s (€ %.2f)", bevande.get(1).nome, bevande.get(1).prezzo));
				System.out.println(String.format("3. %s (€ %.2f)", bevande.get(2).nome, bevande.get(2).prezzo));
				if(bevande.size() > 3) {
					System.out.println(String.format("4. %s (€ %.2f)", bevande.get(3).nome, bevande.get(3).prezzo));
				} else System.out.println("4. Non disponibile");
				System.out.print("Inserisci il numero corrispondente: ");
				scelta = scannerCodice.nextInt(); //l
				
				System.out.println("\nQuante quantità vuoi acquistare? (max 10): ");
				int quantitaDaAcquistare = scannerCodice.nextInt(); //nuova variabile con scanner 

				if (quantitaDaAcquistare <= 0) {
				    System.out.println("Quantità non valida.");
				    continue;
				}
				// Selezione della bevanda in base alla scelta
				switch (scelta) {
				case 1:
					//Bevande tra cui può scegliere sono caffe, cappuccino e te caldo, controllando e diminuendo il numero di bicchieri
					//diminuendo la quantità di ogni bevanda volta per volta
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("Caffe")) {
						if(numeroBicchieri > 0) {
							if (creditoInserito >= (b.prezzo * quantitaDaAcquistare) && b.quantita >= quantitaDaAcquistare) { //se creditoInserito è maggiore del prezzo e la quantita  = 0
									numeroBicchieri-= quantitaDaAcquistare;
									b.effettuaVendita(creditoInserito, quantitaDaAcquistare);
									resto = creditoInserito - (b.prezzo * quantitaDaAcquistare);
										for(int i = 0; i < 5; i++) {
											System.out.println("Quanto zucchero vuoi (0-5)");
											int zucchero = scannerZucchero.nextInt();
											if(zucchero > 0 && zucchero <=5) {
												System.out.println("Hai scelto: " + quantitaDaAcquistare  +" di " + bevande.get(scelta - 1).getNome()  + " con " + zucchero + " zollette di zucchero");
												break;
											} else if (zucchero == 0){
												System.out.println("Non hai selezionato lo zucchero");
												break;
											}
										}
										b.stampaDettagli(b);
										System.out.println("Resto: " + resto + "€");
										creditoInserito -= (b.prezzo + quantitaDaAcquistare); //resto = credito inserito - prezzo bevanda utile per valutare ulteriori acquisti
										System.out.print("\n" + b.quantita + " rimanenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																				// continuare a scegliere le bevande)
										System.out.println("Resto: " + resto + "€"); // stampa resto
										break;
								} else 
								System.out.println("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito;  //restituisce il credito inserito non utilizzato
								continua = 1; //imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
						
								break;
							} else {
								System.out.println("Bicchieri esauriti. "); //bicchieri terminati serlezionare altra bevanda
								
							}
						}
					}
					break;

				case 2:
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("Cappuccino")) {
							if(numeroBicchieri > 0) {
								if (creditoInserito >= (b.prezzo * quantitaDaAcquistare) && b.quantita >= quantitaDaAcquistare) { ///se creditoInserito è maggiore del prezzo e la quantita  = 0
									numeroBicchieri-= quantitaDaAcquistare;
									b.effettuaVendita(creditoInserito, quantitaDaAcquistare);
									resto = creditoInserito - (b.prezzo * quantitaDaAcquistare);
									for(int i = 0; i < 5; i++) {
										System.out.println("Quanto zucchero vuoi (0-5)");
										int zucchero = scannerZucchero.nextInt();
										if(zucchero > 0 && zucchero <=5) {
											System.out.println("Hai scelto: " + quantitaDaAcquistare  +" di " + bevande.get(scelta - 1).getNome()  + " con " + zucchero + " zollette di zucchero");
											break;
										} else if (zucchero == 0){ //controllo sulla quantita di zucchero che vuole l'utente se non lo vuole sarà amaro, quindi impostato a 0
											System.out.println("Non hai selezionato lo zucchero");
											break;
										}
									}
									b.stampaDettagli(b);
									System.out.println("Resto: " + resto + "€");
									creditoInserito -= (b.prezzo * quantitaDaAcquistare);
									System.out.print("\n" + b.quantita + " rimanenti...");//per stampa di controllo per quante quantita rimangono disponibili prima di rifornire
									System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
									continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																			// continuare a scegliere le bevande)
									System.out.println("Resto: " + resto + "€"); // stampa rest
									break;
								} else 	
								System.out.println("Credito non sufficiente o bevanda non disponibile."); //stampa se credito non è sufficiente o la bevanda è esaurita
								resto = creditoInserito;
								continua = 1;
								break;
							} else {
								System.out.println("Bicchieri esauriti. Scegli una bevanda fredda.");
							}
						}
					}
					break;

				case 3:
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("TeCaldo")) {
							if(numeroBicchieri > 0) {
								if (creditoInserito >= (b.prezzo * quantitaDaAcquistare) && b.quantita >= quantitaDaAcquistare) { ///se creditoInserito è maggiore del prezzo e la quantita  = 0
									numeroBicchieri-= quantitaDaAcquistare;
									b.effettuaVendita(creditoInserito, quantitaDaAcquistare);
									resto = creditoInserito - (b.prezzo * quantitaDaAcquistare);
									for(int i = 0; i < 5; i++) {
										System.out.println("Quanto zucchero vuoi (0-5)"); //inserire da 0 a cinque zollette, meno rimanda all'else altrimenti se supera continua finché non mette massimo 5
										int zucchero = scannerZucchero.nextInt();
										if(zucchero > 0 && zucchero <=5) {
											System.out.println("Hai scelto: " + quantitaDaAcquistare  +" di " + bevande.get(scelta - 1).getNome()  + " con " + zucchero + " zollette di zucchero"); //aggiunta della quantità acquistata dell'utente
											break;
										} else if (zucchero == 0){
											System.out.println("Non hai selezionato lo zucchero");//avviso per l'utente che non è stato inserito alcuna zolletta
											break;
										}
										
									}
									b.stampaDettagli(b);
									System.out.println("Resto: " + resto + "€");
									creditoInserito -= (b.prezzo * quantitaDaAcquistare);
									System.out.print("\n" + b.quantita + " rimanenti...");
									System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
									continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																			// continuare a scegliere le bevande)
									System.out.println("Resto: " + resto + "€"); // stampa resto
									break;
								} else {
									System.out.println("Credito non sufficiente o bevanda non disponibile.");
									resto = creditoInserito;
									continua = 1;
									break;
								}
							} else {
								System.out.println("Bicchieri esauriti. Scegli una bevanda fredda.");
							}
						}
					}
					break;
				case 4:
					if (bevande.size() > 3) {
						for (BevandeCalde b : bevande) {
							if (b.nome.equals(bevande.get(3).nome)) {
								if(numeroBicchieri > 0) {
									if (creditoInserito >= (b.prezzo * quantitaDaAcquistare) && b.quantita >= quantitaDaAcquistare) { // se creditoInserito è maggiore												// del prezzo e la quantità è
																						// maggiore do 0 esegue il
																						// blocco di codice
										numeroBicchieri-= quantitaDaAcquistare;
										b.effettuaVendita(creditoInserito, quantitaDaAcquistare);
										resto = creditoInserito - (b.prezzo * quantitaDaAcquistare);
										for(int i = 0; i < 5; i++) {
											System.out.println("Quanto zucchero vuoi (0-5)");
											int zucchero = scannerZucchero.nextInt();
											if(zucchero > 0 && zucchero <=5) {
												System.out.println("Hai scelto il " + bevande.get(scelta - 1).getNome()  + " con " + zucchero + " zollette di zucchero");
												break;
											} else if (zucchero == 0){
												System.out.println("Non hai selezionato lo zucchero");
												break;
											}
										}
										// resto = credito inserito - prezzo bevanda
										creditoInserito -= (b.prezzo * quantitaDaAcquistare); // sottrae a creditoInserito il prezzo della bevanda
																		// (utile nel caso successivamente si ricalcoli il
																		// resto)
										System.out.print("\n" + b.quantita + " rimenenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																				// continuare a scegliere le bevande)
										System.out.println("Resto: " + resto + "€"); // stampa resto
										break;
									} else 	{
									System.out.print("Credito non sufficiente o bevanda non disponibile.");
									resto = creditoInserito; // restituisce il credito inserito non utilizzato
									continua = 1; // imposta continua a 1 per non rientrare nel ciclo in cui verra chiesto di inserire il codice
									} 
								} else {
									System.out.println("Bicchieri esauriti. Scegli una bevanda fredda.");//così non si piò comprare alcuna bevanda ma può scegliere una fredda
									break;
								}
							}
						}
					}
					break;
				default:
					System.out.print("\n\nINSERIRE 0 PER CONTINUARE: "); //stampa per far continuare all'utente l'utilizzo del distributore se ha resto e vuole continuare
					continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
					break;
				}
				System.out.println ("Grazie per aver usato il nostro distributore. Buona giornata");
			} while (continua == 0); // Ripete finché l'utente vuole continuare
		}else {
			resto = creditoInserito; //restituisce il credito inserito non utilizzato
			System.out.println("Resto: " + resto + "€"); //stampa resto
		}
		return bevande;
	}
}