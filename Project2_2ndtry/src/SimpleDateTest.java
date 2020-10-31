import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleDateTest {

	// unit tests for constructor methods
	
	@Test
	public void test_constructor_1() {
		SimpleDate d = new SimpleDate();
		assertEquals(1, d.getMonth());
		assertEquals(1, d.getDay());
		assertEquals(1753, d.getYear());
	}
	
	@Test
	public void test_constructor_2() {
		SimpleDate d = new SimpleDate(1,1,2010);
		assertEquals(1, d.getMonth());
		assertEquals(1, d.getDay());
		assertEquals(2010, d.getYear());
	}
	
	@Test
	public void test_constructor_3() {
		SimpleDate d = new SimpleDate(1,31,2010);
		assertEquals(1, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2010, d.getYear());
	}
	
	@Test
	public void test_constructor_4() {
		SimpleDate d = new SimpleDate(2,28,1900);
		assertEquals(2, d.getMonth());
		assertEquals(28, d.getDay());
		assertEquals(1900, d.getYear());
	}

	@Test
	public void test_constructor_5() {
		SimpleDate d = new SimpleDate(2,28,2009);
		assertEquals(2, d.getMonth());
		assertEquals(28, d.getDay());
		assertEquals(2009, d.getYear());
	}
	
	@Test
	public void test_constructor_6() {
		SimpleDate d = new SimpleDate(2,28,2012);
		assertEquals(2, d.getMonth());
		assertEquals(28, d.getDay());
		assertEquals(2012, d.getYear());
	}
	
	@Test
	public void test_constructor_7() {
		SimpleDate d = new SimpleDate(2,29,2012);
		assertEquals(2, d.getMonth());
		assertEquals(29, d.getDay());
		assertEquals(2012, d.getYear());
	}
	
	@Test
	public void test_constructor_8() {
		SimpleDate d = new SimpleDate(3,31,2000);
		assertEquals(3, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2000, d.getYear());
	}
	
	@Test
	public void test_constructor_9() {
		SimpleDate d = new SimpleDate(4,30,2000);
		assertEquals(4, d.getMonth());
		assertEquals(30, d.getDay());
		assertEquals(2000, d.getYear());
	}
	
	@Test
	public void test_constructor_10() {
		SimpleDate d = new SimpleDate(5,31,2010);
		assertEquals(5, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2010, d.getYear());
	}
	
	@Test
	public void test_constructor_11() {
		SimpleDate d = new SimpleDate(6,30,2006);
		assertEquals(6, d.getMonth());
		assertEquals(30, d.getDay());
		assertEquals(2006, d.getYear());
	}
	
	@Test
	public void test_constructor_12() {
		SimpleDate d = new SimpleDate(7,31,2007);
		assertEquals(7, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2007, d.getYear());
	}
	
	@Test
	public void test_constructor_13() {
		SimpleDate d = new SimpleDate(8,31,2008);
		assertEquals(8, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2008, d.getYear());
	}
	
	@Test
	public void test_constructor_14() {
		SimpleDate d = new SimpleDate(9,30,2002);
		assertEquals(9, d.getMonth());
		assertEquals(30, d.getDay());
		assertEquals(2002, d.getYear());
	}
	
	@Test
	public void test_constructor_15() {
		SimpleDate d = new SimpleDate(10,31,1997);
		assertEquals(10, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(1997, d.getYear());
	}
	
	@Test
	public void test_constructor_16() {
		SimpleDate d = new SimpleDate(11,30,1992);
		assertEquals(11, d.getMonth());
		assertEquals(30, d.getDay());
		assertEquals(1992, d.getYear());
	}
	
	@Test
	public void test_constructor_17() {
		SimpleDate d = new SimpleDate(12,31,2034);
		assertEquals(12, d.getMonth());
		assertEquals(31, d.getDay());
		assertEquals(2034, d.getYear());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_18() {
		new SimpleDate(-1,1,2010);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_19() {
		new SimpleDate(0,1,2010);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_20() {
		new SimpleDate(1,0,2010);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_21() {
		new SimpleDate(1,-3,2010);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_22() {
		new SimpleDate(1,1,1751);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_23() {
		new SimpleDate(1,7,-2023);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_24() {
		new SimpleDate(1,32,2010);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_25() {
		new SimpleDate(2,29,2009);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_26() {
		new SimpleDate(2,29,1900);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_27() {
		new SimpleDate(2,30,2009);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_28() {
		new SimpleDate(2,30,2012);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_29() {
		new SimpleDate(3,32,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_30() {
		new SimpleDate(4,31,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_31() {
		new SimpleDate(5,32,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_32() {
		new SimpleDate(6,31,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_33() {
		new SimpleDate(7,32,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_34() {
		new SimpleDate(8,32,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_35() {
		new SimpleDate(9,31,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_36() {
		new SimpleDate(10,32,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_37() {
		new SimpleDate(11,31,2000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_38() {
		new SimpleDate(12,32,2000);
	}
	
	// unit tests for compareTo()
	
	@Test
	public void test_compareTo_1() {
		SimpleDate d = new SimpleDate(11,30,1992);
		assertTrue(d.compareTo(d) == 0);
		assertEquals("November 30, 1992",d.toString());
	}
	
	@Test
	public void test_compareTo_2() {
		SimpleDate d1 = new SimpleDate(2,29,2012);
		SimpleDate d2 = new SimpleDate(2,29,2012);
		assertTrue(d1.compareTo(d2) == 0);
		assertEquals("February 29, 2012",d1.toString());
		assertEquals("February 29, 2012",d2.toString());
	}
	
	@Test
	public void test_compareTo_3() {
		SimpleDate d1 = new SimpleDate(3,10,2011);
		SimpleDate d2 = new SimpleDate(6,10,2011);
		assertTrue(d1.compareTo(d2) < 0);
		assertEquals("March 10, 2011",d1.toString());
		assertEquals("June 10, 2011",d2.toString());
	}
	
	@Test
	public void test_compareTo_4() {
		SimpleDate d1 = new SimpleDate(3,10,2011);
		SimpleDate d2 = new SimpleDate(6,10,2012);
		assertTrue(d1.compareTo(d2) < 0);
		assertEquals("March 10, 2011",d1.toString());
		assertEquals("June 10, 2012",d2.toString());
	}
	
	@Test
	public void test_compareTo_5() {
		SimpleDate d1 = new SimpleDate(3,10,2011);
		SimpleDate d2 = new SimpleDate(6,10,2011);
		assertTrue(d2.compareTo(d1) > 0);
		assertEquals("March 10, 2011",d1.toString());
		assertEquals("June 10, 2011",d2.toString());
	}
	
	@Test
	public void test_compareTo_6() {
		SimpleDate d1 = new SimpleDate(3,10,2011);
		SimpleDate d2 = new SimpleDate(6,10,2012);
		assertTrue(d2.compareTo(d1) > 0);
		assertEquals("March 10, 2011",d1.toString());
		assertEquals("June 10, 2012",d2.toString());
	}
	
	// units tests for equals()
	
	@Test
	public void test_equals_1() {
		SimpleDate d = new SimpleDate(1,1,2013);
		assertTrue(d.equals(d));
		assertEquals("January 1, 2013",d.toString());
	}
	
	@Test
	public void test_equals_2() {
		SimpleDate d = new SimpleDate(1,1,2013);
		Object obj = "John Doe";
		assertFalse(d.equals(obj));
		assertEquals("January 1, 2013",d.toString());
	}

	@Test
	public void test_equals_3() {
		SimpleDate d1 = new SimpleDate(1,1,2013);
		SimpleDate d2 = new SimpleDate(1,1,2013);
		assertTrue(d1.equals(d2));
		assertEquals("January 1, 2013",d1.toString());
		assertEquals("January 1, 2013",d2.toString());
	}
	
	@Test
	public void test_equals_4() {
		SimpleDate d1 = new SimpleDate(1,1,2013);
		SimpleDate d2 = new SimpleDate(1,1,2012);
		assertFalse(d1.equals(d2));
		assertEquals("January 1, 2013",d1.toString());
		assertEquals("January 1, 2012",d2.toString());
	}
	
	@Test
	public void test_equals_5() {
		SimpleDate d1 = new SimpleDate(1,1,2013);
		SimpleDate d2 = new SimpleDate(2,2,2012);
		assertFalse(d1.equals(d2));
		assertEquals("January 1, 2013",d1.toString());
		assertEquals("February 2, 2012",d2.toString());
	}
	
	// unit tests for isValidDate() static method
	
	@Test
	public void test_isValidDate_1() {
		assertTrue(SimpleDate.isValidDate(1,1,2010));
	}
	
	@Test
	public void test_isValidDate_2() {
		assertTrue(SimpleDate.isValidDate(1,31,2010));
	}
	
	@Test
	public void test_isValidDate_3() {
		assertTrue(SimpleDate.isValidDate(2,28,1900));
	}
	
	@Test
	public void test_isValidDate_4() {
		assertTrue(SimpleDate.isValidDate(2,28,2009));
	}
	
	@Test
	public void test_isValidDate_5() {
		assertTrue(SimpleDate.isValidDate(2,28,2012));
	}
	
	@Test
	public void test_isValidDate_6() {
		assertTrue(SimpleDate.isValidDate(2,29,2012));
	}
	
	@Test
	public void test_isValidDate_7() {
		assertTrue(SimpleDate.isValidDate(3,31,2000));
	}
	
	@Test
	public void test_isValidDate_8() {
		assertTrue(SimpleDate.isValidDate(4,30,2000));
	}
	
	@Test
	public void test_isValidDate_9() {
		assertTrue(SimpleDate.isValidDate(5,31,2010));
	}
	
	@Test
	public void test_isValidDate_10() {
		assertTrue(SimpleDate.isValidDate(6,30,2006));
	}
	
	@Test
	public void test_isValidDate_11() {
		assertTrue(SimpleDate.isValidDate(7,31,2007));
	}
	
	@Test
	public void test_isValidDate_12() {
		assertTrue(SimpleDate.isValidDate(8,31,2008));
	}
	
	@Test
	public void test_isValidDate_13() {
		assertTrue(SimpleDate.isValidDate(9,30,2002));
	}
	
	@Test
	public void test_isValidDate_14() {
		assertTrue(SimpleDate.isValidDate(10,31,1997));
	}
	
	@Test
	public void test_isValidDate_15() {
		assertTrue(SimpleDate.isValidDate(11,30,1992));
	}
	
	@Test
	public void test_isValidDate_16() {
		assertTrue(SimpleDate.isValidDate(12,31,2034));
	}
	
	@Test
	public void test_isValidDate_17() {
		assertFalse(SimpleDate.isValidDate(-1,1,2010));
	}
	
	@Test
	public void test_isValidDate_18() {
		assertFalse(SimpleDate.isValidDate(0,1,2010));
	}
	
	@Test
	public void test_isValidDate_19() {
		assertFalse(SimpleDate.isValidDate(1,0,2010));
	}
	
	@Test
	public void test_isValidDate_20() {
		assertFalse(SimpleDate.isValidDate(1,-3,2010));
	}
	
	@Test
	public void test_isValidDate_21() {
		assertFalse(SimpleDate.isValidDate(1,1,1751));
	}
	
	@Test
	public void test_isValidDate_22() {
		assertFalse(SimpleDate.isValidDate(1,7,-2023));
	}
	
	@Test
	public void test_isValidDate_23() {
		assertFalse(SimpleDate.isValidDate(1,32,2010));
	}
	
	@Test
	public void test_isValidDate_24() {
		assertFalse(SimpleDate.isValidDate(2,29,2009));
	}
	
	@Test
	public void test_isValidDate_25() {
		assertFalse(SimpleDate.isValidDate(2,29,1900));
	}
	
	@Test
	public void test_isValidDate_26() {
		assertFalse(SimpleDate.isValidDate(2,30,2009));
	}
	
	@Test
	public void test_isValidDate_27() {
		assertFalse(SimpleDate.isValidDate(2,30,2012));
	}
	
	@Test
	public void test_isValidDate_28() {
		assertFalse(SimpleDate.isValidDate(3,32,2000));
	}
	
	@Test
	public void test_isValidDate_29() {
		assertFalse(SimpleDate.isValidDate(4,31,2000));
	}
	
	@Test
	public void test_isValidDate_30() {
		assertFalse(SimpleDate.isValidDate(5,32,2000));
	}
	
	@Test
	public void test_isValidDate_31() {
		assertFalse(SimpleDate.isValidDate(6,31,2000));
	}
	
	@Test
	public void test_isValidDate_32() {
		assertFalse(SimpleDate.isValidDate(7,32,2000));
	}
	
	@Test
	public void test_isValidDate_33() {
		assertFalse(SimpleDate.isValidDate(8,32,2000));
	}
	
	@Test
	public void test_isValidDate_34() {
		assertFalse(SimpleDate.isValidDate(9,31,2000));
	}
	
	@Test
	public void test_isValidDate_35() {
		assertFalse(SimpleDate.isValidDate(10,32,2000));
	}
	
	@Test
	public void test_isValidDate_36() {
		assertFalse(SimpleDate.isValidDate(11,31,2000));
	}
	
	@Test
	public void test_isValidDate_37() {
		assertFalse(SimpleDate.isValidDate(12,32,2000));
	}
	
	// unit tests for dayOfWeek()
	
	@Test
	public void test_dayOfWeek_1() {
		SimpleDate d = new SimpleDate(2,29,1908);
		assertEquals(SimpleDate.DAY.SATURDAY, d.dayOfWeek());
		assertEquals("February 29, 1908",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_2() {
		SimpleDate d = new SimpleDate(1,1,1753);
		assertEquals(SimpleDate.DAY.MONDAY, d.dayOfWeek());
		assertEquals("January 1, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_3() {
		SimpleDate d = new SimpleDate(1,2,1753);
		assertEquals(SimpleDate.DAY.TUESDAY, d.dayOfWeek());
		assertEquals("January 2, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_4() {
		SimpleDate d = new SimpleDate(1,3,1753);
		assertEquals(SimpleDate.DAY.WEDNESDAY, d.dayOfWeek());
		assertEquals("January 3, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_5() {
		SimpleDate d = new SimpleDate(1,4,1753);
		assertEquals(SimpleDate.DAY.THURSDAY, d.dayOfWeek());
		assertEquals("January 4, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_6() {
		SimpleDate d = new SimpleDate(1,5,1753);
		assertEquals(SimpleDate.DAY.FRIDAY, d.dayOfWeek());
		assertEquals("January 5, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_7() {
		SimpleDate d = new SimpleDate(1,6,1753);
		assertEquals(SimpleDate.DAY.SATURDAY, d.dayOfWeek());
		assertEquals("January 6, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_8() {
		SimpleDate d = new SimpleDate(1,7,1753);
		assertEquals(SimpleDate.DAY.SUNDAY, d.dayOfWeek());
		assertEquals("January 7, 1753",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_9() {
		SimpleDate d = new SimpleDate(1,6,2012);
		assertEquals(SimpleDate.DAY.FRIDAY, d.dayOfWeek());
		assertEquals("January 6, 2012",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_10() {
		SimpleDate d = new SimpleDate(2,1,2012);
		assertEquals(SimpleDate.DAY.WEDNESDAY, d.dayOfWeek());
		assertEquals("February 1, 2012",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_11() {
		SimpleDate d = new SimpleDate(2,29,2012);
		assertEquals(SimpleDate.DAY.WEDNESDAY, d.dayOfWeek());
		assertEquals("February 29, 2012",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_12() {
		SimpleDate d = new SimpleDate(12,31,2012);
		assertEquals(SimpleDate.DAY.MONDAY, d.dayOfWeek());
		assertEquals("December 31, 2012",d.toString());
	}
	
	@Test
	public void test_dayOfWeek_13() {
		SimpleDate d = new SimpleDate(1,1,2013);
		assertEquals(SimpleDate.DAY.TUESDAY, d.dayOfWeek());
		assertEquals("January 1, 2013",d.toString());
	}
	
	// unit tests for daysInYear() static method
	
	@Test
	public void test_daysInYear_1() {
		assertEquals(366, SimpleDate.daysInYear(1756));
	}
	
	@Test
	public void test_daysInYear_2() {
		assertEquals(366, SimpleDate.daysInYear(1896));
	}
	
	@Test
	public void test_daysInYear_3() {
		assertEquals(366, SimpleDate.daysInYear(1904));
	}
	
	@Test
	public void test_daysInYear_4() {
		assertEquals(366, SimpleDate.daysInYear(1908));
	}
	
	@Test
	public void test_daysInYear_5() {
		assertEquals(365, SimpleDate.daysInYear(1897));
	}
	
	@Test
	public void test_daysInYear_6() {
		assertEquals(365, SimpleDate.daysInYear(1898));
	}
	
	@Test
	public void test_daysInYear_7() {
		assertEquals(365, SimpleDate.daysInYear(1899));
	}
	
	@Test
	public void test_daysInYear_8() {
		assertEquals(365, SimpleDate.daysInYear(1900));
	}
	
	// unit tests for daysInMonth() static method
	
	@Test
	public void test_daysInMonth_1() {
		assertEquals(31, SimpleDate.daysInMonth(1,2012));
	}
	
	@Test
	public void test_daysInMonth_2() {
		assertEquals(29, SimpleDate.daysInMonth(2,2012));
	}
	
	@Test
	public void test_daysInMonth_3() {
		assertEquals(28, SimpleDate.daysInMonth(2,2011));
	}
	
	@Test
	public void test_daysInMonth_4() {
		assertEquals(31, SimpleDate.daysInMonth(12,2012));
	}
	
	@Test
	public void test_daysInMonth_5() {
		assertEquals(31, SimpleDate.daysInMonth(5,2012));
	}
	
	@Test
	public void test_daysInMonth_6() {
		assertEquals(30, SimpleDate.daysInMonth(9,2012));
	}
	
	// unit tests for isLeapYear() static method
	
	@Test
	public void test_isLeapYear_1() {
		assertTrue(SimpleDate.isLeapYear(1756));
	}
	
	@Test
	public void test_isLeapYear_2() {
		assertTrue(SimpleDate.isLeapYear(1896));
	}
	
	@Test
	public void test_isLeapYear_3() {
		assertTrue(SimpleDate.isLeapYear(1904));
	}
	
	@Test
	public void test_isLeapYear_4() {
		assertTrue(SimpleDate.isLeapYear(1908));
	}
	
	@Test
	public void test_isLeapYear_5() {
		assertTrue(SimpleDate.isLeapYear(1996));
	}
	
	@Test
	public void test_isLeapYear_6() {
		assertTrue(SimpleDate.isLeapYear(2000));
	}
	
	@Test
	public void test_isLeapYear_7() {
		assertTrue(SimpleDate.isLeapYear(2004));
	}
	
	@Test
	public void test_isLeapYear_8() {
		assertTrue(SimpleDate.isLeapYear(2008));
	}
	
	@Test
	public void test_isLeapYear_9() {
		assertFalse(SimpleDate.isLeapYear(1753));
	}
	
	@Test
	public void test_isLeapYear_10() {
		assertFalse(SimpleDate.isLeapYear(1897));
	}
	
	@Test
	public void test_isLeapYear_11() {
		assertFalse(SimpleDate.isLeapYear(1898));
	}
	
	@Test
	public void test_isLeapYear_12() {
		assertFalse(SimpleDate.isLeapYear(1899));
	}
	
	@Test
	public void test_isLeapYear_13() {
		assertFalse(SimpleDate.isLeapYear(1900));
	}
	
	@Test
	public void test_isLeapYear_14() {
		assertFalse(SimpleDate.isLeapYear(1901));
	}
	
	@Test
	public void test_isLeapYear_15() {
		assertFalse(SimpleDate.isLeapYear(1902));
	}
	
	@Test
	public void test_isLeapYear_16() {
		assertFalse(SimpleDate.isLeapYear(1903));
	}
	
	@Test
	public void test_isLeapYear_17() {
		assertFalse(SimpleDate.isLeapYear(1999));
	}
	
	@Test
	public void test_isLeapYear_18() {
		assertFalse(SimpleDate.isLeapYear(2001));
	}
	
	// unit test for ordinateDate()
	
	@Test
	public void test_ordinalDate_1() {
		SimpleDate d = new SimpleDate();
		assertEquals(1, d.ordinalDate());
		assertEquals("January 1, 1753", d.toString());
	}
	
	@Test
	public void test_ordinalDate_2() {
		SimpleDate d = new SimpleDate(1,1,2007);
		assertEquals(1, d.ordinalDate());
		assertEquals("January 1, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_3() {
		SimpleDate d = new SimpleDate(1,2,2007);
		assertEquals(2, d.ordinalDate());
		assertEquals("January 2, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_4() {
		SimpleDate d = new SimpleDate(1,31,2007);
		assertEquals(31, d.ordinalDate());
		assertEquals("January 31, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_5() {
		SimpleDate d = new SimpleDate(2,1,2007);
		assertEquals(32, d.ordinalDate());
		assertEquals("February 1, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_6() {
		SimpleDate d = new SimpleDate(2,28,2007);
		assertEquals(59, d.ordinalDate());
		assertEquals("February 28, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_7() {
		SimpleDate d = new SimpleDate(3,1,2007);
		assertEquals(60, d.ordinalDate());
		assertEquals("March 1, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_8() {
		SimpleDate d = new SimpleDate(3,31,2007);
		assertEquals(90, d.ordinalDate());
		assertEquals("March 31, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_9() {
		SimpleDate d = new SimpleDate(4,15,2007);
		assertEquals(105, d.ordinalDate());
		assertEquals("April 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_10() {
		SimpleDate d = new SimpleDate(5,15,2007);
		assertEquals(135, d.ordinalDate());
		assertEquals("May 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_11() {
		SimpleDate d = new SimpleDate(6,15,2007);
		assertEquals(166, d.ordinalDate());
		assertEquals("June 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_12() {
		SimpleDate d = new SimpleDate(7,15,2007);
		assertEquals(196, d.ordinalDate());
		assertEquals("July 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_13() {
		SimpleDate d = new SimpleDate(8,15,2007);
		assertEquals(227, d.ordinalDate());
		assertEquals("August 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_14() {
		SimpleDate d = new SimpleDate(9,15,2007);
		assertEquals(258, d.ordinalDate());
		assertEquals("September 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_15() {
		SimpleDate d = new SimpleDate(10,15,2007);
		assertEquals(288, d.ordinalDate());
		assertEquals("October 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_16() {
		SimpleDate d = new SimpleDate(11,15,2007);
		assertEquals(319, d.ordinalDate());
		assertEquals("November 15, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_17() {
		SimpleDate d = new SimpleDate(12,1,2007);
		assertEquals(335, d.ordinalDate());
		assertEquals("December 1, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_18() {
		SimpleDate d = new SimpleDate(12,31,2007);
		assertEquals(365, d.ordinalDate());
		assertEquals("December 31, 2007", d.toString());
	}
	
	@Test
	public void test_ordinalDate_19() {
		SimpleDate d = new SimpleDate(1,1,2008);
		assertEquals(1, d.ordinalDate());
		assertEquals("January 1, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_20() {
		SimpleDate d = new SimpleDate(1,2,2008);
		assertEquals(2, d.ordinalDate());
		assertEquals("January 2, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_21() {
		SimpleDate d = new SimpleDate(1,31,2008);
		assertEquals(31, d.ordinalDate());
		assertEquals("January 31, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_22() {
		SimpleDate d = new SimpleDate(2,1,2008);
		assertEquals(32, d.ordinalDate());
		assertEquals("February 1, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_23() {
		SimpleDate d = new SimpleDate(2,28,2008);
		assertEquals(59, d.ordinalDate());
		assertEquals("February 28, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_24() {
		SimpleDate d = new SimpleDate(3,1,2008);
		assertEquals(61, d.ordinalDate());
		assertEquals("March 1, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_25() {
		SimpleDate d = new SimpleDate(3,31,2008);
		assertEquals(91, d.ordinalDate());
		assertEquals("March 31, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_26() {
		SimpleDate d = new SimpleDate(4,15,2008);
		assertEquals(106, d.ordinalDate());
		assertEquals("April 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_27() {
		SimpleDate d = new SimpleDate(5,15,2008);
		assertEquals(136, d.ordinalDate());
		assertEquals("May 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_28() {
		SimpleDate d = new SimpleDate(6,15,2008);
		assertEquals(167, d.ordinalDate());
		assertEquals("June 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_29() {
		SimpleDate d = new SimpleDate(7,15,2008);
		assertEquals(197, d.ordinalDate());
		assertEquals("July 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_30() {
		SimpleDate d = new SimpleDate(8,15,2008);
		assertEquals(228, d.ordinalDate());
		assertEquals("August 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_31() {
		SimpleDate d = new SimpleDate(9,15,2008);
		assertEquals(259, d.ordinalDate());
		assertEquals("September 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_32() {
		SimpleDate d = new SimpleDate(10,15,2008);
		assertEquals(289, d.ordinalDate());
		assertEquals("October 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_33() {
		SimpleDate d = new SimpleDate(11,15,2008);
		assertEquals(320, d.ordinalDate());
		assertEquals("November 15, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_34() {
		SimpleDate d = new SimpleDate(12,1,2008);
		assertEquals(336, d.ordinalDate());
		assertEquals("December 1, 2008", d.toString());
	}
	
	@Test
	public void test_ordinalDate_35() {
		SimpleDate d = new SimpleDate(1,1,1753);
		assertEquals(1, d.ordinalDate());
		assertEquals("January 1, 1753", d.toString());
	}
	
	// unit test for nextDate()
	
	@Test
	public void test_nextDate_1() {
		SimpleDate d = new SimpleDate(1,1,2012);
		SimpleDate expected = new SimpleDate(1,2,2012);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("January 1, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_2() {
		SimpleDate d = new SimpleDate(1,30,2012);
		SimpleDate expected = new SimpleDate(1,31,2012);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("January 30, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_3() {
		SimpleDate d = new SimpleDate(2,28,2012);
		SimpleDate expected = new SimpleDate(2,29,2012);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("February 28, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_4() {
		SimpleDate d = new SimpleDate(12,31,2012);
		SimpleDate expected = new SimpleDate(1,1,2013);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("December 31, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_5() {
		SimpleDate d = new SimpleDate(4,30,2012);
		SimpleDate expected = new SimpleDate(5,1,2012);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("April 30, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_6() {
		SimpleDate d = new SimpleDate(5,31,2012);
		SimpleDate expected = new SimpleDate(6,1,2012);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("May 31, 2012", d.toString());
	}
	
	@Test
	public void test_nextDate_7() {
		SimpleDate d = new SimpleDate(2,28,2011);
		SimpleDate expected = new SimpleDate(3,1,2011);
		SimpleDate actual = d.nextDate();
		assertEquals(expected, actual);
		assertEquals("February 28, 2011", d.toString());
	}
	
	// unit test for prevDate()
	
	@Test
	public void test_prevDate_1() {
		SimpleDate d = new SimpleDate(1,1,2013);
		SimpleDate expected = new SimpleDate(12,31,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("January 1, 2013", d.toString());
	}
	
	@Test
	public void test_prevDate_2() {
		SimpleDate d = new SimpleDate(2,1,2012);
		SimpleDate expected = new SimpleDate(1,31,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("February 1, 2012", d.toString());
	}
	
	@Test
	public void test_prevDate_3() {
		SimpleDate d = new SimpleDate(3,1,2012);
		SimpleDate expected = new SimpleDate(2,29,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("March 1, 2012", d.toString());
	}
	
	@Test
	public void test_prevDate_4() {
		SimpleDate d = new SimpleDate(3,1,2011);
		SimpleDate expected = new SimpleDate(2,28,2011);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("March 1, 2011", d.toString());
	}
	
	@Test
	public void test_prevDate_5() {
		SimpleDate d = new SimpleDate(4,1,2012);
		SimpleDate expected = new SimpleDate(3,31,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("April 1, 2012", d.toString());
	}
	
	@Test
	public void test_prevDate_6() {
		SimpleDate d = new SimpleDate(5,1,2012);
		SimpleDate expected = new SimpleDate(4,30,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("May 1, 2012", d.toString());
	}
	
	@Test
	public void test_prevDate_7() {
		SimpleDate d = new SimpleDate(8,1,2012);
		SimpleDate expected = new SimpleDate(7,31,2012);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("August 1, 2012", d.toString());
	}
	
	@Test
	public void test_prevDate_8() {
		SimpleDate d = new SimpleDate(1,1,1753);
		SimpleDate expected = new SimpleDate(1,1,1753);
		SimpleDate actual = d.prevDate();
		assertEquals(expected, actual);
		assertEquals("January 1, 1753", d.toString());
	}
	
	// unit tests for dateFrom()
	
	@Test
	public void test_dateFrom_1() {
		SimpleDate d = new SimpleDate(1,25,2011);
		SimpleDate expected = new SimpleDate(1,28,2011);
		SimpleDate actual = d.dateFrom(3);
		assertEquals(expected, actual);	
		assertEquals("January 25, 2011", d.toString());
	}
	
	@Test
	public void test_dateFrom_2() {
		SimpleDate d = new SimpleDate(1,28,2011);
		SimpleDate expected = new SimpleDate(1,25,2011);
		SimpleDate actual = d.dateFrom(-3);
		assertEquals(expected, actual);	
		assertEquals("January 28, 2011", d.toString());
	}
	
	@Test
	public void test_dateFrom_3() {
		SimpleDate d = new SimpleDate(1,25,2011);
		SimpleDate expected = new SimpleDate(1,25,2011);
		SimpleDate actual = d.dateFrom(0);
		assertEquals(expected, actual);	
		assertEquals("January 25, 2011", d.toString());
	}
	
	@Test
	public void test_dateFrom_4() {
		SimpleDate d = new SimpleDate(12,28,2010);
		SimpleDate expected = new SimpleDate(1,2,2011);
		SimpleDate actual = d.dateFrom(5);
		assertEquals(expected, actual);
		assertEquals("December 28, 2010", d.toString());
	}
	
	@Test
	public void test_dateFrom_5() {
		SimpleDate d = new SimpleDate(11,30,2011);
		SimpleDate expected = new SimpleDate(12,31,2011);
		SimpleDate actual = d.dateFrom(31);
		assertEquals(expected, actual);
		assertEquals("November 30, 2011", d.toString());
	}
	
	@Test
	public void test_dateFrom_6() {
		SimpleDate d = new SimpleDate(1,31,2012);
		SimpleDate expected = new SimpleDate(3,1,2012);
		SimpleDate actual = d.dateFrom(30);
		assertEquals(expected, actual);
		assertEquals("January 31, 2012", d.toString());
	}
	
	@Test
	public void test_dateFrom_7() {
		SimpleDate d = new SimpleDate(2,1,2012);
		SimpleDate expected = new SimpleDate(3,1,2012);
		SimpleDate actual = d.dateFrom(29);
		assertEquals(expected, actual);	
		assertEquals("February 1, 2012", d.toString());
	}
	
	@Test
	public void test_dateFrom_8() {
		SimpleDate d = new SimpleDate(1,2,1753);
		SimpleDate expected = new SimpleDate(1,1,1753);
		SimpleDate actual = d.dateFrom(-3);
		assertEquals(expected, actual);	
		assertEquals("January 2, 1753", d.toString());
	}
	
	@Test
	public void test_dateFrom_9() {
		SimpleDate d = new SimpleDate(1,1,2001);
		SimpleDate expected = new SimpleDate(1,1,2003);
		SimpleDate actual = d.dateFrom(730);
		assertEquals(expected, actual);
		assertEquals("January 1, 2001", d.toString());
	}
	
	@Test
	public void test_dateFrom_10() {
		SimpleDate d = new SimpleDate(1,1,2003);
		SimpleDate expected = new SimpleDate(1,1,2001);
		SimpleDate actual = d.dateFrom(-730);
		assertEquals(expected, actual);	
		assertEquals("January 1, 2003", d.toString());
	}
	
	@Test
	public void test_dateFrom_11() {
		SimpleDate d = new SimpleDate(12,31,2000);
		SimpleDate expected = new SimpleDate(12,31,2002);
		SimpleDate actual = d.dateFrom(730);
		assertEquals(expected, actual);	
		assertEquals("December 31, 2000", d.toString());
	}
	
	@Test
	public void test_dateFrom_12() {
		SimpleDate d = new SimpleDate(12,31,2002);
		SimpleDate expected = new SimpleDate(12,31,2000);
		SimpleDate actual = d.dateFrom(-730);
		assertEquals(expected, actual);	
		assertEquals("December 31, 2002", d.toString());
	}
	
	@Test
	public void test_dateFrom_13() {
		SimpleDate d = new SimpleDate(1,1,2012);
		SimpleDate expected = new SimpleDate(1,1,2013);
		SimpleDate actual = d.dateFrom(366);
		assertEquals(expected, actual);
		assertEquals("January 1, 2012", d.toString());
	}
	
	// unit tests for advance()
	
	@Test
	public void test_advance_1() {
		SimpleDate d = new SimpleDate(1,25,2011);
		d.advance(3);
		assertEquals("January 28, 2011", d.toString());
	}
	
	@Test
	public void test_advance_2() {
		SimpleDate d = new SimpleDate(1,25,2011);
		d.advance(-25);
		assertEquals("December 31, 2010", d.toString());
	}
	
	@Test
	public void test_advance_3() {
		SimpleDate d = new SimpleDate(1,25,2011);
		d.advance(0);
		assertEquals("January 25, 2011", d.toString());
	}
	
	@Test
	public void test_advance_4() {
		SimpleDate d = new SimpleDate(12,28,2010);
		d.advance(5);
		assertEquals("January 2, 2011", d.toString());
	}
	
	@Test
	public void test_advance_5() {
		SimpleDate d = new SimpleDate(11,30,2011);
		d.advance(31);
		assertEquals("December 31, 2011", d.toString());
	}
	
	@Test
	public void test_advance_6() {
		SimpleDate d = new SimpleDate(1,31,2012);
		d.advance(30);
		assertEquals("March 1, 2012", d.toString());
	}
	
	@Test
	public void test_advance_7() {
		SimpleDate d = new SimpleDate(2,1,2012);
		d.advance(29);
		assertEquals("March 1, 2012", d.toString());
	}
	
	@Test
	public void test_advance_8() {
		SimpleDate d = new SimpleDate(1,2,1753);
		d.advance(-3);
		assertEquals("January 1, 1753", d.toString());
	}
	
	@Test
	public void test_advance_9() {
		SimpleDate d = new SimpleDate(1,1,2001);
		d.advance(730);
		assertEquals("January 1, 2003", d.toString());
	}
	
	@Test
	public void test_advance_10() {
		SimpleDate d = new SimpleDate(1,1,2003);
		d.advance(-730);
		assertEquals("January 1, 2001", d.toString());
	}
	
	@Test
	public void test_advance_11() {
		SimpleDate d = new SimpleDate(12,31,2000);
		d.advance(730);
		assertEquals("December 31, 2002", d.toString());
	}
	
	@Test
	public void test_advance_12() {
		SimpleDate d = new SimpleDate(1,1,2012);
		d.advance(366);
		assertEquals("January 1, 2013", d.toString());
	}
	
	// unit tests for daysBetween()
	
	@Test
	public void test_daysBetween_1() {
		SimpleDate d1 = new SimpleDate(1,25,2011);
		SimpleDate d2 = new SimpleDate(1,28,2011);
		assertEquals(3, d1.daysBetween(d2));
		assertEquals("January 25, 2011", d1.toString());
		assertEquals("January 28, 2011", d2.toString());
	}
	
	@Test
	public void test_daysBetween_2() {
		SimpleDate d1 = new SimpleDate(1,25,2011);
		SimpleDate d2 = new SimpleDate(1,28,2011);
		assertEquals(3, d2.daysBetween(d1));
		assertEquals("January 25, 2011", d1.toString());
		assertEquals("January 28, 2011", d2.toString());
	}
	
	@Test
	public void test_daysBetween_3() {
		SimpleDate d = new SimpleDate(1,25,2011);
		assertEquals(0, d.daysBetween(d));
		assertEquals("January 25, 2011", d.toString());
	}
	
	@Test
	public void test_daysBetween_4() {
		SimpleDate d1 = new SimpleDate(1,25,2011);
		SimpleDate d2 = new SimpleDate(1,25,2011);
		assertEquals(0, d1.daysBetween(d2));
		assertEquals("January 25, 2011", d1.toString());
		assertEquals("January 25, 2011", d2.toString());
	}
	
	@Test
	public void test_daysBetween_5() {
		SimpleDate d1 = new SimpleDate(1,2,2011);
		SimpleDate d2 = new SimpleDate(12,28,2010);
		assertEquals(5, d1.daysBetween(d2));
		assertEquals("January 2, 2011", d1.toString());
		assertEquals("December 28, 2010", d2.toString());
	}
	
	@Test
	public void test_daysBetween_6() {
		SimpleDate d1 = new SimpleDate(12,31,2011);
		SimpleDate d2 = new SimpleDate(11,30,2011);
		assertEquals(31, d1.daysBetween(d2));
		assertEquals("December 31, 2011", d1.toString());
		assertEquals("November 30, 2011", d2.toString());
	}
	
	@Test
	public void test_daysBetween_7() {
		SimpleDate d1 = new SimpleDate(3,1,2012);
		SimpleDate d2 = new SimpleDate(1,31,2012);
		assertEquals(30, d1.daysBetween(d2));
		assertEquals("March 1, 2012", d1.toString());
		assertEquals("January 31, 2012", d2.toString());
	}
	
	@Test
	public void test_daysBetween_8() {
		SimpleDate d1 = new SimpleDate(3,1,2012);
		SimpleDate d2 = new SimpleDate(2,1,2012);
		assertEquals(29, d1.daysBetween(d2));
		assertEquals("March 1, 2012", d1.toString());
		assertEquals("February 1, 2012", d2.toString());
	}
	
	@Test
	public void test_daysBetween_9() {
		SimpleDate d1 = new SimpleDate(1,1,2003);
		SimpleDate d2 = new SimpleDate(1,1,2001);
		assertEquals(730, d1.daysBetween(d2));
		assertEquals("January 1, 2003", d1.toString());
		assertEquals("January 1, 2001", d2.toString());
	}
	
	@Test
	public void test_daysBetween_10() {
		SimpleDate d1 = new SimpleDate(1,1,2003);
		SimpleDate d2 = new SimpleDate(1,1,2001);
		assertEquals(730, d2.daysBetween(d1));
		assertEquals("January 1, 2003", d1.toString());
		assertEquals("January 1, 2001", d2.toString());
	}
	
	@Test
	public void test_daysBetween_11() {
		SimpleDate d1 = new SimpleDate(12,31,2002);
		SimpleDate d2 = new SimpleDate(12,31,2000);
		assertEquals(730, d1.daysBetween(d2));
		assertEquals("December 31, 2002", d1.toString());
		assertEquals("December 31, 2000", d2.toString());
	}
	
	@Test
	public void test_daysBetween_12() {
		SimpleDate d1 = new SimpleDate(12,31,2000);
		SimpleDate d2 = new SimpleDate(12,31,2002);
		assertEquals(730, d1.daysBetween(d2));
		assertEquals("December 31, 2000", d1.toString());
		assertEquals("December 31, 2002", d2.toString());
	}
	
	@Test
	public void test_daysBetween_13() {
		SimpleDate d1 = new SimpleDate(1,1,2013);
		SimpleDate d2 = new SimpleDate(1,1,2012);
		assertEquals(366, d1.daysBetween(d2));
		assertEquals("January 1, 2013", d1.toString());
		assertEquals("January 1, 2012", d2.toString());
	}
	
	@Test
	public void test_daysBetween_14() {
		SimpleDate d1 = new SimpleDate(1,1,2013);
		SimpleDate d2 = new SimpleDate(1,1,2012);
		assertEquals(366, d2.daysBetween(d1));
		assertEquals("January 1, 2013", d1.toString());
		assertEquals("January 1, 2012", d2.toString());
	}
}
