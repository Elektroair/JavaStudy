package BlockingQueue.Actors;

import BlockingQueue.Mediation.BlockingQueue;

public class MessageProducer extends Thread
{
	BlockingQueue<String> blockingQueue;
	int                   nMessages;
	int              sendIntervalMillis;

	public MessageProducer(BlockingQueue<String> blockingQueue, int nMessages, int sendIntervalMillis)
	{
		this.blockingQueue      = blockingQueue;
		this.nMessages          = nMessages;
		this.sendIntervalMillis = sendIntervalMillis;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < nMessages; i++)
		{
			try
			{
				Thread.sleep(sendIntervalMillis);
			}
			catch (InterruptedException e)
			{
				// noop
			}
			String message = "message № " + i;
			blockingQueue.push(message);
			System.out.println(message + " <== producer " + getId());
		}
	}
}
