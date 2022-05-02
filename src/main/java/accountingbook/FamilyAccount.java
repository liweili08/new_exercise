package accountingbook;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FamilyAccount {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int balance =10000;
        boolean isFlag=true;
        String details="Ein/Aus\t\tKontosumme\t\tBeitrag\t\tErklärung\n";
        //damit man details der Einkommen und Ausgaben speichern kann

        while (isFlag){
            System.out.println("-------------------- Family Account --------------------");
            System.out.println("                    1. Details                         ");
            System.out.println("                    2. Einkommen                         ");
            System.out.println("                    3. Ausgaben                         ");
            System.out.println("                    4. Ausloggen                         ");
            System.out.print("               Bitte wählen Sie (1-4):");

            char selection = Utility.readMenuSelection();
            //die "static" Methode in Utility kann durch "KlasseName.MethodeName()" direkt angerufen() werden.
            switch (selection){
                case '1':
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
                        isFlag=false;
                    }
                    //break;
            }
        }
    }
}
