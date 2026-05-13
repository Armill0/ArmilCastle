package motore.comandi;

import motore.core.*;
import motore.io.*;

public record ComandoCarica (GestoreSalvataggio gestore) implements Comando {

    @Override
    public void esegui (Gioco gioco, String argomento) {
        gestore.carica(gioco);
    }
}
