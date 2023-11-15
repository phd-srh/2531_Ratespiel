import java.util.Scanner;

public class Ratespiel {

    public static void main(String[] args) {
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

            int korrekteZiffern = bestimmeKorrekteZiffern(geheime_zahl, zahl);
            int vorhandeneZiffern = bestimmeVorhandeneZiffern(geheime_zahl, zahl);
            System.out.println("Es sind " + korrekteZiffern + " korrekte Ziffern");
            System.out.println("Es sind " + vorhandeneZiffern + " Ziffern vorhanden");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }

    public static boolean istZifferInZahl(int ziffer, int zahl) {
        // TODO
        return false;
    }

    public static int bestimmeVorhandeneZiffern(int geheime_zahl, int zahl) {
        // TODO
        return 0;
    }

    // Achtung: (Call-By-Value) Die Parameter sind Kopien(!!) der verwendeten Variablen
    private static int bestimmeKorrekteZiffern(int geheime_zahl, int zahl) {
        int korrekteZiffern = 0;
        while ( geheime_zahl > 0 ) {
            int zifferGeheimeZahl = geheime_zahl % 10;
            int zifferTipp = zahl % 10;
            if (zifferGeheimeZahl == zifferTipp) {
                korrekteZiffern++;
            }
            geheime_zahl = geheime_zahl / 10;
            zahl = zahl / 10;
        }
        return korrekteZiffern;
    }
}
