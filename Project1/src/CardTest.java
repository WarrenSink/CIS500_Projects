import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void test_constructor_1() {
		Card c = new Card("5","C");
		assertEquals("5", c.getRank());
		assertEquals("C", c.getSuit());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_2() {
		new Card("0","S");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_3() {
		new Card("A","P");
	}
	
	@Test
	public void test_equals_1() {
		Card c1 = new Card("5","C");
		assertTrue(c1.equals(c1));
	}
	
	@Test
	public void test_equals_2() {
		Card c1 = new Card("5","C");
		Card c2 = new Card("5","C");
		assertTrue(c1.equals(c2));
	}
	
	@Test
	public void test_equals_3() {
		Card c1 = new Card("5","C");
		Card c2 = new Card("A","H");
		assertFalse(c1.equals(c2));
	}
	
	@Test
	public void test_equals_4() {
		Card c1 = new Card("5","C");
		assertFalse(c1.equals(null));
	}
	
	@Test
	public void test_equals_5() {
		Card c1 = new Card("5","C");
		Object str = new String("John");
		assertFalse(c1.equals(str));
	}
	
	@Test
	public void test_toString_1() {
		Card c = new Card("5","C");
		assertEquals("5C", c.toString());
	}
	
	@Test
	public void test_toString_2() {
		Card c = new Card("10","D");
		assertEquals("10D", c.toString());
	}
	
	@Test
	public void test_toString_3() {
		Card c = new Card("A","S");
		assertEquals("AS", c.toString());
	}
}
