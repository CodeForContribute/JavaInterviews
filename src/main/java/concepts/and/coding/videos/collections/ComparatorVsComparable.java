package concepts.and.coding.videos.collections;
import java.util.*;

class Car{
    private String carName;
    private String carType;

    public Car(String carName, String carType) {
        this.carName = carName;
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}

class CarNameComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getCarName().compareTo(o2.getCarName());
    }
}

class CarTypeComparator implements Comparator<Car>{
    @Override
    public int compare(Car o1, Car o2) {
        return  o2.getCarType().compareTo(o1.getCarType());
    }
}
public class ComparatorVsComparable {
    public static void main(String[] args) {
        // primitive collection sorting
        Integer[]arr = {1,4,5,1,3};
        Arrays.sort(arr);
        // Object collection sorting
        Car[]cars = new Car[3];
        cars[0] = new Car("SUV","Petrol");
        cars[1] = new Car("Sedan","Diesel");
        cars[2] = new Car("HatchBack","CNG");
        //Arrays.sort(cars);
        /*
        * Comparator -int compare(T o1, T o2)
         * sorting algo uses this compare method of comparator to compare
         * 2 variables and decide whether to swap the variables or not.
         * Method returns
         * 1. if o1 is bigger than o2.
         * 2. if o1 and o2 are equal.
         * 3. if o1 is smaller than o2.
         * if this method returns 1, swap the values.
         *
         * Comparable - int compareTo(T o)
         * the sorting algo uses this to compareTo method of Comparator
         * to compare 2 variables and decide whether to swap the variables or not.
         *
        * */

        // sort in ascending order
        Arrays.sort(arr,(Integer a,Integer b)->a-b);
        // sort in descending order
        Arrays.sort(arr,(Integer a, Integer b)->b-a);
        //Arrays.stream(arr).forEach(System.out::println);
        //Arrays.sort(cars,(Car a, Car b)->a.getCarType().compareTo(b.getCarType()));
        //Arrays.stream(cars).forEach(car -> System.out.println(car.getCarType()));
        //Arrays.sort(cars,(Car a, Car b)->b.getCarName().compareTo(a.getCarName()));
        Arrays.sort(cars, (Car a, Car b) -> b.getCarName().compareTo(a.getCarName()));
        //Arrays.stream(cars).forEach(car -> System.out.println(car.getCarName()));
        // Alternatively we can create individual comparator class and implements comparator interface
        // and pass to the function arg
        List<Car>carList = new ArrayList<>();
        carList.add(new Car("SUV","Petrol"));
        carList.add(new Car("Sedan","Diesel"));
        carList.add(new Car("HatchBack","CNG"));
        carList.sort(new CarNameComparator());
        carList.forEach(car -> System.out.println(car.getCarName()));
        carList.sort(new CarTypeComparator());
        carList.forEach(car -> System.out.println(car.getCarType()));

    }
}
