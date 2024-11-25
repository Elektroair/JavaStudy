public class InfiniteLoopApp
{
	public static void main(String[] args) throws InterruptedException
	{
		InfinityLoop infinityLoop = new InfinityLoop();
		Thread thread = new Thread(infinityLoop);
		thread.start();
		System.out.println("Before: " + infinityLoop.isFlag());
		Thread.sleep(3000);
		System.out.println("After: " + infinityLoop.isFlag());
		infinityLoop.setFlag(false);
		System.out.println(Thread.currentThread().getName() + " is finished");
	}
}
