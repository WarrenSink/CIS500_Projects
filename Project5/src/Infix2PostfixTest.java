import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Infix2PostfixTest {

	@Test
	public void test_toPostfixExpr_1() {
		String expected = "3 4 2 5 ^ - * 6 +";
		String actual = Infix2Postfix.toPostfixExpr("3 * ( 4 - 2 ^ 5 ) + 6");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_2() {
		String expected = "3 2 1 2 + ^ ^";
		String actual = Infix2Postfix.toPostfixExpr("3 ^ 2 ^ ( 1 + 2 )");
		assertEquals(expected,actual);
	}

	@Test
	public void test_toPostfixExpr_3() {
		String expected = "10 2 2 2 ^ ^ * 10 50 * +";
		String actual = Infix2Postfix.toPostfixExpr("10 * ( 2 ^ 2 ^ 2 ) + 10 * 50");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_4() {
		String expected = "100 50 2 3 ^ - / 50 10 / - 5 +";
		String actual = Infix2Postfix.toPostfixExpr("100 / ( 50 - 2 ^ 3 ) - 50 / 10 + 5");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_5() {
		String expected = "10 54 10 % 25 10 - 2 2 ^ + * 3 / +";
		String actual = Infix2Postfix.toPostfixExpr("10 + 54 % 10 * ( 25 - 10 + 2 ^ 2 ) / 3");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_6() {
		String expected = "10 5 2 % + 5 3 3 ^ * + 25 5 / -";
		String actual = Infix2Postfix.toPostfixExpr("( 10 + 5 % 2 ) + ( 5 * 3 ^ 3 ) - ( 25 / 5 )");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_7() {
		String expected = "2 2 * 2 * 2 2 2 ^ ^ +";
		String actual = Infix2Postfix.toPostfixExpr("( 2 * 2 * 2 ) + ( 2 ^ 2 ^ 2 )");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_8() {
		String expected = "2 2 3 ^ ^ 2 2 * 2 * /";
		String actual = Infix2Postfix.toPostfixExpr("( 2 ^ 2 ^ 3 ) / ( 2 * 2 * 2 )");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_9() {
		String expected = "2 2 3 ^ ^ 100 + 8 4 / 2 * +";
		String actual = Infix2Postfix.toPostfixExpr("( 2 ^ 2 ^ 3 ) + 100 + ( 8 / 4 * 2 )");
		assertEquals(expected,actual);
	}
	
	@Test
	public void test_toPostfixExpr_10() {
		String expected = "2 2 3 ^ ^ 100 10 * + 8 4 / 2 * +";
		String actual = Infix2Postfix.toPostfixExpr("2 ^ 2 ^ 3 + 100 * 10 + 8 / 4 * 2");
		assertEquals(expected,actual);
	}
	
	// Invalid token "5.25" in the expression
	@Test(expected = InvalidInfixExprException.class)
	public void test_toPostfixExpr_11() {
		Infix2Postfix.toPostfixExpr("3 * ( 4 - 2 ^ 5.25 ) + 6");
	}
	
	// Invalid tokens "[" and "]" in the expression
	@Test(expected = InvalidInfixExprException.class)
	public void test_toPostfixExpr_12() {
		Infix2Postfix.toPostfixExpr("3 * [ 4 - 2 ^ 5 ] + 6");
	}
	
	// Invalid token "xyz" in the expression
	@Test(expected = InvalidInfixExprException.class)
	public void test_toPostfixExpr_13() {
		Infix2Postfix.toPostfixExpr("3 * [ xyz - 2 ^ 5 ] + 6");
	}
	
	@Test
	public void test_evalPostfixExpr_1() {
		assertEquals(-78,Infix2Postfix.evalPostfixExpr("3 4 2 5 ^ - * 6 +"));
	}
	
	@Test
	public void test_evalPostfixExpr_2() {
		assertEquals(6561,Infix2Postfix.evalPostfixExpr("3 2 1 2 + ^ ^"));
	}
	
	@Test
	public void test_evalPostfixExpr_3() {
		assertEquals(660,Infix2Postfix.evalPostfixExpr("10 2 2 2 ^ ^ * 10 50 * +"));
	}
	
	@Test
	public void test_evalPostfixExpr_4() {
		assertEquals(2,Infix2Postfix.evalPostfixExpr("100 50 2 3 ^ - / 50 10 / - 5 +"));
	}
	
	@Test
	public void test_evalPostfixExpr_5() {
		assertEquals(35,Infix2Postfix.evalPostfixExpr("10 54 10 % 25 10 - 2 2 ^ + * 3 / +"));
	}
	
	@Test
	public void test_evalPostfixExpr_6() {
		assertEquals(141,Infix2Postfix.evalPostfixExpr("10 5 2 % + 5 3 3 ^ * + 25 5 / -"));
	}
	
	@Test
	public void test_evalPostfixExpr_7() {
		assertEquals(24,Infix2Postfix.evalPostfixExpr("2 2 * 2 * 2 2 2 ^ ^ +"));
	}
	
	@Test
	public void test_evalPostfixExpr_8() {
		assertEquals(32,Infix2Postfix.evalPostfixExpr("2 2 3 ^ ^ 2 2 * 2 * /"));
	}
	
	@Test
	public void test_evalPostfixExpr_9() {
		assertEquals(360,Infix2Postfix.evalPostfixExpr("2 2 3 ^ ^ 100 + 8 4 / 2 * +"));
	}
	
	@Test
	public void test_evalPostfixExpr_10() {
		assertEquals(1260,Infix2Postfix.evalPostfixExpr("2 2 3 ^ ^ 100 10 * + 8 4 / 2 * +"));
	}
	
	// Invalid token "4.5" in the expression
	@Test(expected = InvalidPostfixExprException.class)
	public void test_evalPostfixExpr_11() {
		Infix2Postfix.evalPostfixExpr("3 4.5 2 5 ^ - * 6 +");
	}
	
	// Missing operand on stack for + operator
	@Test(expected = InvalidPostfixExprException.class)
	public void test_evalPostfixExpr_12() {
		Infix2Postfix.evalPostfixExpr("3 4 2 5 ^ - * +");
	}
	
	// Stack has more than one operand in it after all the tokens in the expression have been processed
	@Test(expected = InvalidPostfixExprException.class)
	public void test_evalPostfixExpr_13() {
		Infix2Postfix.evalPostfixExpr("3 4 2 5 ^ - * 6 10 +");
	}
	
	// Invalid token "xyz" in the expression
	@Test(expected = InvalidPostfixExprException.class)
	public void test_evalPostfixExpr_14() {
		Infix2Postfix.evalPostfixExpr("3 4 xyz 5 ^ - * 6 10 +");
	}
	
	// Invalid token ($) in the expression
	@Test(expected = InvalidPostfixExprException.class)
	public void test_evalPostfixExpr_15() {
		Infix2Postfix.evalPostfixExpr("3 4 2 5 $ - * 6 10 +");
	}
}
