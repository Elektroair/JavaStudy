public class Main
{
	public static void main(String[] args)
	{
		int[] result;
		int[] arrayAfterSorting;
		result            = Sorting.minNumbersToEnd(new int[]{1, 6, 3, 4, 2, 5});
		for (int index : result)
		{
			System.out.print(index + " ");
		}
		System.out.println();

		result = Sorting.evenNumbersToEnd(new int[]{1, 6, 3, 4, 2, 5});
		for (int index : result)
		{
			System.out.print(index + " ");
		}
		System.out.println();

		result = Sorting.sortingToOddAndEven(new int[]{1, 6, 3, 4, 2, 5});
		for (int index : result)
		{
			System.out.print(index + " ");
		}
		System.out.println();

		Book book = new Book("J. R. R. Tolkien", "Vlastelin kolec", 450, 5678);

		System.out.println(book.getAuthor());
		System.out.println(book.getTitle());
		System.out.println(book.getPages());
		System.out.println(book.getIsbn());

		book.setAuthor("George Orwell");
		book.setTitle("1984");
		book.setPages(320);
		book.setIsbn(1234);

		System.out.println(book.getAuthor());
		System.out.println(book.getTitle());
		System.out.println(book.getPages());
		System.out.println(book.getIsbn());
	}
}