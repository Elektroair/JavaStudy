public class Main
{
	public static void main(String[] args)
	{
		Book book = new Book("J. R. R. Tolkien", "Vlastelin kolec", 450, 5678);
		System.out.println(book.toString());

		FictionBook fictionBook = new FictionBook("George Orwell", "1984", 320, 4124, "Dystopia");
	}
}