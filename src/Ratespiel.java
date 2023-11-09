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
            if (zahl == geheime_zahl) {
                System.out.println("Jawoll, die Zahl ist richtig!");
                break;
            }
            else if (zahl - 100 > geheime_zahl) {
                System.out.println("Die Zahl ist viel zu groß");
            }
            else if (zahl > geheime_zahl ) {
                System.out.println("Die Zahl ist zu groß");
            }
            else if (zahl + 100 < geheime_zahl) {
                System.out.println("Die Zahl ist viel zu klein");
            }
            else {
                System.out.println("Die Zahl ist zu klein");
            }
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht");
    }
}
