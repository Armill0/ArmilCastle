package motore.eventi;

import motore.core.*;

/*
    Evento "mostra messaggio":
    Un evento che mostra un messaggio al giocatore.
     Può essere usato per descrivere qualcosa che accade, o per dare indizi.
 */

public class EventoMostraMessaggio extends Evento {

    private final String messaggio;

    public EventoMostraMessaggio(String id, String messaggio) {
        super(id);
        this.messaggio = messaggio;
    }

    public EventoMostraMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public void attiva(Gioco gioco) {
        if (hasId()) {
            if (isConsumato()) {
                gioco.scrivi(messaggio);
                consuma(gioco);
            }
        } else  {
            gioco.scrivi(messaggio);
        }
    }
}
