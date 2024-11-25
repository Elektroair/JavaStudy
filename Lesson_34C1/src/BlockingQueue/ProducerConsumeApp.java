package BlockingQueue;

import BlockingQueue.Actors.MessageConsumer;
import BlockingQueue.Actors.MessageProducer;
import BlockingQueue.Mediation.BlockingQueueImplemented;
import BlockingQueue.Mediation.BlockingQueue;

public class ProducerConsumeApp
{

	private static final int MessageCount              = 50;
	private static final int ConsumerCount             = 5;
	private static final int MessageSendIntervalMillis = 100;
	private static final int MessageHandlingTimeMillis = 1000;
	private static final int QueueMaxSize              = 10;

	public static void main(String[] args) throws InterruptedException
	{
		BlockingQueue<String> blockingQueue = new BlockingQueueImplemented<>(QueueMaxSize);
		MessageProducer       sender        =
				new MessageProducer(blockingQueue, MessageCount, MessageSendIntervalMillis);
		sender.start();
		for (int i = 0; i < ConsumerCount; i++)
		{
			new MessageConsumer(blockingQueue, MessageHandlingTimeMillis).start();
		}

		Thread.sleep(MessageCount / ConsumerCount * MessageHandlingTimeMillis + 1000);

	}

}
