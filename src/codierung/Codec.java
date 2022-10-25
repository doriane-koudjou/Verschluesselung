package codierung;


public interface Codec {
    /**
     * @param klartext Parameter der Methode und ist der Text der verschluesselt sein muss
     * @return liefert ein Wert Zurueck
     * kodiere ist die Signatur der Methode  die ein Klartext nimmt und ein geheimtext am Ende der Verschluesselung zurueck gibt
     */
    public String kodiere(String klartext);


    /**
     * dekodiere nimmt einen geheimText als Parameter und liefert einen klartext am Ende der dekodiere
     * @param geheimtext der Text der entschluesselt sein soll
     * @return liefert ein String am Ende Zurück
     */

    public String dekodiere(String geheimtext);

    /**
     * gibLosung Signature der Methode  ,die die losung ausgibt
     * @return liefert die losung zurück
     */

    public String gibLosung();

    /**
     *
     * @param schluessel Parameter der Methode
     * @throws IllegalArgumentException liefert ein Exception bei ungeeignete losung oder schluessel
     */

    public void setzeLosung(String schluessel)throws
            IllegalArgumentException;


}

