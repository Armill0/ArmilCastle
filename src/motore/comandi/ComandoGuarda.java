package motore.comandi;
import motore.core.Gioco;

/*
    Comando "guarda":
    Descrive la stanza corrente.
    È il comando più semplice: non ha bisogno dell'argomento.
    Stampa la descrizione della stanza attuale.
 */

public class ComandoGuarda  implements Comando {

    @Override
    public void esegui (Gioco gioco, String argomento) {
        gioco.scrivi(gioco.getStanzaCorrente().descriviCompleta());
    }
}
