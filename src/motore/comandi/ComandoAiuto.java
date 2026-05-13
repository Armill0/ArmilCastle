package motore.comandi;

import motore.core.*;

/*
    Comando "aiuto":
    Mostra una lista dei comandi disponibili e una breve descrizione di ciascuno.
 */

public class ComandoAiuto implements Comando {

    @Override
    public void esegui (Gioco gioco, String argomento) {
        gioco.scrivi("""
                === COMANDI DISPONIBILI ===
                guarda          - Osserva la stanza in cui ti trovi
                esamina         - Perlustra la stanza alla ricerca di oggetti
                vai [direzione] - Spostati in una direzione (nord, sud, est, ovest)
                parla           - Parla con un personaggio presente nella stanza
                prendi [nome]   - Raccogli un oggetto dalla stanza
                usa             - Utilizza un oggetto presente nel tuo inventario
                aiuto           - Mostra questo preziosissimo messaggio di aiuto
                """);
    }
}
