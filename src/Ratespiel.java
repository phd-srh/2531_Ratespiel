import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int geheime_zahl = (int)(Math.random() * 900 + 100);

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

            int gesuchteZahl = geheime_zahl;
            while ( gesuchteZahl > 0 ) {
                int zifferGeheimeZahl = gesuchteZahl % 10;
                int zifferTipp = zahl % 10;
                if (zifferGeheimeZahl == zifferTipp) {
                    korrekteZiffern++;
                }
                gesuchteZahl = gesuchteZahl / 10;
                zahl = zahl / 10;
            }

            System.out.println("Es sind " + korrekteZiffern + " korrekte Ziffern");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }
}
