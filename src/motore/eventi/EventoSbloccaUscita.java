package motore.eventi;

import motore.core.*;

/*
    Evento "sblocca uscita":
    Un evento che sblocca un'uscita bloccata in una stanza.
     Può essere usato per rappresentare una porta che si apre, o un passaggio segreto che viene rivelato.
 */

public class EventoSbloccaUscita extends Evento {

    private final String nomeStanza;
    private final String direzione;
    private final String messaggio;


    public EventoSbloccaUscita(String id, String nomeStanza, String direzione, String messaggio) {
        super(id);
        this.nomeStanza     = nomeStanza    ;
        this.direzione      = direzione     ;
        this.messaggio      = messaggio      ;
    }

    @Override
    public void attiva(Gioco gioco){
        if (!isConsumato()){
            Stanza stanza = gioco.getStanza(nomeStanza);
            if (stanza != null) {
                stanza.rivelaUscita(direzione);
                gioco.scrivi(this.messaggio);
            }
            consuma(gioco);
        }
    }
}
