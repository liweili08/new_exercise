package person_aufgabe;

public class PersonTest
{
    public static void main(String[] args)
    {
        Person p1 = new Person();

        p1.name="Tom";
        p1.isMale=true;
        System.out.println(p1.name+" and age is "+p1.age);
        p1.eat();
        System.out.println("***********************");
        p1.sleep(8);
        System.out.println("***********************");
        p1.talk("chinese");
        System.out.println("***********************");
        //**********************

        Person p2 = new Person();
        System.out.println(p2+" and name is"+p2.name+" and age is "+p2.age+" and "+p2.isMale);
        System.out.println("***********************");
        //**********************

        Person p3 = p1;
        System.out.println(p3.name+ " and age is "+p3.age);
        p3.age = 90;
        System.out.println(p3.age+" and p1 is "+ p1.age);


    }
}

class Person
{
    //Feld
    String name;
    int age=1;
    boolean isMale;

    //Konstruktur
    public Person(){}

    public Person(String name, int age, boolean isMale)
    {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    //Methode
    public void eat()
    {
        System.out.println("People can eat.");
    }

    public void sleep(int hour)
    {
        System.out.println("People should sleep "+hour+" hour");
        eat();
    }

    public void talk(String language)
    {
        System.out.println("People can talk in "+language);
    }

    public String display()
    {
        return "name is "+name+" age is "+age;
    }

    //innere Klasse
    class Pet
    {
        String name;
        float weight;
    }
}