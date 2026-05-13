package motore.core;

import motore.comandi.*;
import motore.eventi.*;
import motore.io.*;

import javax.swing.*;
import java.util.List;

/*
    Classe di utilità che userò per avviare il Main, lasciandolo il più`possibile pulito.
    Costruisce il mondo di gioco e contiene tutta la configurazione.
    Utilizzerò tutti metodi statici.
 */


public class CostruttoreMondo {

    private CostruttoreMondo() {} // il costruttore privato impedisce la creazione di istanze della classe

    public static void costruisci(Gioco gioco) {
        // --- Stanze ---
        // PIANO TERRA
        Stanza ingresso             = new Stanza("Ingresso",                "Sei all’ingresso di un imponente castello gotico.\nDavanti a te si apre un labirinto di possibilità, così vasto da paralizzare ogni pensiero. Le porte alle tue spalle sono chiuse. Non ricordi di averle aperte. Il castello si estende davanti a te — ombre, respiri, attese. Qualcosa qui dentro ti conosce.\nTi guardi attorno...");
        Stanza corridoio            = new Stanza("Corridoio",               "Sei in un corridoio buio. Senti odore di muffa. Dove pensi di andare?");
        Stanza giardino             = new Stanza("Giardino",                "Ti trovi in un giardino fiorito. Tra rose e orchidee forse anche qualche idea strampalata potrà fiorire.");
        Stanza cappella             = new Stanza("Cappella",                "Una cappella piccola, con vetrate che mostrano scene che non riconosci. Sull'altare, nessuna divinità — solo uno specchio, rivolto verso di te.");
        Stanza cucina               = new Stanza("Cucina Abbandonata",      "Pentole sporche, tavoli apparecchiati, cibo oramai raffreddato. C'era qualcuno qui. Qualcuno che non è mai tornato a tavola.  Forse è meglio così.");
        Stanza biblioteca           = new Stanza("Biblioteca",              "Scaffali che toccano il soffitto, libri ovunque. Li apri — le pagine sono bianche. Tutti. Eppure qualcuno li ha scritti, rilegati, messi in ordine. Come se il contenuto non fosse mai stato importante quanto il gesto di preservarlo.");
        Stanza salaArmature         = new Stanza("Sala delle armature",     "Sette armature vuote si fronteggiano in due file. Nessuna porta un nome. Nessuna porta un volto. Eppure hai la sensazione che ognuna di esse abbia una storia — e che tu ne conosca almeno una.  Come hai fatto a dimenticare?");
        Stanza armeria              = new Stanza("Armeria",                 "Armi appese alle pareti, tutte perfettamente conservate. Mai usate. Per cosa sono state prese?");
        // PRIMO PIANO
        Stanza corridoioDeiRitratti = new Stanza("Corridoio dei ritratti",  "Ritratti di persone che non conosci. Eppure i loro occhi sembrano seguire ogni tuo movimento.");
        Stanza cameraDaLetto        = new Stanza("Camera da letto",         "Un letto disfatto, come se qualcuno si fosse alzato di fretta. Sul comodino, un bicchiere d'acqua ancora pieno. Una finestra aperta su un cielo che non cambia mai.");
        Stanza stanzaDeiGiochi      = new Stanza("Stanza dei giochi",       "Piccoli cubi in legno scoloriti impilati, bambole senza volto sparse qua e la', pedine di legno raffinato su una scacchiera.  Manca una pedina.  Sul pavimento, disegnato con dei pastelli, un percorso che indica un muro. Quasi come se si potesse attraversare.");
        Stanza studio               = new Stanza("Studio",                  "Una scrivania sommersa di carte, calcoli, schizzi. Qualcuno stava cercando di risolvere qualcosa di importante. Ma... Cosa?  Nell'aria, appena percettibile, odore di caffè freddo e di notti che non finivano mai.");
        Stanza salaMusica           = new Stanza("Sala della musica",       "Non sei solo. Strumenti e musica ti accompagnano in questa sala che sembra ti abbia fatto entrare in punta di piedi. Una melodia si ripete, uguale a sé stessa, come se non dovesse mai finire.");
        Stanza salaDelTrono         = new Stanza("Sala del trono",          "Numerose colonne di marmo si innalzano come spine bianche verso un soffitto d'oro immobile, un cielo artificiale che non conosce il passare del tempo. I lampadari di cristallo frantumano la luce in mille schegge, e ogni riflesso sembra un ricordo che non scalda più. Il velluto cremisi ricopre ogni superficie con una cura ossessiva: braccioli, gradini, pareti. Un lusso così perfetto da sembrare finto, come un sogno ripetuto troppe volte.  Eppure, nell'aria c’è un freddo che non appartiene alla pietra. È il freddo di chi resta fermo troppo a lungo. Di chi ha dimenticato perché' è arrivato fin qui.  Al centro della sala, il trono. Enorme. Lussuoso. Vuoto. Un vuoto che chiama. Non importa chi tu sia, né da dove vieni: una parte di te vorrebbe sedersi lì, anche solo per un istante. Come se bastasse quel gesto per mettere a tacere il rumore del mondo, per allontanare le battaglie, per smettere di chiedersi cosa fare dopo.  È un pensiero dolce, quasi innocente. Ed è proprio questo che lo rende pericoloso.  Perché in questa sala nulla si muove. Nulla cambia. Nulla cresce.  È un luogo costruito senza volerlo, un rifugio nato dal peso degli anni, dalle convinzioni che diventano muri, dagli obiettivi che diventano catene. Qui tutto è perfetto, sì... ma è una perfezione che non vive. Una perfezione che non serve più a niente.  E mentre osservi il trono, ti rendi conto che sembrerebbe un posto perfetto per te. Talmente perfetto da farti dimenticare che, fuori da queste mura, c’è ancora qualcosa che ti aspetta.  Qualcosa che non puoi trovare qui dentro.");
        // SECONDO PIANO
        Stanza corridoioCircolare   = new Stanza("Corridoio Circolare",     "Un corridoio che gira su sé stesso. Hai la certezza di aver già passato quella torcia spenta. E quella crepa nel muro. E quel disegno sul pavimento.");
        Stanza stanzaCapovolta      = new Stanza("Stanza capovolta",        "Una stanza capovolta, distorta come un pensiero fuori asse. Le pareti sembrano piegarsi su sé stesse. Il pavimento diventa soffitto. Qui, il mondo perde contorni, scivola ai margini. Il tempo striscia in fondo alle priorità, come se nulla attorno avesse abbastanza importanza da essere percepito.");
        Stanza terrazza             = new Stanza("Terrazza",                "Una terrazza che si affaccia su nulla. Non c’è paesaggio — solo nebbia bianca fino all'orizzonte. L'aria è ferma. Non fa né caldo né freddo.");
        Stanza stanzaDegliSpecchi   = new Stanza("Stanza degli specchi",    "Specchi ovunque — sul soffitto, sul pavimento, sulle pareti. Ogni riflesso mostra una versione diversa di te. Alcuni ti guardano. Uno di essi sorride, anche quando tu non lo fai. Un attimo, ricordi ancora da dove sei entrato?");
        Stanza stanzaBianca         = new Stanza("Stanza Bianca",           "Una stanza completamente bianca. Nessun mobile, nessuna finestra, nessuna porta visibile — eppure sei entrato. Le pareti assorbono il suono. Qui dentro, i tuoi pensieri sembrano più rumorosi.");
        Stanza portaSbagliata       = new Stanza("Porta sbagliata",         "Una porta che sembra uguale alle altre. Non lo è.");
        Stanza portaEco             = new Stanza("Stanza dell'eco",         "Tutto quello che dici in questa stanza torna indietro — ma le parole sono diverse. Come se il castello le correggesse.");
        Stanza balconeVuoto         = new Stanza("Balcone sul Vuoto",       "Un balcone che si affaccia sull'interno del castello — ma dall'interno non hai mai visto questo balcone. Guardando giù, vedi tutte le stanze contemporaneamente, come se le pareti fossero trasparenti.  E lì, al centro del primo piano, qualcosa che non avevi notato prima. Come hai fatto a non vederla?");
        // SOTTERRANEI
        Stanza cantina              = new Stanza("Cantina",                 "Sei in una cantina umida e buia. Senti odore di vino e muffa. Non hai idea di come sei finito in questa situazione, ma forse è meglio così. Un attimo... A che servirebbe un passaggio segreto se non portasse a nulla? Il mistero s'infittisce.");
        Stanza cantinaProfond       = new Stanza("Cantina - Profondità",    "Stiamo scendendo... o salendo? In quest'area facente parte della cantina, troviamo qualcosa che non avremmo mai voluto trovare: la voglia di arrenderci, di lasciar perdere ogni peso portato sulle spalle e lasciarsi sopraffare... La sola idea è inebriante.");
        Stanza corridoioAllagato    = new Stanza("Corridoio Allagato",      "Il pavimento è coperto d'acqua — pochi centimetri, ma abbastanza da riflettere tutto. Nonostante il livello dell'acqua sia basso, senti di annegare qui dentro. Le impronte scompaiono immediatamente... Come se non fossi mai stato qui.");
        Stanza stanzaDeiNomi        = new Stanza("Stanza dei nomi",         "Le pareti sono coperte di nomi incisi nella pietra. Migliaia di nomi. Cerchi il tuo — non c’è. O forse non lo ricordi abbastanza bene da riconoscerlo.");
        Stanza salaDeiPassi         = new Stanza("Sala dei passi",          "Senti passi dietro di te. Ti giri — nessuno. Vai avanti — i passi ricominciano. Alla fine, capisci: sono i tuoi passi di prima, che il castello ha conservato.  Quanto tempo abbiamo passato in questo abisso?");
        Stanza stanzaVuota          = new Stanza("Stanza vuota",            "Non c’è nulla. Nessun oggetto, nessun rumore, nessuna porta visibile. Solo spazio.  Eppure, più a lungo resti qui, più senti qualcosa. Non fuori. Dentro.");
        Stanza pozzo                = new Stanza("Pozzo",                   "Un pozzo al centro della stanza. Non si vede il fondo. La luce della lanterna si fa meno intensa... C'è nessuno?");
        Stanza stanzaLuce           = new Stanza("Stanza della luce",       "In fondo a tutto — una stanza avvolta dall’oscurità. C'era una targhetta sulla porta con su scritta la parola 'Luce'. Che contrasto inquietante. Ma cosa si cela in quest’oscurità?");
        // CUORE
        Stanza cuore                = new Stanza("Stanza del Cuore",        "Qualcosa si spezza. Non il muro - quello era già caduto. Qualcosa dentro.\nUn raggio di luce fioca perfora la penombra del castello, mentre percorri quello che sembra un sentiero verso l'uscita. Non pensavo si potesse arrivare fin qui… ma sono contento per te. Per noi.\nI colori si aprono in scie vive, e volti che credevamo perduti tornano nitidi davanti a noi. Per la prima volta sentiamo che tutto si muove attorno a noi — cresce, respira, cambia. \nMi fa un po' paura, questa vita che ricomincia a scorrere… \n...Che stavo dicendo?"
        );


        // --- Collegamenti tra le stanze ---
        // PIANO TERRA
        ingresso.collegaUscita                      ("nord" , corridoio             );
        ingresso.collegaUscita                      ("est"  , biblioteca            );
        ingresso.aggiungiUscitaNascosta             ("sud"  , giardino              );
        ingresso.collegaUscita                      ("ovest", cappella              );

        cappella.collegaUscita                      ("est"  , ingresso              );

        biblioteca.collegaUscita                    ("ovest", ingresso              );

        corridoio.collegaUscita                     ("sud"  , ingresso              );
        corridoio.collegaUscita                     ("ovest", salaArmature          );
        corridoio.collegaUscita                     ("est"  , cucina                );
        corridoio.aggiungiUscitaNascosta            ("su"   , corridoioDeiRitratti  );

        salaArmature.collegaUscita                  ("nord" , armeria               );
        salaArmature.collegaUscita                  ("est"  , corridoio             );

        armeria.collegaUscita                       ("sud"  , salaArmature          );

        cucina.collegaUscita                        ("ovest", corridoio             );

        giardino.collegaUscita                      ("nord" , ingresso              );
        giardino.aggiungiUscitaNascosta             ("giù"  , cantina               );

        // 1° PIANO
        corridoioDeiRitratti.collegaUscita          ("giù"  , corridoio             );
        corridoioDeiRitratti.collegaUscita          ("ovest", stanzaDeiGiochi       );
        corridoioDeiRitratti.collegaUscita          ("est"  , salaMusica            );
        corridoioDeiRitratti.collegaUscita          ("su"   , corridoioCircolare    );
        corridoioDeiRitratti.aggiungiUscitaNascosta ("nord" , salaDelTrono          );

        stanzaDeiGiochi.collegaUscita               ("est"  , corridoioDeiRitratti  );
        stanzaDeiGiochi.aggiungiUscitaNascosta      ("nord" , studio                );

        studio.collegaUscita                        ("sud" , stanzaDeiGiochi        );

        salaMusica.collegaUscita                    ("ovest", corridoioDeiRitratti  );
        salaMusica.collegaUscita                    ("est"  , cameraDaLetto         );

        cameraDaLetto.collegaUscita                 ("ovest", salaMusica            );

        salaDelTrono.collegaUscita                  ("sud"  , corridoioDeiRitratti  );

        // 2° PIANO
        corridoioCircolare.collegaUscita            ("giù"  , corridoioDeiRitratti  );
        corridoioCircolare.collegaUscita            ("ovest", stanzaDegliSpecchi    );
        corridoioCircolare.collegaUscita            ("est"  , portaEco              );
        corridoioCircolare.collegaUscita            ("nord" , balconeVuoto          );

        stanzaDegliSpecchi.collegaUscita            ("est"  , corridoioCircolare    );
        stanzaDegliSpecchi.aggiungiUscitaNascosta   ("nord" , terrazza              );

        terrazza.collegaUscita                      ("sud"  , stanzaDegliSpecchi    );

        portaEco.collegaUscita                      ("ovest", corridoioCircolare    );
        portaEco.collegaUscita                      ("sud"  , stanzaCapovolta       );

        stanzaCapovolta.collegaUscita               ("nord" , portaEco              );
        stanzaCapovolta.collegaUscita               ("ovest", stanzaBianca          );
        stanzaCapovolta.collegaUscita               ("est"  , portaSbagliata        );

        stanzaBianca.collegaUscita                  ("est"  , stanzaCapovolta       );

        portaSbagliata.collegaUscita                ("ovest", stanzaCapovolta       );

        balconeVuoto.collegaUscita                  ("sud"  , corridoioCircolare    );

        // SOTTERRANEI
        cantina.collegaUscita                       ("nord" , cantinaProfond      );
        cantina.collegaUscita                       ("est"  , corridoioAllagato   );
        cantina.collegaUscita                       ("ovest", salaDeiPassi        );

        cantinaProfond.collegaUscita                ("sud"  , cantina             );

        corridoioAllagato.collegaUscita             ("ovest", cantina             );
        corridoioAllagato.collegaUscita             ("est"  , stanzaDeiNomi       );

        stanzaDeiNomi.collegaUscita                 ("ovest", corridoioAllagato   );
        stanzaDeiNomi.collegaUscita                 ("nord" , stanzaVuota         );

        stanzaVuota.collegaUscita                   ("sud"  , stanzaDeiNomi       );
        stanzaVuota.collegaUscita                   ("est"  , pozzo               );
        stanzaVuota.aggiungiUscitaNascosta          ("ovest", stanzaLuce          );

        pozzo.collegaUscita                         ("ovest", stanzaVuota         );

        stanzaLuce.collegaUscita                    ("est"  , stanzaVuota         );

        salaDeiPassi.collegaUscita                  ("est"  , cantina             );



        // --- Creazione oggetti ---
        Oggetto chiave              = new Oggetto("chiave",             "Una vecchia chiave arrugginita.");
        Oggetto sferaDiCristallo    = new Oggetto("sfera di cristallo", "Una sfera di cristallo apparentemente inutile. Si narra che nelle mani giuste possa predire il futuro.");
        Oggetto lanterna            = new Oggetto("lanterna",           "Una lanterna a olio. Potrebbe essere utile per illuminare luoghi bui come... La coscienza.");
        Oggetto cannocchiale        = new Oggetto("cannocchiale",       "Un cannocchiale consunto. A che serve?");
        Oggetto elmo                = new Oggetto("elmo",               "Un elmo che ha visto troppe battaglie. Sul bordo interno, incisa con uno strumento appuntito, una parola: 'resisti'. Resistere a cosa, esattamente?");
        Oggetto spada               = new Oggetto("spada",              "La metà di una spada. Il taglio è irregolare — c'era una crepa, e nessuno se n’è accorto in tempo. O forse se n’è accorto, e ha pensato che potesse aspettare.");
        Oggetto libro               = new Oggetto("libro",              "L'unico libro con qualcosa di scritto dentro. Le parole sembrano sillabe sparse, incomprensibili. In fondo alla pagina, quasi nascosta, un'unica parola: 'luce'.");
        Oggetto candela             = new Oggetto("candela",            "Una candela che è rimasta accesa così a lungo da non avere quasi piu' cera. Brucia ancora. Non sai come.");
        Oggetto ricetta             = new Oggetto("ricetta",            "Un foglio con una ricetta scritta a mano. Gli ingredienti sono illeggibili — tranne l'ultimo: 'un motivo per restare'. Sembra un ingrediente estraneo al castello.");
        Oggetto pennello            = new Oggetto("pennello",           "Un pennello con il pelo indurito di vernice secca. Il colore è quello degli occhi di qualcuno che non riesci a ricordare. Forse riusciresti a disegnarlo, impegnandoti.");
        Oggetto alfiere             = new Oggetto("alfiere",            "Una pedina di una scacchiera, dai lineamenti molto eleganti. Che ci fa qui?");
        Oggetto spartitoStrappato   = new Oggetto("spartito strappato", "Metà di uno spartito. Le note che mancano sono quelle del finale — o forse dell'inizio. Impossibile dirlo. Sul retro, una serie di calcoli: distanze, proporzioni, coordinate. Qualcuno ha trovato la posizione delle dita sul pianoforte senza conoscere una nota. Come se la matematica potesse recuperare quello che la memoria ha perso.");
        Oggetto appuntiCifrati      = new Oggetto("appunti cifrati",    "Pagine di numeri e simboli che non seguono nessun sistema conosciuto. Forse qualcuno saprebbe come interpretarli.");
        Oggetto frammentoSpecchio   = new Oggetto("frammento di vetro", "Un frammento di specchio rotto. Fai attenzione nel maneggiarlo, potresti tagliarti. In un mondo dove tutto è una finzione, il riflesso in questo specchio mostra la verità.");
        Oggetto giocattolo          = new Oggetto("giocattolo",         "Ai piedi del trono, quasi inghiottito dal velluto cremisi, un piccolo cavallo di legno. Levigato dal tempo, consumato dalle mani di qualcuno che lo ha tenuto stretto per anni. In mezzo a questo lusso immobile, sembra una reliquia di un tempo in cui non esisteva ancora tutto questo. Ti cuce addosso un'inspiegabile nostalgia.");
        Oggetto calendarioTascabile = new Oggetto("calendario",         "Un vecchio calendario tascabile. Metà dei giorni sono segnati. Gli altri no. Come se in un anno ci fossero metà dei mesi... metà degli istanti. Non capisci se chi l'ha usato ha smesso di contare, o se, semplicemente, ha smesso di importargliene.");
        Oggetto diarioSenzaAutore   = new Oggetto("diario senza autore","Un diario con date che non esistono nel calendario. Gli ultimi tre mesi sono stati strappati.");
        Oggetto bottigliaSEtichetta = new Oggetto("bottiglia anonima",  "Una bottiglia senza etichetta. Non sai da dove proviene. La stappi. Odora di qualcosa che non riesci a descrivere — come un ricordo che stai per afferrare, ma che scivola via.");
        Oggetto scalpello           = new Oggetto("scalpello",          "Qualcuno lo ha usato per incidere tutti quei nomi. Il manico è consumato — ci sono voluti anni. Sta per rompersi, ma... Senti di poterlo utilizzare ancora prima che accada.");
        Oggetto chiaveCuore         = new Oggetto("chiave del cuore",   "Non è una chiave come le altre. Non ha denti, non ha peso, non ha forma precisa. Eppure la riconosci — come si riconosce qualcosa che si è sempre saputo e mai ammesso. Era con te da quando sei entrato in questo castello. Forse da prima.");


        portaSbagliata.         aggiungiOggetto (sferaDiCristallo    );
        giardino.               aggiungiOggetto (chiave              );
        terrazza.               aggiungiOggetto (cannocchiale        );
        armeria.                aggiungiOggetto (spada               );
        salaArmature.           aggiungiOggetto (elmo                );
        biblioteca.             aggiungiOggetto (libro               );
        cappella.               aggiungiOggetto (candela             );
        cucina.                 aggiungiOggetto (ricetta             );
        cameraDaLetto.          aggiungiOggetto (pennello            );
        corridoioDeiRitratti.   aggiungiOggetto (alfiere             );
        stanzaDeiGiochi.        aggiungiOggetto (spartitoStrappato   );
        studio.                 aggiungiOggetto (appuntiCifrati      );
        salaMusica.             aggiungiOggetto (frammentoSpecchio   );
        salaDelTrono.           aggiungiOggetto (giocattolo          );
        corridoioCircolare.     aggiungiOggetto (calendarioTascabile );
        portaEco.               aggiungiOggetto (diarioSenzaAutore   );
        cantinaProfond.         aggiungiOggetto (bottigliaSEtichetta );
        stanzaDeiNomi.          aggiungiOggetto (scalpello           );


        // --- Proprietà degli oggetti ---
        chiaveCuore.        setProprieta        ("rivelaOggetto", "chiave del cuore"        );
        chiaveCuore.        setProprieta        ("rivelaStanza",  "Stanza vuota"            );
        chiave.             setProprieta        ("stanza",        "Giardino"                );
        chiave.             setProprieta        ("flagRichiesto", "botola-rivelata"         );
        lanterna.           setProprieta        ("stanza",        "Giardino"                );
        sferaDiCristallo.   setProprieta        ("rivelaUscita" , "giù"                     );
        sferaDiCristallo.   setProprieta        ("rivelaStanza",  "Giardino"                );
        cannocchiale.       setProprieta        ("stanza",        "Terrazza"                );
        pennello.           setProprieta        ("stanza",        "Corridoio dei ritratti"  );
        pennello.           setProprieta        ("flagRichiesto", "tela-rivelata"           );
        alfiere.            setProprieta        ("stanza",        "Stanza dei giochi"       );
        frammentoSpecchio.  setProprieta        ("rivelaUscita",  "nord"                    );
        frammentoSpecchio.  setProprieta        ("rivelaStanza",  "Stanza degli specchi"    );
        scalpello.          setProprieta        ("stanza",        "Sala del trono"          );
        giocattolo.         setProprieta        ("stanza",        "Stanza della luce"       );
        spartitoStrappato.  setProprieta        ("stanza",        "Sala della musica"       );
        bottigliaSEtichetta.setProprieta        ("stanza",        "Cucina Abbandonata"      );
        ricetta.            setProprieta        ("stanza",        "Cantina - Profondità"    );
        diarioSenzaAutore.  setProprieta        ("stanza",        "Stanza dell'eco"         );
        candela.            setProprieta        ("stanza",        "Pozzo"                   );


        // --- Creazione degli NPC ---
        NPC ubriacone = new NPC("Vecchio ubriacone",
                "Un vecchio dall'aria vissuta, seduto in un angolo. Fuma una sigaretta raggrinzita almeno quanto la sua pelle. Sembra... Ubriaco?",
                List.of(
                        "Ho lavorato tutta la vita per qualcosa che non ricordo più cos'era. Ah-ah-ah! Che hai da ridere? Ti ammazzo.",
                        "Mi ricordi mia moglie. Diceva sempre che non l'ascoltavo. Forse aveva ragione. Forse stavo solo aspettando che smettesse di parlare per tornare a pensare.",
                        "Ho cercato qualcosa in questo posto per tanto tempo. Sai, non ricordo per nulla cosa stavo cercando. Ah-ah-ah! *uhg*",
                        "Ricordi come sei giunto qui? Penso di essermi perso, ma non so quando e dove... Se solo il mondo smettesse di girare... Cosa? Non sta girando? Smettila di prenderti gioco di me. *uhhhg*",
                        "Se dovessi sentirti perso, sappi QUESTO: la LUCE non serve ad illuminare i luoghi, ma a NON PERDERE te stesso. *burp*",
                        "Certe porte non si aprono con la forza. Si aprono quando capisci perché sono chiuse. Accidenti, la nausea...",
                        "Una volta avevo una lanterna. La lasciai da qualche parte pensando di non averne bisogno. Fu il mio errore più grande. Perché dici? ...Perché, cosa?",
                        "Credo di aver girato ogni angolo di questo castello inutilmente sfarzoso. Gli angoli più interessanti erano quelli che sembravano vuoti.",
                        "Chissà se riuscirò a prendere almeno questo treno... Ma che dico, oramai non servirebbe più a nulla.",
                        "È forse questa la solitudine? Dannazione, perché ho questi pensieri proprio ora?",
                        "Non sono arrabbiato! Sono solo stanco di fare finta che vada bene... Capisci che intendo?",
                        "Chiedere aiuto spesso mi ha riportato sui binari. Peccato che lo abbia capito tardi.",
                        "..."
                ));
        NPC cuoca = new NPC("La Cuoca",
                "Una donna anziana che aspetta. Non è ben chiaro chi, cosa e da quanto.",
                List.of(
                        "Ma quanto ci vuole ancora?",
                        "La minestra è pronta. Sempre pronta. Credo",
                        "Non so più che ora è. Non so più che giorno è. Ma la minestra è pronta.",
                        "Siediti. Non devi dire niente. Sii composto.",
                        "Perchè hai tardato tanto? Un attimo... Chi sei tu?",
                        "Un tempo qualcuno mi disse che avrei dovuto mangiare ancora tanto minestrone... Dovrebbe assaggiare la mia minestra ora!",
                        "Chissà che bolle in pentola... Ah-ah!",
                        "..."));
        NPC bibliotecario = new NPC("Il Bibliotecario",
                "Un uomo che sistema libri vuoti con la cura di chi custodisce tesori. Ti guarda come se ti riconoscesse.",
                List.of(
                        "Ogni libro qui dentro apparteneva a qualcuno. Quando se ne vanno, le parole spariscono. Sono convinto che prima o poi torneranno.",
                        "Stai cercando qualcosa? Tra le parole ormai sbiadite non penso che troverai ciò che cerchi.",
                        "Ho letto tutto quello che c'era da leggere, da prima che le parole scomparissero. Eppure non riesco a ricordare quanto letto. Non mi resta che aspettare...",
                        "A volte mi chiedo se qualcuno ricorda di aver scritto questi libri. La curiosità è una mia fedele compagna, sai?",
                        "Ti aspettavo. Non sapevo che fossi tu, ma ti aspettavo.",
                        "..."
                        ));
        NPC bambino = new NPC("Il Bambino",
                "Un bambino seduto per terra, che costruisce qualcosa con dei blocchi di legno. È davvero un bambino? I suoi vestiti ricordano più un anziano...",
                List.of(
                        "Stavo costruendo una torre. È caduta. La ricostruirò. Ho tutto il tempo del mondo. O almeno, così pensavo...",
                        "Mio padre custodiva i suoi segreti all'interno del suo studio. Diceva che certi posti vanno trovati, non mostrati.",
                        "Sai giocare? Prometto di rivelarti un segreto se vinci",
                        "Una volta sapevo giocare. Poi ho dimenticato le regole. Poi ho dimenticato il gioco. Poi ho dimenticato perchè importasse.",
                        "I bambini di adesso non sanno cosa si perdono. Noi sì che sapevamo stare in silenzio.",
                        "Siediti. Gioca con me. Non andare via come hanno fatto gli altri.",
                        "..."
                ));
        NPC musicista = new NPC("Il Musicista",
                "Un uomo seduto al pianoforte, la schiena dritta, le dita che si muovono con una precisione chirurgica, quasi innaturale. La melodia si ripete ciclicamente — sempre uguale, quasi perfetta.",
                List.of(
                        "Q-questa melodia... La sentivo da bambino. O forse la sognavo. Non sono sicuro.",
                        "V-vuoi sentirla? Si-siediti. *la musica si intensifica*",
                        "Ho imp-impiegato anni a capire dove mettere le dita. Non conosco le note, ma...",
                        "Se la suono abbastanza volte, forse ri-ricorderò da dove viene...",
                        "... (continua a suonare, come se non fossi mai e-entrato. Un attimo perchè anche il narratore sta balbettando!?)"
                ));
        NPC voce = new NPC("La Voce",
                "Non c'è nessuno. Eppure odi una voce che sussurra il tuo nome — o quello che era il tuo nome, una volta.",
                List.of(
                        "Hai intenzione di tornare, prima o poi?",
                        "Sapevo che saresti venuto fin qui. È quello che hai sempre fatto.",
                        "Non devi rispondermi. So già cosa pensi.",
                        "Quando sei pronto, la porta è alle mie spalle. È sempre stata lì.",
                        "Cosa c'è lì dentro? Oh, davvero non ci arrivi da solo?",
                        "..."
                ));
        NPC sommelier = new NPC("Il Sommelier",
                "Un uomo che annusa bottiglie vuote con l'espressione di chi assaggia qualcosa di straordinario.",
                List.of(
                        "Questo è un'ottima annata. 1987. O forse 2003. O forse non è mai esistita.",
                        "Il vino migliore è quello che non hai ancora bevuto.",
                        "Ho dimenticato l'odore di tutto. Ma continuo ad annusare. Il gesto mi basta.",
                        "È passato così tanto tempo che potrebbero darmi minestra e la scambierei per vino.",
                        "..."
                ));
        NPC anziana = new NPC("L'Anziana",
                "Una donna seduta sul bordo del pozzo. Non guarda dentro — guarda te.",
                List.of(
                        "Stai cercando il fondo? Non c'è nulla qui. Dovresti andartene.",
                        "Ho buttato dentro tutto quello che non volevo più portare. Non è servito a niente...",
                        "Il peso non sta nelle cose. Lo sai già. Davvero non ricordi..?",
                        "Torna su. C'è ancora luce, là sopra.",
                        "Quella lanterna non ti basterà stavolta. Non si torna indietro da qui.",
                        "..."
                ));


        // Inserimento degli NPC nelle stanze
        ingresso.           setNPC( ubriacone    );
        cucina.             setNPC( cuoca        );
        biblioteca.         setNPC( bibliotecario);
        stanzaDeiGiochi.    setNPC( bambino      );
        salaMusica.         setNPC( musicista     );
        pozzo.              setNPC( anziana       );
        cantinaProfond.     setNPC( sommelier     );
        stanzaBianca.       setNPC( voce          );


        // --- Eventi ---
        Evento musicistaSvanisce        = new Evento()             { @Override public void attiva(Gioco g) { g.scrivi("Avvicini lo spartito agli appunti. Le note mancanti trovano il loro posto.\nIl musicista smette di suonare per la prima volta da quando sei entrato. Ti guarda. Sorride. Poi - lentamente - svanisce.\nLa melodia, però, rimane. Completa."); salaMusica.setNPC(null); g.rimuoviInventario(g.trovaInInventario("spartito strappato")); g.rimuoviInventario(g.trovaInInventario("appunti cifrati")); }};
        Evento cuocaSvanisce            = new Evento()             { @Override public void attiva(Gioco g) { g.scrivi("Porgi la bottiglia. La Cuoca la prende senza dir nulla. La annusa con gli occhi chiusi. Quando li riapre, sembra diversa - più leggera. Ti guarda una volta sola, come se volesse dirti qualcosa. Poi se ne va. La minestra è ancora lì, ma... È calda. Non c'è più nessuno da aspettare."); cucina.setNPC(null); g.rimuoviInventario(g.trovaInInventario("bottiglia anonima")); }};
        Evento sommelierSvanisce        = new Evento()             { @Override public void attiva(Gioco g) { g.scrivi("Mostri la ricetta al Sommelier. La legge lentamente, muovendo le labbra senza parlare. Poi annuisce - come se avesse finalmente ricordato qualcosa di importante. Si alza. Lascia cadere la bottiglia vuota che stringeva.\nEsce senza voltarsi. Forse sa dove andare, adesso."); cantinaProfond.setNPC(null); g.rimuoviInventario(g.trovaInInventario("ricetta")); }};
        Evento anzianaSvanisce          = new Evento()             { @Override public void attiva(Gioco g) { g.scrivi("Porgi la candela. L'anziana signora la prende con entrambe le mani, come se fosse qualcosa di infinitamente prezioso.\nLa osserva un momento. Poi ti guarda.\nC'è ancora luce, vedi? Basta saperla tenere accesa.\nSi alza lentamente. Si allontana verso il buio, portando con sé la fiamma.\nIl pozzo rimane. Lei no."); pozzo.setNPC(null); g.rimuoviInventario(g.trovaInInventario("candela")); }};

        Evento accendiLanterna          = new EventoMostraMessaggio("Accendi la lanterna. La flebile luce tremolante rischiara le tue incertezze.");
        Evento vittoria                 = new EventoVittoria       ("Il muro cede come un peso che finalmente si lascia andare.\nLa stanza oltre il trono non ha pareti: è uno spazio che ha la tua forma.\nLa luce non abbaglia, il silenzio non pesa.\nCapisci che non stai uscendo dal castello: stai smettendo di abitarlo.\nNon serve chiudere la porta.\nNon tornerai.\nE per la prima volta, il mondo fuori non fa paura.\nFine.");
        Evento sconfitta                = new EventoSconfitta      ("Scendi, e il buio non ti avvolge: ti riconosce.\nLa botola si richiude senza rumore. Non c’è caduta, non c’è dolore.\nSolo un istante in cui capisci che non stavi cercando un’uscita, ma un posto dove smettere di cercare.\nIl castello trattiene il respiro. Tu non ricordi più perché eri qui.\nE il buio, paziente, ti tiene con sé.\nFine.");
        Evento sbloccaScale             = new EventoSbloccaUscita  ("sblocca-scale", "Corridoio", "su", "Stringi l'elmo e la spada. Per un momento ti senti invincibile.\nÈ una bugia e lo sai. Ma è una bugia confortante.\nIn fondo al corridoio, una scala prende forma.");

        chiave.setEventoUso             (new EventoMostraMessaggio ("La chiave penetra la toppa come un'idea fulminante attraversa il cervello."));
        elmo.setEventoUso               (new EventoMostraMessaggio ("Ti infili l'elmo. Non ti senti più al sicuro, ma almeno hai l'aria di qualcuno che sa quello che fa."));
        spada.setEventoUso              (new EventoMostraMessaggio ("Impugni la mezza spada. È spezzata, inutile, e lo sai. Eppure stringerla fa sentire meno soli."));
        libro.setEventoUso              (new EventoMostraMessaggio ("Sfogli il libro. Le parole sembrano sillabe sparse, sfuggenti. In fondo alla pagina, una sola parola si distingue: 'Luce'."));

        cannocchiale.setEventoUso       (new EventoSbloccaUscita   ("sblocca-giardino", "Ingresso",               "sud",  "Puntandolo verso il basso, oltre la nebbia, intravedi qualcosa tra le pietre del castello: un giardino. Come hai fatto a dimenticarlo?"));
        pennello.setEventoUso           (new EventoSbloccaUscita   ("sblocca-trono",    "Corridoio dei ritratti", "nord", "Dipingi sulla tela. Il volto che emerge è familiare - eppure non riesci a nominarlo. La tela scivola di lato."));
        alfiere.setEventoUso            (new EventoSbloccaUscita   ("sblocca-studio",   "Stanza dei giochi",      "nord", "L'alfiere attiva un meccanismo innaturale. Il bambino ti sorride e indica il mur- È una porta! Da dove è sbucata fuori?"));

        lanterna.setEventoUso           (new EventoImpostaFlag     ("lanterna-accesa",    accendiLanterna));
        giocattolo.setEventoUso         (new EventoImpostaFlag     ("luce-accesa",        new EventoMostraMessaggio ("Il giocatolo emette un tepore confortante. La stanza si illumina lentamente. Che ci facciamo qui? Dovremmo risalire. Ora.")));
        bottigliaSEtichetta.setEventoUso(new EventoImpostaFlag     ("cuoca-salutata",     cuocaSvanisce));
        ricetta.setEventoUso            (new EventoImpostaFlag     ("sommelier-salutato", sommelierSvanisce));
        candela.setEventoUso            (new EventoImpostaFlag     ("anziana-salutata",   anzianaSvanisce));
        scalpello.setEventoUso          (new EventoImpostaFlag     ("muro-abbattuto",     new EventoSbloccaUscita   ("sblocca-cuore",     "Sala del trono", "nord", "Nonostante l'usura, questo muro è crollato come se fosse di carta... Bastava così poco?")));
        balconeVuoto.aggiungiEvento     (new EventoImpostaFlag     ("tela-rivelata",      new EventoMostraMessaggio ("balcone-messaggio", "Guardando giù, noti il corridoio dei ritratti. E lì - una tela vuota che prima non avevi visto. Come ci è finita?")));

        cantina.aggiungiEvento          (new EventoCondizionale    ("lanterna-accesa",      true, new EventoMostraMessaggio("La lanterna illumina il buio. Puoi proseguire."), sconfitta));
        diarioSenzaAutore.setEventoUso  (new EventoCondizionale    ("calendario",       new EventoImpostaFlag("giorni-ritrovati",    new EventoMostraMessaggio("Accosti il diario al calendario. Le date che mancavano trovano il loro posto. I giorni che non contavi più tornano visibili - tutti interi, tutti tuoi. Non sai quanti ne hai persi. Ma sai che ne hai ancora. E per la prima volta, sembra abbastanza.")), new EventoMostraMessaggio("Ti manca ancora qualcosa.")));
        spartitoStrappato.setEventoUso  (new EventoCondizionale    ("appunti cifrati",  new EventoImpostaFlag("musica-completata",   musicistaSvanisce), new EventoMostraMessaggio("Ti manca ancora qualcosa...")));
        corridoio.aggiungiEvento        (new EventoCondizionale    ("elmo", new EventoCondizionale("spada", sbloccaScale, new EventoMostraMessaggio("")), new EventoMostraMessaggio("")));

        cuore.aggiungiEvento            (vittoria);


        // --- Registrazione delle stanze di gioco ---
        // PIANO TERRA
        gioco.registraStanza    (ingresso               );
        gioco.registraStanza    (corridoio              );
        gioco.registraStanza    (giardino               );
        gioco.registraStanza    (cappella               );
        gioco.registraStanza    (biblioteca             );
        gioco.registraStanza    (salaArmature           );
        gioco.registraStanza    (armeria                );
        gioco.registraStanza    (cucina                 );
        // 1° PIANO
        gioco.registraStanza    (corridoioDeiRitratti   );
        gioco.registraStanza    (stanzaDeiGiochi        );
        gioco.registraStanza    (studio                 );
        gioco.registraStanza    (salaMusica             );
        gioco.registraStanza    (cameraDaLetto          );
        gioco.registraStanza    (salaDelTrono           );
        // 2° PIANO
        gioco.registraStanza    (corridoioCircolare     );
        gioco.registraStanza    (stanzaDegliSpecchi     );
        gioco.registraStanza    (terrazza               );
        gioco.registraStanza    (stanzaCapovolta        );
        gioco.registraStanza    (stanzaBianca           );
        gioco.registraStanza    (portaSbagliata         );
        gioco.registraStanza    (portaEco               );
        gioco.registraStanza    (balconeVuoto           );
        // SOTTERRANEI
        gioco.registraStanza    (cantina                );
        gioco.registraStanza    (cantinaProfond         );
        gioco.registraStanza    (corridoioAllagato      );
        gioco.registraStanza    (stanzaDeiNomi          );
        gioco.registraStanza    (stanzaVuota            );
        gioco.registraStanza    (pozzo                  );
        gioco.registraStanza    (stanzaLuce             );
        gioco.registraStanza    (salaDeiPassi           );
        // FINALE
        gioco.registraStanza    (cuore                  );

        gioco.setStanzaCorrente(ingresso);
    }



