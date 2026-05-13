package motore.comandi;

import motore.core.*;

/*
    Comando "inventario":
    Mostra gli oggetti attualmente presenti nell'inventario del giocatore.
 */

public class ComandoInventario implements Comando {

    @Override
    public void esegui (Gioco gioco, String argomento) {
        if (gioco.getInventario().isEmpty()) {
            gioco.scrivi("Non porti nulla con te. Leggero come i tuoi pensieri.");
            return;
        }
        gioco.scrivi("Nelle tue tasche hai:");
        for (Oggetto o : gioco.getInventario()) {
            gioco.scrivi(" - " + o.getNome());
        }
    }
}
