import java.util.Scanner;

public class CockroachRace
{
	public static void main(String[] args)
	{
		int distance;
		int cockroachCount;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the race distance:");
		distance = scanner.nextInt();
		System.out.println("Enter the cockroach count:");
		cockroachCount = scanner.nextInt();

		Thread[] threads = new Thread[cockroachCount];
		Cockroach[] cockroaches = new Cockroach[cockroachCount];

		for (int i = 0; i < threads.length; i++)
		{
			cockroaches[i] = new Cockroach(distance, i);
			threads[i] = new Thread(cockroaches[i]);
		}

		for (Thread thread : threads)
		{
			thread.start();
		}

		for (Thread thread : threads)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}

		System.out.println();
		System.out.println("Congratulations to cockroach " + Cockroach.winner);
	}
}
