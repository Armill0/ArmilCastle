package motore.io;

import motore.core.*;

import java.io.*;

/*
    Classe responsabile del salvataggio e caricamento dello stato di gioco.
     - Salvataggio: scrive su file lo stato attuale del gioco (stanza corrente, inventario, eventi consumati)
     - Caricamento: legge da file lo stato di gioco e lo ripristina.

     Usa try with resources per garantire la chiusura automatica dei file anche in caso di errori.
 */

public class GestoreSalvataggio {

    private final String percorsoFile;

    public GestoreSalvataggio(String percorsoFile) {
        this.percorsoFile = percorsoFile;
    }

    // metodi d'appoggio di chicca
    private void recuperaOggettoNelMondo(Gioco gioco, String nome) {
        for (motore.core.Stanza s : gioco.getMappaStanze().values()) {
            motore.core.Oggetto trovato = s.trovaNomeOggetto(nome);
            if (trovato != null) {
                s.rimuoviOggetto(trovato);
                gioco.aggiungiInventario(trovato);
                return;
            }
        }
    }


    // --- Salvataggio ---
    public void salva(Gioco gioco) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(percorsoFile))) {
            bw.write("stanza:" + gioco.getStanzaCorrente().getNome());
            bw.newLine();

            StringBuilder inventario = new StringBuilder("inventario:");

            for (Oggetto o : gioco.getInventario()) {
                inventario.append(o.getNome()).append(";");
            }
            bw.write(inventario.toString());
            bw.newLine();

            for (String id : gioco.getEventiConsumati()) {
                bw.write("evento_consumato:" + id);
                bw.newLine();
            }

            gioco.scrivi("Credo di riuscire a tenere in mente tutti i dettagli per ora...");

        } catch (IOException e) {
            gioco.scrivi("Errore durante il salvataggio: " + e.getMessage());
            gioco.scrivi("Ma dove hai la testa?");
        }
    }


    // --- Caricamento ---
    public void carica(Gioco gioco) {
        try (BufferedReader br = new BufferedReader(new FileReader(percorsoFile))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(":");

                switch (parti[0]) {
                    case "stanza" -> {
                        motore.core.Stanza s = gioco.getStanza(parti[1]);
                        if (s != null) {
                            gioco.setStanzaCorrente(s);
                        }
                    }
                    case "inventario" -> {
                        if (parti.length > 1 && !parti[1].isEmpty()) {
                            String[] nomiOggetti = parti[1].split(";");
                            for (String nome : nomiOggetti) {
                                recuperaOggettoNelMondo(gioco, nome);
                            }
                        }
                    }
                    case "flag" -> {
                        if (parti.length == 3) {
                            gioco.setFlag(parti[1], Boolean.parseBoolean(parti[2]));
                        }
                    }
                    case "evento_consumato" -> {
                        if (parti.length > 1) {
                            gioco.registraEventoConsumato(parti[1]);
                        }
                    }
                }
            }
            gioco.ripristinaEventi();
            gioco.scrivi("Sembra che tu abbia ricordato tutto... O forse no? Solo il tempo lo dirà.");
        } catch (FileNotFoundException e) {
            gioco.scrivi("File di salvataggio non trovato. Forse è meglio così, non è detto che tu voglia ricordare tutto...");
        } catch (IOException e) {
            gioco.scrivi("Errore durante il caricamento: " + e.getMessage());
            gioco.scrivi("Oh no, non ricordo cosa dovevo ricordarmi... E tu?");
        }
    }

    public boolean esisteSalvataggio() {
        return new File(percorsoFile).exists();
    }
}
