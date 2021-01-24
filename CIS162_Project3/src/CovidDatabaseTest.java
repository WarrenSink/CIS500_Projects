import static org.junit.Assert.*;
import java.util.*;
import java.util.ArrayList;
import org.junit.*;

public class CovidDatabaseTest {
	
	public static void main(String[] args) {

		
		ArrayList <Integer> arrayInt = new ArrayList <Integer>();
		arrayInt.add(20);
		boolean vrai = isValuefound(arrayInt, 2);
		System.out.println(vrai);
		
		int f = 89;
		int c = (int) ((5 / (double) 9) *(f - 32));
		System.out.println("c: " + c);
		
		
		boolean isOK = true;
		boolean isFound = false;
		boolean result = !(isOK || !isFound);
		System.out.println("result: " + result);
		
		System.out.println ("Testing starts");
		CovidDatabase db = new CovidDatabase();
		
		
		db.readCovidData("covid_data.csv");
		// check number of records, total infections, and total deaths
		assert db.countRecords() == 10346 : "database should have 10,346"; 
		assert db.getTotalDeaths() == 196696 : "Total deaths should be: 196,696"; 
		assert db.getTotalInfections() ==  7032090 : "infections should be: 7,032,090"; 
		// check peak daily deaths for 5/5
		CovidEntry mostDeaths = db.peakDailyDeaths(5, 5);
		assert mostDeaths.getState().equals("PA") : "State with most deaths for 5/5 is PA";
		assert mostDeaths.getDailyDeaths() ==  554 : "Deaths for 5/5 is PA: 554";
		
		
		CovidDatabase database;
		ArrayList<CovidEntry> list;
        database= new CovidDatabase(); 
        database.readCovidData("covid_data.csv"); 
        
        int infections = database.countTotalInfections(5,5);
        assertEquals("The number of infections should be 22215",
        		22215, infections); 
        
        int m = database.peakDailyDeaths("PA").getMonth();
        assertEquals("The month should be May",
                5, m); 
        int d = database.peakDailyDeaths("PA").getDay();
        assertEquals("The day should be the fifth",
                5, d); 
       
        
        String PA = database.peakDailyDeaths(5, 5).getState();
        assertEquals("The state should be PA",
                "PA", PA); 
        
        //chegck mostTotalDeaths
        String ny = database.mostTotalDeaths().getState();
        assertEquals("The state should be NY",
                "NY", ny); 

        // testing a Minimum of 2,500 infections on 9/11
        list = database.listMinimumDailyInfections(8, 1, 2500);
        System.out.println(list.get(0).getState()+ " " + list.get(0).getDailyInfections());
        System.out.println(list.get(1).getState()+ " " + list.get(1).getDailyInfections());
        System.out.println(list.get(2).getState()+ " " + list.get(2).getDailyInfections());
        
        // testing safe to open
        list = database.safeToOpen("WA");
        assertEquals("Safe to open should have 5 records" ,
            5, list.size());

        //testing first record on the list
        assertEquals("The states should be WA",
            "WA", list.get(0).getState());    
        assertEquals("Month in the first record in the sequence should be 5",
            5, list.get(0).getMonth());
        assertEquals("Day in the first record in the sequence should be 6",
            6, list.get(0).getDay());
        assertEquals("Infections in the first record in the sequence whould be 289",
            289, list.get(0).getDailyInfections());  
        
        // testing top ten for 8/1
        list = database.topTenDeaths(8, 1);
        //testing 8/1
        assertEquals("TX should have the highest number of deaths on 8/1",
            "TX", list.get(0).getState()); 
        assertEquals("top ten number of records should be 10" ,
            10, list.size());
        assertEquals("TX should have the highest number of deaths on 8/1",
            "TX", list.get(0).getState());    
        assertEquals("Deaths in TX on 8/1 should be 268",
            268, list.get(0).getDailyDeaths());
        
        // testing 9/11
        list = database.listMinimumDailyInfections(9, 11, 2500);
        assertEquals("three records with 2,500 infections or more on 9/11" ,
            3, list.size());
        
        //testing highest - index 0
        assertEquals("TX should have the highest number of deaths on 9/11",
            "FL", list.get(0).getState());    
        assertEquals("Infections in TX on 9/11 should be 3547",
            3547, list.get(1).getDailyInfections());

        //testing last entry 
        assertEquals("CA should be the last entry on the list",
            "CA", list.get(2).getState());    
        assertEquals("Infections in CA on 9/11 should be 3326",
            3326, list.get(2).getDailyInfections());
        
        System.out.println ("Testing ends");
        


		
	}

	private static boolean isValuefound(ArrayList<Integer> nums, int value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.size(); i++) 
			
			if (nums.get(i) == value)
				return true;
						
			
		return false;
		
	}


}