    // --- Registrazione dei comandi ---
    public static void registraComandi (MotoreIO motore, GestoreSalvataggio gestore){
        motore.registraComando("guarda"     ,    new ComandoGuarda()        );
        motore.registraComando("prendi"     ,    new ComandoPrendi()        );
        motore.registraComando("vai"        ,    new ComandoMuovi()         );
        motore.registraComando("esamina"    ,    new ComandoEsamina()       );
        motore.registraComando("inventario" ,    new ComandoInventario()    );
        motore.registraComando("usa"        ,    new ComandoUsa()           );
        motore.registraComando("aiuto"      ,    new ComandoAiuto()         );
        motore.registraComando("salva"      ,    new ComandoSalva(gestore)  );
        motore.registraComando("carica"     ,    new ComandoCarica(gestore) );
        motore.registraComando("parla"      ,    new ComandoParla()         );
    }



    // --- Menu iniziale con caricamento o inizio di una nuova partita ---
    public static void mostraMenuIniziale(Gioco gioco, GestoreSalvataggio gestore) {
        String[] opzioni = {"Nuova partita", "Carica partita", "Esci"};

        int scelta = JOptionPane.showOptionDialog(
                null,
                "Benvenuto ad Armil Castle.\nCosa vuoi fare?",
                "Armil Castle",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opzioni,
                opzioni[0]
        );

        switch (scelta) {
            case 0 -> avviaGUI(gioco, gestore);           // Nuova partita
            case 1 -> {                                    // Carica partita
                if (gestore.esisteSalvataggio()) {
                    gestore.carica(gioco);
                    avviaGUI(gioco, gestore);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nessuna partita salvata trovata.",
                            "Armil Castle",
                            JOptionPane.INFORMATION_MESSAGE);
                    mostraMenuIniziale(gioco, gestore);    // Torna al menu
                }
            }
            case 2, -1 -> System.exit(0);                 // Esci o chiudi finestra
        }
    }


    // --- Avvio della GUI ---
    public static void avviaGUI(Gioco gioco, GestoreSalvataggio gestore) {
        SwingUtilities.invokeLater(() -> {
            FinestraGioco finestra = new FinestraGioco();
            Output output = new OutputGUI(finestra);
            gioco.setOutput(output);

            // --- Motore io collegato ai comandi
            MotoreIO motore = new MotoreIO(output);
            CostruttoreMondo.registraComandi(motore, gestore);

            // --- Messaggio iniziale ---
            gioco.scrivi("=== Benvenuto ad Armil Castle: il castello di Armil Land! ===\n");
            gioco.scrivi(gioco.getStanzaCorrente().descriviCompleta());

            // --- Collegamento finestra al motore ---
            finestra.collegaMotore(motore, gioco);
            finestra.aggiornaPannelloLaterale(gioco);
            finestra.setVisible(true);

            gioco.avvia();
        });
    }
}
