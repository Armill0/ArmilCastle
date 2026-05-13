package motore.io;

import motore.comandi.*;
import motore.core.*;

import java.util.HashMap;
// import java.util.Scanner;

/*
    Loop principale del gioco:
    legge in ingresso e chiama il comando giusto.
 */

public class MotoreIO {

    // private final Scanner scanner;
    private final Output output;
    private final HashMap<String, Comando> comandi;

    public MotoreIO(Output output) {
        this.output  = output;
        // this.scanner = new Scanner(System.in);
        this.comandi = new HashMap<>();
    }

    // Registrazione dei comandi nella mappa
    public void registraComando(String parola, Comando comando) {
        this.comandi.put(parola.toLowerCase(), comando);
    }

    /*
        Esegue un singolo comando testuale.
        Usato dalla GUI invece del loop da terminale.
     */
    public void eseguiComando(Gioco gioco, String riga) {
        riga = riga.trim().toLowerCase();
        if (riga.isEmpty()) return;

        String comando;
        String argomento;

        int spazio = riga.indexOf(' ');
        if (spazio == -1) {
            comando   = riga;
            argomento = "";
        } else {
            comando   = riga.substring(0, spazio);
            argomento = riga.substring(spazio + 1).trim();
        }

        Comando c = comandi.get(comando);
        if (c == null) {
            output.scrivi("Il castello rimane immobile. Come se non avesse capito le tue intenzioni.");
        } else {
            c.esegui(gioco, argomento);
        }
    }

    /* Loop di gioco da terminale (usato per test senza GUI)
        Ho deciso di mantenerlo per debug futuri. Prima avviavo il programma così!
    public void avviaLoop(Gioco gioco) {
        output.scrivi("Digita un comando. Scrivi 'aiuto' per la lista dei comandi.");

        while (gioco.isInCorso()) {

            System.out.print("> ");
            String riga = scanner.nextLine().trim().toLowerCase();

            if (riga.isEmpty()) continue;

            eseguiComando(gioco, riga);
        }

        output.scrivi("E anche quest'avventura volge al termine...");
        scanner.close();
    }
    */
}