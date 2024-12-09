package Distributore;
import java.util.Scanner;
public class BevandeCalde {
	// Classe per le bevande calde
	    // Attributi
	    protected String nome;
	    protected double prezzo;
	    protected int quantita;
	    
	    // Costruttore
	    public BevandeCalde(String nome, double prezzo, int quantita) {
	        this.nome = nome;
	        this.prezzo = prezzo;
	        this.quantita = quantita;
	    }
	    
	    public BevandeCalde() {
	    }

	    // Metodo per effettuare la vendita della bevanda
	    public boolean effettuaVendita(double credito) {
	        if (credito >= prezzo && quantita > 0) {
	            quantita--; // Riduce la quantità disponibile della bevanda
	            return true; // Vendita riuscita
	        } else {
	            return false; // Vendita non riuscita
	        }
	    }

	    // Metodo per stampare i dettagli della bevanda calda
	    public void stampaDettagli(BevandeCalde bevanda) {
	        System.out.println("\nBevanda: " + bevanda.nome);
	        System.out.println("Prezzo: €" + bevanda.prezzo);
	        System.out.println("Quantità disponibile: " + bevanda.quantita);
	        System.out.println("Con bicchiere e bastoncino inclusi.");
	    }
	    
	    public double inserisciCreditoCalda() {
            Scanner scannerCodice = new Scanner(System.in);
            Scanner scannerContinua = new Scanner(System.in);
	    	int scelta = 0, continua = 0, bevandaOttenuta = 0;
	    	double resto = 0;

	    	BevandeCalde bevandaScelta = null;
			BevandeCalde caffe = new BevandeCalde("caffe", 1.00, 3);
			BevandeCalde cappuccino = new BevandeCalde("cappuccino", 2.00, 3);
			BevandeCalde teCaldo = new BevandeCalde("teCaldo", 1.50, 3);
			
			Scanner scannerCredito = new Scanner(System.in);
		    double creditoInserito;
		    
		    System.out.println("\ninserire credito:");
		    creditoInserito = scannerCredito.nextDouble();
		    
			if (creditoInserito >= 1 && creditoInserito <= 10) {
	            do {
	                System.out.println("\nSeleziona una bevanda: ");
	                System.out.println("1. " + caffe.nome + " (€" + caffe.prezzo + ")");
	                System.out.println("2. " + cappuccino.nome + " (€" + cappuccino.prezzo + ")");
	                System.out.println("3. " + teCaldo.nome + " (€" + teCaldo.prezzo + ")");
	                System.out.print("Inserisci il numero corrispondente: ");
	                scelta = scannerCodice.nextInt();
	                
	                // Selezione della bevanda in base alla scelta
	                switch (scelta) {
	                    case 1:
	                    	if(creditoInserito >= caffe.prezzo && caffe.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
	                    		bevandaScelta = caffe;
								System.out.print("hai scelto il caffe.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - caffe.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= caffe.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								caffe.quantita--; //decremento quantita bevanda
								System.out.print("\n" + caffe.quantita + " rimenenti...");
								System.out.println("\n");
							    stampaDettagli(bevandaScelta);
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
	                    	if(creditoInserito >= cappuccino.prezzo  && cappuccino.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
	                    		bevandaScelta = cappuccino;
								System.out.print("hai scelto il cappuccino.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - cappuccino.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= cappuccino.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								cappuccino.quantita--; //decremento quantita bevanda
								System.out.print("\n" + cappuccino.quantita + " rimenenti...");
								System.out.println("\n");
							    stampaDettagli(bevandaScelta);
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
	                    	if(creditoInserito >= teCaldo.prezzo  && teCaldo.quantita > 0) { //se creditoInserito è maggiore del prezzo e la quantità è maggiore do 0 esegue il blocco di codice
	                    		bevandaScelta = teCaldo;
								System.out.print("hai scelto il te caldo.");
								System.out.print("\nBevanda erogata.");
								resto = creditoInserito - teCaldo.prezzo; //resto = credito inserito - prezzo bevanda
								creditoInserito -= teCaldo.prezzo; //sottrae a creditoInserito il prezzo della bevanda (utile nel caso successivamente si ricalcoli il resto)
								teCaldo.quantita--; //decremento quantita bevanda
								System.out.print("\n" + teCaldo.quantita + " rimenenti...");
								System.out.println("\n");
							    stampaDettagli(bevandaScelta);
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

