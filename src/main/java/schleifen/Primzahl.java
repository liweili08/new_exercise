package schleifen;

//Finde alle Primzahlen kleiner gleich 1000
public class Primzahl {
    public static void main(String[] args) {
        int num = 0;
        long start = System.currentTimeMillis();
        for(int i =2; i<=100000; i++){
            boolean isPrim=true;
            for (int j=2; j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isPrim=false;
                    //break;
                }
            }
            if(isPrim==true){
                //System.out.println(i);
                num++;
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("Es gibt "+num+" Primzahlen und die Zeitaufwendung ist "+ (end-start));
    }
}
