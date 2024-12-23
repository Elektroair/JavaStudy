import java.util.Iterator;

public class Range implements Iterable<Integer>
{
	private int start;
	private int end;

	public Range(int start, int end)
	{
		this.start = start;
		this.end   = end;
	}

	public int getEnd()
	{
		return end;
	}

	public void setEnd(int end)
	{
		this.end = end;
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new RangeIterator(this);
	}
}