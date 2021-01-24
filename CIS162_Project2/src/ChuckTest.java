import javax.swing.JFrame;
import static org.junit.Assert.assertEquals;

public class ChuckTest {
	
	public static void main(String[] args) {
		int before = 0;
		
		final int ONES = 1;
		final int TWOS = 2;
		final int THREES= 3;
		final int FOURS = 4;
		final int FIVES = 5;
		final int SIXES = 6;
		final int FIELD = 7;
		final int SMALL = 8;
		final int LARGE = 9;
		
		Chuck game = new Chuck();
		
		System.out.println("Testing begins...");
		
		System.out.println("======================");
		System.out.println("Testing Large");
		System.out.println("----------------------");
		assert game.getCredits() == 10 : "credits should start at 10";   
		before = game.getCredits();
		game.placeBet(LARGE);
		game.testRoll(new int [] {6,3,3});
		assert game.getCredits() == before+1 : "should have won betting on Large";
		before = game.getCredits();
		game.placeBet(LARGE);
		game.testRoll(new int [] {2,3,3});
		assert game.getCredits() == before-1 : "should have lost betting on Large";
		
		System.out.println("----------------------");
		System.out.println("Testing Small");
		System.out.println("----------------------");
		before = game.getCredits();
		game.placeBet(SMALL);
		game.testRoll(new int [] {2,3,3});
		assert game.getCredits() == before+1 : "should have won betting on Small";
		before = game.getCredits();
		game.placeBet(SMALL);
		game.testRoll(new int [] {6,3,3});
		assert game.getCredits() == before-1 : "should have lost betting on Small";
		
		System.out.println("----------------------");
		System.out.println("Testing Field");
		System.out.println("----------------------");
		before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(new int [] {6,3,4});
        assert game.getCredits() == before+1 : "should have won betting on Field";
        
        before = game.getCredits();
        game.placeBet(FIELD);
        game.testRoll(new int [] {3,3,4});
        assert game.getCredits() == before-1 : "should have lost betting on Field";
       
        System.out.println("----------------------");
		System.out.println("Testing Number");
		System.out.println("----------------------");
		
		before = game.getCredits();
        game.placeBet(THREES);
        game.testRoll(new int [] {6,3,4});
        assert game.getCredits() == before+1 : "should have won betting on Number";
        before = game.getCredits();
        game.placeBet(TWOS);
        game.testRoll(new int [] {3,3,4});
        assert game.getCredits() == before-1 : "should have lost betting on Number";
        before = game.getCredits();
        game.placeBet(THREES);
        game.testRoll(new int [] {3,3,4});
        assert game.getCredits() == before+2 : "credits should have increased by 2";
        before = game.getCredits();
        game.placeBet(THREES);
        game.testRoll(new int [] {3,3,3});
        assert game.getCredits() == before+10 : "credits should have increased by 10";
        
		System.out.println("----------------------");
		System.out.println("Testing cancelBet");
		System.out.println("----------------------");
		game.placeBet(THREES);
		game.cancelBet(THREES);
		boolean [] bets = game.getBets();
		if (bets[THREES-1] == true) {
			
			System.out.println("This bet should have been cancelled.");
			
		}
		
		System.out.println("----------------------");
		System.out.println("Testing addCredits");
		System.out.println("----------------------");
		game.addCredits(10);
        assert game.getCredits() == before+10 : "credits should have increased by 10";
        
		System.out.println("----------------------");
		System.out.println("Testing diceToString");
		System.out.println("----------------------");
		game.testRoll(new int [] {3,3,4});
		assertEquals("3, 3, 4", game.diceToString());
        
		System.out.println("----------------------");
		System.out.println("Testing getValue");
		System.out.println("----------------------");
		int [] values = new int [] {6,3,4};
		game.testRoll(new int [] {6,3,4});
        int count = 0;
        GVdie[] diceArray1 = game.getDice();
        for (GVdie die : diceArray1) {
        	int dieInt = die.getValue();
        	assert dieInt == values[count]: "should have matching die values";
        	count++;
        	
        	
        }
        assert count == 3 : "count should be 3";
        
        System.out.println("----------------------");
        System.out.println("Testing Reset");
        System.out.println("----------------------");
        game.reset();
        assert game.getCredits() == 10 : "credits should start at 10"; 
        
        System.out.println("----------------------");
        System.out.println("Miscellaneous testing..." );
        System.out.println("----------------------");
        //game 2
		Chuck game2 = new Chuck();
        int credits2 = game2.getCredits();
        game2.placeBet(FIELD);
        game2.testRoll(new int [] {6,3,4});
        System.out.println("game2.getCredits: "+game2.getCredits());
        System.out.println("credits2: "+credits2+1);
        assertEquals("bet FIELD(6,3,4): credits should increase by one", 
        		game2.getCredits(), credits2 + 1); 
        //game 3
		Chuck game3 = new Chuck();
        int credits3 = game3.getCredits();
        System.out.println("1: "+credits3);
        game3.placeBet(ONES);
        System.out.println("2: "+credits3);
        game3.testRoll(new int [] {1,2,3});
        System.out.println("3: "+credits3);
        System.out.println("game3.getCredits: "+game3.getCredits());
        System.out.println("4: "+credits3);
        System.out.println("credits3: "+(credits3+1));
        assertEquals("bet ONES(1,2,3): credits should have increased by one", 
        		game3.getCredits(), credits3 + 1); 
        System.out.println("5: "+credits3 + 1);
        //testing ChuckGUI
        ChuckGUI gui = new ChuckGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("My Game of Chuck A Luck");
        gui.pack();
        gui.setVisible(true);
        System.out.println("======================");
        
        System.out.println("Testing completed.");
		
	}

}
