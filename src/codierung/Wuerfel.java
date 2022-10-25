package codierung;



public class Wuerfel implements Codec {


    private String losung;

    /**
     * Konstruktor der Klasse
     * @param losung ist der Attribut der Klasse , soll bei jedem Verfahren eingegeben werden
     */
    Wuerfel(String losung) { //make it private
        this.losung = losung;
    }

    /**
     * getLosung , Getter fuer das  Private Attribut
     * @return liefert die losung
     */
    public String getLosung() {
        return losung;
    }

    /**
     * setLosung ist der Setter fuer  das private Attribut
     * @param losung  Attribut der Klasse
     */

    public void setLosung(String losung) {
        this.losung = losung;
    }

    /**
     * losung.toUpperCase  wandeln jeder Buchstabe der losung in Große Buchstabe
     *  r ist das modulo der Division des klartext durch die Losung um die Anzahl der Zeile zu wissen
     * geheimArray [][]  dort wird den Klartext als character gespeichert
     * Array1[] speichert die geordnete Werte der Losung als character
     * Array[] speichert jeder character der losung
     *ar1[] speichert die Werte am Ende der Permutation als int
     *geheimtextFinal speichert der GeheimText am Ende  der Verschluesselung als String
     *Die Methode kodiere nimmt ein klartext als Parameter und liefert am Ende der Verschluesselung einen Geheimtext hier aber gespeichert in geheimtextFinal
     */
    public String kodiere(String klartext) {
        int zeilenAnzahl;
        char geheimtext;
        StringBuilder geheimtextFinal = new StringBuilder();
        losung = losung.toUpperCase();

        int r = klartext.length() % losung.length();

        if (r == 0) {
            zeilenAnzahl = klartext.length() / losung.length();
        }

        else

        {
            zeilenAnzahl = klartext.length() / losung.length() + 1;
        }
        char[][] geheimArray = new char[zeilenAnzahl][losung.length()]; // Array erzeugen

        // char geheimArray [] = losung.toCharArray();
        int k = 0;
        for (int i = 0; i < geheimArray.length; i++) {
            for (int j = 0; j < geheimArray[i].length; j++) {
                if (k >= klartext.length())
                    break;
                geheimArray[i][j] = klartext.charAt(k++); // Der Array mit dem Klartext
                // ausfüllen
            }
        }
        char[] Array2 = new char[losung.length()];
        char[] Array1 = new char[losung.length()];
        int[] ar1 = new int[losung.length()];

        for (int i = 0; i < losung.length(); i++) {
            Array2[i] = losung.charAt(i); // ungeordnete Array
            Array1[i] = losung.charAt(i); // geordnete Array
        }
        // nouveu
        int y = 0;

        for (char i = 'A'; i <= 'Z'; i++) {
            for (int j = 0; j < losung.length(); j++) {

                if (Array2[j] == i) {

                    ar1[y] = j;
                    y = y + 1;
                }

            }
        }


        for (int i = 0; i < losung.length(); i++) {
            for (int j = 0; j < losung.length(); j++) {
                if (ar1[i] == j) {
                    for (char[] chars : geheimArray) {
                        if (chars[j] != '\000') {
                            geheimtext = chars[j];
                            geheimtextFinal.append(chars[j]);
                        }
                    }
                }
            }
        }


        return geheimtextFinal.toString();
    }
    /**
     * String geheimtext ist der Parameter der Methode von der Benutzer einzugeben
     * klartextArray ist der der Array indem den Klartext am Ende als character gespeichert ist
     * losungArray[] dort werden die Buchtaben der  losung als character gespeichert am Anfang des Verfahren
     * Ar3[] speichert die Positionen der Buchstaben der  Losung als integer
     * S speichert den Klartext am Ende der Entschluesselung
     * Diese Methode nimmt ein geheimtext als Parameter und liefert am Ende einen geheimtext und der in der Variable s gespeichert wurde
     */

    public String dekodiere(String geheimtext) {

        String Klartext;
        int zeilenAnzahl2;
        losung = losung.toUpperCase();

        int r = geheimtext.length() % losung.length();

        if (r == 0) {
            zeilenAnzahl2 = geheimtext.length() / losung.length();
        }

        else

        {
            zeilenAnzahl2 = geheimtext.length() / losung.length() + 1;
        }

        // ein zwei dimensional Array erzeugen wo den Klartext wird am ende gespeichert
        char[][] klartextArray = new char[zeilenAnzahl2][losung.length()]; // Array erzeugen

        // ein Array erzeugen und die Losung reinmachen
        char[] losungArray = new char[losung.length()];

        for (int i = 0; i < losung.length(); i++) {
            losungArray[i] = losung.charAt(i);
        }

        // ein Array erzeugen und den geheimtext rein speichern

        char[] geheimtextArray = new char[geheimtext.length()];
        for (int i = 0; i < geheimtext.length(); i++) {
            geheimtextArray[i] = geheimtext.charAt(i);
        }

        if (r != 0) {
            for (int j = r; j < losung.length(); j++) {
                klartextArray[zeilenAnzahl2 - 1][j] = '\000';
            }
        }


        int Ar3[] = new int[losung.length()];

        int k = 0;

        for (char i = 'A'; i <= 'Z'; i++) {
            for (int j = 0; j < losungArray.length; j++) {

                if (losungArray[j] == i) {

                    Ar3[k] = j;
                    k = k + 1;
                }
            }
        }



        int z = 0;



        int counter = 0;

        for (int i = 0; i < losung.length(); i++) {
            int q = 0;
            for (int j = 0; j < losung.length(); j++) {


                if (Ar3[i] == j) {
                    if (r != 0) {
                        if (Ar3[i]< r) {
                            q = geheimtext.length() / losung.length()+1;
                            counter += q;
                        } else {
                            q = geheimtext.length() / losung.length();

                        }
                    }
                    else {
                        q = geheimtext.length() / losung.length();
                    }
                    for (int l = 0; l < q; l++) {

                        if (z == geheimtext.length())break;

                        klartextArray[l][j] = geheimtextArray[z++];

                    }


                }

            }
        }

        String s  = "";

        for (int i = 0; i < klartextArray.length; i++) {
            for (int j = 0; j < klartextArray[i].length; j++) {
                if(klartextArray[i][j] == '\000') continue;
                s+=(klartextArray[i][j]);
            }

        }

        return s;
    }

    /**
     * gibLosung liefert die Losung zurueck
     */

    public String gibLosung() {
        return losung;
    }

    /**
     * setzeLosung  legtfest welche Werte nicht erlaubt sind
     * throw IllegalArgumentException liefert eine Exception  wenn eine ungeeignet wert eingegeben ist
     */


    public void setzeLosung(String schluessel) {

        this.losung = schluessel;
        if  ( schluessel == "'\000'") {

            throw new IllegalArgumentException ();}
    }


    public static void main(String[] args) {

        Wuerfel w2 = new Wuerfel("schwarzwald");


    }

}

