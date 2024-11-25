package person.company.model;

import java.time.LocalTime;
import java.util.Objects;

public class Person
{
	private final int id;
	private String nameFirst;
	private String nameLast;
	private LocalTime birthDate;

	public Person(int id, String nameFirst, String nameLast, LocalTime birthDate)
	{
		this.id        = id;
		this.nameFirst = nameFirst;
		this.nameLast  = nameLast;
		this.birthDate = birthDate;
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
		Person person = (Person) object;
		return id == person.id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(id);
	}

	@Override
	public String toString()
	{
		return "Person{" + "id=" + id + ", nameFirst='" + nameFirst + '\'' + ", nameLast='" + nameLast + '\'' +
		       ", birthDate=" + birthDate + '}';
	}

	public int getId()
	{
		return id;
	}

	public String getNameFirst()
	{
		return nameFirst;
	}

	public void setNameFirst(String nameFirst)
	{
		this.nameFirst = nameFirst;
	}

	public String getNameLast()
	{
		return nameLast;
	}

	public void setNameLast(String nameLast)
	{
		this.nameLast = nameLast;
	}

	public LocalTime getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalTime birthDate)
	{
		this.birthDate = birthDate;
	}
}
