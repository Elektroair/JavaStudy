public class DigitsSum
{
	public static void main(String[] args)
	{
		System.out.println("\nResult of evenDigitsSum:   " + evenDigitsSum(34567));
		System.out.println("\nResult of findDigitsCount:   " + findDigitsCount(313330353, 3)); // Bus lines near Ayanot with digit 3 :D
		System.out.println("\nResult of xPowerY:   " + xPowerY(4, 3) + "\n");
		System.out.println("Result of hasNumberUsingInt (count of repetition):      " + hasNumberUsingInt(1234545321, 45) + "\n");
		System.out.println("Result of hasNumberUsingString (count of repetition):   " + hasNumberUsingString(1234545321, 45));
	}

	public static int evenDigitsSum(int number)
	{
		int sum = 0;
		while (number != 0)
		{
			if (number % 2 == 0)
			{
				sum += number % 10;
			}
			number /= 10;
		}
		return sum;
	}

	public static int findDigitsCount(int number, int digit)
	{
		int count = 0;
		while (number != 0)
		{
			if (number % 10 == digit)
			{
				count++;
			}
			number /= 10;
		}
		return count;
	}

	public static int xPowerY(int x, int y)
	{
		int result = 1;
		for (int power = 1; power <= y; power++)
		{
			result *= x;
		}
		return result;
	}

	public static int hasNumberUsingInt(int numberInput, int subNumberInput)
	{
		int number               = numberInput;
		int subNumber            = subNumberInput;
		int numberDigitsCount    = 0;
		int subNumberDigitsCount = 0;
		int subNumberRepetition  = 0;


		while (number != 0)
		{
			number /= 10;
			numberDigitsCount++;
		}

		while (subNumber != 0) // Checking of
		{
			subNumber /= 10;
			subNumberDigitsCount++;
		}

		if (numberDigitsCount < subNumberDigitsCount)
		{
			System.out.println("Message form hasNumberUsingInt: ERROR! The number shorter than sub number");
			return 0;
		}


		for (int iteration = 0; iteration <= (numberDigitsCount - subNumberDigitsCount); iteration++)
		{
			if (numberInput % (Math.pow(10, subNumberDigitsCount)) == subNumberInput)
			{
				subNumberRepetition++;
			}
			numberInput /= 10;
		}
		return subNumberRepetition;
	}

	public static int hasNumberUsingString(int numberInput, int subNumberInput)
	{
		String number              = Integer.toString(numberInput);
		String subNumber           = Integer.toString(subNumberInput);
		int    subNumberRepetition = 0;

		if (number.length() < subNumber.length())
		{
			System.out.println("Message form hasNumberUsingString: ERROR! The number shorter than sub number");
			return 0;
		}

		while (number.contains(subNumber))
		{
			subNumberRepetition++;
			number = number.replaceFirst(subNumber, "");
		}
		return subNumberRepetition;
	}
}
