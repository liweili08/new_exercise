package student_aufgabe;

import org.junit.Test;

public class Student {
    //field
    int number; //Matrikelnummer
    int state; //Klasse [1,6]
    int score; //[0,100]

    //Methode
    public void printInfo(){
        System.out.println("number=" + number + ", state=" + state + ", score=" + score);
    }
    /*
    obere Methode hat keinen Rückgabewert.
    kann auch mit String als Rückgabewert(ohne sout, sonder mit return), wie folgende toString Methode:
     */

    @Override
    public String toString() {
        return  "number=" + number +
                ", state=" + state +
                ", score=" + score ;
    }

    public Student getStudent(int a)
    {
        if(a>0)
        {
            return new Student();
        }
        return null;
    }

    @Test
    public void test()
    {

    }

}
