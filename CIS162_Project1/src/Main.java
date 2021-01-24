import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println ("Testing begings");
        
        //testing validity of constructor argument: should be invalid
		// testing setter methods 
		GVdate theDay = new GVdate(1, 10, 1995);
		//testing setMonth
		theDay.setMonth(8);
		// TO DO: complete the code to check for month
		assert theDay.getMonth() == 8;
				
		theDay.setDay(9);
	    assert theDay.getDay() == 9;
				
		theDay.setYear(2020);
		assert theDay.getYear() == 2020;

		String stringTheDay = theDay.toString(1);
		assertEquals(stringTheDay, "8/9/2020");
		
		//testing validity of constructor argument
        GVdate f = new GVdate(2,29,1960);    
        assertTrue(isLeapYear(f.getYear()));
        
      //testing validity of the setters
        assert false; f.setDay(30);
        assert true; f.setDay(1);
        
		
		System.out.println ("Testing ends");
	}


}
