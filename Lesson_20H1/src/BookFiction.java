public class BookFiction extends Book
{
	private String  genre;
	private boolean isBestseller;


	public BookFiction()
	{
	}

	public BookFiction(String author, String title, int pages, String genre, boolean isBestseller)
	{
		super(author, title, pages);
		this.genre = genre;
		this.isBestseller = isBestseller;
	}


	@Override
	public double calculatePrice(double price)
	{
		if (isBestseller())
		{
			return super.pricePerPage(price) * super.getPages() * 2;
		}
		return super.pricePerPage(price) * super.getPages();
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public boolean isBestseller()
	{
		return isBestseller;
	}

	public void setBestseller(boolean isBestseller)
	{
		this.isBestseller = isBestseller;
	}
}
