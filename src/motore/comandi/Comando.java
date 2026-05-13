package motore.comandi;

import motore.core.Gioco;

/*
    Interfaccia che viene implementata da tutti i comandi del gioco.
    Ogni comando riceve il riferimento al gioco per modificarne lo stato e l'argomento
    Es. "prendi chiave" -> esegui(gioco, "chiave");
 */

public interface Comando {
    void esegui (Gioco gioco, String argomento);
}
