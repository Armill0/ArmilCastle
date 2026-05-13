package motore.eventi;

import motore.core.*;

/*
    Evento "ImpostaFlag":
    imposta un flag booleano nel gioco,
    per attivare un effetto secondario.
    Registra azioni che impatteranno in futuro
 */

public class EventoImpostaFlag extends Evento {

    private final String flag;
    private final Evento eventoSecondario;

    public EventoImpostaFlag(String flag, Evento eventoSecondario) {
        this.flag = flag;
        this.eventoSecondario = eventoSecondario;
    }

    @Override
    public void attiva(Gioco gioco) {
        if (!isConsumato()) {
            gioco.setFlag(flag, true);
            eventoSecondario.attiva(gioco);
            consuma(gioco);
        }
    }
}
