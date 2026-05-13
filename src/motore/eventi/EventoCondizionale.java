package motore.eventi;

import motore.core.*;

/*
    Evento condizionale:
    Un evento che si attiva solo se una certa condizione è vera.
     La condizione è rappresentata da un'interfaccia funzionale che prende il gioco come argomento e restituisce un booleano.
     Es. "Se il giocatore ha la chiave, mostra un messaggio segreto".
 */

public class EventoCondizionale extends Evento {

    private final String oggettoRichiesto;
    private final Evento eventoSeVero;
    private final Evento messaggioFalso;
    private final boolean usaFlag;


    public EventoCondizionale(String oggettoRichiesto, Evento eventoSeVero, Evento messaggioFalso) {
        this.oggettoRichiesto   = oggettoRichiesto;
        this.eventoSeVero       = eventoSeVero;
        this.messaggioFalso     = messaggioFalso;
        this.usaFlag            = false;
    }

    public EventoCondizionale(String flag, boolean usaFlag, Evento eventoSeVero, Evento messaggioFalso) {
        this.oggettoRichiesto   = flag;
        this.eventoSeVero       = eventoSeVero;
        this.messaggioFalso     = messaggioFalso;
        this.usaFlag           = usaFlag;
    }

    @Override
    public void attiva(Gioco gioco){
        boolean condizione = usaFlag
            ? gioco.getFlag(oggettoRichiesto)
            : gioco.haInInventario(oggettoRichiesto);

        if (condizione) {
            eventoSeVero.attiva(gioco);
        } else {
            messaggioFalso.attiva(gioco);
        }
    }
}
