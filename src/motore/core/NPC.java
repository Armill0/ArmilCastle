package motore.core;

import java.util.Random;
import java.util.List;

/*
    NPC (Non-Player Character) rappresenta un personaggio non giocante all'interno del gioco.
 */

public class NPC {

    private final String nome;
    private final String descrizione;
    private final List<String> battute;
    private static final Random rnd = new Random();


    public NPC(String nome, String descrizione,  List<String> battute) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.battute = battute;
    }

    public String getNome()         { return nome;          }
    public String getDescrizione()  { return descrizione;   }

    public String parla() {
        return battute.get(rnd.nextInt(battute.size()));
    }
}