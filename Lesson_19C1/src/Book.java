public class Book
{
	private String author;
	private String title;
	private int    pages;
	private int    isbn;

	public Book ()
	{

	}

	public Book (String author, String title, int pages, int isbn)
	{
		this.author = author;
		this.title = title;
		this.pages = pages;
		this.isbn = isbn;
	}

	@Override
	public String toString()
	{
		return "Author: " + author + "\nTitle: " + title + "\nPages: " + pages + "\nISBN: " + isbn;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		if (author != null)
		{
			this.author = author;
		}
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		if (title != null)
		{
			this.title = title;
		}
	}

	public int getPages()
	{
		return pages;
	}

	public void setPages(int pages)
	{
		if (pages > 0)
		{
			this.pages = pages;
		}
	}

	public int getIsbn()
	{
		return isbn;
	}

	public void setIsbn(int isbn)
	{
		if (isbn > 0)
		{
			this.isbn = isbn;
		}
	}
}