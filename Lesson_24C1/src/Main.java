import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		String string_1 = "Nashville";
		String string_2 = "New York";
		String string_3 = "Las Vegas";
		String string_4 = "Seattle";

		System.out.println(string_1.hashCode());
		System.out.println(string_2.hashCode());
		System.out.println(string_3.hashCode());
		System.out.println(string_4.hashCode());

		{
			HashSet<String> hashSet = new HashSet<>();
			hashSet.add(string_1);
			hashSet.add(string_2);
			hashSet.add(string_3);
			hashSet.add(string_4);
			System.out.println(hashSet);
		}

		{
			LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
			linkedHashSet.add(string_1);
			linkedHashSet.add(string_2);
			linkedHashSet.add(string_3);
			linkedHashSet.add(string_4);
			System.out.println(linkedHashSet);
		}

		{
			TreeSet<String> treeSet = new TreeSet<>();
			treeSet.add(string_1);
			treeSet.add(string_2);
			treeSet.add(string_3);
			treeSet.add(string_4);
			System.out.println(treeSet);

			boolean result = treeSet.contains("Nashville");
			System.out.println(result);
			Set<String> treeSetDescending = treeSet.descendingSet();
			System.out.println(treeSetDescending);
			treeSet.remove("New York");
			System.out.println(treeSet);

			printCharReserveOrder ("ABCD");
		}

	}

	public static void printCharReserveOrder(String string)
	{
		TreeSet<Character> treeSet = new TreeSet<>();
		for (int index = 0; index < string.length(); index++)
		{
			char symbol = string.charAt(index);
			treeSet.add(symbol);
		}
		for (char symbol : treeSet.descendingSet())
		{
			System.out.print(symbol);
		}
		System.out.println();
	}
}
