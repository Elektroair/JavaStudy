public class Truck implements Runnable
{
	int tripCount;
	int capacity;
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
			elevator.add(capacity);
		}
	}
}
