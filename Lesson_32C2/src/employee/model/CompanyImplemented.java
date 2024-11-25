package employee.model;

import employee.Company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CompanyImplemented implements Company
{
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock          readLock      = readWriteLock.readLock();
	private Lock          writeLock     = readWriteLock.writeLock();
	Employee[] employees = new Employee[1];

	@Override
	public boolean addEmployee(Employee employee)
	{
		writeLock.lock();
		try
		{
			employees[0] = employee;
			return false;
		}
		finally
		{
			writeLock.unlock();
		}
	}

	@Override
	public Employee removeEmployee(int id)
	{
		writeLock.lock();
		try
		{
			return null;
		}
		finally
		{
			writeLock.unlock();
		}
	}

	@Override
	public Employee updateEmployee(Employee employee)
	{
		writeLock.lock();
		try
		{
			employees[0] = employee;
			return null;
		}
		finally
		{
			writeLock.unlock();
		}
	}

	@Override
	public Employee findById(int id)
	{
		readLock.lock();
		try
		{
			return null;
		}
		finally
		{
			readLock.unlock();
		}
	}

	@Override
	public Employee findByName(String name)
	{
		readLock.lock();
		try
		{
			return null;
		}
		finally
		{
			readLock.unlock();
		}
	}

	@Override
	public Employee[] findBetweenSalary(double min, double max)
	{
		readLock.lock();
		try
		{
			return new Employee[0];
		}
		finally
		{
			readLock.unlock();
		}
	}

	@Override
	public Employee[] findByPosition(String position)
	{
		readLock.lock();
		try
		{
			return new Employee[0];
		}
		finally
		{
			readLock.unlock();
		}
	}
}
