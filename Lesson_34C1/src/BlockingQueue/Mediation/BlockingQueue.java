package BlockingQueue.Mediation;

// This interface represents Blocking Queue for usage
// as communication buffer between Producers and Consumers

public interface BlockingQueue<T>
{
	void push(T message);

	T pop();
}
