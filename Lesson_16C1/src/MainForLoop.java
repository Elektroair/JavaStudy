public class MainForLoop
{
	public static void main(String[] args)
	{
		int a = 5;
		int b = 3;
		while (a > 0)
		{
			System.out.println("a = " + a);
			a--;
		}
		for (a = 5; a > 0; a--)
		{
			System.out.println("a = " + a);
		}
		for (a = 5, b = 1; a > 0; a--, b++)
		{
			System.out.println("a = " + a + "\nb = " + b);
		}
	}
}
