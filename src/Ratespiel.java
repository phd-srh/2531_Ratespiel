import java.util.Scanner;

public class Ratespiel {

    // Methoden - Unterprogramme, Prozeduren/Funktionen, Subroutinen

    // Aufbau von Methoden
    // Methode = Methodenkopf + Methodenrumpf

    // Methodenkopf = Sichtbarkeitsattribut (public) Modifikator (static)
    //                Datentyp Methodenname ( Parameterliste )
    // Datentyp = void | int | boolean | double | char | ...
    // Parameterlist = leer | Datentyp Parametername [, ...]
    // Methodensignatur = Methodenname + Datentypen aller Parameter (Überladung)

    // Feine Unterscheidung (in manchen Programmiersprachen)
    // Methode mit Datentyp (int, boolean, ...) -> Funktion
    // Methode ohne Datentyp (void)             -> Prozedur

    // z.B.
    public static double berechneQuadrat ( double x ) {
        return x * x;
    }

    // z.B. Ausgabe einer Zahl
    public static void ausgabeZahl( double zahl ) {
        System.out.println("Das ist meine Zahl: " + zahl );
    }


//  /--- Methodenkopf -------------------\ /--- Methodenrumpf ---\
    public static void main(String[] args) {

        //double ergebnis = ;
        System.out.println( berechneQuadrat( 163 ) );

        ausgabeZahl( 17 );
        ausgabeZahl( 22 );
        ausgabeZahl( 3.4 );


        Scanner eingabe = new Scanner(System.in);
        final int geheime_zahl = (int)(Math.random() * 900 + 100);

        //System.out.println("Achtung, nur zum Testen! Geheime Zahl = " + geheime_zahl);
        int anzahlVersuche = 0;
        while (true) {
            System.out.print("Wie lautet die Zahl: ");
            int zahl = eingabe.nextInt();
            if (zahl == 0) {
                System.out.println("Schade, viel Erfolg beim nächsten Mal");
                System.out.println("Die gesuchte Zahl ist " + geheime_zahl);
                break;
            }
            anzahlVersuche++;

            // Anzahl korrekter Ziffern bestimmen (siehe Struktogramm)
            int korrekteZiffern = 0;

            int kopieDerGeheimenZahl = geheime_zahl;
            while ( kopieDerGeheimenZahl > 0 ) {
                int zifferGeheimeZahl = kopieDerGeheimenZahl % 10;
                int zifferTipp = zahl % 10;
                if (zifferGeheimeZahl == zifferTipp) {
                    korrekteZiffern++;
                }
                kopieDerGeheimenZahl = kopieDerGeheimenZahl / 10;
                zahl = zahl / 10;
            }

            System.out.println("Es sind " + korrekteZiffern + " korrekte Ziffern");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }
}
