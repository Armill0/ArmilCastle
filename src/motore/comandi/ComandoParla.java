package motore.comandi;

import motore.core.*;
import motore.eventi.*;

/*
    Comando "parla":
    Se nella stanza c'è un NPC, ci puoi parlare.
    La battuta sarà randomizzata e ripetibile.
    Questo permette di non perdere dettagli del gioco.
 */

public class ComandoParla implements Comando {

    @Override
    public void esegui(Gioco gioco, String argomento) {
        NPC npc = gioco.getStanzaCorrente().getNPC();

        if (npc == null) {
            gioco.scrivi("Non c'è nessuno con cui parlare qui. " +
                    "Solo il silenzio dei tuoi pensieri.");
            return;
        }

        gioco.scrivi(npc.getNome() + ": \"" + npc.parla() + "\"");

        // --- La Voce — dopo 4 battute appare la lanterna nella Stanza Bianca ---
        if (gioco.getStanzaCorrente().getNome().equalsIgnoreCase("Stanza Bianca")
                && !gioco.getFlag("lanterna-rivelata")) {

            gioco.incrementaContatore();


            if (gioco.getContatoreVoce() >= 4) {
                gioco.setFlag("lanterna-rivelata", true);
                Oggetto lanterna = new Oggetto("lanterna", "Una lanterna a olio. Potrebbe essere utile per illuminare luoghi bui come... La coscienza.");
                lanterna.setProprieta("stanza", "Giardino");
                lanterna.setEventoUso(new EventoImpostaFlag("lanterna-accesa", new EventoMostraMessaggio("Accendi la lanterna. La flebile luce tremolante rischiara le tue incertezze.")));
                gioco.getStanza("Stanza Bianca").aggiungiOggetto(lanterna);
                gioco.scrivi("Un momento. C'è qualcosa che prima non avevi notato.");
            }
        }
    }
}