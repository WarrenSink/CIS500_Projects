import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class CovidDatabase {

	/*
	 * instance variables
	 */
	private ArrayList<CovidEntry> covidDatabase;
	private static final int SAFE = 5;
	
	/*
	 * constructor; instantiates ArrayList of CovidEntry Objects
	 */
	public CovidDatabase() {
		
		this.covidDatabase = new ArrayList<CovidEntry>();
		
	}

	/**
	 * reads covid_data.csv file
	 * @param filename
	 */
	public void readCovidData(String filename) {
		
		Scanner inFS = null;
		FileInputStream fileByteStream = null;
		String currentPath = System.getProperty("user.dir");
		try{
			// open the File and set delimiters 
			fileByteStream = new FileInputStream(currentPath + "/src/" + filename); 
			inFS = new Scanner(fileByteStream);
			inFS.useDelimiter("[,\r\n]+");

			// continue while there is more data to read 
			int count = 0;
			while(inFS.hasNext()) {
				// read data elements
				
				if (count == 0) {
					
					count++;
					inFS.nextLine();
					continue;
					
				} else {
				
					String st = inFS.next();
					int m = inFS.nextInt(); 
					int d = inFS.nextInt();
					int di = inFS.nextInt();
					int dd = inFS.nextInt();
					int ti = inFS.nextInt();
					int td = inFS.nextInt();
					CovidEntry newCovidEntry = new CovidEntry(st, m, d, di, dd, ti, td);
					covidDatabase.add(newCovidEntry);
					
				}
				
			} fileByteStream.close();
			
			// error while reading the file
			} catch (InputMismatchException e) {
	            System.out.println("Please give an integer!");
	        } catch(IOException error1) {
		        	 
		        	 System.out.println("Oops! Error related to: " + filename);
		        	 
		        	 }
		
		
	}
	
	/**
	 * returns the number of records in the CovidDatabase
	 * @return
	 */
	public int countRecords() {
		
		return this.covidDatabase.size();
		
	}
	

	/**
	 * returns the number of deaths in the CovidDatabase 
	 * @return sum
	 */
	public int getTotalDeaths() {
		
		int sum = 0;
		for (CovidEntry covidEntry : covidDatabase) {
			
			int dd = covidEntry.getDailyDeaths();
			sum += dd;
			
		}
		return sum;
		
	}
	
	/**
	 * returns the number of infections in the CovidDatabase 
	 * @return sum
	 */
	public int getTotalInfections() {
		
		int sum = 0;
		for (CovidEntry covidEntry : covidDatabase) {
			
			int di = covidEntry.getDailyInfections();
			sum += di;
			
		}
		return sum;
		
	}
	
	/**
	 * returns the number of deaths in the CovidDatabase 
	 * on a certain day
	 * @param m
	 * @param d
	 * @return sum
	 */
	public int countTotalDeaths(int m, int d) {
		
		
		int sum = 0;
		for (CovidEntry covidEntry : covidDatabase) {
			
			
			if (covidEntry.getMonth() == m && covidEntry.getDay() == d) {
				
				int dd = covidEntry.getDailyDeaths();
				sum += dd;	
				
			} else {
				
				break;
				
			}
			
		}
		return sum;
		
	}
	
	/**
	 * returns the number of infections in the CovidDatabase 
	 * on a certain day
	 * @param m
	 * @param d
	 * @return sum
	 */
	public int countTotalInfections(int m, int d) {
		
		
		int sum = 0;
		for (CovidEntry covidEntry : covidDatabase) {
			
			
			if (covidEntry.getMonth() == m && covidEntry.getDay() == d) {
				
				sum += covidEntry.getDailyInfections();
				//sum += di;	
				
			} else {
				
				continue;
				
			}
			
		}
		return sum;
		
	}
	
	/**
	 * returns the CovidEntry of a particular state with its most
	 * deadly date
	 * @param st
	 * @return CovidEntry
	 */
	public CovidEntry peakDailyDeaths(String st) {
		
		CovidEntry peak = null;
		for (CovidEntry covidEntry : covidDatabase) {
			
			
			if (covidEntry.getState().equalsIgnoreCase(st)) {
				
				if (peak == null) {
					
					peak = covidEntry;
					
				} else {
					
					if(covidEntry.getDailyDeaths() > peak.getDailyDeaths()) {
						
						peak = covidEntry;
						
					}
					
				}
				
			} else {
				
				continue;
				
			}
			
		}
		return peak;
		
	}
	
	/**
	 * returns the CovidEntry on a particular date with its most
	 * deadly state
	 * @param m
	 * @param d
	 * @return CovidEntry
	 */
	public CovidEntry peakDailyDeaths(int m, int d) {
		
		CovidEntry peak = null;
		for (CovidEntry covidEntry : covidDatabase) {
			
			
			if (covidEntry.getMonth() == m && covidEntry.getDay() == d) {
				
				if (peak == null) {
					
					peak = covidEntry;
					
				} else {
					
					if(covidEntry.getDailyDeaths() > peak.getDailyDeaths()) {
						
						peak = covidEntry;
						
					}
					
				}
				
			} else {
				
				continue;
				
			}
			
		}
		return peak;
		
	}

	/**
	 * returns an ArrayList of CovidEntry Objects on a particular date
	 * @param m
	 * @param d
	 * @return CovidEntry
	 */
	public ArrayList<CovidEntry> getDailyDeaths(int m, int d){
		
        ArrayList<CovidEntry> dailyDeaths = new ArrayList<CovidEntry>();
		for (CovidEntry covidEntry : covidDatabase) {
			
			
			if (covidEntry.getMonth() == m && covidEntry.getDay() == d) {
				
				dailyDeaths.add(covidEntry);
				
			} else {
				
				continue;
				
			}
			
		}
		return dailyDeaths;
		
	}
	

	/**
	 * returns the CovidEntry with the most total deaths
	 * @return CovidEntry
	 */
	public CovidEntry mostTotalDeaths() {
		
		CovidEntry entryHighestTotalDeaths = null;
	    for (CovidEntry covidEntry: covidDatabase) {
			
			if (entryHighestTotalDeaths == null) {
				
				entryHighestTotalDeaths = covidEntry;
				
			} else {
				
				if (covidEntry.getTotalDeaths() > entryHighestTotalDeaths.getTotalDeaths()) {
					
					entryHighestTotalDeaths = covidEntry;
					
					}
			 }
			
		}
	    return entryHighestTotalDeaths;
		
		
	}
	
	
	
	/**
	 * returns an ArrayList of CovidEntry Objects with minimum number
	 * of infections
	 * @param m
	 * @param d
	 * @param min
	 * @return
	 */
	public ArrayList<CovidEntry> listMinimumDailyInfections(int m, int d, int min) {
		
		ArrayList<CovidEntry> minDailyInfections = new ArrayList<CovidEntry>();
		for (CovidEntry covidEntry : covidDatabase) {
			
			if (covidEntry.getMonth() == m && 
				covidEntry.getDay() == d && 
				covidEntry.getDailyInfections() >= min) {
				
				minDailyInfections.add(covidEntry);
				
			}
			
		}
		ArrayList<CovidEntry> minDailyInfectionsSorted = new ArrayList<CovidEntry>();
		Collections.sort(minDailyInfections);
		minDailyInfectionsSorted.addAll(minDailyInfections);
		return minDailyInfectionsSorted;
		
	}
	
	

	/**
	 * returns an ArrayList of 5 CovidEntry Objects from particular state
	 * of the first occurrence of 5 days with decreasing infections
	 * @param st
	 * @return ArrayList<CovidEntry>
	 */
	public ArrayList<CovidEntry> safeToOpen(String st){
		

		
		ArrayList<CovidEntry> safeToOpen = new ArrayList<CovidEntry>();
		CovidEntry previousEntry = null;
				
		int counter = 0;
		for (CovidEntry covidEntry : covidDatabase) {
			
			if (st.toUpperCase().equals(covidEntry.getState())) {
				
				if (previousEntry == null) {
					
					previousEntry = covidEntry;
					
				} else {
										
					if (covidEntry.getDailyInfections() < previousEntry.getDailyInfections()) {
						
						counter ++;
						
						if (safeToOpen.size() == 0) {
							
							counter ++;
							safeToOpen.add(previousEntry);
							safeToOpen.add(covidEntry);
							
						} else {
							
							safeToOpen.add(covidEntry);
							
						}
												
						if (counter == SAFE) {
							
							return safeToOpen;
							
						}
						
					} else {
						
						counter = 0;
						safeToOpen.clear();
						
					}
					
				}
				
				previousEntry = covidEntry;
				
			}
			
		}
		safeToOpen = null;
		return safeToOpen;
		
	}
	
	/**
	 * returns an ArrayList of 10 CovidEntry Objects on a particular date
	 * sorted from greatest to least corresponding to the overall greatest
	 * amount of deaths, state-wise
	 * @param m
	 * @param d
	 * @return ArrayList<CovidEntry>
	 */
	public ArrayList<CovidEntry> topTenDeaths(int m,int d){
		
		ArrayList<CovidEntry> topTenDeaths;
		topTenDeaths = getDailyDeaths(m , d);
		
		if (topTenDeaths.size() - 1 == -1) {
			
			return topTenDeaths;
			
		} else {
			
			Collections.sort(topTenDeaths);
			List<CovidEntry> rmCovidEntry = topTenDeaths.subList(9, topTenDeaths.size() - 1);
			topTenDeaths.removeAll(rmCovidEntry);
			return topTenDeaths;
			
		}

	}
	
	

	
	
}
