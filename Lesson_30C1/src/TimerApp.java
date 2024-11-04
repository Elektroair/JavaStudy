import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerApp
{
	public static void main(String[] args) throws IOException
	{
		Timer  timer  = new Timer();
		Thread thread = new Thread(timer);
		thread.start();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			System.out.println("Enter time interval, or press «Q» for exit");

			String string = bufferedReader.readLine();

			if (string.equalsIgnoreCase("Q"))
			{
				System.out.println("Stopped thread " + Thread.currentThread().getName());
				thread.interrupt();
				break;
			}
			else
			{
				timer.setClockPeriod(Integer.parseInt(string));
			}

		}
		System.out.println("Main thread finished");
	}
}
