import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteInputStream
{
	public static void main(String[] args)
	{
		try (FileInputStream fileInputStream = new FileInputStream("./out/FOS.txt"))
		{
//			int word = fileInputStream.read();
//			while (word != -1)
//			{
//				System.out.println(word);
//				word = fileInputStream.read();
//			}
//
//			while (fileInputStream.available() != 0)
//			{
//				System.out.println(fileInputStream.read());
//			}

			byte[] array = new byte[fileInputStream.available() + 1];
			fileInputStream.read(array);
			for (int index = 0; index < array.length; index++)
			{
				System.out.println(array[index]);
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
