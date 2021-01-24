import java.util.ArrayList;


public class Main {
	
	public static int sumDigits(int n) throws Exception {
		if (n < 0) {
		   throw new Exception("Enter nonnegative integer");
		} else if (n == 0){
		    return n;
		} else {
			return n % 10 + sumDigits(n / 10);
			}
}
	public static void crazy1(int int1, int int2) {
		
		int1 = int2;
		int2 = int1;
	
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		String s = "Did Hannah see bees? Hannah did.";
		System.out.println(s.length());
		System.out.println(s.substring(15));
		System.out.println(s.indexOf('h'));
		System.out.println(s.lastIndexOf("ee"));
		System.out.println("Hannah".compareTo("Joanne"));
		
		int int1 = 20;
		int int2 = 40;
		System.out.println(int1 + " " + int2);
		crazy1(int2, int1);
		System.out.println(int1 + " " + int2);
		
		int[][] intAry = new int[3][5]; 
		
		System.out.println(intAry[2].length);
		
		System.out.println(sumDigits(1445));
		
	}


}
