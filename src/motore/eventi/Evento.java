package motore.eventi;

import motore.core.*;

/*
    Classe base per gli eventi di gioco.
    Un evento è qualcosa che accade in una situazione.
    Entrare in una stanza, usare un oggetto...
    Sono eventi che possono far scaturire qualcosa.
 */

public abstract class Evento {

    private boolean consumato;
    private final String id;

    public Evento(String id){
        this.consumato = false;
        this.id = id;
    }

    public Evento() {
        this(null);
    }

    public String getId()           { return id;         }
    public boolean hasId()          { return id != null; }
    public boolean isConsumato()    { return consumato;  }


    // Attivazione dell'evento
    public abstract void attiva(Gioco gioco);

    // Cambiamento del flag, per evitare di ripetere l'evento nella sessione in corso
    public void consuma(Gioco gioco) {
        this.consumato = true;
        if (hasId()) {
            gioco.registraEventoConsumato(id);
        }
    }

    public void forceConsuma(){
        this.consumato = true;
    }
}
