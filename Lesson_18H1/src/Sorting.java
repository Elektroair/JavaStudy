public class Sorting
{
	public static int[] minNumbersToEnd(int[] array)
	{
		boolean finalCheck = false;
		while (!finalCheck)
		{
			finalCheck = true;
			for (int index = 0; index < array.length - 1; index++)
			{
				if (array[index] < array[index + 1])
				{
					finalCheck = false;
					int replacing = array[index + 1];
					array[index + 1] = array[index];
					array[index]     = replacing;
				}
			}
		}
		return array;
	}

	public static int[] evenNumbersToEnd(int[] array)
	{
		boolean finalCheck = false;
		while (!finalCheck)
		{
			finalCheck = true;
			for (int index = 0; index < array.length - 1; index++)
			{
				int left = array [index];
				int right = array [index + 1];
				if (left % 2 == 0 && right % 2 == 1)
				{
					finalCheck = false;
					int replacing = array[index + 1];
					array[index + 1] = array[index];
					array[index]     = replacing;
				}
			}
		}
		return array;
	}

	public static int[] sortingToOddAndEven(int[] array)
	{
		boolean finalCheck = false;
		while (!finalCheck)
		{
			finalCheck = true;
			for (int index = 0; index < array.length - 1; index++)
			{
				if (array[index] > array[index + 1])
				{
					finalCheck = false;
					int replacing = array[index + 1];
					array[index + 1] = array[index];
					array[index]     = replacing;
				}
			}
		}

		finalCheck = false;
		while (!finalCheck)
		{
			finalCheck = true;
			for (int index = 0; index < array.length - 1; index++)
			{
				int left = array [index];
				int right = array [index + 1];
				if (left % 2 == 0 && right % 2 == 1)
				{
					finalCheck = false;
					int replacing = array[index + 1];
					array[index + 1] = array[index];
					array[index]     = replacing;
				}
			}
		}
		return array;
	}
}
