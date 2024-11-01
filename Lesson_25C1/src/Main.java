import java.net.Inet4Address;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("Kia", 4);
		linkedHashMap.put("Ford", 3);
		linkedHashMap.put("Mazda", 5);
		linkedHashMap.put("Chevrolet", 2);
		linkedHashMap.put("Honda", 2);
		linkedHashMap.put("Audi", 3);
		linkedHashMap.put("Volvo", 1);

		System.out.println(linkedHashMap);
		boolean result = linkedHashMap.containsKey("Volvo");
		System.out.println(result);
		int value = linkedHashMap.get("Volvo");
		System.out.println(value);
		Set<String> keys = linkedHashMap.keySet();
		for (String key : keys)
		{
			System.out.println(key + " => " + linkedHashMap.get(key));
		}
		linkedHashMap.remove("Honda");
		System.out.println(linkedHashMap);
		linkedHashMap.remove("Kia", 3);
		System.out.println(linkedHashMap);
		linkedHashMap.replace("Kia", 6);
		linkedHashMap.put("Ford", 2);
		System.out.println(linkedHashMap);
		linkedHashMap.replace("Audi", 4, 5);
		System.out.println(linkedHashMap);
		System.out.println(linkedHashMap.size());
		
	}
}
