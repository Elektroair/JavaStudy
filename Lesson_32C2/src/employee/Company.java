package employee;

import employee.model.Employee;

public interface Company
{
	boolean addEmployee(Employee employee);
	Employee removeEmployee(int id);
	Employee updateEmployee(Employee employee);
	Employee findById(int id);
	Employee findByName(String name);
	Employee[] findBetweenSalary(double min, double max);
	Employee[] findByPosition(String position);
}
