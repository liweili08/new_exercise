package schleifen;

import java.util.Scanner;

/*
Für den Fall dass man vorher nicht weiß, wie oft die Schleife durchgeführt werden soll.
Aufgabe: nehme ganze Zahlen(unbestimmte Anzahl) von Tastatur, gebe die Anzahl der positiven und negativen Zahlen. Für 0 endet das Programm
*/
public class InfiniteLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int posNumber=0;
        int negNumber=0;
        System.out.println("Bitte geben Sie Nummer an:");
        while (true) {
            int inputNumber = scanner.nextInt();
            if (inputNumber > 0) {
                posNumber++;
                //hier sout: die Anzahl nach jeder Eingabe einmal ausdrucken
                //System.out.println("Es gibt "+ posNumber+ " positive Nummer und "+negNumber+ " negative Nummer.");
            } else if (inputNumber < 0) {
                negNumber++;
                //System.out.println("Es gibt "+ posNumber+ " positive Nummer und "+negNumber+ " negative Nummer.");
            } else {
                //System.out.println("Es gibt "+ posNumber+ " positive Nummer und "+negNumber+ " negative Nummer.");
                break;
            }
        }
        //hier sout: die gesammte Anzahl der posNumber und negNumber (NUR EINMALL)
        System.out.println("Es gibt "+ posNumber+ " positive Nummer und "+negNumber+ " negative Nummer.");
    }


}
