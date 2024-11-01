import java.util.*;

public class Car implements Comparable<Car>
{
	public String model;
	public int    year;
	public double volume;

	public Car(String name, int year, double volume)
	{
		this.model   = name;
		this.year   = year;
		this.volume = volume;
	}

	@Override
	public String toString()
	{
		return "Name: " + this.model + "; Year: " + this.year + "; Engine volume: " + this.volume;
	}

	@Override
	public int hashCode()
	{
		return model.hashCode() + year - Double.hashCode(volume);
	}

	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		if (object == null || getClass() != object.getClass())
		{
			return false;
		}
		Car car = (Car) object;
		return year == car.year && Double.compare(volume, car.volume) == 0 && Objects.equals(model, car.model);
	}

	@Override
	public int compareTo(Car car)
	{
		int result = model.compareToIgnoreCase(car.model);
		if(result == 0)
		{
			result = Integer.compare(year, car.year);
		}
		if (result == 0)
		{
			result = Double.compare(volume, car.volume);
		}
		return result;
	}
}
