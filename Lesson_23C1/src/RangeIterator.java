import java.util.Iterator;

public class RangeIterator implements Iterator <Integer>
{
	private Range range;
	private int position;

	public RangeIterator(Range range)
	{
		this.range = range;
		this.position = range.getStart();
	}

	@Override
	public boolean hasNext()
	{
		if (position <= range.getEnd())
		{
			return true;
		}
		return false;
	}

	@Override
	public Integer next()
	{
		int current = position;
		position++;
		return current;
	}
}