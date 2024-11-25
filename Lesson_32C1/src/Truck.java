import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable
{
	static Lock locker = new ReentrantLock();
	int      tripCount;
	int      capacity;
	Elevator elevator;

	public Truck(int tripCount, int capacity, Elevator elevator)
	{
		this.tripCount = tripCount;
		this.capacity  = capacity;
		this.elevator  = elevator;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < tripCount; i++)
		{
			if (locker.tryLock())
			{
				locker.lock();
				try
				{
					elevator.add(capacity);
				}
				finally
				{
					locker.unlock();
				}
			}
			else
			{
				locker.lock();
				try
				{
					elevator.add(capacity);
				}
				finally
				{
					locker.unlock();
				}
			}
		}
	}
}
