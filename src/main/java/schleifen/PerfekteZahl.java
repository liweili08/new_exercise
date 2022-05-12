package schleifen;

/*
Eine ganze Zahl a ist eine perfekte Zahl, falls a gleich der Summe aller ihrer Teiler außer sich selbst ist.
z.B. 6 = 1+2+3.
Finde alle perfekte Zahle kleiner gleich 1000.
*/
//
public class PerfekteZahl {
    public static void main(String[] args) {
        for(int i=1;i<=1000;i++){
            int sum=0;
            //finde alle Teiler von i:
            for (int j=1;j<=i/2;j++){ //j<i ist auch richtig aber computer muss mehr berechnen.
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum==i){
                System.out.println(i+" ist eine perfekte Zahl.");
            }
        }
    }
}
