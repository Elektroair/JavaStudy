import java.util.*;

public class MainListSort
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("Kraków");
		list.add("Warszawa");
		list.add("Poznań");
		list.add("Szczecin");
		list.add("Wrocław");
		list.add("Łódź");
		list.sort(new ComparatorString());
		System.out.println(list);
	}
}
