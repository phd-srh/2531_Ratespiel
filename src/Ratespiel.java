import java.util.Scanner;

public class Ratespiel {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int geheime_zahl = 37;

        while (true) {
            System.out.print("Wie lautet die Zahl: ");
            int zahl = eingabe.nextInt();

            if (zahl == geheime_zahl) {
                System.out.println("Jawoll, die Zahl ist richtig!");
                break;
            }
            else {
                System.out.println("Das war leider die falsche Zahl");
            }
        }
    }
}
