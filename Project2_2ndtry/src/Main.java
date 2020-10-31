
public class Main {
	
	public static void main(String[] args) {
		
		SimpleDate d = new SimpleDate(2,28,2012);
		SimpleDate expected = new SimpleDate(2,29,2012);
		SimpleDate actual = d.nextDate();
		
		System.out.println("expected: "+expected);
		System.out.println("actual: "+actual);
		
		if (expected.equals(actual)) {
			
			System.out.println("Hooray");
			
		}
		
		
		SimpleDate e = new SimpleDate(1,30,2012);
		SimpleDate expected_e = new SimpleDate(1,31,2012);
		SimpleDate actual_e = e.nextDate();
		
		System.out.println("expected_e: "+expected_e);
		System.out.println("actual_e: "+actual_e);
		
		
		System.out.println("January 1, 2012 :::"+ d.toString());
		System.out.println("January 30, 2012 :::"+ e.toString());
		
		
		
		if (d.isLeapYear()) {
			
			System.out.println("Hooray, it's a leap year");
			
		}
	}

}
