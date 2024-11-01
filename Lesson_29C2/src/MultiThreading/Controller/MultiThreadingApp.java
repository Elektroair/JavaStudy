package MultiThreading.Controller;

public class MultiThreadingApp
{
	private static final int Max = 10;
	private static final int Size = 5;

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println ("Main thread started");
		TaskImplements taskImplements = new TaskImplements("Task_1", Max);
		Thread thread_1 = new Thread(taskImplements);
		thread_1.start();

		TaskExtends thread_2 = new TaskExtends("Task_2", Max);

		Thread[] threads = new Thread[Size];
		TaskImplements[] tasks = new TaskImplements[Size];

		for (int index = 1; index <= Size; index++)
		{
			tasks [index] = new TaskImplements("Name " + index, Max);
		}

		for (int index = 1; index <= threads.length; index++)
		{
			threads [index] = new Thread(tasks[index]);
		}

		for (Thread thread : threads)
		{
			thread.start();
		}

		thread_2.start();

		for (int index = 0; index <= Max; index++)
		{
			System.out.println("Main thread, count = " + index);
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}

		thread_1.join();
		thread_2.join();
		System.out.println("Main thread finished");
	}
}
