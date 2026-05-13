package motore.comandi;

import motore.core.*;

/*
    Comando "prendi":
    Permette al giocatore di prendere un oggetto dalla stanza e metterlo nell'inventario.
    L'argomento è il nome dell'oggetto da prendere.
     Es. "Prendi chiave" -> esegui(gioco, "chiave");
     Il comando controlla se l'oggetto è presente nella stanza, e se è "prendibile".
     Se sì, rimuove l'oggetto dalla stanza e lo aggiunge all'inventario del giocatore.
 */

public class ComandoPrendi implements Comando {

    @Override
    public void esegui(Gioco gioco, String argomento) {
        if (argomento == null || argomento.isEmpty()) {
            gioco.scrivi("Vuoi raccogliere qualcosa? Che cosa?");
            return;
        }

        // Cerca l'oggetto nella stanza attuale
        Oggetto trovato = gioco.getStanzaCorrente().trovaNomeOggetto(argomento);

        if (trovato == null) {
            gioco.scrivi("Niente da fare... Non c'è " + argomento + " qui.");
        } else {
            gioco.getStanzaCorrente().rimuoviOggetto(trovato);
            gioco.aggiungiInventario(trovato);
            gioco.scrivi("Hai raccolto: " + trovato.getNome() + "!");
        }
    }
}
