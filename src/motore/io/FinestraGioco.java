package motore.io;

import motore.core.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/*
    Finestra principale del gioco — tema dark atmosferico.
    3 macro aree:
    1 - area narrativa    (JTextArea)
    2 - input             (JTextField + bottone)
    3 - pannello laterale (JPanel)
*/

public class FinestraGioco extends JFrame {

    // --- Palette colori ---
    private static final Color SFONDO_SCURO     = new Color(10,  10,  12 );  // quasi nero
    private static final Color SFONDO_LATERALE  = new Color(16,  14,  18 );  // viola scurissimo
    private static final Color SFONDO_INPUT     = new Color(20,  18,  22 );
    private static final Color TESTO_PRINCIPALE = new Color(210, 195, 160);  // pergamena
    private static final Color TESTO_SECONDARIO = new Color(130, 115, 90 );  // pergamena scura
    private static final Color ACCENTO_ORO      = new Color(180, 140, 60 );  // oro antico
    private static final Color ACCENTO_ORO_DIM  = new Color(100, 78,  30 );  // oro spento
    private static final Color BORDO            = new Color(45,  38,  28 );  // bordo caldo

    // --- Font ---
    private static final Font FONT_NARRATIVA    = new Font("Georgia",   Font.PLAIN,  17);
    private static final Font FONT_TITOLO       = new Font("Georgia",   Font.BOLD,   16);
    private static final Font FONT_INPUT        = new Font("Georgia",   Font.PLAIN,  16);
    private static final Font FONT_ETICHETTA    = new Font("Georgia",   Font.BOLD,   13);
    private static final Font FONT_COMANDI      = new Font("Georgia",   Font.PLAIN,  16);
    private static final Font FONT_INVENTARIO   = new Font("Georgia",   Font.ITALIC, 15);

    private JTextArea   areaNarrativa;
    private JTextField  campoInput;
    private JTextArea   areaInventario;
    private JLabel      etichettaStanza;
    private JButton     bottoneInvia;

    public FinestraGioco() {
        setTitle               ("Armil Castle — Un viaggio mentale...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize                (1050, 700);
        setResizable           (false);
        setLocationRelativeTo  (null);
        getContentPane().setBackground(SFONDO_SCURO);

        costruisciUI();
    }

    private void costruisciUI() {
        setLayout(new BorderLayout(0, 0));

        // ══════════════════════════════════════════
        //  AREA NARRATIVA (CENTER)
        // ══════════════════════════════════════════
        areaNarrativa = new JTextArea();
        areaNarrativa.setEditable      (false);
        areaNarrativa.setLineWrap      (true);
        areaNarrativa.setWrapStyleWord (true);
        areaNarrativa.setFont          (FONT_NARRATIVA);
        areaNarrativa.setBackground    (SFONDO_SCURO);
        areaNarrativa.setForeground    (TESTO_PRINCIPALE);
        areaNarrativa.setCaretColor    (ACCENTO_ORO);
        areaNarrativa.setMargin        (new Insets(18, 22, 18, 22));

        JScrollPane scrollPane = new JScrollPane(areaNarrativa);
        scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDO));
        scrollPane.getVerticalScrollBar().setUI(new DarkScrollBarUI());
        scrollPane.setBackground(SFONDO_SCURO);
        scrollPane.getViewport().setBackground(SFONDO_SCURO);
        add(scrollPane, BorderLayout.CENTER);

