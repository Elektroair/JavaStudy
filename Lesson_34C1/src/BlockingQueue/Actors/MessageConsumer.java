package BlockingQueue.Actors;

import BlockingQueue.Mediation.BlockingQueue;

public class MessageConsumer extends Thread
{
	BlockingQueue<String> blockingQueue;
	int                   messageHandlingTimeMillis;

	public MessageConsumer(BlockingQueue<String> blockingQueue, int messageHandlingTimeMillis)
	{
		this.blockingQueue             = blockingQueue;
		this.messageHandlingTimeMillis = messageHandlingTimeMillis;
		setDaemon(true);
	}

	@Override
	public void run()
	{
		while (true)
		{
			String message = blockingQueue.pop();
			System.out.println(message + " ==> Consumer " + getId());
			try
			{ // Simulate message handling
				Thread.sleep(messageHandlingTimeMillis);
			}
			catch (InterruptedException e)
			{
				// Noop
			}
		}
	}
}
