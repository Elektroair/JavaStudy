import java.io.*;

public class ConsoleIO
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter file name");
		String string = bufferedReader.readLine();
		System.out.println(string);

		PrintWriter printWriter = new PrintWriter(new FileWriter(string, true));
		System.out.println("Enter something");
		string = bufferedReader.readLine();

		while (!"exit".equalsIgnoreCase(string))
		{
			printWriter.println(string);
			printWriter.flush();
			string = bufferedReader.readLine();
		}
		printWriter.flush();
	}
}
