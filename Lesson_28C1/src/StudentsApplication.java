import java.io.*;

public class StudentsApplication
{
	public static void main(String[] args)
	{
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Students.csv")))
		{
			Student student = new Student("1", "John", "Nashville", 25);
			objectOutputStream.writeObject(student);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("OIS.txt")))
		{
			Student student = (Student) objectInputStream.readObject();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
}
