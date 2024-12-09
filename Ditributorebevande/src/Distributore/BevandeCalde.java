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
	    public void stampaDettagli() {
	        System.out.println("\nBevanda: " + nome);
	        System.out.println("Prezzo: €" + prezzo);
	        System.out.println("Quantità disponibile: " + quantita);
	        System.out.println("Con bicchiere e bastoncino inclusi.");
	    }

	    public static void main(String[] args) {
	        // Creazione delle bevande calde
	        BevandeCalde caffè = new BevandeCalde("Caffè", 2.00, 5);
	        BevandeCalde cappuccino = new BevandeCalde("Cappuccino", 2.50, 3);
	        BevandeCalde te = new BevandeCalde("Tè", 1.80, 4);

	        // Scanner per l'inserimento del credito
	        Scanner scannerCredito = new Scanner(System.in);
	        double creditoInserito;

	        System.out.print("\nInserisci credito (tra 1 e 10 euro): ");
	        creditoInserito = scannerCredito.nextDouble();

	        if (creditoInserito >= 1 && creditoInserito <= 10) {
	            System.out.println("Credito inserito: €" + creditoInserito);
	            Scanner scannerCodice = new Scanner(System.in);
	            int scelta;
	            int continua = 1; // Variabile per continuare a scegliere le bevande

	            do {
	                System.out.println("\nSeleziona una bevanda: ");
	                System.out.println("1. " + caffè.nome + " (€" + caffè.prezzo + ")");
	                System.out.println("2. " + cappuccino.nome + " (€" + cappuccino.prezzo + ")");
	                System.out.println("3. " + te.nome + " (€" + te.prezzo + ")");
	                System.out.print("Inserisci il numero corrispondente: ");
	                scelta = scannerCodice.nextInt();

	                BevandeCalde bevandaScelta = null;

	                // Selezione della bevanda in base alla scelta
	                switch (scelta) {
	                    case 1:
	                        bevandaScelta = caffè;
	                        break;
	                    case 2:
	                        bevandaScelta = cappuccino;
	                        break;
	                    case 3:
	                        bevandaScelta = te;
	                        break;
	                    default:
	                        System.out.println("Scelta non valida!");
	                        continue;
	                }

	                bevandaScelta.stampaDettagli();

	                // Verifica se il credito è sufficiente per la bevanda scelta
	                if (bevandaScelta.effettuaVendita(creditoInserito)) {
	                    creditoInserito -= bevandaScelta.prezzo;
	                    System.out.println("Bevanda erogata con successo!");
	                    System.out.println("Credito residuo: €" + creditoInserito);
	                } else {
	                    System.out.println("Credito non sufficiente o bevanda esaurita.");
	                }

	                System.out.print("\nVuoi acquistare un'altra bevanda? (1 per continuare, 0 per uscire): ");
	                continua = scannerCodice.nextInt();

	            } while (continua == 1); // Continua finché l'utente vuole acquistare altre bevande

	        } else {
	            System.out.println("Credito non valido. Inserisci un importo tra 1 e 10 euro.");
	        }
	    }
	}

