public class Child extends Parent
{

	private static final long serialVersionUID = 1L;
	private int childField;
	public Child (int childField)
	{
		super();
		System.out.println("Child construction");
		this.childField = childField;
	}

	public int getChildField()
	{
		return childField;
	}

	public void setChildField (int childField)
	{
		this.childField = childField;
	}
}
