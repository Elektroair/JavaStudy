package person.company.dao;

import person.company.model.Employee;
import person.company.model.Person;

public interface Company
{
	boolean addPerson(Person person);

	Employee removeEmployee(int id);

	Employee findById(int id);

	Employee updateByPosition(int id, String position, double salary);
	Employee updateByLastName(int id, String nameLast);

	Employee[] findEmployeesByPosition(String position);

	Employee[] findEmployeesBySalary(double min, double max);
}
