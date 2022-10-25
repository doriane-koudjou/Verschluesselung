package codierung;



public class Caesar implements  Codec  {



    private String schluessel;


    /**
     * default  Konstruktor der Klasse
     */
    Caesar() { //make it private

    }



    /**
     * getSchluessel  Der Getter für die private Atributen
     * @return liefert den Schlussel zurück
     */
    public String getSchluessel() {
        return schluessel;
    }


    /**
     *  Setter
     * @param schluessel soll von dem Benutzer eingegeben werden und davon die Laenge wird für die Verscluesselung verwenden
     */

    public void setSchluessel(String schluessel) {
        this.schluessel = schluessel;
    }




    /**
     * @param klartext  Text ,der  der verschluesselt sein sollte
     * @return liefert ein Wert zurueck
     * geheimtext text, der am Ende des Verfahren rauskommt
     * klar ist die Variable in der den geheimtext am Ende als String  gespeichert wird
     * Die Methode nimmt einen Klartext als Parameter macht die Kodierung und liefert das Ergebnis als Geheimtext
     */

    public String kodiere(String klartext) {
        char[] geheimArrayCaesar = new char [klartext.length()];
        StringBuilder klar = new StringBuilder();

        for (int i= 0 ; i< klartext.length() ; i++ ) {

            geheimArrayCaesar[i]= klartext.charAt(i) ;   }

/* for (int i = 0 ; i< geheimArrayCaesar.length ; i++) {


                                                      }*/

        for (char e : geheimArrayCaesar)      {
            if ( e>= 'a' && e<= 'z') {

                klar.append((char) (((((e - 'a') + schluessel.length()) + 26) % 26) + 'a'));
            }

            else if (e>= 'A' && e<= 'Z') {
                klar.append((char) (((((e - 'A') + schluessel.length()) + 26) % 26) + 'A'));
            }
            else { klar.append(e);}


        }

        return klar.toString();

    }

    /**
     * d ist irgengwelcher character in dem Array
     * geheimtext ist von den Benutzer einzugeben und wird von der Methode dekodiert
     *  klar ist die Variable in der den klartext am Ende als String  gespeichert wird
     *  Die Methode nimmt ein geheimText als Parameter und liefert am Ende einen klartext  als String der in der Variable klar gespeichert ist
     */

    public String dekodiere(String geheimtext) {

        char[] klartext = new char [geheimtext.length()] ;
        StringBuilder klar = new StringBuilder();

        for (int i = 0 ; i< klartext.length ; i++) {
            klartext[i] = geheimtext.charAt(i);
        }

        for  (char d : klartext) {

            if (d>= 'a' && d<= 'z'  ) {

                klar.append((char) (((((d - 'a') - schluessel.length()) + 26) % 26) + 'a'));                             }



            else if ( d >= 'A' && d <= 'Z') {
                klar.append((char) (((((d - 'A') - schluessel.length()) + 26) % 26) + 'A'));                             }

            else { klar.append(d);}

        }


        return klar.toString();
    }



    /**
     * gibLosung liefert die Losung zurueck
     *
     */

    public String gibLosung() {


        return schluessel ;

    }


    /**
     * @throws IllegalArgumentException Liefert eine Exception zurück wenn  die eingegebene Schluessel ungeeignet ist
     */

    public void setzeLosung(String schluessel) {
        this.schluessel = schluessel ;
        if  (schluessel.equals("'\000'")) {
            throw new IllegalArgumentException ();}


    }
}