package schleifen;

//Finde alle Primzahlen kleiner gleich 1000
public class Primzahl {
    public static void main(String[] args) {
        for(int i =2; i<=100; i++){
            boolean isPrim=true;
            for (int j=2; j<=i-1;j++){
                if(i%j==0){
                    isPrim=false;
                    break;
                }
            }
            if(isPrim==true){
                System.out.println(i);
            }

        }
    }
}
