package collection_list;

import java.util.*;

public class List_Aufgabe2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben Sie 5 Nummer an:");
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            int input = scan.nextInt();
            list.add(input);
        }
//        Collections.reverse(list);
//        System.out.println(list);


        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer int1 = (Integer) o1;
                    Integer int2 = (Integer) o2;
                    return -Integer.compare(int1, int2);
                }
                throw new RuntimeException("wrong input");
            }
        });
        System.out.println(list);
    }


}
