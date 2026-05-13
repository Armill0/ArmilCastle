package motore.core;

import java.util.HashMap;
import motore.eventi.*;

/*
    Rappresenta un oggetto che può trovarsi in una stanza, o nell'inventario del giocatore.
 */

public class Oggetto {

    private String nome;
    private String descrizione;
    private final HashMap<String, String> proprieta;
    private Evento eventoUso;

    public Oggetto(String nome, String descrizione) {
        setNome(nome);
        setDescrizione(descrizione);
        this.proprieta = new HashMap<>();
    }

    public void setNome(String nome)               { this.nome        = nome;        }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public void setEventoUso(Evento eventoUso)     { this.eventoUso   = eventoUso;   }

    public String getNome()                        { return this.nome;               }
    public String getDescrizione()                 { return this.descrizione;        }
    public Evento getEventoUso()                   { return this.eventoUso;          }

    public boolean isUsabile() {
        return eventoUso != null;
    }

    // --- GESTIONE PROPRIETA ---


    // Imposta una proprietà arbitraria sull'oggetto.
    // Esempio: oggetto.setProprietà("usabile", "true");
    public void setProprieta(String chiave, String valore) {
        proprieta.put(chiave, valore);
    }


    // Restituisce il valore di una proprietà, oppure null se non esiste.
    public String getProprieta(String chiave) {
        return proprieta.get(chiave);
    }

    // Controlla se l'oggetto ha una certa proprietà.
    public boolean haProprieta(String chiave) {
        return proprieta.containsKey(chiave);
    }

    @Override
    public String toString() {
        return nome + " - " +  descrizione;
    }

}
