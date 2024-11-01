public class Main
{
	public static void main(String[] args)
	{
		int    number_1 = 6;
		int    number_2 = 2;
		String string_1 = null;
		String string_2 = "NO WAR";

		while (true)
		{
			try
			{
				System.out.println(number_1 / number_2);
				System.out.println("Size: " + string_1.length());
				System.out.println(string_2.charAt(6));
				break;
			}
			catch (ArithmeticException exception)
			{
				System.out.println(exception.getMessage());
				number_2 = 1;
			}
			catch (NullPointerException exception)
			{
				System.out.println(exception.getMessage());
				string_1 = "";
			}
			catch (StringIndexOutOfBoundsException exception)
			{
				System.out.println(exception.getMessage());
				string_2 = "NO WAR!";
			}
			catch (Exception exception)
			{
				System.out.println(exception.getMessage());
			}
		}

		System.out.println("The End");

	}
}
