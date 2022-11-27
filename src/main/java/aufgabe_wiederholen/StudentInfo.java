package aufgabe_wiederholen;
/*
1. baue 20 Studenten mit Matrikelnummer von 1 bis 20, und beliebige state & score
2. gebe alle Studenten mit state 3 an
3. sortiere die score und gebe alle Infomationen an
*/


public class StudentInfo
{
    public static void main(String[] args)
    {
        //StudentNeu studentNeu= new StudentNeu();
        Student[] studentArray =new Student[20];

        for (int i = 0; i <20; i++) {
            studentArray[i] = new Student();
            studentArray[i].number=i+1;
            studentArray[i].state=(int)(Math.random()*(6-1+1)+1);
            studentArray[i].score=(int)(Math.random()*(100-0+1)+0);
        }

        for (Student student_i:studentArray)
        {
            System.out.println(student_i);
        }
        System.out.println("********************");
        for (Student student_i:studentArray)
        {
            if(student_i.state==3)
            {
                //System.out.println(student_i);
                System.out.println(student_i.toString());
            }
        }
        System.out.println("********************");

        for (int i = 0; i < studentArray.length; i++) {
            for (int j = 0; j <studentArray.length-i-1; j++) {
                if(studentArray[j].score>=studentArray[j+1].score)
                {
                    Student temp=studentArray[j];
                    studentArray[j] =studentArray[j+1];
                    studentArray[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }
    }
}
