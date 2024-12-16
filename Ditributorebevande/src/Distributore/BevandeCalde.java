package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class BevandeCalde {
	//ATTRIBUTI
	private String nome;
	private double prezzo;
	private int quantita;
	private double totaleIncassato;
	private int numeroBicchieri = 10;

	public double getTotaleIncassato() {
		return totaleIncassato;
	}
	
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
	public void stampaDettagli(BevandeCalde b) {
		System.out.println("\nBevanda: " + b.nome);
		System.out.println("Prezzo: €" + b.prezzo);
		System.out.println("Quantità disponibile: " + b.quantita);
		System.out.println("Con bicchiere e bastoncino inclusi.");
	}

	// Metodo per inserire il credito e scegliere una bevanda
	public ArrayList<BevandeCalde> inserisciCreditoCalda(ArrayList<BevandeCalde> bevande) {
		Scanner scannerCodice = new Scanner(System.in);
		Scanner scannerCredito = new Scanner(System.in);
		Scanner scannerContinua = new Scanner(System.in);
		Scanner scannerZucchero = new Scanner(System.in);

		double creditoInserito;
		int scelta = 0, continua = 0;
		double resto = 0;

		// Crea le bevande disponibili

		System.out.println("\nInserire credito [1-10]:");
		creditoInserito = scannerCredito.nextDouble();

		if (creditoInserito >= 1 && creditoInserito <= 10) {
			do {
				System.out.println("\nSeleziona una bevanda: ");
				System.out.println("1. Caffè (€1)");
				System.out.println("2. Cappuccino (€2)");
				System.out.println("3. Tè Caldo (€1.50)");
				if(bevande.size() > 3) {
					System.out.println("4. "+ bevande.get(3).nome + " (€" + bevande.get(3).prezzo + ")");
				} else System.out.println("4. Non disponibile");
				System.out.print("Inserisci il numero corrispondente: ");
				scelta = scannerCodice.nextInt();
				
				// Selezione della bevanda in base alla scelta
				switch (scelta) {
				case 1:
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("Caffe")) {
						if(numeroBicchieri > 0) {
							if (creditoInserito >= b.prezzo && b.quantita > 0) {
									numeroBicchieri--;
									b.effettuaVendita(creditoInserito);
									resto = creditoInserito - b.prezzo;
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
										b.stampaDettagli(b);
										System.out.println("Resto: " + resto + "€");
										creditoInserito -= b.prezzo;
										System.out.print("\n" + b.quantita + " rimanenti...");
										System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
										continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																				// continuare a scegliere le bevande)
										System.out.println("Resto: " + resto + "€"); // stampa resto
										break;
								} else 
								System.out.println("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito;
								continua = 1;
								break;
							} else {
								System.out.println("Bicchieri esauriti");
							}
						}
					}
					break;

				case 2:
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("Cappuccino")) {
							if(numeroBicchieri > 0) {
								if (creditoInserito >= b.prezzo && b.quantita > 0) {
									numeroBicchieri--;
									b.effettuaVendita(creditoInserito);
									resto = creditoInserito - b.prezzo;
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
									b.stampaDettagli(b);
									System.out.println("Resto: " + resto + "€");
									creditoInserito -= b.prezzo;
									System.out.print("\n" + b.quantita + " rimanenti...");
									System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
									continua = scannerContinua.nextInt(); // legge un numero intero (variabile per
																			// continuare a scegliere le bevande)
									System.out.println("Resto: " + resto + "€"); // stampa rest
									break;
								} else 	
								System.out.println("Credito non sufficiente o bevanda non disponibile.");
								resto = creditoInserito;
								continua = 1;
								break;
							} else {
								System.out.println("Bicchieri esauriti");
							}
						}
					}
					break;

				case 3:
					for (BevandeCalde b : bevande) {
						if (b.nome.equalsIgnoreCase("TeCaldo")) {
							if(numeroBicchieri > 0) {
								if (creditoInserito >= b.prezzo && b.quantita > 0) {
									b.effettuaVendita(creditoInserito);
									resto = creditoInserito - b.prezzo;
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
									b.stampaDettagli(b);
									System.out.println("Resto: " + resto + "€");
									creditoInserito -= b.prezzo;
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
								System.out.println("Bicchieri esauriti");
							}
						}
					}
					break;
				case 4:
					if (bevande.size() > 3) {
						for (BevandeCalde b : bevande) {
							if (b.nome.equals(bevande.get(3).nome)) {
								if(numeroBicchieri > 0) {
									if (creditoInserito >= b.prezzo && b.quantita > 0) { // se creditoInserito è maggiore												// del prezzo e la quantità è
																						// maggiore do 0 esegue il
																						// blocco di codice
										numeroBicchieri--;
										b.effettuaVendita(creditoInserito);
										resto = creditoInserito - b.prezzo;
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
										creditoInserito -= b.prezzo; // sottrae a creditoInserito il prezzo della bevanda
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
									System.out.println("Bicchieri esauriti");
									break;
								}
							}
						}
					}
					break;
				default:
					System.out.print("\n\nINSERIRE 0 PER CONTINUARE: ");
					continua = scannerContinua.nextInt(); //legge un numero intero (variabile per continuare a scegliere le bevande)
					break;
				}
			} while (continua == 0); // Ripete finché l'utente vuole continuare
		}else {
			resto = creditoInserito; //restituisce il credito inserito non utilizzato
			System.out.println("Resto: " + resto + "€"); //stampa resto
		}
		return bevande;
	}
}