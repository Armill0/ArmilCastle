package motore.comandi;

import motore.core.*;

/*
    Comando "usa":
    Permette al giocatore di utilizzare un oggetto presente nell'inventario.
 */
public class ComandoUsa implements Comando {

    @Override
    public void esegui(Gioco gioco, String argomento) {
        if (argomento == null || argomento.isEmpty()) {
            gioco.scrivi("Vuoi usare qualcosa, oltre la testa? Che cosa?");
            return;
        }

        Oggetto trovato = gioco.trovaInInventario(argomento);

        if (trovato == null) {
            gioco.scrivi("Non hai '" + argomento + "' nell'inventario.");
            return;
        }

        if (!trovato.isUsabile()) {
            gioco.scrivi("Al momento '" + trovato.getNome() + "' non sembra sortire alcun effetto.");
            return;
        }

        if (trovato.haProprieta("stanza")) {
            String stanzaRichiesta = trovato.getProprieta("stanza");
            if (!gioco.getStanzaCorrente().getNome().equalsIgnoreCase(stanzaRichiesta)) {
                gioco.scrivi("Non riesci ad usare '" + trovato.getNome() + "' qui. Chissà che ti è saltato in mente...");
                return;
            }
        }

        if (trovato.haProprieta("flagRichiesto")) {
            String flag = trovato.getProprieta("flagRichiesto");
            if (!gioco.getFlag(flag)) {
                gioco.scrivi("Non sembra esserci nulla su cui usare '" + trovato.getNome() + "' al momento.");
                return;
            }
        }

        trovato.getEventoUso().attiva(gioco);
    }
}