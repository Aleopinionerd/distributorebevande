package Distributore;

import java.util.Scanner;

public class BevandeCalde {

    protected String nome;
    protected double prezzo;
    protected int quantita;
    protected double totaleIncassato;

    // Costruttore
    public BevandeCalde(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.totaleIncassato = 0;
    }

    public BevandeCalde() {}

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
    public void inserisciCreditoCalda() {
        Scanner scannerCodice = new Scanner(System.in);
        Scanner scannerCredito = new Scanner(System.in);
        Scanner scannerContinua = new Scanner(System.in);

        double creditoInserito;
        int scelta = 0, continua = 0;
        double resto = 0;

        // Crea le bevande disponibili
        BevandeCalde caffe = new BevandeCalde("Caffè", 1.00, 3);
        BevandeCalde cappuccino = new BevandeCalde("Cappuccino", 2.00, 3);
        BevandeCalde teCaldo = new BevandeCalde("Tè caldo", 1.50, 3);

        // Array di bevande
        BevandeCalde[] bevande = {caffe, cappuccino, teCaldo};

        System.out.println("\nInserire credito [1-10]:");
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
                        if (creditoInserito >= caffe.prezzo && caffe.quantita > 0) {
                            caffe.effettuaVendita(creditoInserito);
                            resto = creditoInserito - caffe.prezzo;
                            System.out.println("Hai scelto il Caffè.");
                            caffe.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= caffe.prezzo;
                            System.out.print("\n" + caffe.quantita + " rimanenti...");
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                        }
                        break;

                    case 2:
                        if (creditoInserito >= cappuccino.prezzo && cappuccino.quantita > 0) {
                            cappuccino.effettuaVendita(creditoInserito);
                            resto = creditoInserito - cappuccino.prezzo;
                            System.out.println("Hai scelto il Cappuccino.");
                            cappuccino.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= cappuccino.prezzo;
                            System.out.print("\n" + cappuccino.quantita + " rimanenti...");
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                        }
                        break;

                    case 3:
                        if (creditoInserito >= teCaldo.prezzo && teCaldo.quantita > 0) {
                            teCaldo.effettuaVendita(creditoInserito);
                            resto = creditoInserito - teCaldo.prezzo;
                            System.out.println("Hai scelto il Tè caldo.");
                            teCaldo.stampaDettagli();
                            System.out.println("Resto: " + resto + "€");
                            creditoInserito -= teCaldo.prezzo;
                            System.out.print("\n" + teCaldo.quantita + " rimanenti...");
                        } else {
                            System.out.println("Credito non sufficiente o bevanda non disponibile.");
                            resto = creditoInserito;
                        }
                        break;

                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }

                // Chiedi se l'utente vuole continuare
                System.out.print("\nVuoi continuare? (0 per continuare, 1 per uscire): ");
                continua = scannerContinua.nextInt();
            } while (continua == 0); // Ripete finché l'utente vuole continuare
        } else {
            System.out.println("Credito non valido.");
        }
        System.out.println("Resto finale: " + resto + "€");
    }
}
