import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GVdateTest {
	
public static void main(String[] args) {
		
		System.out.println ("Testing begings");
		
		//********** phase 1 testing ************
		System.out.println("==================================");
		System.out.println("phase 1 testing");
		System.out.println("==================================");
		// testing the default constructor 
		GVdate today = new GVdate();
		assert today.getMonth() == 10 : "month should be 10"; 
		assert today.getDay() == 12 : "day should be 12";  
		assert today.getYear() == 2020 : "year should be 2020"; 
		
		// testing constructor 2
		GVdate theDay = new GVdate(1, 10, 1995);
		
		// testing setter methods 
		theDay.setMonth(8);
		assert theDay.getMonth() == 8;
		
		theDay.setDay(9);
		assert theDay.getDay() == 9;
		
		theDay.setYear(2020);
		assert theDay.getYear() == 2020;

		String stringTheDay = theDay.toString();
		assertEquals(stringTheDay, "8/9/2020");
		System.out.println("phase 1 testing done");
		
		//********** phase 2 testing ************
		System.out.println("==================================");
		System.out.println("phase 2 testing");
		System.out.println("==================================");
		//test for constructor 3
		GVdate stringDateInput = new GVdate("10/07/2020");
		assert theDay.getMonth() == 10;
		assert stringDateInput.getDay() == 7;
		assert stringDateInput.getYear() == 2020;
		
		GVdate d = new GVdate(1,31,1960);    
        d.setMonth(6);
        assert d.getMonth() != 6;
        
        //testing validity of constructor argument
        GVdate e = new GVdate(2,29,1961);
        assert e.getMonth() == 10;
		assert e.getDay() == 12;
		assert e.getYear() == 2020;
		
        //testing validity of constructor argument
        GVdate f = new GVdate(2,29,1960);    
        assertTrue(f.isLeapYear(f.getYear()));
        
        //testing validity of constructor argument
        GVdate g = new GVdate(2,28,1961);    
        assertFalse(g.isLeapYear(g.getYear()));
        
        //testing validity of the setters
        d.setDate(2,29,2020);
        assert d.getMonth() == 2;
		assert d.getDay() == 29;
		assert d.getYear() == 2020;
		
        d.setDate(2,30,2020);
        assert d.getMonth() == 2;
		assert d.getDay() == 29;
		assert d.getYear() == 2020;
        
        f.setDay(30);
        assert f.getDay() != 30;
        
        f.setDay(1);
        assert f.getDay() == 1;
        
        f.setYear(-1960);
        assert f.getYear() == 1960;
        
        f.setYear(1962);
        assert f.getYear() == 1960;
        
        f.setMonth(23);
        assert f.getMonth() == 2;
        assert true; f.setMonth(3);
        System.out.println("phase 2 testing done");
        
      //********** phase 3 testing ************
        System.out.println("==================================");
		System.out.println("phase 3 testing");
		System.out.println("==================================");
		
		System.out.println("Testing nextDay and dateFormat == 2");
		System.out.println("-----------------------------------");
		System.out.println("The current date: " + d.toString(2));
        d.nextDay();
        System.out.println("Tomorrow: " + d.toString(2));
        assert d.getMonth() == 3;
		assert d.getDay() == 1;
		assert d.getYear() == 2020;
		
		System.out.println("-----------------------------------");
		System.out.println("Testing skipDay");
		System.out.println("-----------------------------------");
        d.skipAhead(6);
        System.out.println("Six days after tomorrow: " + d.toString(2));
        assert d.getMonth() == 3;
		assert d.getDay() == 7;
		assert d.getYear() == 2020;
        
		System.out.println("-----------------------------------");
		System.out.println("Testing isLeapYear on 2020 and 1963");
		System.out.println("-----------------------------------");
		System.out.print("Is 2020 a leap year? ");
		if (d.isLeapYear(d.getYear())) {
			
			System.out.println("Yes!");
			
		} else {
			
			System.out.println("No!");
			
		}
		
        d.setDate(12,8,1963);
        System.out.println("The new date: " + d.toString(2));
        System.out.print("Is 1963 a leap year? ");
        if (d.isLeapYear(d.getYear())) {
			
			System.out.println("Yes!");
			
		} else {
			
			System.out.println("No!");
			
		}
        
        System.out.println("-----------------------------------");
        System.out.println("Testing the 4 dateFormats");
		System.out.println("-----------------------------------");
		System.out.println("Format 1: " + d.toString(1));
        assertEquals(d.toString(1), "12/8/1963");
        System.out.println("Format 2: " + d.toString(2));
        assertEquals(d.toString(2), "12/08/1963");
        System.out.println("Format 3: " + d.toString(3));
        assertEquals(d.toString(3), "Dec 8, 1963");
        System.out.println("Format 4: " + d.toString(4));
        assertEquals(d.toString(4), "December 8, 1963");
        
        System.out.println("-----------------------------------");
        System.out.println("Testing equals");
		System.out.println("-----------------------------------");
		System.out.println("Date One: " + d.toString(4));
        e.setDate(12,8,1963);
        System.out.println("Date Two: " + e.toString(4));
        assertTrue(e.equals(d));
        System.out.print("Are Date One and Two the same? ");
        if (e.equals(d)) {
        	
        	System.out.println("Yes!");
        	
        } else {
			
			System.out.println("No!");
			
		}
        e.setDate(12,21,1963);
        System.out.println("Date Three: " + e.toString(4));
        System.out.print("Are Date One and Three the same? ");
        if (e.equals(d)) {
        	
        	System.out.println("Yes!");
        	
        } else {
			
			System.out.println("No!");
			
		}
        
        System.out.println("-----------------------------------");
        System.out.println("Testing isMyBirthday method");
		System.out.println("-----------------------------------");
		System.out.print("Is my birthday April 12, 1996? ");
        GVdate date = new GVdate(4,12,1996);
        if (date.isMyBirthday()) {
        	
        	System.out.println("Yes!");
        	
        } else {
			
			System.out.println("No!");
			
		}
        assertTrue(date.isMyBirthday());
        
        System.out.print("Is my birthday December 21, 1963? ");
        if (e.isMyBirthday()) {
        	
        	System.out.println("Yes!");
        	
        } else {
			
			System.out.println("No!");
			
		}
        System.out.println("-----------------------------------");       
        System.out.println("phase 3 testing done");
        System.out.println("==================================");
		System.out.println ("Testing ends");
	}

}