        // ══════════════════════════════════════════
        //  PANNELLO INPUT (SOUTH)
        // ══════════════════════════════════════════
        JPanel pannelloInput = new JPanel(new BorderLayout(0, 0));
        pannelloInput.setBackground(SFONDO_INPUT);
        pannelloInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, BORDO),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        // Prompt ">"
        JLabel prompt = new JLabel("  ›  ");
        prompt.setFont(new Font("Georgia", Font.BOLD, 16));
        prompt.setForeground(ACCENTO_ORO);
        pannelloInput.add(prompt, BorderLayout.WEST);

        campoInput = new JTextField();
        campoInput.setFont       (FONT_INPUT);
        campoInput.setBackground (SFONDO_INPUT);
        campoInput.setForeground (TESTO_PRINCIPALE);
        campoInput.setCaretColor (ACCENTO_ORO);
        campoInput.setBorder     (BorderFactory.createEmptyBorder(2, 4, 2, 4));
        pannelloInput.add(campoInput, BorderLayout.CENTER);

        bottoneInvia = new JButton("Invia");
        bottoneInvia.setFont           (new Font("Georgia", Font.BOLD, 13));
        bottoneInvia.setBackground     (new Color(35, 28, 15));
        bottoneInvia.setForeground     (ACCENTO_ORO);
        bottoneInvia.setBorder         (BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ACCENTO_ORO_DIM, 1),
                BorderFactory.createEmptyBorder(5, 16, 5, 16)
        ));
        bottoneInvia.setFocusPainted   (false);
        bottoneInvia.setCursor         (new Cursor(Cursor.HAND_CURSOR));
        bottoneInvia.addMouseListener  (new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                bottoneInvia.setBackground(new Color(55, 44, 20));
                bottoneInvia.setForeground(new Color(220, 175, 80));
            }
            public void mouseExited(MouseEvent e) {
                bottoneInvia.setBackground(new Color(35, 28, 15));
                bottoneInvia.setForeground(ACCENTO_ORO);
            }
        });
        pannelloInput.add(bottoneInvia, BorderLayout.EAST);
        add(pannelloInput, BorderLayout.SOUTH);

        // ══════════════════════════════════════════
        //  PANNELLO LATERALE (EAST)
        // ══════════════════════════════════════════
        JPanel pannelloLaterale = new JPanel();
        pannelloLaterale.setLayout        (new BoxLayout(pannelloLaterale, BoxLayout.Y_AXIS));
        pannelloLaterale.setPreferredSize (new Dimension(260, 0));
        pannelloLaterale.setBackground    (SFONDO_LATERALE);
        pannelloLaterale.setBorder        (BorderFactory.createEmptyBorder(18, 16, 18, 16));

        // Nome stanza
        etichettaStanza = new JLabel("— ");
        etichettaStanza.setFont         (FONT_TITOLO);
        etichettaStanza.setForeground   (ACCENTO_ORO);
        etichettaStanza.setAlignmentX   (Component.LEFT_ALIGNMENT);
        etichettaStanza.setBorder       (BorderFactory.createEmptyBorder(0, 0, 4, 0));
        pannelloLaterale.add(etichettaStanza);

        // Separatore oro
        pannelloLaterale.add(creaLinea());
        pannelloLaterale.add(Box.createVerticalStrut(14));

        // Inventario
        JLabel lblInv = creaEtichetta("Oggetti raccolti");
        pannelloLaterale.add(lblInv);
        pannelloLaterale.add(Box.createVerticalStrut(6));

        areaInventario = new JTextArea("(Nulla)");
        areaInventario.setEditable     (false);
        areaInventario.setFont         (FONT_INVENTARIO);
        areaInventario.setBackground   (SFONDO_LATERALE);
        areaInventario.setForeground   (TESTO_PRINCIPALE);
        areaInventario.setOpaque       (true);
        areaInventario.setWrapStyleWord(true);
        areaInventario.setLineWrap     (true);
        areaInventario.setAlignmentX   (Component.LEFT_ALIGNMENT);
        pannelloLaterale.add(areaInventario);

        pannelloLaterale.add(Box.createVerticalStrut(20));
        pannelloLaterale.add(creaLinea());
        pannelloLaterale.add(Box.createVerticalStrut(14));

        // Comandi
        JLabel lblCmd = creaEtichetta("Comandi");
        pannelloLaterale.add(lblCmd);
        pannelloLaterale.add(Box.createVerticalStrut(8));

        String[] comandi = {
                "guarda", "esamina", "vai [direzione]",
                "prendi [oggetto]", "usa [oggetto]",
                "parla", "inventario", "salva", "carica", "aiuto"
        };
        for (String cmd : comandi) {
            JLabel lbl = new JLabel("  " + cmd);
            lbl.setFont       (FONT_COMANDI);
            lbl.setForeground (TESTO_SECONDARIO);
            lbl.setAlignmentX (Component.LEFT_ALIGNMENT);
            lbl.setBorder     (BorderFactory.createEmptyBorder(2, 0, 2, 0));
            pannelloLaterale.add(lbl);
        }

        pannelloLaterale.add(Box.createVerticalGlue());

        // Firma in fondo
        JLabel firma = new JLabel("Armil Castle © 2026");
        firma.setFont     (new Font("Georgia", Font.ITALIC, 10));
        firma.setForeground(new Color(60, 52, 38));
        firma.setAlignmentX(Component.LEFT_ALIGNMENT);
        pannelloLaterale.add(firma);

        add(pannelloLaterale, BorderLayout.EAST);
    }

    // --- Helper: etichetta sezione ---
    private JLabel creaEtichetta(String testo) {
        JLabel lbl = new JLabel(testo.toUpperCase());
        lbl.setFont     (FONT_ETICHETTA);
        lbl.setForeground(new Color(100, 85, 55));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbl.setBorder   (BorderFactory.createEmptyBorder(0, 0, 2, 0));
        return lbl;
    }

    // --- Helper: linea separatrice ---
    private JPanel creaLinea() {
        JPanel linea = new JPanel();
        linea.setMaximumSize (new Dimension(Integer.MAX_VALUE, 1));
        linea.setPreferredSize(new Dimension(0, 1));
        linea.setBackground (BORDO);
        linea.setAlignmentX (Component.LEFT_ALIGNMENT);
        return linea;
    }

    // --- Aggiorna pannello laterale ---
    public void aggiornaPannelloLaterale(Gioco gioco) {
        etichettaStanza.setText(gioco.getStanzaCorrente().getNome());

        if (gioco.getInventario().isEmpty()) {
            areaInventario.setText("(Nulla)");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Oggetto o : gioco.getInventario()) {
                sb.append("· ").append(o.getNome()).append("\n");
            }
            areaInventario.setText(sb.toString());
        }
    }

    // --- Scrivi nella narrativa ---
    public void scriviNarrativa(String testo) {
        areaNarrativa.append(testo + "\n");
        areaNarrativa.setCaretPosition(areaNarrativa.getDocument().getLength());
    }

    // --- Collega il motore ---
    public void collegaMotore(MotoreIO motore, Gioco gioco) {
        ActionListener azione = e -> {
            String testo = campoInput.getText().trim();
            if (!testo.isEmpty() && gioco.isInCorso()) {
                scriviNarrativa("\n› " + testo);
                campoInput.setText("");
                motore.eseguiComando(gioco, testo);
                aggiornaPannelloLaterale(gioco);
            }
        };
        campoInput.addActionListener(azione);
        bottoneInvia.addActionListener(azione);
    }

    // ══════════════════════════════════════════
    //  Scrollbar scura personalizzata
    // ══════════════════════════════════════════
    private static class DarkScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            thumbColor      = new Color(70, 58, 35);
            trackColor      = new Color(15, 13, 10);
        }
        @Override
        protected JButton createDecreaseButton(int orientation) { return invisibile(); }
        @Override
        protected JButton createIncreaseButton(int orientation) { return invisibile(); }
        private JButton invisibile() {
            JButton b = new JButton();
            b.setPreferredSize(new Dimension(0, 0));
            return b;
        }
    }
}