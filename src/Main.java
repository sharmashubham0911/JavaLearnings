import Collection.ComparatorAndComparable.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Car car1  = new Car("SUV", "Petrol");
        Car car2 = new Car("Sedan", "Diesel");
        Car car3 = new Car("HetchBack", "CNG");

        List<Car> carList = new ArrayList<>();
        carList.add((car1));
        carList.add((car2));
        carList.add((car3));

        Collections.sort(carList);

        for (Car car: carList){
            System.out.println(car.getCarType());
        }

    }
}