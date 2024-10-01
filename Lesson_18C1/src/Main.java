public class Main
{
	public static void main(String[] args)
	{
		Person person_1 = new Person();
		person_1.setName("Alex Kon");
		person_1.setId(1234);
		person_1.setAge(34.5);

		System.out.println(person_1.getName());
		System.out.println(person_1.getId());
		System.out.println(person_1.getAge());
	}
}
