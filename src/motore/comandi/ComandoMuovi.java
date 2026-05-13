package motore.comandi;

import motore.core.*;

import java.util.Random;

/*
    Comando "muovi":
    Permette al giocatore di muoversi da una stanza all'altra.
    L'argomento è il nome della stanza in cui si vuole andare.
     Es. "Muovi cucina" -> esegui(gioco, "cucina");
     Il comando controlla se la stanza è adiacente a quella attuale, e se la porta è aperta.
     Se sì, cambia la stanza corrente del gioco.
 */

public class ComandoMuovi implements Comando {

    @Override
    public void esegui(Gioco gioco, String argomento) {
        // Senza direzione fornita
        if (argomento == null || argomento.isEmpty()) {
            gioco.scrivi("In quale direzione stai puntando?");
            return;
        }

        if (gioco.getStanzaCorrente().getNome().equalsIgnoreCase("Stanza degli specchi") && !gioco.haInInventario("frammento di vetro")) {
            gioco.setStanzaCorrente(gioco.getStanza("Corridoio Circolare"));
            gioco.scrivi("I riflessi si moltiplicano. Perdi l'orientamento. \nQuando ti rialzi ti accorgi di essere tornato indietro.");
            gioco.scrivi(gioco.getStanzaCorrente().descriviCompleta());
            return;
        }

        if (gioco.getStanzaCorrente().getNome().equalsIgnoreCase("Porta sbagliata")) {
            String[] visitate = gioco.getStanzeVisitate().toArray(new String[0]);
            String casuale = visitate [new Random().nextInt(visitate.length)];
            gioco.setStanzaCorrente(gioco.getStanza(casuale));
            gioco.scrivi("La porta si apre su qualcosa di inaspettato. \n Non sai come, ma ti ritrovi altrove. Eri forse sovrappensiero?");
            gioco.scrivi(gioco.getStanzaCorrente().descriviCompleta());
            return;
        }

        // Cerca l'uscita
        Stanza destinazione = gioco.getStanzaCorrente().getUscita(argomento);

        if (destinazione == null) {
            gioco.scrivi("Niente da fare... Non puoi andare verso " + argomento);
        } else {
            gioco.registraStanzaVisitata(gioco.getStanzaCorrente().getNome());
            gioco.setStanzaCorrente(destinazione);
            gioco.scrivi("Ti sei spostato verso " + argomento + "\n");
            gioco.getStanzaCorrente().attivaEventi(gioco);

            if (gioco.isInCorso()) {
                gioco.scrivi(gioco.getStanzaCorrente().descriviCompleta());
            }
        }
    }
}
