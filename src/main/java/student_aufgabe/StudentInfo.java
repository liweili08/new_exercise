package student_aufgabe;

public class StudentInfo {
    public static void main(String[] args) {
        //deklariere ein Array names students mit Länge 20, jedes Element ist ein Student-Objekt.
        Student[] students = new Student[20];
        /*Nach der Deklaration von students gibt es
          in stack: eine Variable students und
          in heap:  ein Array mit Länge 20, jedes Element des Arrays ist nicht zugewiesen => alle Elemente sind null
         */

        //Mit for-Schleife alle Elemente des Arrays erzeugen und danach Wert geben
        for (int i = 0; i < students.length; i++) {
            //das i-te Element ist ein Student-Objekt
            students[i] = new Student();
            /*muss nicht so:
            Student stu = new Student(); students[i] = stu;
            denn nach der Deklaration des Arrays sind alle Elemente ein Student-Objekt!
             */
            students[i].number = i + 1;
            students[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            students[i].score = (int) (Math.random() * (100 - 0 + 1) + 0);
        }

        //zeige Info aller Studenten:
        /* Mit Schleife:
        for (int i=0; i< students.length; i++){
            System.out.println("number=" + students[i].number + ", state="
                    + students[i].state + ", score=" + students[i].score);
        }
         */

        //Mit Methode in Student Klasse:
//        for (int i=0; i< students.length; i++){
//           students[i].printInfo();
//        //    System.out.println(students[i].toString());//um den Rückgabewert sehen zu können muss sout benutzt
//        }
//        System.out.println("***************************************");

        //zeige StudentenInfo mit state 3:
//        for (int i = 0; i < students.length; i++) {
//            if (students[i].state == 3) {
//                students[i].printInfo();
//            }
//        }

        //zeige StudentenInfo mit gewünschten state:
//        Scanner scanner =new Scanner(System.in);
//        System.out.println("Bitte geben Sie die Anzahl der Klasse (von 1 bis 6) an:");
//        int stateWanted = scanner.nextInt();
//        for (int i = 0; i < students.length; i++) {
//            if (students[i].state==stateWanted) {
//                students[i].printInfo();
//            }
//        }

        //sortiere Array nach score mit "Bubble sort" und zeige alle Info mit neuer Reihenfolge:

        for (int i = 0; i < students.length; i++) {
            students[i].printInfo();
        }
        System.out.println("**************************");
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].score >= students[j + 1].score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            students[i].printInfo();
        }

    }
}
