import java.util.Comparator;

public class ComparatorPersonAge implements Comparator<Person>
{

	@Override
	public int compare(Person person_1, Person person_2)
	{
		return Double.compare(person_1.getAge(), person_2.getAge());
	}
}
