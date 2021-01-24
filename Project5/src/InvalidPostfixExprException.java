public class InvalidPostfixExprException extends RuntimeException {

	public InvalidPostfixExprException() {
		super("Invalid postfix expression");
	}
	
	public InvalidPostfixExprException(String msg) {
		super(msg);
	}
}
