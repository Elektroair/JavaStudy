public class FunctionBook extends Book
{
	private String genre;

	public FunctionBook()
	{
	}

	public FunctionBook(String author, String title, int pages, int isbn, String genre)
	{
		super(author, title, pages, isbn);
		this.genre = genre;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}
}