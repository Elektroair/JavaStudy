import java.time.Instant;
import java.time.LocalTime;

public class TimerSleep implements Runnable
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
				customSleep(clockPeriod * 1000);
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

	private void customSleep(long time) throws InterruptedException
	{
		Instant currentTime = Instant.now();
		Instant finishTime = currentTime.plusMillis(time);
		while (currentTime.isBefore(finishTime))
		{
			currentTime = Instant.now();
			if (Thread.currentThread().isInterrupted())
			{
				throw new InterruptedException();
			}
		}
	}
}
