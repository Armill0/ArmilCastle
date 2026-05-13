package motore.eventi;

import motore.core.*;

/*
    Evento "vittoria":
    Un evento che rappresenta la vittoria del giocatore.
     Quando attivato, stampa un messaggio di vittoria e termina il gioco.
 */

public class EventoVittoria extends Evento {

    private final String messaggio;

    public EventoVittoria(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public void attiva(Gioco gioco) {
        if (!isConsumato()) {
            gioco.scrivi("\n" + messaggio + "/n");
            consuma(gioco);
            gioco.vinci();
        }
    }
}
