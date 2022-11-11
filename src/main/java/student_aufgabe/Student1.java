package student_aufgabe;

import org.junit.Test;

public class Student1
{    //field
    String number; //Matrikelnummer
    int state; //Klasse [1,6]
    int score; //[0,100]

    public Student1()
    {
    }

    public Student1(String number, int state, int score) {
        this.number = number;
        this.state = state;
        this.score = score;
    }

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

    public static Student1 getStudent1(int a)
    {
        if(a>0)
        {
            a=a+10;
            System.out.println("a ist "+a);
            return new Student1("001",1,90);
        }
        else if(a==0)
        {
            a=a+20;
            System.out.println("a ist "+a);
            return new Student1("002",2,100);
        }

        a=a+1;
        System.out.println("a ist "+a);

        return new Student1("003",3,60);

    }

    public Student1 correctScore(Student1 student1)
    {
        if(student1.state==3)
        {
            score=student1.score+5;
        }

        score++;
        System.out.println("The new score is "+score);
        return new Student1(student1.number,student1.state,score);
    }
    public static void main(String[] args) {
       // int a = -10;
       // System.out.println(getStudent1(a));

        Student1 student1 = new Student1("004",3,55);
        Student1 student2 = new Student1("005",4,76);

        System.out.println(student1.correctScore(student1));
        System.out.println(student2.correctScore(student2));


    }

}


