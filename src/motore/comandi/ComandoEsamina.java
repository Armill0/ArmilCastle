package motore.comandi;

import motore.core.*;

/*
    Comando "esamina":
    Perlustra la stanza corrente e rivela gli oggetti presenti.
    Controlla anche se qualche oggetto nell'inventario
    rivela uscite nascoste nella stanza corrente.
 */
public class ComandoEsamina implements Comando {

    @Override
    public void esegui(Gioco gioco, String argomento) {
        gioco.scrivi(gioco.getStanzaCorrente().descriviOggetti());

        for (Oggetto o : gioco.getInventario()) {
            if (o.haProprieta("rivelaUscita")
                    && o.haProprieta("rivelaStanza")
                    && o.getProprieta("rivelaStanza").equalsIgnoreCase(gioco.getStanzaCorrente().getNome())
                    && gioco.getStanzaCorrente().haNascoste()) {

                String direzione = o.getProprieta("rivelaUscita");
                gioco.getStanzaCorrente().rivelaUscita(direzione);
                gioco.setFlag("botola-rivelata", true);
                gioco.scrivi("La " + o.getNome() + " vibra tra le tue mani... C'è qualcosa di nascosto qui.");
            }
        }

        if (gioco.getStanzaCorrente().haNpc()) {
            NPC npc = gioco.getStanzaCorrente().getNPC();
            gioco.scrivi(" - " + npc.getNome() + " è qui. " + npc.getDescrizione() + " (puoi parlarci se ti va)");
        }

        if(gioco.getStanzaCorrente().getNome().equalsIgnoreCase("Stanza vuota")
        && !gioco.getFlag("chiave-cuore-trovata")) {

            gioco.setFlag("chiave-cuore-trovata", true);
            gioco.aggiungiInventario(new Oggetto("Chiave del Cuore", "Non è una chiave come le altre. Non ha denti, non ha peso, non ha forma precisa. Eppure la riconosci - come si riconosce qualcosa che si è sempre saputo e mai ammesso. Era con te da quando sei entrato in questo castello. Forse da prima."));
            gioco.scrivi("Cerchi qualcosa. Non sai cosa. Poi la trovi — non per terra, non sulle pareti. Era con te da quando sei entrato in questo castello. Probabilmente da prima");
        }
    }
}