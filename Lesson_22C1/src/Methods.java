public class Methods
{
	public static double parseAndSum(String string_1, String string_2)
	{
		if (string_1 == null || string_2 == null)
		{
			System.out.println("Error");
		}
		double number_1;
		double number_2;
		try
		{
			number_1 = Double.parseDouble(string_1);
			number_2 = Double.parseDouble(string_2);
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
			return 0;
		}
		return number_1 + number_2;
	}

	public static int findChar(String string_3, char symbol)
	{
		return 0;
	}
}
