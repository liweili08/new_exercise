package method_reference;

public class Employee_Reference {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee_Reference() {
        System.out.println("空参构造器");
    }

    public Employee_Reference(int id) {
        this.id = id;
        System.out.println("带id的构造器");
    }

    public Employee_Reference(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("带id和name的构造器");
    }

    public Employee_Reference(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        //System.out.println("全参构造器");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee_Reference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee_Reference that = (Employee_Reference) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (Double.compare(that.salary, salary) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
