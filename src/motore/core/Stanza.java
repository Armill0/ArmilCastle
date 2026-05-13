package motore.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import motore.eventi.*;

/*
    Rappresenta una stanza nel mondo di gioco.
    Ogni stanza conosce:
    - il suo nome e descrizione
    - gli oggetti che contiene
    - le uscite verso altre stanze (es. "Nord" -> stanza2)
 */

public class Stanza {

    private String nome;
    private String descrizione;
    private final HashMap<String,Stanza> uscite;
    private final HashMap<String,Stanza> usciteNascoste;
    private final ArrayList<Oggetto> oggetti;
    private final ArrayList<Evento> eventi;
    private NPC npc;

    public Stanza(String nome, String descrizione) {
        setNome(nome);
        setDescrizione(descrizione);
        this.uscite             = new HashMap<>()   ;
        this.usciteNascoste     = new HashMap<>()   ;
        this.oggetti            = new ArrayList<>() ;
        this.eventi             = new ArrayList<>() ;
    }

    public void setNome(String nome)                { this.nome        = nome;        }
    public void setDescrizione(String descrizione)  { this.descrizione = descrizione; }
    public void setNPC(NPC npc)                     { this.npc         = npc;         }

    public String  getNome()                        { return this.nome;               }
    public String  getDescrizione()                 { return this.descrizione;        }
    public NPC     getNPC()                         { return this.npc;                }
    public boolean haNpc()                          { return this.npc != null;        }


    // --- Gestione delle uscite

    // Collega questa stanza a un'altra in una direzione
    // Es. Ingresso.collegaUscita("nord", "corridoio");
    public void collegaUscita(String direzione, Stanza destinazione) {
        uscite.put(direzione.toLowerCase(),  destinazione);
    }

    // Restituisce la stanza in una direzione, oppure null se non c'è uscita in quella direzione
    public Stanza getUscita(String direzione) {
        return uscite.get(direzione.toLowerCase());
    }


    // --- Gestione delle stanze nascoste
    public void aggiungiUscitaNascosta(String direzione, Stanza destinazione) {
        usciteNascoste.put(direzione.toLowerCase(), destinazione);
    }

    // Rivelazione dell'uscita nascosta
    public void rivelaUscita (String direzione) {
        Stanza destinazione = usciteNascoste.remove(direzione.toLowerCase());

        if (destinazione != null) {
            uscite.put(direzione.toLowerCase(), destinazione);
        }
    }

    public boolean haNascoste() {
        return !usciteNascoste.isEmpty();
    }


    // --- Gestione degli oggetti

    public void aggiungiOggetto(Oggetto o){
        oggetti.add(o);
    }

    public void rimuoviOggetto(Oggetto o){
        oggetti.remove(o);
    }

    // Cerca un oggetto nella stanza, per nome. Restituisce null se non trovato.
    public Oggetto trovaNomeOggetto(String nome){
        for (Oggetto o : oggetti) {
            if (o.getNome().equalsIgnoreCase(nome)) {
                return o;
            }
        }
        return null;
    }

    public ArrayList<Oggetto> getOggetti() {
        return oggetti;
    }

     // Restituisce una stringa con la descrizione della stanza, le uscite e gli oggetti presenti.
     public String descriviCompleta() {
         StringBuilder sb = new StringBuilder();
         sb.append("=== ").append(nome).append(" ===\n");
         sb.append("Descrizione: ").append(descrizione).append("\n");

         // Uscite disponibili con destinazione
         sb.append("\nUscite: ");
         StringBuilder usciteString = new StringBuilder();
         for (Map.Entry<String, Stanza> e : uscite.entrySet()) {
             if (!usciteString.isEmpty()) usciteString.append(", ");
             usciteString.append(e.getKey()).append(" (").append(e.getValue().getNome()).append(")");
         }
         sb.append(usciteString);
         sb.append("\n");

         return sb.toString();
     }

    public String descriviOggetti(){
        if (oggetti.isEmpty()) {
            return "Non noti nulla di intrigante, o anche solo vagamente utile.";
        }
        StringBuilder sb = new StringBuilder("Guardando con attenzione... Noti:\n");
        for (Oggetto o : oggetti) {
            sb.append(" - " ).append(o.toString()).append("\n");
        }
        return sb.toString();
    }

    // --- Gestione degli eventi
    public void aggiungiEvento(Evento e){
        eventi.add(e);
    }

    public ArrayList<Evento> getEventi() {
        return eventi;
    }

    // Attivazione degli eventi interni alla stanza
    public void attivaEventi(Gioco gioco) {
        for (Evento e : eventi) {
            e.attiva(gioco);
        }
    }
}
