import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable
{
	String id;
	String name;
	String city;
	int age;

	public Student ()
	{

	}

	public Student(String id, String name, String city, int age)
	{
		this.id   = id;
		this.name = name;
		this.city = city;
		this.age  = age;
	}

	@Override
	public boolean equals(Object object)
	{
		if (this == object)
		{
			return true;
		}
		if (object == null || getClass() != object.getClass())
		{
			return false;
		}
		Student student = (Student) object;
		return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name) &&
		       Objects.equals(city, student.city);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, name, city, age);
	}

	@Override
	public String toString()
	{
		return id + "\t" + name + "\t" + city + "\t\t\t" + age;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
