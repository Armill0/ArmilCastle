package motore.core;

import motore.io.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
    Classe centrale del motore.
    Tiene traccia dello stato del gioco:
    - stanza in cui si trova il giocatore;
    - inventario del giocatore;
    - mappa di tutte le stanze;
    - flag booleani porta aperta / chiusa
 */

public class Gioco {

    private Stanza stanzaCorrente;
    private final ArrayList <Oggetto>           inventario;
    private final HashMap   <String, Stanza>    mappaStanze;
    private final HashMap   <String, Boolean>   flagStato;
    private final HashSet   <String>            eventiConsumati;
    private       Output                        output;
    private       StatoGioco                    stato;
    private final HashSet   <String>            stanzeVisitate  = new HashSet<>();
    private int                                 contatoreVoce = 0;

    public Gioco (){
        this.inventario         = new ArrayList<>();
        this.mappaStanze        = new HashMap<>();
        this.flagStato          = new HashMap<>();
        this.eventiConsumati    = new HashSet<>();
        this.stato = StatoGioco.IN_CORSO;
    }

    // --- Gestione del contatore ---
    public void incrementaContatore()   {   contatoreVoce++;        }
    public int getContatoreVoce()       {   return contatoreVoce;   }


    // --- Gestione degli eventi consumati ---
    public void registraEventoConsumato(String id) {
        eventiConsumati.add(id);
    }



    public HashSet<String> getEventiConsumati() {
        return eventiConsumati;
    }


    public void ripristinaEventi() {
        for (Stanza s : mappaStanze.values()) {
            for (motore.eventi.Evento e : s.getEventi()) {
                if (e.hasId() && eventiConsumati.contains(e.getId())) {
                    e.forceConsuma();
                }
            }
        }
    }


    // --- Gestione stanze ---
    public void registraStanza(Stanza s) {
        mappaStanze.put(s.getNome(), s);
    }

    public Stanza getStanza(String nome) {
        return mappaStanze.get(nome);
    }

    public HashMap<String, Stanza> getMappaStanze() { return mappaStanze;   }

    public void setStanzaCorrente(Stanza s) {
        this.stanzaCorrente = s;
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public void registraStanzaVisitata(String nome) {
        stanzeVisitate.add(nome);
    }

    public HashSet<String> getStanzeVisitate() {
        return stanzeVisitate;
    }




    // --- Gestione inventario ---
    public void aggiungiInventario(Oggetto o) {
        inventario.add(o);
    }


    public void rimuoviInventario(Oggetto o) {
        inventario.remove(o);
    }


    // Cerca un oggetto nell'inventario per nome. Restituisce null se non trovato
    public Oggetto trovaInInventario(String nome){
        for (Oggetto o : inventario) {
            if (o.getNome().equalsIgnoreCase(nome)) {
                return o;
            }
        }
        return null;
    }


    public boolean haInInventario(String nome) {
        return trovaInInventario(nome) != null;
    }


    public ArrayList<Oggetto> getInventario() {
        return inventario;
    }


    public void setOutput(Output output) {
        this.output = output;
    }



    public void scrivi(String testo) {
        if (output !=  null) {
            output.scrivi(testo);
        }
    }




    // --- Flag di stato ---
    public void setFlag(String chiave, boolean valore) {
        flagStato.put(chiave, valore);
    }

    // lettura del flag. se non esiste restituisce default
    public boolean getFlag(String chiave) {
        return flagStato.getOrDefault(chiave, false);
    }




    // -- Controllo loop ---
    public boolean isInCorso() { return stato == StatoGioco.IN_CORSO; }

    public void avvia()             {this.stato = StatoGioco.IN_CORSO;  }
    public void termina()           {this.stato = StatoGioco.SCONFITTA; }
    public void vinci()             {this.stato = StatoGioco.VITTORIA;  }


}
