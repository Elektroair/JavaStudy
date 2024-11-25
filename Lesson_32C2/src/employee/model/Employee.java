package employee.model;

import java.util.Objects;

public class Employee
{
	private int id;
	private String name;
	private String position;
	private double salary;

	public Employee(int id, String name, String position, double salary)
	{
		this.id       = id;
		this.name     = name;
		this.position = position;
		this.salary   = salary;
	}

	@Override
	public String toString()
	{
		return "employee.model.Employee{" + "id=" + id + ", name='" + name + '\'' + ", position='" + position + '\'' + ", salary=" +
		       salary + '}';
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
		Employee employee = (Employee) object;
		return id == employee.id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, position, salary);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
}
