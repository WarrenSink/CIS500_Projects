import static org.junit.Assert.assertEquals;
import java.util.*;

public class Infix2Postfix {
	
	/*
	 * helper method imitating "popping" ArrayList of String Objects
	 */
	private static String pop(ArrayList<String> stack) {
		
		return stack.remove(stack.size() - 1);
		
	}
	
	/*
	 * helper method imitating "peaking" ArrayList of String Objects
	 */
	private static String peak(ArrayList<String> stack) {
		
		return stack.get(stack.size() - 1);
		
	}
	
	/*
	 * helper method imitating "peaking" ArrayList of String Objects
	 * with additional counter variable argument
	 */
	private static String peak(ArrayList<String> stack, int i) {
		
		return stack.get(stack.size() - 1 - i);
		
	}
	
	/*
	 * helper method imitating "popping" ArrayList of Integer Objects
	 */
	private static Integer popInt(ArrayList<Integer> stack) {
		
		return stack.remove(stack.size() - 1);
		
	}
	
	/*
	 * helper method imitating "peaking" ArrayList of Integer Objects
	 */
	private static Integer peakInt(ArrayList<Integer> stack) {
		
		return stack.get(stack.size() - 1);
		
	}
	
	/**
	 * Converts the given infix expression into equivalent postfix expression and returns it.
	 * 
	 * @param infixExpr infix expression to convert
	 * 
	 * @return postfix expression
	 * 
	 * @throws InvalidInfixExprException when the given infix expression is not valid
	 */
	public static String toPostfixExpr(String infixExpr) throws InvalidInfixExprException {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		ArrayList<String> operators = new ArrayList<String>();
		String result = "";
		
        String[] infixExprArray = infixExpr.split(" ");
        
        for (String slice : infixExprArray) {

			if (isOperand(slice)) {
				
				result += slice + " ";

			} else if (isLeftParen(slice)) {
				
				operators.add(slice);
		 		
			} else if (isRightParen(slice)) {
				
				boolean leftParen = false;
				while(!(leftParen)) {
					
					if (operators.size() < 1) {
					
						throw new InvalidInfixExprException();
						
					}
					String popped = pop(operators);
					if (!(isLeftParen(popped))){
						
						result+= popped + " ";
						
						
					} else if (isLeftParen(popped)){
						
						break;
						
					} else {
						
						throw new InvalidInfixExprException();
						
					}
				}
				
			} else if (isOperator(slice)){
				
				boolean higherOrder = false;

				while(!(higherOrder)) {
					
					if (operators.size() < 1) {
						
						break;
						
					}
					
	
					if (oprStackPrecedence(peak(operators)) >= 
						oprInputPrecedence(slice)) {
						
						String popped = pop(operators);
						result+=popped + " ";
						
					} else {
						
						higherOrder = true;
						
					}
					
					
				} 
				operators.add(slice);
				
			} else {
				
				throw new InvalidInfixExprException();
				
			}
		}
		
		for (int i = 0; i < operators.size(); i++) {
			
			String temp = peak(operators, i);
			if (i < operators.size() - 1) {
			
				result+=temp + " ";
				
			} else {
			
				result+=temp;
				
			}
			
		}

		return result;
	}
	
	/**
	 * Evaluates the given postfix expression and returns the result.
	 * 
	 * @param postfixExpr postfix expression to evaluate
	 * 
	 * @return result of evaluating the postfix expression
	 * 
	 * @throws InvalidPostfixExprException when the given postfix expression is not valid
	 */
	public static int evalPostfixExpr(String postfixExpr) throws InvalidPostfixExprException {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		int num1, num2;
		ArrayList<Integer> operandStack = new ArrayList<Integer>();
		String[] postfixExprArray = postfixExpr.split(" ");
		
        for (String postfix : postfixExprArray) {
        	
        	if (isOperand(postfix)) {
        		
        		String operand = "";
        		operand += postfix;

        		operandStack.add(Integer.parseInt(operand));
        		
        	} else if (isOperator(postfix)) {
        		
        		if (operandStack.size() < 2) {
        			
        			throw new InvalidPostfixExprException();
        			
        		} else {
        		
            		num2 = popInt(operandStack);
            		num1 = popInt(operandStack);
            		operandStack.add(applyOperator(num1, num2, postfix));
        			
        			
        		}
        		
        		
        	} else {
        		
        		throw new InvalidPostfixExprException();
        		
        	}
        	
        }
        
        
        if (operandStack.size() == 1) {
        	
        	return peakInt(operandStack);
        	
        } else {
        	
        	throw new InvalidPostfixExprException();
        	
        }

	}
	
