public class JavaForMethods
{
	public static void main(String[] args)
	{
		printStars(16, 4);
	}

	public static void printStars(int stars, int countInRow)
	{
		for (int count = 0; stars > 0; stars--)
		{
			System.out.print("*");
			count++;
			if (count == countInRow)
			{
				System.out.println();
				count = 0;
			}
		}
	}
}