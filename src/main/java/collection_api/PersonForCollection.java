package collection_api;

public class PersonForCollection implements Comparable {
    private String name;
    private int age;

    public PersonForCollection() {
    }

    public PersonForCollection(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

    @Override
    public String toString() {
        return "PersonForCollection{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonForCollection that = (PersonForCollection) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按姓名,age从小到大排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof PersonForCollection) {
            PersonForCollection person = (PersonForCollection) o;
            int compare = this.name.compareTo(person.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, person.age);
            }
        } else {
            throw new RuntimeException("wrong input");
        }

    }
}
