package Collection.ComparatorAndComparable;

import java.util.Comparator;

public class Car implements Comparable<Car> {

    String carType;
    String fuelType;

    public Car(String carType, String fuelType){
        this.carType = carType;
        this.fuelType = fuelType;
    }

    public String getCarType() {
        return carType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public int compareTo(Car o) {
        return this.carType.compareTo(o.carType);
    }
}
