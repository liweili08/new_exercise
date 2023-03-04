package optional_test;

public class Boy {
    private Car car;

    public Boy() {
    }

    public Boy(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "car=" + car +
                '}';
    }
}
