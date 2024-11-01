import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Wrong number of arguments");
			return;
		}

		System.out.println("Source: " + args[0]);
		System.out.println("Target: " + args[1]);

		try (FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
		     FileInputStream fileInputStream = new FileInputStream(args[0]))
		{
			byte[] array = new byte[fileInputStream.available()];
			fileInputStream.read(array);
			fileOutputStream.write(array);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
