import java.text.DecimalFormat;

public class CovidEntry implements Comparable{
	
	/*
	 * instance variables for Covid Entry object
	 */
	private String st;
	private int m;
	private int d;
	private int di;
	private int dd;
	private int ti;
	private int td;
	
	DecimalFormat fmt = new DecimalFormat("#,###");
	
	/*
	 * constructor for covid entry --- a row in the spreadsheet
	 */
	public CovidEntry(String st,int m,int d,int di,int dd, int ti, int td){
		
		this.st = st;
		this.m = m;
		this.d = d;
		this.di = di;
		this.dd = dd;
		this.ti = ti;
		this.td = td;
		
	}
	
	/*
	 * returns month
	 */
	public int getMonth() {
		
		return m;
		
	}
	
	/*
	 * returns month
	 */
	public int getDay() {
		
		return d;
		
	}
	
	/*
	 * returns month
	 */
	public String getState() {
		
		return st;
		
	}
	
	/*
	 * returns month
	 */
	public int getDailyInfections() {
		
		return di;
		
	}
	
	/*
	 * returns month
	 */
	public int getDailyDeaths() {
		
		return dd;
		
	}
	
	/*
	 * returns month
	 */
	public int getTotalInfections() {
		
		return ti;
		
	}
	
	/*
	 * returns month
	 */
	public int getTotalDeaths() {
		
		return td;
		
	}
	
	/* 
	 * returns String representation of CovidEntry object
	 */
	public String toString() {
		
		return st + " " + m + "/" + d + " " + fmt.format(di) + " infections, " +
		fmt.format(dd) + " deaths";
		
	}
	
	/**
	 * @Override
	 * overrides the CompareTo method for the purpose of sorting
	 * CovidEntry objects
	 */
	public int compareTo (Object other) {
		
		CovidEntry c = (CovidEntry) other;
		return c.dd - this.dd;
		
	}

	
}
