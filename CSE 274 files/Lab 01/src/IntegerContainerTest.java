import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerContainerTest {

	@Test
	public void testIsEmpty() {
		IntegerContainer c = new IntegerContainer();
		
		assertTrue(c.isEmpty());
		
		c.add(10);
		assertFalse(c.isEmpty());
	}
	
	@Test
	public void testSize() {
		IntegerContainer c = new IntegerContainer();
		
		assertEquals(0, c.size());
		
	}
	

}
