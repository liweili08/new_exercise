package aufgabe_wiederholen;

public class Student {
    int number;
    int state;// [1,6]
    int score;// [0,100]

    public Student()
    {
    }

    public String toString()
    {
        return "Student hat Matrikelnummer "+ number+" und state "+ state+ " hat score "+ score;
    }

}
