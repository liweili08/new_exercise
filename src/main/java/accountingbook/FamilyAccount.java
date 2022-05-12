package accountingbook;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FamilyAccount {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int balance =10000;
        boolean isFlag=true; //kann später als false geändert werden damit beendet man die Schleife
        String details="Ein/Aus\t\tKontosumme\t\tBeitrag\t\tErklärung\n";
        //damit man details der Einkommen und Ausgaben speichern kann

        while (isFlag){
            /*
            1. Da die folgenden 6 sout immer gezeigt werden, braucht man eine Schleife
            2. die Schleife läuft immer, solange isFalg nicht geändert wird
            */
            System.out.println("-------------------- Family Account --------------------");
            System.out.println("                    1. Details                         ");
            System.out.println("                    2. Einkommen                         ");
            System.out.println("                    3. Ausgaben                         ");
            System.out.println("                    4. Ausloggen                         ");
            System.out.print("               Bitte wählen Sie (1-4):");

            /*
            1. der Auswahl muss von der Tastatur genommen, dafür braucht man die readMenuSelection Methode,
            2. die readMenuSelection ist eine "static" Methode und "static" Methode von einer Klasse kann durch
               "KlasseName.MethodeName()" direkt angerufen() werden.
            */
            char selection = Utility.readMenuSelection();
            /*
            Nachdem man einer von 1-4 gewählt hat, gibt es unterschiedliche Bearbeitungen. Nach der Bearbeitung
            wird der jetzige Zyklus sofort gestoppt und der nächste Zyklus fängt an(falls möglich). Deshalb
            braucht man nach jedem case ein "break;".
            */
            switch (selection){
                case '1': //Achtung: 1,2,3,4 sind Zahlen, aber selection sind char!
                    System.out.println("-------------------- Detials --------------------");
                    System.out.println(details); //in 2 und 3 wird die Variable "details" bearbeitet
                    System.out.println("-------------------------------------------------");
                    break;
                case '2':
                    System.out.print("Beitrag des Einkommens: ");
                    int einkommenZahl= Utility.readNumber();
                    System.out.print("Erklärung: ");
                    String einkommemErk=Utility.readString();
                    balance+=einkommenZahl;
                    details+=("Einkommen\t\t"+balance+"\t\t"+einkommenZahl+"\t\t"+einkommemErk+"\n");
                    break;
                case '3':
                    System.out.print("Beitrag der Ausgabe: ");
                    int ausgabeZahl= Utility.readNumber();
                    System.out.print("Erklärung: ");
                    String ausgabeErk=Utility.readString();
                    if(balance>=ausgabeZahl){
                        balance-=ausgabeZahl;
                        details+=("Einkommen\t\t"+balance+"\t\t"+ausgabeZahl+"\t\t"+ausgabeErk+"\n");
                    }else{
                        System.out.println("kein genug Geld auf Konto!");
                    }
                    break;
                case '4':
                    System.out.print("Möchten Sie ausloggen?(Y/N)");
                    char isExit= Utility.readConfirmSelection();
                    if(isExit=='Y'){
                        isFlag=false; //isFlag ist geändert, nach dieser Zyklus stoppt die Schleife.
                    }//braucht man kein "else", die nächste Zyklus fängt normal an
                    //break;
            }
        }
    }
}
