public class Main
{
	public static void main(String[] args)
	{
		System.out.println(isPalindrome("Saippuakivikauppias")); // Finnish word
		System.out.println(parseIntForSum(args));
	}

	public static boolean isPalindrome(String string)
	{
		StringBuilder stringBuilder = new StringBuilder(string.toLowerCase());
		for (int toRight = 0, toLeft = stringBuilder.length() - 1; toRight < toLeft; toRight++, toLeft--)
		{
			if (stringBuilder.charAt(toRight) != stringBuilder.charAt(toLeft))
			{
				return false;
			}
		}
		return true;
	}

	public static int parseIntForSum (String[] args)
	{
		int sum = 0;
		for (String number : args)
		{
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}