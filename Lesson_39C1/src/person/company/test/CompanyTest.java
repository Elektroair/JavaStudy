package person.company.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import person.company.dao.Company;
import person.company.model.Employee;

class CompanyTest
{
	private Company company;

	private Employee emp1;
	private Employee emp2;
	private Employee emp3;

	@BeforeEach
	void setUp()
	{
		company = new CompanyImpl();

		emp1 = new Employee(1, "John", "Doe", LocalDate.of(1993, 5, 12), "Manager", 5000.0, 40.0);
		emp2 = new Employee(2, "Jane", "Smith", LocalDate.of(1998, 3, 23), "Engineer", 4500.0, 35.0);
		emp3 = new Employee(3, "Alice", "Brown", LocalDate.of(1985, 12, 15), "Manager", 7000.0, 50.0);

		company.addPerson(emp1);
		company.addPerson(emp2);
		company.addPerson(emp3);
	}

	@Nested
	class AddPersonTests
	{

		@Test
		void shouldAddNewPerson()
		{
			Employee emp4 = new Employee(4, "Bob", "White", LocalDate.of(1990, 8, 19), "Designer", 4000.0, 38.0);
			assertTrue(company.addPerson(emp4));
			assertEquals(emp4, company.findById(4));
		}

		@Test
		void shouldNotAddDuplicatePerson()
		{
			assertFalse(company.addPerson(emp1));
		}
	}

	@Nested
	class RemoveEmployeeTests
	{

		@Test
		void shouldRemoveEmployeeById()
		{
			Employee removed = company.removeEmployee(1);
			assertEquals(emp1, removed);
			assertNull(company.findById(1));
		}

		@Test
		void shouldReturnNull_WhenRemovingNonExistentEmployee()
		{
			assertNull(company.removeEmployee(99));
		}
	}

	@Nested
	class UpdateTests
	{

		@Test
		void shouldUpdateLastName()
		{
			Employee updated = company.updateByLastName(1, , "Smith");
			assertNotNull(updated);
			assertEquals("Smith", updated.getLastName());
		}

		@ParameterizedTest
		@CsvSource({"2, Senior Engineer, 6000.0", "3, Team Lead, 7500.0"})
		void shouldUpdatePositionAndSalary(int id, String newPosition, double newSalary)
		{
			Employee updated = company.updateByPosition(id, newPosition, newSalary);
			assertNotNull(updated);
			assertEquals(newPosition, updated.getPosition());
			assertEquals(newSalary, updated.getSalary());
		}
	}

	@Nested
	class FindTests
	{

		@Test
		void shouldFindEmployeesByPosition()
		{
			Employee[] managers = company.findEmployeesByPosition("Manager");
			assertArrayEquals(new Employee[]{emp1, emp3}, managers);
		}

		@Test
		void shouldReturnEmptyArray_WhenNoEmployeesInPosition()
		{
			Employee[] interns = company.findEmployeesByPosition("Intern");
			assertArrayEquals(new Employee[]{}, interns);
		}

		@ParameterizedTest
		@CsvSource({"4000.0, 6000.0, 1, 2", "5000.0, 8000.0, 1, 3"})
		void shouldFindEmployeesBySalaryRange(double min, double max, int id1, int id2)
		{
			Employee[] result = company.findEmployeesBySalary(min, max);
			assertEquals(2, result.length);
			assertEquals(id1, result[0].getId());
			assertEquals(id2, result[1].getId());
		}

		@Test
		void shouldReturnEmptyArray_WhenNoEmployeesInSalaryRange()
		{
			Employee[] result = company.findEmployeesBySalary(10000, 20000);
			assertArrayEquals(new Employee[]{}, result);
		}

	}

	@Nested
	class EdgeCaseTests
	{

		@Test
		void shouldHandleNullInputsGracefully()
		{
			assertFalse(company.addPerson(null));
			assertNull(company.updateByLastName(99, null));
			assertNull(company.updateByPosition(99, null, 0));
		}

		@Test
		void shouldReturnEmptyArrays_WhenNoEmployees()
		{
			Company emptyCompany = new CompanyImpl();
			assertArrayEquals(new Employee[]{}, emptyCompany.findEmployeesByPosition("Manager"));
			assertArrayEquals(new Employee[]{}, emptyCompany.findEmployeesSalaryBetween(0, 1000));
			assertArrayEquals(new Employee[]{}, emptyCompany.findEmployeesAgeBetween(20, 30));
		}
	}
}
