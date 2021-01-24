
public class Recursion {

	public static int fact(int n) {
		
		if (n < 0) {
			
			throw new IllegalArgumentException("n can't be negative");
			
		} else if (n == 0) {
			
			return 1;
			
		} else {
			
			return n * fact(n - 1);
			
		}
		
	}
	
	
	public static int fibonacci (int n) {
		
        if (n < 0) {
			
			throw new IllegalArgumentException("n can't be negative");
			
		} else if (n == 0) {
			
			return 0;
			
		} else if (n == 1){
			
			return 1;
			
		} else {
			
			return fibonacci(n-1) + fibonacci(n-2);
			
		}
		
		
	}
	
	public static int pow(int x, int n) {
		
		if (n == 0) {
			
			return 0;
			
		} else {
			
			return x * pow(x, n - 1);
			
		}
		
		
	}
	
	
	public static int bunnyEars(int n) {
		
        if (n < 0) {
			
			throw new IllegalArgumentException("there can't be negative bunnies");
			
		} else if (n == 0) {
			
			return 0;
			
		} else {
			
			return 2 + bunnyEars(n-1);
			
		}
		
		
	}
	
	
	public static int strlen(String str) {
		
		if (str.equals(null)) {
			
			throw new IllegalArgumentException("input cannot be string");
			
		} else if (str.equals("")) {
			
			return 0;
			
		} else {
			
			return 1 + strlen(str.substring(1));
			
		}
		
		
	}
	
	
	public static boolean isPalindrome(String str) {
		
		if (str.equals(null)) {
			
			throw new IllegalArgumentException("enter sequence of characters");
			
		} else if (str.length() == 1 || str.length() == 0) {
			
			return true;
			
		} else if (str.charAt(0) == str.charAt(str.length()- 1)){
			
			return isPalindrome(str.substring(1, str.length() - 1));
			
		} else {
			
			return false;
			
		}
		
	}
	
	public static void main(String [] args) {
		
		String str = "  ";
		if (str.equals("        ")) {System.out.println("true");}
		
	}
	
	
	
}
