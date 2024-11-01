public class BookReligion extends Book
{
	String religion;
	double donation;
	@Override
	public double calculatePrice(double price)
	{
		return donation;
	}
}
