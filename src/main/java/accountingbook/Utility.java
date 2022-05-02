package accountingbook;

import java.util.Locale;
import java.util.Scanner;

public class Utility {
    //Für Menü wählen: bekommt die Nummer von Tastatur.
    private static Scanner scanner = new Scanner(System.in);

    /*
    Die Methode gibt char als Rückgabewert, falls die angegebene Nummer 1,2,3, oder 4 ist.
    Ansonst: Fehlermeldung
    */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'){ //Falls andere Buchstabe angegeben ist, Fehlermeldung
                System.out.println("Falsche Eingabe, bitte neue Zahl angeben: ");
            }else {
                break;
            }
        }
        return c;
    }

    /*
    Die Methode wird angewendet für die Angabe der Beiträge vom Einkommen und Ausgaben.
    Die Methode nimmt eine ganze Zahl(<10000) von der Tastatur und gibt die Zahl als Rückgabewert.
    */
    public static int readNumber(){
        int n;
        for(;;){
            String str = readKeyBoard(10);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){  //Falls man keine Zahl (z.B. "abcd") angegeben hat, Fehlermeldung
                System.out.println("Falsche Eingabe, bitte neuen Beitrag angeben: ");
            }
        }
        return n;
    }

    /*
    Die Methode wird angewendet für die Details der Beiträge vom Einkommen und Ausgaben.
    Die Methode nimmt ein String(<30) von der Tastatur und gibt es als Rückgabewert.
     */
    public static String readString(){
        String str =readKeyBoard(30);
        return str;
    }

    /*
    Die Methode wird angewendet für Angabe von Y oder N .
    Die Methode nimmt 'Y' oder 'N' von der Tastatur und gibt es als Rückgabewert.
     */
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else{ //Falls andere Buchstabe angegeben ist, Fahlermeldung
                System.out.println("Falsche Eingabe, bitte neue angeben: ");
            }
        }
        return c;
    }


//**************************************************************************************
    private static String readKeyBoard(int limit) { //die Methode beschränkt die Länge des Inputs
        String line = "";
        while (scanner.hasNext()) {
            /*
            die scanner.hasNext() Methode gibt true wenn der Scanner andere Buchstabe(kein Leerzeichen) enthalten
            die scanner.next() Methode nimmt das angegebene String(bis zu dem nächsten Leerzeichen) und gibt es zurück
             */
            line = scanner.nextLine();//nimmt alle Sachen in der aktuelle Zeile und gibt sie zurück
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("Input falsch! (Die Länge soll kleiner oder gleich " + limit + " sein.)");
                continue;
            } else {
                break;
            }
        }
        return line;
    }
}


