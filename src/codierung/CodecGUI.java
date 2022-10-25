package codierung;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodecGUI extends JFrame implements ActionListener {
        /**
         * Hier wird Objekte von Codec erstellt
         */
        private final Codec caesar = new Caesar();
        private final Codec wuerfel = new Wuerfel("");

        private JButton  bouton1 , bouton2;
        private JTextField tf1;
        private JRadioButton b1, b2 ;
        private JTextArea t1,t2 ;

//private List liste1 , liste2;



        private CodecGUI() {

/**
 * hier wird ein Panel fuer das Fenster erstellt
 */
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();

            /**
             * hier wird das Fenster mit bestimmte  Eigenschaften erstellt
             */
            JFrame fenster = new JFrame("Welcome ");
            fenster.setSize(850,400);	 // Fenster Große
            fenster.setLocationRelativeTo(null);    // in der Mitte
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setResizable(false);
            Container contain = getContentPane();

            /*
              Hier wird ein Label erstellt und zu ein Panel hinzugefugt
             */

            JLabel lab1 = new JLabel("Klartext");
            panel1.add(lab1);
            lab1.setBounds(20, 80, 150, 48);

            /*
              hier wird ein TextArea fuer eine Tastatureingabe erstellt und zu einem Panel hinzugefugt
             */
            t1 = new JTextArea(5,25) ;
            //t1.setSize(60,60);
            t1.setColumns(20);
            t1.setRows(5);
            t1.setLineWrap(true);
            t1.setWrapStyleWord(false);

            //fenster.getContentPane().add(t1);
            panel1.add( t1);
            t1.setBounds(10, 20, 10, 10);

            /*
              Hier wird ein zweite Label erstellt und zu dem Panel hinzugefuegt
             */
            JLabel lab2 = new JLabel("Geheimtext");
            panel1.add(lab2);
            lab2.setBounds(90, 80, 150, 48);

            /*
              hier wird ein zweite TextArea  fuer eine Tastatureingabe erstellt und zu einem Panel hinzugefugt
             */
            t2 = new JTextArea (5,25);
            //t2.setSize(60,60);
            t2.setColumns(20);
            t2.setRows(5);
            t2.setLineWrap(true);
            t2.setWrapStyleWord(false);
            //fenster.getContentPane().add(t2);
            panel1.add(t2);
            t2.setBounds(10, 20, 10, 10);


            JLabel lab3 = new JLabel("Schluessel1");
            panel2.add(lab3);
            lab3.setBounds(5, 80, 150, 48);
            /*
              Hier wir ein Texfield erstellt und hinzugefuegt
             */
            tf1 = new JTextField(12);
            tf1.setColumns(10);
            //fenster.setContentPane(tf1);
            panel2.add(tf1);

            JLabel lab4 = new JLabel("Schluessel2");
            panel2.add(lab4);
            lab4.setBounds(10, 80, 150, 48);


            /*
              Ein TextField fuer Tastatuereingabe
             */
            JTextField tf2 = new JTextField(12);
            tf2.setColumns(10);
            panel2.add(tf2);
            /*
              hier wird ein Button erstellt
             */
            bouton1 = new JButton("verschluesseln");
            panel2.add(bouton1);
//	fenster.getContentPane().add(bouton1);
            bouton1.setBounds(250,150,72,62);
            //fenster.setVisible(true);

            /*
              ein zweiter Button
             */
            bouton2 = new JButton ( " entschluesseln");
            //fenster.getContentPane().add(bouton2);
            panel2.add(bouton2);
            bouton2.setBounds(250,100, 72, 62 );
            //fenster.setVisible(true);

            /*
              es wird zwei  RadioButton erstellt und zu dem Fenster hinzugefuegt
             */

            b1 = new JRadioButton("caesar");
            panel2.add(b1);
            b1.setBounds(250, 300,50,10);
            b2 = new JRadioButton ("Wuerfel");
            ButtonGroup group = new ButtonGroup();
            group.add(b1);
            group.add(b2);

            panel2.add(b2) ;
            b1.setBounds(250, 300, 50,10);

            /*
              Es wird Actionslistener hinzugefuegt
             */

            b1.addActionListener(this);

            bouton1.addActionListener(this);

            b2.addActionListener(this);

            bouton2.addActionListener(this);

            /*
              die Position der Panel auf dem Fenster
             */
            fenster.add(panel1, BorderLayout.CENTER);
            fenster.add(panel2, BorderLayout.SOUTH);



/*
  fenster sichtbar machen
 */

            fenster.setVisible(true);
        }



        public static void main(String[] args) {
            CodecGUI fen = new CodecGUI();


        }

        /**
         * actionPerformed Methode fuer die Action Handlung
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            /*
              hier die Verschluesselung  mit caesar und dann Wuerfel
             */
            if (event.getSource()==bouton1)    {
                if(b1.isSelected()) {
                    caesar.setzeLosung(tf1.getText());
                    String g = caesar.kodiere(t1.getText());
                    t2.setText(g);}

                else if (b2.isSelected())
                {
                    wuerfel.setzeLosung(tf1.getText());
                    String g2 = wuerfel.kodiere(t1.getText());
                    t2.setText(g2);
                }

            }

/*
  Hier die Entschluesselung mit caesar und dann mit wuerfel
 */

            else if(event.getSource()==bouton2) {
                if (b1.isSelected()) {
                    caesar.setzeLosung(tf1.getText());
                    String g3 = caesar.dekodiere(t2.getText());
                    t1.setText(g3);
                }
                else if (b2.isSelected()) {
                    wuerfel.setzeLosung(tf1.getText());
                    String g4 = wuerfel.dekodiere(t2.getText());
                    t1.setText(g4);

                }
            }


        }
    }
