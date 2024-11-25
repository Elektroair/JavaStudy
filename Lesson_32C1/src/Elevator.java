public class Elevator
{
	String name;
	int    currentVolume;

	public Elevator(String name)
	{
		super();
		this.name = name;
	}

	public int getCurrentVolume()
	{
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume)
	{
		this.currentVolume = currentVolume;
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
			currentVolume += portion;
	}
}
