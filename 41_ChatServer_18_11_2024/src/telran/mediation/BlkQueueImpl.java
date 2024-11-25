package telran.mediation;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlkQueueImpl<T> implements BlkQueue<T> {

	LinkedList<T> queue;
	int maxSize;
	private Lock mutex = new ReentrantLock();
	private Condition senderWaitingCondition = mutex.newCondition();
	private Condition receiverWaitingCondition = mutex.newCondition();

	public BlkQueueImpl(int maxSize) {
		this.maxSize = maxSize;
		queue = new LinkedList<>();
	}

	@Override
	public void push(T message) {
		mutex.lock();
		try {
			while (queue.size() >= maxSize) {
				try {
					senderWaitingCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			queue.add(message);
//			if (queue.size() == maxSize) {
			receiverWaitingCondition.signal();
//			}
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public T pop() {
		mutex.lock();
		try {
			while (queue.isEmpty()) {
				try {
					receiverWaitingCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			T res = queue.pop();
//			if (queue.isEmpty()) {
			senderWaitingCondition.signal();
//			}
			return res;
		} finally {
			mutex.unlock();
		}
	}

}