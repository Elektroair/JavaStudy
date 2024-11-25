package BlockingQueue.Mediation;

import BlockingQueue.Mediation.BlockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImplemented<T> implements BlockingQueue<T>
{

	LinkedList<T> queue;

	Lock      mutex                    = new ReentrantLock();
	Condition consumerWaitingCondition = mutex.newCondition();
	Condition producerWaitingCondition = mutex.newCondition();
	int       maxSize;

	public BlockingQueueImplemented(int maxSize)
	{
		this.maxSize = maxSize;
		queue        = new LinkedList<>();
	}


	@Override
	public void push(T message)
	{
		mutex.lock();
		try
		{
			while (queue.size() >= maxSize)
			{
				try
				{
					producerWaitingCondition.await();
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException();
				}
			}
			queue.add(message);
			consumerWaitingCondition.signal();
		}
		finally
		{
			mutex.unlock();
		}
	}


	@Override
	public T pop()
	{
		mutex.lock();
		try
		{
			while (queue.size() < maxSize)
			{
				try
				{
					consumerWaitingCondition.await();
				}
				catch (InterruptedException e)
				{
					throw new RuntimeException();
				}
			}
			T msg = queue.pop();
			if (queue.size() == 0)
			{
				producerWaitingCondition.signal();
			}
			return msg;
		}
		finally
		{
			mutex.unlock();
		}
	}

}