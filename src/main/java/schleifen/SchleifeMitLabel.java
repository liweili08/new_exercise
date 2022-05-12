package schleifen;

public class SchleifeMitLabel {
    public static void main(String[] args) {
        //break:beende die ganze Schleife (d.h. die j-Schleife ist fertig)
        for(int i=1;i<=4;i++){
            for(int j=1;j<=10;j++){
                if(j%4==0){
                    break;
                }
                System.out.print(j);
            }
            System.out.println("");
        }

        //continue: beende die jetzige Schleife (d.h. die j-Schleife kann weiter durchgeführt bis j==10)
        for(int i=1;i<=4;i++){
            for(int j=1;j<=10;j++){
                if(j%4==0){
                    continue;
                }
                System.out.print(j);
            }
            System.out.println("");
        }
        System.out.println("******************");

        //label: man markiert eine Schleife mit "label" und kann später die markierte Schleife beenden
        label: for(int i=1;i<=4;i++){
        for(int j=1;j<=10;j++){
            if(j%4==0){
                break label;
                //continue label;
            }
            System.out.print(j);
        }
            System.out.println();
        }
    }
}
