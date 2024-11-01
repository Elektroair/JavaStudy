public class BookEducation extends Book
{
	private String subject;
	private int    subsidy;

	public BookEducation()
	{
	}

	public BookEducation(String author, String title, int pages, String subject)
	{
		super(author, title, pages);
		this.subject = subject;
	}

	@Override
	public double calculatePrice(double price)
	{
		return super.pricePerPage(price) * super.getPages() - getSubsidy();
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public int getSubsidy()
	{
		return subsidy;
	}

	public void setSubsidy(int subsidy)
	{
		this.subsidy = subsidy;
	}
}
