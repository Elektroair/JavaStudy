import java.util.concurrent.atomic.AtomicInteger;

public class Elevator
{
	static final Object Monitor = new Object();
	String name;
//	int    currentVolume;
	AtomicInteger currentVolume = new AtomicInteger();

	public Elevator(String name)
	{
		super();
		this.name = name;
	}

	public int getCurrentVolume()
	{
		return currentVolume.get();
	}

	public void setCurrentVolume(int currentVolume)
	{
		this.currentVolume.set(currentVolume);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void add(int portion)
	{
//		synchronized (Monitor)
//		{
			currentVolume.addAndGet(portion);
//		}
	}
}
