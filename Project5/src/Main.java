import toPostfixExpr;
public class Main {
	
	public static void main(String[] args) {
		
		String str = "( (2 * 4) )";
		
		System.out.println("str: " + str);
		String str1 = str.replaceAll("\\s", "");
		System.out.println("str: " + str1);
		String[] str2 = str1.split("");
		int counter = 0;
		for (String strI : str2) {
			counter ++;
		    if (counter == 1) {
		    	
		    	System.out.print("str: " + strI);
		    	
		    }
			System.out.print(" " + strI);
			
		}
		
		toPostfixExpr(str);
		
	}

}
