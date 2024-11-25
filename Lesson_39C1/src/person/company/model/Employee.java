package person.company.model;

import java.time.LocalTime;

public class Employee extends Person
{
	private String position;
	private Double salary;
	private double hours;

	public Employee(int id, String nameFirst, String nameLast, LocalTime birthDate, String position, Double salary,
	                double hours)
	{
		super(id, nameFirst, nameLast, birthDate);
		this.position = position;
		this.salary   = salary;
		this.hours    = hours;
	}

	@Override
	public String toString()
	{
		return "Employee{" + "position='" + position + '\'' + ", salary=" + salary + ", hours=" + hours + '}';
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public Double getSalary()
	{
		return salary;
	}

	public void setSalary(Double salary)
	{
		this.salary = salary;
	}

	public double getHours()
	{
		return hours;
	}

	public void setHours(double hours)
	{
		this.hours = hours;
	}
}
