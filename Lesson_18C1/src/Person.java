public class Person
{
	private String name;
	private int    id;
	private double age;

	public void setName(String nameInput)
	{
		if (nameInput != null)
		{
			name = nameInput;
		}
	}

	public void setId(int idInput)
	{
		if (idInput > 0)
		{
			id = idInput;
		}
	}

	public void setAge(double ageInput)
	{
		if (ageInput > 0)
		{
			age = ageInput;
		}
	}

	public String getName()
	{
		return name;
	}

	public int getId()
	{
		return id;
	}

	public double getAge()
	{
		return age;
	}
}
