public class InfinityLoop implements Runnable
{
	volatile boolean flag = true;

	public boolean isFlag()
	{
		return flag;
	}

	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}

	@Override
	public void run()
	{
		while (flag) ;

		System.out.println("Finished");
	}
}
