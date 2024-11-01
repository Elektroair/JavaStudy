import java.util.*;

public class CarSet
{
	public static void main(String[] args)
	{
		Car car_1 = new Car("Toyota Camry", 2020, 2.5);
		Car car_2 = new Car("Honda Accord", 2021, 1.5);
		Car car_3 = new Car("Ford Mustang", 2019, 5.0);
		Car car_4 = new Car("Chevrolet Malibu", 2022, 1.5);
		Car car_5 = new Car("Tesla Model 3", 2023, 0.0); // Electric car
		Car car_6 = new Car("Nissan Altima", 2020, 2.0);
		Car car_7 = new Car("BMW 3 Series", 2021, 2.0);

		LinkedHashSet<Car> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(car_1);
		linkedHashSet.add(car_2);
		linkedHashSet.add(car_3);
		linkedHashSet.add(car_4);
		linkedHashSet.add(car_5);
		linkedHashSet.add(car_6);
		linkedHashSet.add(car_7);

		printCarSet(linkedHashSet);
		Car car_8 = new Car("Honda Accord", 2021, 1.5);
		System.out.println(car_8.hashCode());
		linkedHashSet.add(car_8);
		printCarSet(linkedHashSet);


		TreeSet<Car> treeSet = new TreeSet<>();
		treeSet.add(car_1);
		treeSet.add(car_2);
		treeSet.add(car_3);
		treeSet.add(car_4);
		treeSet.add(car_5);
		treeSet.add(car_6);
		treeSet.add(car_7);

		printCarSet(treeSet);
	}

	public static void printCarSet(Set<Car> set)
	{
		for (Car car : set)
		{
			System.out.println(car.toString());
		}
	}
}
