import java.time.LocalDate;
import java.time.LocalTime;

public class Timer implements Runnable
{
	int clockPeriod = 1;

	public int getClockPeriod()
	{
		return clockPeriod;
	}

	public void setClockPeriod(int clockPeriod)
	{
		this.clockPeriod = clockPeriod;
	}

	@Override
	public void run()
	{
		while (true)
		{
			System.out.println(LocalTime.now());
			try
			{
				Thread.sleep(clockPeriod * 1000);
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().isInterrupted());
				System.out.println(Thread.interrupted());
				System.out.println(Thread.currentThread().getName() + " stopped");
				throw new RuntimeException(e);
			}
		}

	}
}
