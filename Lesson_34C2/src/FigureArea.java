import java.util.function.Function;

public class FigureArea implements Runnable
{
	double sideX;
	double sideY;
	Function<Double, Double> function;

	public FigureArea(double sideX, double sideY, Function<Double, Double> function)
	{
		this.sideX    = sideX;
		this.sideY    = sideY;
		this.function = function;
	}

	@Override
	public void run()
	{

	}
}
