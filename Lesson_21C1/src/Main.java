public class Main
{
	static String string = "Cześć";
	public static void main(String[] args)
	{

		char sum = string.charAt(4);
		System.out.println(sum);
		System.out.println(string.length());
		printStrReverse();
	}

	public static void printStrReverse ()
	{
		for (int N = string.length() - 1; N >= 0; N--)
		{
			System.out.print(string.charAt(N));
		}
	}

	public static boolean isPalindrome (String string)
	{
		for (int toRight = 0, toLeft = string.length() - 1; toRight < toLeft; toRight++, toLeft++)
		{
			if (string.charAt(toRight) != string.charAt(toLeft))
			{
				return false;
			}
		}
		return true;
	}
}
