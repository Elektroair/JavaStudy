public class MainRange
{
	public static void main(String[] args)
	{
		Range range = new Range(5, 15);
		RangeIterator iterator = new RangeIterator(range);

//		while (iterator.hasNext())
//		{
//			System.out.print(iterator.next() + " ");
//		}

		for (int N : range)
		{
			System.out.print(N + " ");
		}
	}
}
