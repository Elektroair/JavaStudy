public class ElevatorApp
{
	static final int TruckCount = 1000;
	static final int TripCount = 10;
	static final int Capacity = 20;

	public static void main(String[] args) throws InterruptedException
	{
		Elevator elevator = new Elevator("Lenin");
		Truck[]  trucks   = new Truck[TruckCount];
		Thread[] threads = new Thread[TruckCount];

		for (int i = 0; i < trucks.length; i++)
		{
			trucks[i] = new Truck(TripCount, Capacity, elevator);
		}

		for (int i = 0; i < threads.length; i++)
		{
			threads[i] = new Thread(trucks[i]);
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}

		System.out.println("Elevator " + elevator.getName() + " has " + elevator.getCurrentVolume() + " t");
	}
}
