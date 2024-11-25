package person.company.dao;

import person.company.model.Employee;
import person.company.model.Person;

public class CompanyImplemented implements Company
{

	@Override
	public boolean addPerson(Person person)
	{
		return false;
	}

	@Override
	public Employee removeEmployee(int id)
	{
		return null;
	}

	@Override
	public Employee findById(int id)
	{
		return null;
	}

	@Override
	public Employee updateByPosition(int id, String position, double salary)
	{
		return null;
	}

	@Override
	public Employee updateByLastName(int id, String nameLast)
	{
		return null;
	}

	@Override
	public Employee[] findEmployeesByPosition(String position)
	{
		return new Employee[0];
	}

	@Override
	public Employee[] findEmployeesBySalary(double min, double max)
	{
		return new Employee[0];
	}
}
