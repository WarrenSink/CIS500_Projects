public class InvalidInfixExprException extends RuntimeException {

	public InvalidInfixExprException() {
		super("Invalid infix expression");
	}
	
	public InvalidInfixExprException(String msg) {
		super(msg);
	}
}
