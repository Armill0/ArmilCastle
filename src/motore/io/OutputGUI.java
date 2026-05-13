package motore.io;

public record OutputGUI (FinestraGioco finestra) implements Output {


    @Override
    public void scrivi(String testo) {
        finestra.scriviNarrativa(testo);
    }
}
