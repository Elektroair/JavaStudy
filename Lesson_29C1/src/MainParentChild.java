import java.io.*;

public class MainParentChild
{
	public static void main(String[] args)
	{
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Output.txt")))
		{
			System.out.println("Serializing...");
			Child child = new Child(1);
			System.out.println("child.getChildField() = " + child.getChildField());
			System.out.println("child.getParentField() = " + child.getParentField());
			child.setParentField(100);
			child.setChildField(10);
			objectOutputStream.writeObject(child);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Output.txt")))
		{
			System.out.println("Deserializing...");
			Child child = (Child) objectInputStream.readObject();
			System.out.println("child.getChildField() = " + child.getChildField());
			System.out.println("child.getParentField() = " + child.getParentField());
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