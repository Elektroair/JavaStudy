package MultiThreading.Controller;

public class TaskExtends extends Thread
{
	String name;
	int    max;

	public TaskExtends(String name, int max)
	{
		this.name = name;
		this.max  = max;
	}

	@Override
	public void run()
	{
		System.out.println("«" + name + "» started");
		for (int index = 0; index <= max; index++)
		{
			System.out.println("«" + name + "», count = " + index);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				throw new RuntimeException(e);
			}
		}
		System.out.println("«" + name + "» finished");
	}
}
