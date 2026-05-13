package motore.eventi;

import motore.core.*;

/*
    Evento "sconfitta":
    Un evento che rappresenta la sconfitta del giocatore.
    Quando attivato, mostra un messaggio di sconfitta e termina il gioco.
 */

public class EventoSconfitta extends Evento {

    private final String messaggio;

    public EventoSconfitta(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public void attiva(Gioco gioco) {
        if (!isConsumato()) {
            gioco.scrivi("\n" + messaggio + "/n");
            consuma(gioco);
            gioco.termina();
        }
    }
}
