package employee;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {

    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    //没有泛型时
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof MyDate) {
//            MyDate m = (MyDate) o;
//            int diffYear = this.getYear() - m.getYear();
//            if (diffYear != 0) {
//                return diffYear;
//            }
//
//            int diffMonth = this.getMonth() - m.getMonth();
//            if (diffMonth != 0) {
//                return diffMonth;
//            }
//            return this.getDay() - m.getDay();
//        }
//        throw new RuntimeException("wrong input");
//    }

    //有泛型时
    @Override
    public int compareTo(MyDate m) {
        //比较年
        int diffYear = this.getYear() - m.getYear();
        if (diffYear != 0) {
            return diffYear;
        }
        //比较月
        int diffMonth = this.getMonth() - m.getMonth();
        if (diffMonth != 0) {
            return diffMonth;
        }
        //比较日
        return this.getDay() - m.getDay();
    }
}
