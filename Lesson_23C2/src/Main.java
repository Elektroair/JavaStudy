import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<>();
		list.add("Kraków");
		list.add("Warszawa");
		list.add("Poznań");
		list.add("Szczecin");
		list.add("Wrocław");
		list.add("Łódź");
		System.out.println(list);
		list.add(2, "Ostrowiec Świętokrzyski");
		System.out.println(list);
		System.out.println(list.contains("Łódź"));
		System.out.println(list.get(2));
		for(int index = 0; index < list.size(); index++)
		{
			System.out.print(list.get(index) + "; ");
		}
	}
}
