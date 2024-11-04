import java.util.Random;

public class Cockroach implements Runnable
{
	public static int winner;
	static boolean isAnyoneWinner = false;
	Random random          = new Random();
	int    distance;
	int    coveredDistance = 0;
	int    cockroachNumber;
	int    delay;
	int    time            = 0;

	public Cockroach(int distance, int cockroach)
	{
		this.distance        = distance;
		this.cockroachNumber = cockroach;
	}

	@Override
	public void run()
	{
		while (coveredDistance < distance)
		{
			try
			{
				delay = random.nextInt(3) + 2;
				time += delay;
				Thread.sleep(delay);
				coveredDistance++;
				System.out.println(
						"Cockroach " + (cockroachNumber + 1) + " covered distance in " + coveredDistance + ".        Delay: " +
						delay + ";   Total time: " + time + " ms");
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}

		synchronized (Cockroach.class)
		{
			if (!isAnyoneWinner)
			{
				isAnyoneWinner = true;
				winner         = cockroachNumber + 1;
			}
		}
	}
}