/*****************************************************************
Represents a modifiable date of positive integer years  

@author Warren Sink
@version Fall 2020
*****************************************************************/


public class GVdate {

	/** holds current value for month value */
	private static final int NUM_MONTHS = 12;
	
	/** holds current value for month value */
	private static final int DAYS_YEAR = 365;
	
	/** holds current value for month value */
	private static final int DAYS_LEAP_YEAR = 366;
	
	/** Stores number of days in each month in a non-leap year
	 * DAYS_IN_MONTH[0] is not used since 1 <= month <= 12 */
	private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**Stores number of days in February when in a leap year*/
	private static final int DAYS_IN_FEB_LEAP = 29;
	
	/** MONTH_NAMES[0] is not used since 1 <= month <= 12*/
	private static final String[] MONTH_NAMES = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"July", "August", "September", "October", "November", "Dec"};
	
	/** holds current value for month value */
	private int m; 
	
	/** holds current value for day value */
	private int d; 
	
	/** holds current value for year value */
	private int y; 
	
	
	/******************************************************************
	 * Default GVdate constructor for when no arguments are input
	 *****************************************************************/
    public GVdate() {
		
		this(10, 12, 2020);
		
	}
    
    /******************************************************************
     * This GVdate constructor allows a user to 
     * @param m month
     * @param d day
     * @param y year
     *****************************************************************/
    public GVdate(int m, int d, int y) {
		
    	//test for whether date is valid given the arguments
    	if (!(isDateValid(m, d, y))) {
    		
    		//if not valid, returns an object with these values
    		setDate(10, 12, 2020);
    		
    	} else {
    		
    		//if date is valid, sets object values to arguments
    		setDate(m, d, y);
    		
    	}
    	
	}
    
    /******************************************************************
     * This GVdate constructor takes a String as an argument, parses the
     * contents, and returns a GVdate object
     * @param date
     *****************************************************************/
    public GVdate(String date) {
    	
    	//get length of date string
    	int dateLength = date.length();
    	
    	/* get index of first slash and parse integer with Integer method
    	and substring to create the integer variable month which will
    	be input to setDate() */
    	int firstSlash = date.indexOf ("/");
    	int m = Integer.parseInt (date.substring (0, firstSlash));
    	
    	/* similar instructions as above except updating the indices for 
    	the day */
    	String dateParedOne = date.substring(firstSlash+1, dateLength);
    	int secondSlash = dateParedOne.indexOf ("/");
    	int d = Integer.parseInt (dateParedOne.substring (0, secondSlash));
    	
    	//now, the year
    	dateLength = dateParedOne.length();
    	String dateParedTwo = dateParedOne.substring(secondSlash+1, dateLength);
    	int y = Integer.parseInt (dateParedTwo.substring(0));
    	
    	//finally, we set the date with the proper data types
        if (!(isDateValid(m, d, y))) {
    		
    		setDate(10, 12, 2020);
    		
    	} else {
    		
    		setDate(m, d, y);
    		
    	}
    	
    }
    
    
    /******************************************************************
     * Sets the private field of month, day, and year 
     * @param m month
     * @param d day
     * @param y year
     *****************************************************************/
    public void setDate(int m, int d, int y) {
    	
    	//tempDay holds current value for day
    	int tempDay = this.d;
    	
    	//modifies current day value to argument value for testing 
    	//hypothetical validity (if this day, is date valid)
    	this.d = d;
    	
    	//test for validity of the day given day argument value
    	if (!(isDateValid(m, d, y))) {
    		    		
    		//if argued date is invalid, re-modify current day value to
    		//what it was previously
    		this.d = tempDay;
    		
    	} else {
    		
    		//if date is valid, set current year and month values to
    		//argument values
    		this.setYear(y);
    		this.setMonth(m);
    		
    	}
    	
    }
    
    /******************************************************************
     * getter for month field
     * @return month
     *****************************************************************/
    public int getMonth() {
    	
    	return this.m;
    	
    }
    
    /******************************************************************
     * setter for month field
     * @param m month
     * @param d day
     *****************************************************************/
    public void setMonth(int m) {
    	
    	//tests for whether month argument is valid
    	if (!(isValidMonth(m, this.y))) {
    		
    		System.out.println("Invalid month");
    		
    	} else {
    		
    		//if argument is valid, set month to value
    		this.m = m;
    		
    	}
    	
    }
    
    /******************************************************************
     * getter for day
     * @return day
     *****************************************************************/
    public int getDay() {
    	
    	return this.d;
    	
    }
    
    /******************************************************************
     * setter for day
     * @param d day
     *****************************************************************/
    public void setDay(int d) {
    	
    	if (!(isValidDay(this.m, d, this.y))) {
    		
    		System.out.println("Invalid day");
    		
    	} else {
    		
    		this.d = d;	
    		
    	}
    	
    }
    
    /******************************************************************
     * getter for year
     * @return year 
     *****************************************************************/
    public int getYear() {
    	
    	return this.y;
    	
    }
    
    /******************************************************************
     * setter for year
     * @param y year
     *****************************************************************/
    public void setYear(int y) {
    	
    	if (!(isValidYear(y))) {
    		
    		System.out.println("Invalid year");
    		
    	} else {
    		
    		this.y = y;
    		
    	}
    	
    }
    
    
    /******************************************************************
	 * Tests if the year specified by argument is a leap year.
	 * @param year year to test
	 * @return true if year year is leap year, otherwise false
	 *****************************************************************/
    public boolean isLeapYear(int y) {
    	
		if (y % 4 > 0) {
			
			return false;
			
		} else if (y % 400 == 0) {
			
			return true;
			
		} else if (y % 100 == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
    	
    }
	
	
	/******************************************************************
	 * static method which prevents repeating code in the methods
	 * determining the validity of a date; year argument necessary
	 * to detect leap years
	 * @param m month
	 * @param y year
	 * @return the last day of the month 
	 *****************************************************************/
	private int getLastDayOfMonth(int m, int y) {

		//get last day of month depending upon argument with a check 
		//for leap years
		switch(m) {
		
        case 1:
			
			return DAYS_IN_MONTH[1];
		
		case 2:
						
			if (isLeapYear(y)) {
								
				return DAYS_IN_FEB_LEAP;
									
			} else {
				 				
                return DAYS_IN_MONTH[2];
					
			}
		
		case 3:
			
			return DAYS_IN_MONTH[3];
			
        case 4:
			
			return DAYS_IN_MONTH[4];	
			
        case 5:
			
			return DAYS_IN_MONTH[5];
		
        case 6:
				
			return DAYS_IN_MONTH[6];
			
        case 7:
			
			return DAYS_IN_MONTH[7];
			
        case 8:
			
			return DAYS_IN_MONTH[8];	
			
        case 9:
			
			return DAYS_IN_MONTH[9];
		
        case 10:
				
			return DAYS_IN_MONTH[10];
			
        case 11:
			
			return DAYS_IN_MONTH[11];
			
        case 12:
			
			return DAYS_IN_MONTH[12];
			
		default:
			
			return DAYS_IN_MONTH[0];
		
		}
			
	}
	
	/******************************************************************
	 * Returns a boolean value relating whether the date is valid given
	 * certain constraints (eg minimum year). If day is valid, month is 
	 * valid.
	 * @param m month
	 * @param d day
	 * @param y year
	 * @return true or false
	 *****************************************************************/
	private boolean isDateValid(int m, int d, int y) {

		//test for whether the day is invalid
		if (!(isValidDay(m, d, y))) {
						
			return false;
			
		}
		
		//test for whether the year is invalid
        if (!(isValidYear(y))) {
        				
			return false;
			
		}
		
        //if both tests fail, date is valid
		return true;
	}
    
	/******************************************************************
	 * Tests if value for year is valid i.e. not less than
	 * minimum year
	 * @param year
	 * @return true if year is valid; otherwise, false
	 *****************************************************************/
	private boolean isValidYear(int year) {
		
		//checks for whether year is negative
		//if not year is valid
		if (year < 1) {
			
			return false;
			
		} else {
			
			return true;
			
		}
				
	}
	
	/******************************************************************
	 * Tests if value for month is valid
	 * @param month 
	 * @param year 
	 * @return true if month is valid; otherwise, false
	**************************************************************** */
    private boolean isValidMonth(int month, int year) {
    	
    	//makes sure month is between 1 and 12
    	if (month < 1 || month  > NUM_MONTHS) {
    		
			return false;
			
		} else if (this.d > getLastDayOfMonth(month, year)) {
			
			return false;
			
		} else {
			
			return true;
			
		}
    	
		
	}
	
    /******************************************************************
     * Tests if value for day is valid; checks for whether date
     * is within valid range of days for a particular month in a
     * given year (for February && Leap Years)
     * @param month 
     * @param day
     * @param year
     * @return true if day is valid; otherwise, false
     *****************************************************************/
	private boolean isValidDay(int m, int d, int y) {
		
		//test if day is negative
		if (d < 1) {
			
			return false;
			
		} else {		
			
			//if day is not negative, test if day is not larger than
			//the number of days in the month
			if (!(d <= getLastDayOfMonth(m, y))) {
				
				return false;
				
			} else {
				
				return true;
				
			}
        	
		}
	
	}
    
    
    /******************************************************************
     * returns true or false depending upon whether the GVdate object
     * represents my birthday
     * @return true / false
     *****************************************************************/
    public boolean isMyBirthday(){
    	
    	//check for whether date is April 12, 1996
    	if(m == 4 && d == 12 && y == 1996) {
    		
    		return true;
    		
    	} else {
    		
    		return false;
    		
    	}
    	
    } 
    
	/******************************************************************
	 * Returns a SimpleDate object representing the next date of this 
	 * date object.
	 * @return the next date of this date object
	 *****************************************************************/
	public void nextDay() {
		
		
		//goes through a series of checks to figure out whether day is at the extremes
		//of month or year
		if ((isLeapYear(y)) && m == 2 && d == DAYS_IN_FEB_LEAP) {
			
			this.m = m + 1;
			this.d = 1;
			this.y = this.y;
			
		} else if ((isLeapYear(y)) && m == 2 && d == (DAYS_IN_FEB_LEAP - 1)) {
			
			this.m = this.m;
			this.d = this.d + 1;
			this.y = this.y;
			
		} else if (d == DAYS_IN_MONTH[m] && m == 12) {
			
			this.m = 1;
			this.d = 1;
			this.y = this.y + 1;
			
			
		} else if (d == DAYS_IN_MONTH[m]) {
			
			this.m = this.m + 1;
			this.d = 1;
			this.y = this.y;
			
			
		} else {
			
			this.m = this.m;
			this.d = this.d + 1;
			this.y = this.y;
	        
			
		}        
		
	}
	
	/******************************************************************
	 * Returns the number of days in a given year.
	 * 
	 * @param year year
	 * 
	 * @return the number of days in a given year
	 *****************************************************************/
	public int daysInYear(int y) {
		// test for whether year is leap year
		if (!(isLeapYear(this.y))) {
			
			return DAYS_YEAR;
			
		} else {
			
			return DAYS_LEAP_YEAR;
			
		}
	}
	
	
	/******************************************************************
	 * Modifies the current GVdate object's month, day, and year if 
	 * argument is positive
	 * @param numDays
	 *****************************************************************/
	public void skipAhead(int numDays) {
		
		//checks for whether argument is a positive number
		if (numDays > 0) {
			
			int numDaysLeft = numDays;
			while (numDaysLeft > 0){
				
				nextDay();
				numDaysLeft -= 1;
				
			}
			
		} else {
			
			System.out.println("Enter a positive number of days to skip.");
			
		}
		
	}
	
	/******************************************************************
	 * Returns true or false depending upon whether the argument GVdate 
	 * object has month, day, and year fields which are equal to the 
	 * GVdate object compared to
	 * @param otherDate
	 * @return true or false
	******************************************************************/
	public boolean equals(GVdate otherDate) {
		
		
		if (this.m == otherDate.m && this.d == otherDate.d && this.y == otherDate.y) {
			
			return true;
			
			
		} else {
			
			return false;
			
		}
		
	}
	
	
	/******************************************************************
     * Converts GVdate object into String object
     *****************************************************************/
    public String toString() {
    	
    	//for when no argument is input
    	return String.format("%d/%d/%s", m, d, y);
    	
    }
	
    
    /******************************************************************
     * Converts GVdate object into String object
     * @param format 
     *****************************************************************/
    public String toString(int format) {
    	
    	//test for what format user wants
    	if (format == 1) {
    		    		
    		return String.format("%d/%d/%s", m, d, y);
    		
    	} else if (format == 2) {
    		
    		
    		return String.format("%02d/%02d/%04d", m, d, y);
    		
    	} else if (format == 3) {
    		    		
    		return String.format("%s %d, %04d", MONTH_NAMES[m], d, y);
    		
    	} else if (format == 4) {
    		
    		//returns string with appropriate months
    		switch(m) {
    		
    		case 1:
    			
    			return String.format("January %d, %04d", d, y);
    			    			
    		case 2:
    			
    			return String.format("February %d, %04d", d, y);
    			
    		case 3:
    			
    			return String.format("March %d, %04d", d, y);
    			
    		case 4:
    			
    			return String.format("April %d, %04d", d, y);
    			
    		case 5:
    			
    			return String.format("May %d, %04d", d, y);
    			
    		case 6:
    			
    			return String.format("June %d, %04d", d, y);
    			
    		case 7:
    			
    			return String.format("July %d, %04d", d, y);
    			
    		case 8:
    			
    			return String.format("August %d, %04d", d, y);
    			
    		case 9:
    			
    			return String.format("September %d, %04d", d, y);
    			
    		case 10:
    			
    			return String.format("October %d, %04d", d, y);
    			
    		case 11:
    			
    			return String.format("November %d, %04d", d, y);
    			
    		default:
    			
    			return String.format("December %d, %04d", d, y);
    		
    		}
    		
    	} else {
    		
    		return null;
    		
    	}
    	
    	
    }
    
    
    
    
   
    
    
    

}
