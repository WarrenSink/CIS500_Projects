/**
 * The SimpleDate class represents a simple date object with three fields - month, day, and year.
 * 
 * @author Warren Sink
 *
 */
import java.lang.Math; 

public class SimpleDate implements Comparable<SimpleDate> {

	private static final int MIN_YEAR = 1753; // minimum allowable year in a date
	
	private static final int NUM_MONTHS = 12;
	private static final int DAYS_YEAR = 365;
	private static final int DAYS_LEAP_YEAR = 366;
	
	// Stores number of days in each month in a non-leap year
	// DAYS_IN_MONTH[0] is not used since 1 <= month <= 12
	private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	//Stores number of days in February when in a leap year
	private static final int DAYS_IN_FEB_LEAP = 29;
	// Stores number of days lapsed to the beginning of each month since the beginning of the year (non-leap)
	// DAYS_THUS_FAR[0] is not used since 1 <= month <= 12
	private static final int[] DAYS_THUS_FAR = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
	//like DAYS_THUS_FAR except for leap years; I use it for ordinalDate() method in particular
	private static final int[] DAYS_THUS_FAR_LEAP = {0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
	// MONTH_NAMES[0] is not used since 1 <= month <= 12
	private static final String[] MONTH_NAMES = {"", "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
	
	public static enum DAY {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
	
	private int month;	// 1 <= month <= 12
	
	private int day;	// 1 <= day <= 31
	
	private int year;	// year >= 1753
	
	/**
	 * Constructs a SimpleDate object with month, day, and year field values set to 1, 1, and 1753 (1/1/1753).
	 */
	public SimpleDate() {
		this(1, 1, 1753);
	}
	
	/**
	 * Constructs a SimpleDate object with month, day, and year field values set to given argument values.
	 * 
	 * @param month month of the date
	 * @param day day of the date
	 * @param year year of the date
	 * 
	 * @throws IllegalArgumentException if argument values supplied do not represent a valid date
	 */
	public SimpleDate(int month, int day, int year) throws IllegalArgumentException {        
		// COMPLETE THIS METHOD
		
		
		if (!(isValidDate(month, day, year))) {
			
			throw new IllegalArgumentException("Date is not valid.");	
			
		} else {

			this.month = month;
			this.day = day;
			this.year = year;
			
		}
			
	}

	/**
	 * Returns the month of this date object.
	 * 
	 * @return month of this date
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Given an ordinal number as an argument, returns an ordinal number of the 
	 * opposite sign, -365 or -366 through 365 or 366, depending upon if a leap year, 
	 * which is the complement to the argument
	 * ex: argument = 20 (in leap year); returns: -346
	 * @return complement to ordinal number argument
	 */
	
	public int ordComplement(int ord) {
		
		if (isLeapYear(this.year)) {
			
			if (ord == 0) {
				
				return 0;
				
			} else if (ord > 0) {
				
				return ord - DAYS_LEAP_YEAR;
				
			} else {
				
				return ord + DAYS_LEAP_YEAR;
				
			}
			
		} else {
			
            if (ord == 0) {
				
				return 0;
				
			} else if (ord > 0) {
				
				return ord - DAYS_YEAR;
				
			} else {
				
				return ord + DAYS_YEAR;
				
			}
			
		}
		
	}
	
	/**
	 * Returns the month of an ordinal date when not a leap year
	 * @return month of ordinal date
	 */
	public static int monthOrd(int ord) {
		
		if (ord == 0) {
			
			return 1;
			
		} else if (ord < 0) {
			
			ord = ord + DAYS_YEAR + 1;
			
			if (ord <= (DAYS_THUS_FAR[1] + DAYS_IN_MONTH[1])) {
				
				return 1;
				
			} else if (ord <= (DAYS_THUS_FAR[2]+ DAYS_IN_MONTH[2])) {
				
				return 2;
				
			} else if (ord <= (DAYS_THUS_FAR[3] + DAYS_IN_MONTH[3])) {
				
				return 3;
				
			} else if (ord <= (DAYS_THUS_FAR[4]+ DAYS_IN_MONTH[4])) {
				
				return 4;
				
			} else if (ord <= (DAYS_THUS_FAR[5] + DAYS_IN_MONTH[5])) {
				
				return 5;
				
			} else if (ord <= (DAYS_THUS_FAR[6] + DAYS_IN_MONTH[6])) {
				
				return 6;
				
			} else if (ord <= (DAYS_THUS_FAR[7] + DAYS_IN_MONTH[7])) {
				
				return 7;
				
			} else if (ord <= (DAYS_THUS_FAR[8] + DAYS_IN_MONTH[8])) {
				
				return 8;
				
			} else if (ord <= (DAYS_THUS_FAR[9] + DAYS_IN_MONTH[9])) {
				
				return 9;
				
			} else if (ord <= (DAYS_THUS_FAR[10] + DAYS_IN_MONTH[10])) {
				
				return 10;
				
			} else if (ord <= (DAYS_THUS_FAR[11] + DAYS_IN_MONTH[11])) {
				
				return 11;
				
			} else if (ord <= (DAYS_THUS_FAR[12] + DAYS_IN_MONTH[12])) {
				
				return 12;
				
			} else {
				
				return 0;
				
			}
			
		} else {
			
			
			if (ord <= (DAYS_THUS_FAR[1] + DAYS_IN_MONTH[1])) {
				
				return 1;
				
			} else if (ord <= (DAYS_THUS_FAR[2]+ DAYS_IN_MONTH[2])) {
				
				return 2;
				
			} else if (ord <= (DAYS_THUS_FAR[3] + DAYS_IN_MONTH[3])) {
				
				return 3;
				
			} else if (ord <= (DAYS_THUS_FAR[4]+ DAYS_IN_MONTH[4])) {
				
				return 4;
				
			} else if (ord <= (DAYS_THUS_FAR[5] + DAYS_IN_MONTH[5])) {
				
				return 5;
				
			} else if (ord <= (DAYS_THUS_FAR[6] + DAYS_IN_MONTH[6])) {
				
				return 6;
				
			} else if (ord <= (DAYS_THUS_FAR[7] + DAYS_IN_MONTH[7])) {
				
				return 7;
				
			} else if (ord <= (DAYS_THUS_FAR[8] + DAYS_IN_MONTH[8])) {
				
				return 8;
				
			} else if (ord <= (DAYS_THUS_FAR[9] + DAYS_IN_MONTH[9])) {
				
				return 9;
				
			} else if (ord <= (DAYS_THUS_FAR[10] + DAYS_IN_MONTH[10])) {
				
				return 10;
				
			} else if (ord <= (DAYS_THUS_FAR[11] + DAYS_IN_MONTH[11])) {
				
				return 11;
				
			} else if (ord <= (DAYS_THUS_FAR[12] + DAYS_IN_MONTH[12])) {
				
				return 12;
				
			} else {
				
				return 0;
				
			}
			
		}
		
		
        
		
	}
	
	/**
	 * returns the day of the month of an ordinal number from 1 - 365
	 * @param ord number representing an ordinal
	 * @return day of month
	 */
    public int monthDayMod(int ord) {
    	
    	int dayValue = 0;
    	int finalValue = 0;
		
		if (ord == 0) {
			
			finalValue = DAYS_THUS_FAR[12] + 31;
			
		} else if (ord < 0) {
			
			ord = ord + DAYS_YEAR + 1;
			
			if (ord <= (DAYS_THUS_FAR[1] + DAYS_IN_MONTH[1])) {
				
				finalValue = ord;
				
			} else if (ord <= (DAYS_THUS_FAR[2] + DAYS_IN_MONTH[2])) {
				
				dayValue = (ord % DAYS_THUS_FAR[2]);
				
				if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[2];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[3] + DAYS_IN_MONTH[3])) {
				
				dayValue =  (ord % DAYS_THUS_FAR[3]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[3];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[4] + DAYS_IN_MONTH[4])) {
				
				dayValue = (ord % DAYS_THUS_FAR[4]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[4];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[5]+ DAYS_IN_MONTH[5])) {
				
				dayValue = (ord % DAYS_THUS_FAR[5]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[5];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[6] + DAYS_IN_MONTH[6])) {
				
				dayValue =  (ord % DAYS_THUS_FAR[6]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[6];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[7] + DAYS_IN_MONTH[7])) {
				
				dayValue =  (ord % DAYS_THUS_FAR[7]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[7];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[8] + DAYS_IN_MONTH[8])) {
				
				dayValue = (ord % DAYS_THUS_FAR[8]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[8];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[9] + DAYS_IN_MONTH[9])) {
				
				dayValue = (ord % DAYS_THUS_FAR[9]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[9];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[10] + DAYS_IN_MONTH[10])) {
				
				dayValue = (ord % DAYS_THUS_FAR[10]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[10];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[11] + DAYS_IN_MONTH[11])) {
				
				dayValue = (ord % DAYS_THUS_FAR[11]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[11];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord <= (DAYS_THUS_FAR[12] + DAYS_IN_MONTH[12])) {
				
				dayValue = (ord % DAYS_THUS_FAR[12]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[12];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else {
				
				finalValue = 0;
				
			}
			
		} else {
			
            if (ord <= (DAYS_THUS_FAR[1] + DAYS_IN_MONTH[1])) {
				
            	finalValue = ord;
				
			} else if (ord <= (DAYS_THUS_FAR[2] + DAYS_IN_MONTH[2])) {
				
				finalValue = ord % DAYS_THUS_FAR[2];
				
			} else if (ord <= (DAYS_THUS_FAR[3] + DAYS_IN_MONTH[3])) {
				
				dayValue =  ord % DAYS_THUS_FAR[3];
				
			} else if (ord <= (DAYS_THUS_FAR[4] + DAYS_IN_MONTH[4])) {
				
				finalValue = ord % DAYS_THUS_FAR[4];
				
			} else if (ord <= (DAYS_THUS_FAR[5]+ DAYS_IN_MONTH[5])) {
				
				finalValue = ord % DAYS_THUS_FAR[5];
				
			} else if (ord <= (DAYS_THUS_FAR[6] + DAYS_IN_MONTH[6])) {
				
				finalValue =  ord % DAYS_THUS_FAR[6];
				
			} else if (ord <= (DAYS_THUS_FAR[7] + DAYS_IN_MONTH[7])) {
				
				finalValue =  ord % DAYS_THUS_FAR[7];
				
			} else if (ord <= (DAYS_THUS_FAR[8] + DAYS_IN_MONTH[8])) {
				
				finalValue = ord % DAYS_THUS_FAR[8];
				
			} else if (ord <= (DAYS_THUS_FAR[9] + DAYS_IN_MONTH[9])) {
				
				finalValue = ord % DAYS_THUS_FAR[9];
				
			} else if (ord <= (DAYS_THUS_FAR[10] + DAYS_IN_MONTH[10])) {
				
				finalValue = ord % DAYS_THUS_FAR[10];
				
			} else if (ord <= (DAYS_THUS_FAR[11] + DAYS_IN_MONTH[11])) {
				
				finalValue = ord % DAYS_THUS_FAR[11];
				
			} else if (ord <= (DAYS_THUS_FAR[12] + DAYS_IN_MONTH[12])) {
				
				finalValue = ord % DAYS_THUS_FAR[12];
			}
			
		}
            
        
		return finalValue;
		
	}
	
    /**
     * returns the month during a leap year from an ordinal number from
     * 1 - 366
     * @param ord number representing an ordinal number
     * @return month of ord number
     */
    public static int monthOrdLeap(int ord) {
		
		if (ord == 0) {
			
			return 1;
			
		} else if (ord < 0) {
			
			ord = ord + DAYS_LEAP_YEAR + 1;
			
			if (ord <= (DAYS_THUS_FAR_LEAP[1] + DAYS_IN_MONTH[1])) {
				
				return 1;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[2] + DAYS_IN_FEB_LEAP)) {
				
				return 2;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[3] + DAYS_IN_MONTH[3])) {
				
				return 3;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[4] + DAYS_IN_MONTH[4])) {
				
				return 4;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[5] + DAYS_IN_MONTH[5])) {
				
				return 5;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[6] + DAYS_IN_MONTH[6])) {
				
				return 6;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[7] + DAYS_IN_MONTH[7])) {
				
				return 7;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[8]+ DAYS_IN_MONTH[8])) {
				
				return 8;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[9] + DAYS_IN_MONTH[9])) {
				
				return 9;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[10] + DAYS_IN_MONTH[10])) {
				
				return 10;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[11] + DAYS_IN_MONTH[11])) {
				
				return 11;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[12] + DAYS_IN_MONTH[12])) {
				
				return 12;
				
			} else {
				
				return 0;
				
			}
			
		} else {
			
			if (ord <= (DAYS_THUS_FAR_LEAP[1] + DAYS_IN_MONTH[1])) {
				
				return 1;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[2] + DAYS_IN_FEB_LEAP)) {
				
				return 2;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[3] + DAYS_IN_MONTH[3])) {
				
				return 3;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[4] + DAYS_IN_MONTH[4])) {
				
				return 4;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[5] + DAYS_IN_MONTH[5])) {
				
				return 5;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[6] + DAYS_IN_MONTH[6])) {
				
				return 6;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[7] + DAYS_IN_MONTH[7])) {
				
				return 7;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[8]+ DAYS_IN_MONTH[8])) {
				
				return 8;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[9] + DAYS_IN_MONTH[9])) {
				
				return 9;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[10] + DAYS_IN_MONTH[10])) {
				
				return 10;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[11] + DAYS_IN_MONTH[11])) {
				
				return 11;
				
			} else if (ord <= (DAYS_THUS_FAR_LEAP[12] + DAYS_IN_MONTH[12])) {
				
				return 12;
				
			} else {
				
				return 0;
				
			}
			
		}
		
		
        
		
	}
    
    
    /**
     * this static method will take an ordinal number from 1 - 366 and return
     * the day of the month which the ordinal represents
     * @param ord number representing an ordinal 
     * @return day in 
     */
    public static int monthDayModLeap(int ord) {
    	int dayValue = 0;
    	int finalValue = 0;
		
		if (ord == 0) {
			
			return 0;
			
		}  else if (ord < 0) {
			
			ord = ord + DAYS_LEAP_YEAR + 1;
			
			if (ord < (DAYS_THUS_FAR_LEAP[1] + DAYS_IN_MONTH[1] +1)) {

				finalValue = ord;
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[2] + DAYS_IN_FEB_LEAP +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[2]);
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_FEB_LEAP;
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[3] + DAYS_IN_MONTH[3] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[3]);
								
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[3];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[4]+ DAYS_IN_MONTH[4] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[4]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[4];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[5] + DAYS_IN_MONTH[5]+1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[5]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[5];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[6] + DAYS_IN_MONTH[6] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[6]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[6];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[7]+ DAYS_IN_MONTH[7] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[7]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[7];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[8]+ DAYS_IN_MONTH[8] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[8]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[8];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[9]+ DAYS_IN_MONTH[9] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[9]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[9];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[10] + DAYS_IN_MONTH[10] +1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[10]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[10];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[11] + DAYS_IN_MONTH[11]+1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[11]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[11];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[12] + DAYS_IN_MONTH[12]+1)) {
				
				dayValue = ord % (DAYS_THUS_FAR_LEAP[12]);
				
				
                if (dayValue == 0) {
					
					finalValue = DAYS_IN_MONTH[12];
					
				} else {
					
					finalValue = dayValue;
					
				}
				
			} else {
				
				finalValue = 0;
			}
			
		} else {
			
			if (ord < (DAYS_THUS_FAR_LEAP[1] + DAYS_IN_MONTH[1] +1)) {

				finalValue = ord;
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[2] + DAYS_IN_FEB_LEAP +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[2]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[3] + DAYS_IN_MONTH[3] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[3]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[4]+ DAYS_IN_MONTH[4] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[4]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[5] + DAYS_IN_MONTH[5]+1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[5]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[6] + DAYS_IN_MONTH[6] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[6]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[7]+ DAYS_IN_MONTH[7] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[7]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[8]+ DAYS_IN_MONTH[8] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[8]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[9]+ DAYS_IN_MONTH[9] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[9]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[10] + DAYS_IN_MONTH[10] +1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[10]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[11] + DAYS_IN_MONTH[11]+1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[11]);
				
			} else if (ord < (DAYS_THUS_FAR_LEAP[12] + DAYS_IN_MONTH[12]+1)) {
				
				finalValue = ord % (DAYS_THUS_FAR_LEAP[12]);
				
			} else {
				finalValue = 0; 
			}	
			
		}
		
		return finalValue;
		
	}

	/**
	 * Returns the day of this date object.
	 * 
	 * @return day of this date
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns the year of this date object.
	 * 
	 * @return year of this date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Tests if values provided for month, day, and year represent a valid date.
	 * 
	 * @param month month of date
	 * @param day day of date
	 * @param year year of date
	 * 
	 * @return true if valid date and false otherwise
	 */
	public static boolean isValidDate(int month, int day, int year) {
		// COMPLETE THIS METHOD
		if (!(isValidMonth(month))) {
			
			return false;
			
		} 
		
		if (!(isValidDay(month, day, year))) {
			
			return false;
			
		} 
		
        if (!(isValidYear(year))) {
			
			return false;
			
		}
		
		return true;
	}
    
	/**
	 * Tests if value for year is valid i.e. not less than
	 * minimum year
	 * @param year
	 * @return true if year is valid; otherwise, false
	 */
	public static boolean isValidYear(int year) {
		
		if (year < MIN_YEAR) {
			
			return false;
			
		} else {
			
			return true;
			
		}
				
	}
	
	/**
	 * Tests if value for month is valid
	 * @param month
	 * @return true if month is valid; otherwise, false
	 */
    public static boolean isValidMonth(int month) {
		
    	if (month < 1 || month  > NUM_MONTHS) {
    		
			return false;
			
		} else {
			
			return true;
			
		}
    	
		
	}
	
    /**
     * Tests if value for day is valid; checks for whether date
     * is within valid range of days for a particular month in a
     * given year (for February && Leap Years)
     * @param month 
     * @param day
     * @param year
     * @return true if day is valid; otherwise, false
     */
	public static boolean isValidDay(int month, int day, int year) {
		
		if (day < 1) {
			
			return false;
			
		} else {
			
			switch(month) {
			
            case 1:
				
				if (day <= DAYS_IN_MONTH[1]) {
					
					return true;
					
				} else {
					
					return false;
					
				}
			
			case 2:
				
				if (isLeapYear(year) == true) {
					
					if (day <= DAYS_IN_FEB_LEAP) {
						
						return true;
						
					} else {
						
						return false;
						
					} 
					
				} else {
					
                    if (day <= DAYS_IN_MONTH[2]) {
						
						return true;
						
					} else {
						
						return false;
						
					} 
					
				}
			
			case 3:
				
				if (day <= DAYS_IN_MONTH[3]) {
					
					return true;
					
				} else {
					
					return false;
					
				}
				
            case 4:
				
				if (day <= DAYS_IN_MONTH[4]) {
					
					return true;
					
				} else {
					
					return false;
					
				}	
				
            case 5:
				
				if (day <= DAYS_IN_MONTH[5]) {
					
					return true;
					
				} else {
					
					return false;
					
				}
			
            case 6:
					
				if (day <= DAYS_IN_MONTH[6]) {
						
					return true;
						
				} else {
						
					return false;
						
				}
				
            case 7:
				
				if (day <= DAYS_IN_MONTH[7]) {
					
					return true;
					
				} else {
					
					return false;
					
				}
				
            case 8:
				
				if (day <= DAYS_IN_MONTH[8]) {
					
					return true;
					
				} else {
					
					return false;
					
				}	
				
            case 9:
				
				if (day <= DAYS_IN_MONTH[9]) {
					
					return true;
					
				} else {
					
					return false;
					
				}
			
            case 10:
					
				if (day <= DAYS_IN_MONTH[10]) {
						
					return true;
						
				} else {
						
					return false;
						
				}
				
            case 11:
				
				if (day <= DAYS_IN_MONTH[11]) {
						
					return true;
						
				} else {
						
					return false;
						
				}
				
            case 12:
				
				if (day <= DAYS_IN_MONTH[12]) {
						
					return true;
						
				} else {
						
					return false;
						
				}
				
			default:
				
				return false;
			
			}
        	
		}
	
	}
	
	
	/**
	 * Tests if the year specified by argument is a leap year.
	 * 
	 * @param year year to test
	 * 
	 * @return true if year year is leap year, otherwise false
	 */
	public static boolean isLeapYear(int year) {
		// COMPLETE THIS METHOD
		if (year % 4 > 0) {
			
			return false;
			
		} else if (year % 400 == 0) {
			
			return true;
			
		} else if (year % 100 == 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	/**
	 * Tests if the year of this date object is a leap year.
	 * 
	 * @return true if year year is leap year, otherwise false
	 */
	public boolean isLeapYear() {
		return SimpleDate.isLeapYear(year);
	}
	
	/**
	 * Returns the number of days in a given month of a year.
	 * 
	 * @param month month
	 * @param year year
	 * 
	 * @return the number of days for the given month and year arguments
	 */
	public static int daysInMonth(int month, int year) {
		// COMPLETE THIS METHOD
		switch(month) {
		
        case 1:
			
			return DAYS_IN_MONTH[1];
		
		case 2:
			
			if (isLeapYear(year)) {
				
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
	
	/**
	 * Returns the number of days in a given year.
	 * 
	 * @param year year
	 * 
	 * @return the number of days in a given year
	 */
	public static int daysInYear(int year) {
		// COMPLETE THIS METHOD
		if (!(isLeapYear(year))) {
			
			return DAYS_YEAR;
			
		} else {
			
			return DAYS_LEAP_YEAR;
			
		}
	}
	
	/**
	 * Returns the number of days in year of this date object.
	 * 
	 * @return the number of days in year of this date object
	 */
	public int daysInYear() {
		return SimpleDate.daysInYear(year);
	}
	
	/**
	 * Returns the day (SUNDAY, MONDAY, etc.) representing the day of the week for this date object.
	 * 
	 * @return the day of the week for this date object
	 */
	public DAY dayOfWeek() {
		// COMPLETE THIS METHOD
		
		int newYear;
		int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		
		if (month < 3) {
			
			newYear = year - 1;
			
		} else {
			
			newYear = year;
			
		}
		
		int dayWeek = (newYear + (newYear/4) - (newYear/100) + (newYear/400) + t[month-1] + day) % 7;
		
	    return DAY.values()[dayWeek];
	    	
		
	}
	
	/**
	 * Returns the number of days elapsed (including this day) since January 1st.
	 * 
	 * @return the number of days elapsed (including this day) since January 1st
	 */
	public int ordinalDate() {
		// COMPLETE THIS METHOD
		
		if (isLeapYear(year)) {
			
			return DAYS_THUS_FAR_LEAP[month] + day;
			
		} else {
			
			return DAYS_THUS_FAR[month] + day;
			
		}
		

	}
	
	
	
	/**
	 * Returns a SimpleDate object representing the next date of this date object.
	 * 
	 * @return the next date of this date object
	 */
	public SimpleDate nextDate() {
		
		SimpleDate date = null;
		int newDay = 0;
		int newMonth = 0;
		int newYear = 0;
		
		// COMPLETE THIS METHOD
		if ((isLeapYear(year)) && month == 2 && day == DAYS_IN_FEB_LEAP) {
			
			newMonth = this.month + 1;
			newDay = 1;
			newYear = this.year;
			
		} else if ((isLeapYear(year)) && month == 2 && day == (DAYS_IN_FEB_LEAP - 1)) {
			
			newMonth = this.month;
			newDay = this.day + 1;
			newYear = this.year;
			
		} else if (day == DAYS_IN_MONTH[month] && month == 12) {
			
			newMonth = 1;
			newDay = 1;
			newYear = this.year + 1;
			
			
		} else if (day == DAYS_IN_MONTH[month]) {
			
			newMonth = this.month + 1;
			newDay = 1;
			newYear = this.year;
			
			
		} else {
			
			newMonth = this.month;
			newDay = this.day + 1;
			newYear = this.year;
	        
			
		}
		
		date = new SimpleDate(newMonth, newDay, newYear);
		return date;
        
		
	}
	
	/**
	 * Returns a SimpleDate object representing the previous date of this date object. It returns
	 * SimpleDate(1,1,1753) if this date object represents the 1/1/1753.
	 * 
	 * @return the previous date of this date object
	 */
	public SimpleDate prevDate() {
		SimpleDate date = null;
		int newDay = 0;
		int newMonth = 0;
		int newYear = 0;
		
		// COMPLETE THIS METHOD
		if (year == 1753 && day == 1 && month == 1) {
			
			
			newYear = this.year;
			newMonth = this.month;
			newDay = this.day;
			
		} else {
			
			if (day == 1) {
				
				if (month == 1) {
					
					newMonth = 12;
					newYear = this.year - 1;
					newDay = DAYS_IN_MONTH[newMonth];
					
				} else if (month == 3) {
					
					if (isLeapYear(year)) {
						
						newDay = DAYS_IN_FEB_LEAP;	
						
					} else {
						
						newDay = DAYS_IN_MONTH[2];
						
					}
					
					newMonth = 2;
					newYear = this.year;
					
				} else {
					
					newMonth = this.month - 1;
					newDay = DAYS_IN_MONTH[newMonth];
					newYear = this.year;
					
				}
				
				
			} else {
				
				newMonth = this.month;
				newDay = this.day - 1;
				newYear = this.year;
				
			}
			
		}
		
		date = new SimpleDate(newMonth, newDay, newYear);
		
		return date;
		
	}
	
	/**
	 * Returns a new SimpleDate object representing the date n days in future/past from this date object.
	 * If n &lt; 0, it returns the date n days in the past from this date object.
	 * If n &gt; 0, it returns the date n days in the future from this date object.
	 * If n = 0, it returns a a SimpleDate object whose field values are set to the field values of this date object.
	 * 
	 * @param n number of days in past (n &lt; 0) or future (n &gt; 0) from this date object
	 * 
	 * @return a SimpleDate object representing the date n days in future/past from this date object
	 */
	public SimpleDate dateFrom(int n) {
		// COMPLETE THIS METHOD
		int newYear;
		int newMonth;
		int newDay;
		
		int ordNumber = this.ordinalDate();
		int currentYearLength = daysInYear(year);
		
		SimpleDate minDate = new SimpleDate(1,1,1753);
		int thisLength = this.daysBetween(minDate);
		if (thisLength + n <= 0) {
			
			return minDate;
			
		} else if (n == 0) {
			
			SimpleDate date = new SimpleDate(month, day, year);
			return date;
			
		} else if (n > 0) {
			
			
			int newOrdNumber = ordNumber + n;
			
			int yearCounter = year;
			if (newOrdNumber > currentYearLength) {
				
				while (newOrdNumber > 0) {
					
					if (newOrdNumber - currentYearLength < 1) {
						
						newYear = yearCounter;
						
		                if (isLeapYear(yearCounter) == true) {
							
							newMonth = monthOrdLeap(newOrdNumber);
							
							newDay = monthDayModLeap(newOrdNumber);
							
			                SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
			                return date;
							
						} else {
							
							newMonth = monthOrd(newOrdNumber);
							
							newDay = monthDayMod(newOrdNumber);
							
			                SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
			                return date;
							
						}
						
					}
					
					newOrdNumber -= (currentYearLength);
					yearCounter += 1;
					currentYearLength = daysInYear(yearCounter);

				}
					
						
             } else {
				
				newYear = this.year;
				
				
				if (isLeapYear(newYear)) {
					
					newMonth = monthOrdLeap(newOrdNumber);
					
					newDay = monthDayModLeap(newOrdNumber);
					
				} else {
					
					newMonth = monthOrd(newOrdNumber);
					
					newDay = monthDayMod(newOrdNumber);
					
				}
				
				SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
                return date;
					
				
			}
			
			
			
		} else {
			
			int newOrdNumber = ordNumber + n;
			
			if (newOrdNumber <= 0) {
				
				newOrdNumber = newOrdNumber - 1;
				
			}
			
			
			
			if (newOrdNumber < 0) {
				
				int yearCounter = year - 1;
				currentYearLength = daysInYear(year);
				if (newOrdNumber < -Math.abs(currentYearLength)) {
					
					
					while (newOrdNumber < 0) {
						
						if (newOrdNumber + currentYearLength > -1) {
							
							newYear = yearCounter;
							
			                if (isLeapYear(yearCounter)) {
								
								newMonth = monthOrdLeap((newOrdNumber));
								
								newDay = monthDayModLeap(newOrdNumber);
								
								SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
				                return date;
								
							} else {
								
								newMonth = monthOrd((newOrdNumber));
								
								newDay = monthDayMod(newOrdNumber);
								
								SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
				                return date;
								
							}
			               
							
						}
						
						newOrdNumber += (currentYearLength);
						yearCounter = yearCounter - 1;
						currentYearLength = daysInYear(yearCounter);
						
					}
					
				} else {
					
					
					newYear = yearCounter;
					
					if (isLeapYear(yearCounter) == true) {
						
						newMonth = monthOrdLeap((newOrdNumber));
						
						newDay = monthDayModLeap((newOrdNumber));
						
					} else {
						
						newMonth = monthOrd((newOrdNumber));
						
						newDay = monthDayMod((newOrdNumber));
						
					}
	                
	                SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
	                return date;
					
				}
								
				
			} else {
				
				newYear = year;
				
                if (isLeapYear(newYear) == true) {
					
					newMonth = monthOrdLeap(newOrdNumber);
					
					newDay = monthDayModLeap(newOrdNumber);
					
				} else {
					
					newMonth = monthOrd(newOrdNumber);
					
					newDay = monthDayMod(newOrdNumber);
					
				}
				
                SimpleDate date = new SimpleDate(newMonth, newDay, newYear);
                return date;
                
			}
			
		}
		return this;
			
	}
	
	/**
	 * Changes the month, day, and year field values of this object appropriately to advance the date
	 * by number of days specified by the argument.
	 * If n &gt; 0, the current date is advanced forward. If n &lt; 0, the current date is moved backward.
	 * If n = 0, the current date is unchanged.
	 * 
	 * @param n number of days to advance (forward or backward) the current date
	 * 
	 * have to change the object to where object has been specified to advance to 
	 */
	public void advance(int n) {
		// COMPLETE THIS METHOD
		int ordNumber = this.ordinalDate();
		int currentYearLength = daysInYear(year);
		
		// COMPLETE THIS METHOD
		
		SimpleDate minDate = new SimpleDate(1,1,1753);
		int thisLength = this.daysBetween(minDate);
		if (thisLength + n <= 0) {
			
			this.year = minDate.year;
			this.day = minDate.day;
			this.month = minDate.month;
			
		} else if (n == 0) {
			
			this.month = month;
			this.day = day;
			this.year = year;
			
		} else if (n > 0) {
			
			
			int newOrdNumber = ordNumber + n;
			int yearCounter = year;
			if (newOrdNumber > currentYearLength) {
				
				while (newOrdNumber > 0) {
					
					
					if (newOrdNumber - currentYearLength < 1) {
						
						this.year = yearCounter;
						
						
		                if (isLeapYear(yearCounter) == true) {
							
		                	this.month = monthOrdLeap(newOrdNumber);
							
		                	this.day = monthDayModLeap(newOrdNumber);
							
						} else {
							
                            this.month = monthOrd(newOrdNumber);
		                	this.day = monthDayMod(newOrdNumber);
							
						}
						
					}
					
					newOrdNumber -= currentYearLength;
					yearCounter += 1;
					currentYearLength = daysInYear(yearCounter);
					


				}
					
						
             } else {
				
				this.year = year;
				
				
				if (isLeapYear(this.year) == true) {
					
					this.month = monthOrdLeap(newOrdNumber);
					
					this.day = monthDayModLeap(newOrdNumber);
					
				} else {
					
					this.month = monthOrd(newOrdNumber);
					
					this.day = monthDayMod(newOrdNumber);
					
				}
					
				
			}
			
			
			
		} else {
			
			int newOrdNumber = ordNumber + n;
			
			if (newOrdNumber <= 0) {
				
				newOrdNumber = newOrdNumber - 1;
				
			}

			if (newOrdNumber < 0) {

				int yearCounter = year - 1;
				currentYearLength = daysInYear(year);
				if (newOrdNumber < -Math.abs(currentYearLength)) {
					
					while (newOrdNumber < 0) {
						
						if (newOrdNumber >= -Math.abs(currentYearLength)) {
							
							
							this.year = yearCounter;
							
							
			                if (isLeapYear(yearCounter)) {
								
			                	this.month = monthOrdLeap(ordComplement(newOrdNumber));
								
			                	this.day = monthDayModLeap(newOrdNumber);
			                									
							} else {
								
								this.month = monthOrd(ordComplement(newOrdNumber));
								
								this.day = monthDayMod(newOrdNumber);
																
							}
			                
			                
							
						}
						
						newOrdNumber += currentYearLength;
						yearCounter = yearCounter - 1;
						currentYearLength = daysInYear(yearCounter);
						
					}
					
				} else {
					
					
					this.year = yearCounter;
					
					if (isLeapYear(yearCounter) == true) {
						
						this.month = monthOrdLeap(ordComplement(newOrdNumber));
						
						this.day = monthDayModLeap(newOrdNumber);
						
					} else {
						
						this.month = monthOrd(ordComplement(newOrdNumber));
						
						this.day = monthDayMod(newOrdNumber);
						
					}
	                
					
				}
								
				
			} else {
				
				
				this.year = year;
				
                if (isLeapYear(this.year) == true) {
					
					this.month = monthOrdLeap(newOrdNumber);
					this.day = monthDayModLeap(newOrdNumber);
					
				} else {
					
					this.month = monthOrd(newOrdNumber);
					
					this.day = monthDayMod(newOrdNumber);
					
				}
                
			}
					
		}
			
	}
	
	/**
	 * Returns the number of days between this date and the argument date (inclusive).
	 * 
	 * @param date date object to find the days between
	 * 
	 * @return the number of days between this date and the argument date (inclusive)
	 */
	public int daysBetween(SimpleDate date) {
		// COMPLETE THIS METHOD
		
		int thisOrdinal = this.ordinalDate();
		int argOrdinal = date.ordinalDate();
		int yearDiff = this.year - date.year;
				
		if (yearDiff == 0) {
			
			int dayCounter = Math.abs(thisOrdinal - argOrdinal);
			
			return dayCounter;
			
		} else if (yearDiff < 0) {
			
			int dayCounter = 0;
			
			if (isLeapYear(this.year)) {
				
				dayCounter += DAYS_LEAP_YEAR - thisOrdinal;
				
			} else {
				
				dayCounter += DAYS_YEAR - thisOrdinal;
				
			}
            
			dayCounter += argOrdinal;
			
			yearDiff = Math.abs(yearDiff) - 1;
			if (yearDiff != 0) {
				
				int counter = 1;
				for (int i = 0; i < yearDiff; i++) {
					
					int newYear = this.year + counter;
					
	                if (isLeapYear(newYear)) {
						
	                	dayCounter += DAYS_LEAP_YEAR;
						
					} else {
						
						dayCounter += DAYS_YEAR;
						
					}
					
					counter ++;
					
				}
				
			}
			
			return dayCounter;
			
		} else {
						
			int dayCounter = 0;
			
            if (isLeapYear(date.year)) {
				
				dayCounter += DAYS_LEAP_YEAR - argOrdinal;
				
			} else {
				
				dayCounter += DAYS_YEAR - argOrdinal;
				
			}

			dayCounter += thisOrdinal;
			
			yearDiff -= 1;
			if (yearDiff != 0) {
				
				int counter = 1;
				for (int i = 0; i < yearDiff; i++) {
					
					int newYear = this.year - counter;
					
					
					if (!(isLeapYear(newYear))) {
						
						dayCounter += DAYS_YEAR;
						
					} else {
						
						dayCounter += DAYS_LEAP_YEAR;
						
					}
				
					counter ++;
					
				}
				
			}
			
			return dayCounter;

			
		}
		
	}

	@Override
	/**
	 * Compares this SimpleDate object to the argument object.
	 * 
	 * @param obj The object to compare this SimpleDate against.
	 * 
	 * @return true if the given object represents a SimpleDate equivalent to this SimpleDate, false otherwise.
	 */	
	public boolean equals(Object obj) {
		// COMPLETE THIS METHOD
		//check if the argument is a reference to this object
        if (this == obj){
            
            return true;
        
        }
        
        //check if the argument has the correct type
        if (!(obj instanceof SimpleDate)) {
        	
        	return false;
        	
        }
        
        //cast the argument to the correct type
        SimpleDate other = (SimpleDate) obj;
        
        //check if ranks are equal
        if (!(month == other.month)){
            
            return false;
        
        }
        
        //check if suits are equal
        if (!(day == other.day)){
            
            return false;
        
        }
        
      //check if suits are equal
        if (!(year == other.year)){
            
            return false;
        
        }
        
        return true;
		
	}

	@Override
	/**
	 * Returns a String object representing this SimpleDate's value.
	 * 
	 * @return a string representation of the value of this SimpleDate object
	 * in the form "monthname dd, yyyy". For example: "March 10, 2010"
	 */
	public String toString() {
		return String.format("%s %d, %d", MONTH_NAMES[month], day, year);
	}

	@Override
	/**
	 * Compares two SimpleDate objects for relative ordering.
	 * 
	 * @param other the SimpleDate object to be compared.
	 * 
	 * @return the value 0 if this SimpleDate is equal to the argument SimpleDate;
	 * a value less than 0 if this SimpleDate comes before the argument SimpleDate;
	 * and a value greater than 0 if this SimpleDate comes after the argument SimpleDate.
	 */
	public int compareTo(SimpleDate other) {
		// COMPLETE THIS METHOD
		SimpleDate minDate = new SimpleDate(1,1,1753);
		
		int thisLength = this.daysBetween(minDate);
		int otherLength = other.daysBetween(minDate);
		
		if (thisLength > otherLength) {
			
			return 1;
			
		} else if (thisLength < otherLength) {
			
			return -1;
			
		} else {
			
			return 0;
			
		}
		
	}
	
}
