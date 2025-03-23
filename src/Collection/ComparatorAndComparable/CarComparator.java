package Collection.ComparatorAndComparable;

import java.util.Comparator;

public class CarComparator implements Comparator<CarComparator>{

    String carType;
    String fuelType;

    public CarComparator() {

    }

    public CarComparator(String carType, String fuelType){
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
    public int compare(CarComparator o1, CarComparator o2) {
        return o2.getCarType().compareTo(o1.getCarType());
    }
}
