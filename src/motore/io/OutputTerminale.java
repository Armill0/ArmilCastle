package motore.io;

/*
    Usavo questa classe all'inizio per fare i test da terminale.
    Fa parte dell'architettura del motore che ho creato.
    Se dovesse dare problemi la GUI o ci fosse la necessità di fare debug,
    questa sarebbe la classe perfetta per provare un altro tipo di output.
 */

public class OutputTerminale  implements Output {

    @Override
    public void scrivi(String testo) {
        System.out.println(testo);
    }
}

