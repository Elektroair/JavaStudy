import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputStream
{
	public static void main(String[] args)
	{
		try
		{
			String string;
			string = "Elektroair";
			FileOutputStream fileOutputStream = new FileOutputStream("./out/FOS.txt");
			for (int index = 0; index < string.length(); index++)
			{
				fileOutputStream.write(string.charAt(index));
			}
		}
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
			throw new RuntimeException(exception);
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
			throw new RuntimeException(exception);
		}
	}
}
