public class JavaLoops
{
	// stars = 5 => *****
	public static void printStars(int stars)
	{
		while (stars > 0)
		{

			System.out.print("*");
			stars--;
		}
	}

	public static int factorial(int number)
	{
		int result = 1;
		while (number > 0)
		{
			result *= number;
			number--;
		}
		System.out.println();
		return result;
	}

	public static int xPowerY(int x, int y)
	{
		int result = 1;
		while (y > 0)
		{
			result *= x;
			y--;
		}
		return result;
	}

	public static int digitsCount(int number)
	{
		int count = 0;
		do
		{
			number /= 10;
			count++;
		} while (number != 0);
		return count;
	}
}
