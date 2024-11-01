import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest
{

	@Test
	void parseAndSum()
	{
		//fail("Not yet implemented");
		double result = Methods.parseAndSum("25", "25");
		assertTrue(result == 50);
		result = Methods.parseAndSum("75", "-25");
		assertTrue(result == 50);
		result = Methods.parseAndSum("-100", "-50");
		assertTrue(result == -150);
		result = Methods.parseAndSum("8.4", "-4.2");
		assertTrue(result == 4.2);

		result = Methods.parseAndSum(null, null);
		assertTrue(result == 0);
		result = Methods.parseAndSum("", "");
		assertTrue(result == 0);
		result = Methods.parseAndSum(" ", " ");
		assertTrue(result == 0);
		result = Methods.parseAndSum("12", "NO WAR");
		assertTrue(result == 0);
	}

	@Test
	void findChar()
	{
		//fail("Not yet implemented");
	}
}