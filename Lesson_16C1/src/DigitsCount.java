public class DigitsCount
{
	public static int oddDigitsCount(int number)
	{
		int count = 0;
		while (number != 0)
		{
			if (number % 2 == 1)
			{
				count++;
			}
			number /= 10;
		}
		return count;
	}
}
