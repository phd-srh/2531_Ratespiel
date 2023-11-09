import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int geheime_zahl = (int)(Math.random() * 9000 + 1000);

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

            // TODO

            System.out.println("Es sind " + korrekteZiffern + " korrekte Ziffern");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }
}
