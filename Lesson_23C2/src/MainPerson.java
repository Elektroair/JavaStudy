import java.security.cert.X509CRL;
import java.util.ArrayList;

public class MainPerson
{
	public static void main(String[] args)
	{
		ArrayList<Person> list = new ArrayList<>();

		Person person_1 = new Person("Alice", 101, 25.5);
		Person person_2 = new Person("Bob", 102, 50.2);
		Person person_3 = new Person("Charlie", 103, 22.9);
		Person person_4 = new Person("Diana", 104, 17.5);
		Person person_5 = new Person("Eve", 105, 35.1);

		list.add(person_1);
		list.add(person_2);
		list.add(person_3);
		list.add(person_4);
		list.add(person_5);

		printPersonList(list);

		ComparatorPersonAge comparatorPersonAge = new ComparatorPersonAge();
		list.sort(comparatorPersonAge);

		printPersonList(list);
	}

	private static void printPersonList(ArrayList<Person> list)
	{
		for (Person person : list)
		{
			System.out.println(person);
		}
		System.out.println();
	}
}
