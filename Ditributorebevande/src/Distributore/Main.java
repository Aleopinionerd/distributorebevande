package Distributore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/* New feature: gestione operatore. L'operatore può, inserendo un codice riservato, accedere ad un menu di selezione con cui poter fare le seguenti operazioni:

	   aggiungere un nuovo prodotto
	   rimuovere un prodotto
	   cambiare la quantità disponibile di un prodotto
	   cambiare il prezzo di un prodotto
	   Inoltre, l'operatore potrà vedere:
	
	   totale incassato dal distributore
	   elenco dei prodotti acquistati con relative quantità (es: caffè 10, ginseng 18, coca 4) */
	
	public static void main(String[] args) {
		//VARIABILI
		Scanner scanner = new Scanner(System.in);
		Scanner scannerBevanda = new Scanner(System.in);
		Scanner scannerSceltaAdmin = new Scanner(System.in);
		Scanner scannerScelta = new Scanner(System.in);
		
		boolean admin = false;
		int continua = 1;
		double resto = 0;
		
		BevandaFredda bevanda1 = new BevandaFredda(); //oggetto bevanda instanza di BevandaFredda
		BevandeCalde bevanda2 = new BevandeCalde(); //oggetto bevanda instanza di BevandeCalde
		Amministratore a1 = new Amministratore();
		
		ArrayList <BevandaFredda> bevande = new ArrayList <BevandaFredda>();
		ArrayList <BevandeCalde> bevandeCalde = new ArrayList <BevandeCalde>();
		ArrayList <BevandaFredda> bevandeAggiunte = new ArrayList <BevandaFredda>();
		ArrayList <BevandeCalde> bevandeCaldeAggiunte = new ArrayList <BevandeCalde>();
		
		BevandaFredda acqua = new BevandaFredda("Acqua", 1.0, 3);
		BevandaFredda cocacola = new BevandaFredda("Cocacola", 2.0, 3);
		BevandaFredda te = new BevandaFredda("Te", 1.5, 3);
		
		BevandeCalde caffe = new BevandeCalde("Caffe", 1.0, 3);
		BevandeCalde cappuccino = new BevandeCalde("Cappuccino", 2.0, 3);
		BevandeCalde teCaldo = new BevandeCalde("TeCaldo", 1.5, 3);
		
		bevande.add(acqua);
		bevande.add(cocacola);
		bevande.add(te);
		
		bevandeCalde.add(caffe);
		bevandeCalde.add(cappuccino);
		bevandeCalde.add(teCaldo);
		
		//INIZIO CODICE		
				do {
					System.out.println("1)BEVANDA CALDA\n2)BEVANDA FREDDA\n3)AREA ADMIN");
					int sceltaBevanda = scannerBevanda.nextInt();
					switch(sceltaBevanda) {
					case 1:
						if(bevandeCaldeAggiunte.size() != 0) {bevandeCalde = bevandeCaldeAggiunte;}
							bevandeCalde = bevanda2.inserisciCreditoCalda(bevandeCalde); //richiama il metodo inserisciCredito()
						break;
						
					case 2:
						if(bevandeAggiunte.size() != 0) {bevande = bevandeAggiunte;}
							bevande = bevanda1.inserisciCredito(bevande); //richiama il metodo inserisciCredito()
						break;
						
					case 3:
						admin = a1.accessoAdmin(); //richiama il metodo accessoAdmin()
						if(admin) { // se admin è uguale a true
							System.out.println("SU QUALI BEVANDE VUOI OPERARE?\n1)BEVANDE FREDDE\n2)BEVANDE CALDE");
							int sceltaBevandaAdmin = scannerScelta.nextInt();
							
							switch(sceltaBevandaAdmin) {
							case 1:
								System.out.println("1)AGGIUNGI QUANTITA BEVANDA\n2)CAMBIA PREZZO BEVANDA\n3)AGGIUNGI BEVANDA\n4)RIMUOVI BEVANDA\n5)STATISTICHE");
								int sceltaAdmin = scannerSceltaAdmin.nextInt();
								switch(sceltaAdmin) {
								case 1:
									bevandeAggiunte = a1.quantitaBevanda(bevande);
									break;
									
								case 2:
									bevandeAggiunte = a1.prezzoBevanda(bevande);
									break;
									
								case 3:
									bevandeAggiunte = a1.aggiungiBevanda(bevande);
									for(BevandaFredda b : bevande) {
										System.out.println(b.getNome() + " ");
									}
									break;
									
								case 4:
									int daRimuovere = a1.rimuoviBevanda(bevande);
									bevandeAggiunte.remove(daRimuovere);
									break;
									
								case 5:
									a1.Statistiche(bevande);
									break;
									
								default:
									System.out.println("NUMERO ERRATO");
									break;
								}									
								break;
								
							case 2:
								System.out.println("1)AGGIUNGI QUANTITA BEVANDA\n2)CAMBIA PREZZO BEVANDA\n3)AGGIUNGI BEVANDA\n4)RIMUOVI BEVANDA\n5)STATISTICHE");
								int sceltaAdmin2 = scannerSceltaAdmin.nextInt();
								switch(sceltaAdmin2) {
								case 1:
									bevandeCaldeAggiunte = a1.quantitaBevandaCalda(bevandeCalde);
									break;
									
								case 2:
									bevandeCaldeAggiunte = a1.prezzoBevandaCalda(bevandeCalde);
									break;
									
								case 3:
									bevandeCaldeAggiunte = a1.aggiungiBevandaCalda(bevandeCalde);
									break;
									
								case 4:
									int daRimuovere = a1.rimuoviBevandaCalda(bevandeCalde);
									bevandeCaldeAggiunte.remove(daRimuovere);
									break;
									
								case 5:
									a1.StatisticheCalda(bevandeCalde);
									break;
									
								default:
									System.out.println("NUMERO ERRATO");
									break;
								}	
								
								break;
							
							}
							
						}
						break;
					default:
						System.out.println("NUMERO ERRATO");
					}
					
					System.out.print("\nINSERIRE 0 PER TORNARE AL MENU: ");
					continua = scanner.nextInt();
				} while (continua == 0); //ripete finché "continua" è uguale a 0
		scanner.close();
		
		
		
	}//FINE MAIN
	
	
	//METODI

}
