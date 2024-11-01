import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataBase
{
	public static void main(String[] args)
	{
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Base.csv")))
		{
			String   string = bufferedReader.readLine();
			String[] cells  = string.split(";;");
			printFile(cells);

			List<Student> dataBase = new ArrayList<>();
			string = bufferedReader.readLine();
			while (string != null)
			{
				String[] fields = string.split(";;");
				int birthDate = LocalDate.now().compareTo(
						LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
				dataBase.add(new Student(fields[0], fields[1], fields[2], birthDate));
				string = bufferedReader.readLine();
			}
			for (Student line : dataBase)
			{
				System.out.println(line);
			}

			int sum   = 0;
			int count = 0;
			for (Student student : dataBase)
			{
				System.out.println(student);
				sum += student.age;
				count++;
			}
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	public static void printFile(String[] cells)
	{
		for (String cell : cells)
		{
			System.out.print(cell + "\t\t");
		}
		System.out.println();
	}
}
