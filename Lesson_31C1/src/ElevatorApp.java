public class ElevatorApp
{
	static final int TruckCount = 1000;
	static final int TripCount = 10;
	static final int Capacity = 20;

	public static void main(String[] args) throws InterruptedException
	{
		Elevator elevator_1 = new Elevator("Lenin");
		Elevator elevator_2 = new Elevator("Engels");
		Truck[] trucks = new Truck[TruckCount];
		Thread[] threads = new Thread[TruckCount];

		for (int i = 0; i < trucks.length; i++)
		{
			trucks[i] = new Truck(TripCount, Capacity, elevator_1);
			trucks[i] = new Truck(TripCount, Capacity, elevator_2);
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

		System.out.println("Elevator " + elevator_1.getName() + " has " + elevator_1.getCurrentVolume() + " t");
		System.out.println("Elevator " + elevator_2.getName() + " has " + elevator_2.getCurrentVolume() + " t");
	}
}
