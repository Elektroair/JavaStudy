import java.util.Scanner;

public class MainThrowException
{
	public static void main(String[] args)
	{
		double number_1;
		char action;
		double number_2;

		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			try
			{
				System.out.print("Enter number 1 => ");
				number_1 = scanner.nextDouble();
				break;
			}
			catch (Exception exception)
			{
				System.out.println("ERROR: Wrong input");
			}
		}
		while (true)
		{
			try
			{
				System.out.print("Enter number 1 => ");
				action = scanner.next().charAt(0);
				break;
			}
			catch (Exception exception)
			{
				System.out.println("ERROR: Wrong input");
			}
		}
		while (true)
		{
			try
			{
				System.out.print("Enter number 1 => ");
				number_2 = scanner.nextDouble();
				break;
			}
			catch (Exception exception)
			{
				System.out.println("ERROR: Wrong input");
			}
		}

		try
		{
			System.out.println(calculator(5, '/', 5));
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}

		try
		{
			System.out.println(function_1(4, 0));
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	public static double calculator(double number_1, char action, double number_2) throws Exception
	{
		double result = 0;
		if (action != '/' || number_2 != 0)
		{
			switch (action)
			{
				case '+':
					result = number_1 + number_2;
					break;
				case '-':
					result = number_1 - number_2;
					break;
				case '*':
					result = number_1 * number_2;
					break;
				case '/':
					result = number_1 / number_2;
					break;
				default:
					throw new Exception("ERROR: Unknown operator");
			}
		}
		else
		{
			System.out.println("ERROR: Division by 0");
		}
		return result;
	}

	public static double function_1 (double number_1, double number_2) throws Exception
	{
		return function_2 (number_1, number_2);
	}

	private static double function_2(double number_1, double number_2) throws Exception
	{
		return function_3 (number_1, number_2);
	}

	private static double function_3(double number_1, double number_2) throws Exception
	{
		return function_division (number_1, number_2);
	}

	private static double function_division(double number_1, double number_2) throws Exception
	{
		if (number_2 != 0)
		{
			return number_1 / number_2;
		}
		else
		{
			throw new Exception("ERROR: Division by 0");
		}
	}
}
