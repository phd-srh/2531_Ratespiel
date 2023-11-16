import java.util.Scanner;

public class Ratespiel {

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        int schwierigkeitsgrad;
        do {
            System.out.print("Wie viele Zahlen sollen erraten werden (3-7): ");
            schwierigkeitsgrad = eingabe.nextInt();
        } while (schwierigkeitsgrad < 3 || schwierigkeitsgrad > 7);

        int geheime_zahl;
        do {
            geheime_zahl = (int) (Math.random() * 900 + 100);
        } while ( ! keineZifferIstDoppelt(geheime_zahl) );

//        System.out.println("Achtung, nur zum Testen! Geheime Zahl = " + geheime_zahl);
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
            if (zahl == geheime_zahl) {
                System.out.println("Herzlichen Glückwunsch, das war die gesuchte Zahl");
                break;
            }

            int korrekteZiffern = bestimmeKorrekteZiffern(geheime_zahl, zahl);
            int vorhandeneZiffern = bestimmeVorhandeneZiffern(geheime_zahl, zahl);
            vorhandeneZiffern = vorhandeneZiffern - korrekteZiffern;
            System.out.println("Es sind " + korrekteZiffern + " korrekte Ziffern");
            System.out.println("Es sind " + vorhandeneZiffern + " Ziffern vorhanden");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }

    public static boolean keineZifferIstDoppelt(int geheime_zahl) {
        int gefundeneZiffern = 0;
        for (int ziffer = 0; ziffer <= 9; ziffer++) {
            if ( istZifferInZahl(ziffer, geheime_zahl) ) {
                 gefundeneZiffern++;
            }
        }
        return gefundeneZiffern == 3;
    }

    public static boolean istZifferInZahl(int ziffer, int zahl) {
        while ( zahl > 0 ) {
            int zifferDerZahl = zahl % 10;
            if (ziffer == zifferDerZahl) {
                return true;
            }
            zahl = zahl / 10;
        }
        return false;
    }

    public static int bestimmeVorhandeneZiffern(int geheime_zahl, int zahl) {
        int vorhandeneZiffern = 0;
        while ( zahl > 0 ) {
            int zifferDerZahl = zahl % 10;
            if ( istZifferInZahl(zifferDerZahl, geheime_zahl) ) {
                vorhandeneZiffern++;
            }
            zahl = zahl / 10;
        }
        return vorhandeneZiffern;
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
