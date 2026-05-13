import motore.core   .*;
import motore.io     .*;

void main() {
        Gioco gioco                     = new Gioco ()                                          ;
        GestoreSalvataggio gestore      = new GestoreSalvataggio("salvataggio.txt")    ;

        CostruttoreMondo.costruisci(gioco);
        CostruttoreMondo.mostraMenuIniziale(gioco, gestore);
    }