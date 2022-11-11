package person_aufgabe;

public class PersonTest
{
public static void main(String[] args)
{
    Person p1 = new Person();
    //Person p2 = new Person();

    p1.name="Tom";
    p1.isMale=true;
    System.out.println(p1.name);
    p1.eat();
    p1.sleep();
    p1.talk("chinese");
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

    public void sleep()
    {
        System.out.println("People can sleep.");
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