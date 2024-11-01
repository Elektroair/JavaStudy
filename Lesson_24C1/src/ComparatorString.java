import java.util.Comparator;

public class ComparatorString implements Comparator<String>
{

	@Override
	public int compare(String string_1, String string_2)
	{
		return Integer.compare(string_1.length(), string_2.length());
	}
}