	/**
	 * Returns true if the argument is an operator, false otherwise.
	 * 
	 * @param str string that is checked to see if it is an operator
	 * 
	 * @return true if the argument is an operator, false otherwise
	 */
	private static boolean isOperator(String str) {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		if (str.equals("^")) {
			
			return true;
			
		} else if (str.equals("*")||str.equals("/")||str.equals("%")) {
			
			return true;
			
		} else if (str.equals("+")||str.equals("-")) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	/**
	 * Returns true if the argument is an operand, false otherwise.
	 * my implementation is inspired from these related sites
	 * https://www.baeldung.com/java-check-string-number
	 * https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-string-operations
	 * @param str string that is checked to see if it is an operand
	 * 
	 * @return true if the argument is an operand, false otherwise
	 */
	private static boolean isOperand(String str) {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
	    if (str == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Returns true if the argument is a left parenthesis ("("), false otherwise.
	 * 
	 * @param str string that is checked to see if it is a left parenthesis
	 * 
	 * @return true if the argument is a left parenthesis (")"), false otherwise
	 */
	private static boolean isLeftParen(String str) {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		if (str.equals("(")) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Returns true if the argument is a right parenthesis (")"), false otherwise.
	 * 
	 * @param str string that is checked to see if it is a right parenthesis
	 * 
	 * @return true if the argument is a right parenthesis (")"), false otherwise
	 */
	private static boolean isRightParen(String str) {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		if (str.equals(")")) {
			
			return true;
			
		}
		
		return false;
	}
	
	/**
	 * Returns the stack precedence of the specified operator.
	 * 
	 * @param operator operator whose stack precedence is to be determined
	 * 
	 * @return stack precedence of the operator
	 * 
	 * @throws IllegalArgumentException when the operator is not valid. Valid operators are: +, -, *, /, %, ^
	 */
	private static int oprStackPrecedence(String operator) throws IllegalArgumentException {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
        if (isLeftParen(operator)) {
			
			return -1;
			
		} else if (operator.equals("^")) {
			
			return 3;
			
		} else if (operator.equals("*")||operator.equals("/")|| operator.equals("%")) {
			
			return 2;
			
		} else if (operator.equals("+")||operator.equals("-")){
			
			return 1;
			
		} else {
			
			throw new IllegalArgumentException();
			
		}
	}
	
	/**
	 * Returns the input precedence of the specified operator.
	 * 
	 * @param operator operator whose input precedence is to be determined
	 * 
	 * @return input precedence of the operator
	 * 
	 * @throws IllegalArgumentException when the operator is not valid. Valid operators are: +, -, *, /, %, ^
	 */
	private static int oprInputPrecedence(String operator) throws IllegalArgumentException {
		
        if (isLeftParen(operator)) {
			
			return 5;
			
		} else if (operator.equals("^")) {
			
			return 4;
			
		} else if(operator.equals("*")||operator.equals("/")|| operator.equals("%")) {
			
			return 2;
			
		} else if (operator.equals("+")||operator.equals("-")){
			
			return 1;
			
		} else {
			
			throw new IllegalArgumentException();
			
		}
	}
	
	/**
	 * Method applies the specified operator to num1 (left operand) and num2 (right operand) and returns
	 * the result.
	 * 
	 * @param num1 left operand for operator
	 * @param num2 right operand for operator
	 * @param operator binary operator (+, -, *, /, %, ^) to apply to operands
	 * 
	 * @return result of applying the operator to operands
	 * 
	 * @throws IllegalArgumentException when the operator is not valid. Valid operators are: +, -, *, /, %, ^
	 */
	private static int applyOperator(int num1, int num2, String operator) throws IllegalArgumentException {
		// REPLACE THE FOLLOWING LINE WITH YOUR IMPLEMENTATION
		if (operator.equals("^")) {
			
			double power = Math.pow((double) num1,(double) num2);
		
			int powerInt = (int) power;
			
			return powerInt;
			
			
			
		} else if (operator.equals("*")) {
			
			return num1 * num2;
			
		} else if (operator.equals("/")) {
			
			return num1 / num2;
			
		} else if (operator.equals("%")) {
			
			return num1 % num2;
			
		} else if (operator.equals("+")) {
			
			return num1 + num2;
			
		} else if (operator.equals("-")){
			
			return num1 - num2;
			
		} else {
			
			
			
		}
		throw new InvalidPostfixExprException();
	}
	
	
	//example of impromptu testing
	public static void main(String[] args) {
		
		String string = "10 2 2 2 ^ ^ *";
		String[] string1 = string.split(" ");
		for (String string2 : string1) {
			
			System.out.println(string2);
			
		}
	
		System.out.println(Infix2Postfix.evalPostfixExpr("3 4 2 5 ^ - *"));
		assertEquals(660,Infix2Postfix.evalPostfixExpr("10 2 2 2 ^ ^ * 10 50 * +"));
		
		String expected = "2 2 3 ^ ^ 100 10 * + 8 4 / 2 * +";
		
		String infixExprSpaceless = expected.replaceAll("\\s", "");
        String[] infixExprArray = infixExprSpaceless.split("");
        for (String string69 : infixExprArray) {
        	
        	System.out.print(string69 + " ");
        }
        
		String expected3 = "3 2 1 2 + ^ ^";
		String actual3 = Infix2Postfix.toPostfixExpr("3 ^ 2 ^ ( 1 + 2 )");
		assertEquals(expected3,actual3);
        
		System.out.println();
		String actual = Infix2Postfix.toPostfixExpr("2 ^ 2 ^ 3 + 100 * 10 + 8 / 4 * 2");
		assertEquals(expected,actual);
		
		String expected2 = "3 4 2 5 ^ - * 6 +";
		String actual2 = Infix2Postfix.toPostfixExpr("3 * ( 4 - 2 ^ 5 ) + 6");
		assertEquals(expected2,actual2);

		
	}
	

}
	


