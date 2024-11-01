import java.io.Serializable;

public class Parent implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int parentField;

	public Parent ()
	{
		super();
		System.out.println("Parent constructor");
		this.parentField = 10;
	}

	public int getParentField ()
	{
		return parentField;
	}

	public void setParentField (int parentField)
	{
		this.parentField = parentField;
	}
}
