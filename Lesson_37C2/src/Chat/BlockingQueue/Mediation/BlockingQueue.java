package Chat.BlockingQueue.Mediation;

public interface BlockingQueue<T>
{
	void push(T message);

	T pop();
}
