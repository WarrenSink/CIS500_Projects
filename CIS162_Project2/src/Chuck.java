
public class Chuck {
	
	private int credits;
	private GVdie[] diceArray;
	private String message;
	private boolean[] bets;
	
	
	/**
	 * Constructor for objects of class Chuck
	 */
	public Chuck(){
		
		this.credits = 10;
		diceArray = new GVdie[3];
		
		for (int i = 0; i < diceArray.length; i++) {
			
			diceArray[i] = new GVdie();
			diceArray[i].setBlank();
		}
		
		message = "";
		
		bets = new boolean[9];
		for (int j = 0; j < bets.length; j++) {
			
			bets[j] = false;
			
		}
		
		
	}
	
	/**
	 * getter for credits
	 * @return credits
	 */
	public int getCredits() {
		
		return credits;
		
	}
	
	/**
	 * getter for die
	 * @return array of GVdie
	 */
	public GVdie[] getDice() {
		
		return diceArray;
		
	}
	
	/**
	 * getter for message
	 * @return message
	 */
	public String getMessage() {
		
		return message;
		
	}
	
	/**
	 * getter array of bets
	 * @return
	 */
	public boolean[] getBets() {
		
		return bets;
		
	}
	
	/**
	 * getter for sum of dice values
	 * @return sum of dice values
	 */
	private int getSumDiceValues() {
		
		int sum = 0;
		for (int i = 0; i < diceArray.length; i++) {
			
			sum+=diceArray[i].getValue();
			
		}
		return sum;
		
	}
	
	/**
	 * Checks for if whether num matches two rolled die
	 * @param num
	 * @return false if no doubles
	 */
	private boolean isDoubles(int num) {
		
		int counter = 0;
		for (int i = 0; i < diceArray.length; i++) {
			
			if (num == diceArray[i].getValue()) {
				
				counter ++;
				
			}
			
		}
		
		if (counter == 2) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * detects if a roll has triplets
	 * @return false if no triplets
	 */
	private boolean isTriplets() {

		int counter = 0;
        for (int i = 0; i < (diceArray.length - 1); i++) {
			
        	if (diceArray[i].getValue() == diceArray[i+1].getValue()) {
				
				counter += 1;
				
			}
			
		}
        
		if (counter == 2) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * detects if whether the sum of a roll is greater than 10
	 * and adds 2 credits when so
	 */
	public void checkLarge() {
		
		int sum = this.getSumDiceValues();
		boolean triplets = this.isTriplets();
		if (sum > 10 && triplets == false) {
			
			this.credits += 2;
			this.message = "You won!";
			
		}
		
	}
	
	/**
	 * detects if whether the sum of a roll is less than 11 and 
	 * adds 2 credits when so
	 */
	private void checkSmall() {
		
		int sum = this.getSumDiceValues();
		boolean triplets = this.isTriplets();
		if (sum < 11 && triplets == false) {
			
			this.credits += 2;
			this.message = "You won!";
			
		}
		
	}
	
	/**
	 * detects if whether the sum of a roll is outside the range 
	 * of 8 to 12 and adds 2 credits when so
	 */
    public void checkField() {
		
		int sum = this.getSumDiceValues();
		if (sum > 12 || sum < 8) {
			
			this.credits += 2;
			this.message = "You won!";
			
		}
		
	}
	
    /**
     * checks for a given num, if whether a roll has a singlet,
     * doublet, or triplet and adds credits accordingly
     * @param num
     */
    private void checkNumber(int num) {

    	int trueNum = num + 1;
    	boolean doublets = this.isDoubles(trueNum);
    	boolean triplets = this.isTriplets();
    	int firstDie = diceArray[0].getValue();
    	
    	if (firstDie == trueNum && triplets == true) {
    		
    		this.credits += 11;
    		this.message = "You won!";
    		
    	} else if (doublets == true) {
    		
    		this.credits += 3;
    		this.message = "You won!";
    		
    	} else {
    		
    		for (int i = 0; i < diceArray.length; i++) {
    			
    			int currDieValue = diceArray[i].getValue();

    			if (currDieValue == trueNum) {
    				credits += 2;
    				this.message = "You won!";
    				break;
    				}
    			
    		}
    		
    	}
    	
    }
	
    /**
     * goes through all checked bets and runs the appropriate method
     * to determine if whether the bet is won or not, reducing a 
     * credit for each bet
     */
    private void checkAllBets() {
    	
    	this.message = "You lost!";
    	
    	int i = 0;
    	for (boolean bet : bets) {
    		
    		if (bet == true) {
    			
    			this.credits -= 1;
    			
    			if (i < 6) {
    				
    				checkNumber(i);
    				
    			} else if(i == 6) {
    				
    				checkField();
    				
    			} else if (i == 7) {
    				
    				checkSmall();
    				
    			} else  if (i == 8){
    				
    				checkLarge();
    				
    			} else {
    				
    				continue;
    				
    			}
    			
    		}
    		
    		i++;
    	}
    	
    }
	
    /**
     * adds amount of credits to the current credits count
     * @param amount
     */
    public void addCredits (int amount) {
    	
    	if (amount >= 0) {
    	
    		this.credits += amount;
    		
    	}
    	
    }
	
    /**
     * sets at the appropriate index to true if bet wanted
     * @param bet
     */
	public void placeBet(int bet) {
		
		bets[bet-1] = true;
		
	}
	
	/**
	 * sets at the appropriate index to false if bet not
	 * wanted
	 * @param bet
	 */
	public void cancelBet (int bet) {
		
		bets[bet-1] = false;
		
	}
	
	/**
	 * removes all bets if present
	 */
	public void clearAllBets() {
		
		for (int i = 0; i < bets.length; i++) {
			
			bets[i] = false;
			
		}
		
	}
	
	/**
	 * rolls the die to get a set of die values, then checks
	 * and clears all bets
	 */
	public void roll() {
		
		boolean enoughCred = this.enoughCredits();
		if (enoughCred != true) {
			
			this.message = "You don't have enough credits to cover the bets.";
			
			for (int i = 0; i < diceArray.length; i++) {
				
				diceArray[i] = new GVdie();
				diceArray[i].setBlank();
			}
			
		} else {
			
			for (int i = 0; i < diceArray.length; i++) {
				
				diceArray[i].roll();
				
			}
			
			checkAllBets();
			
			clearAllBets();
				
		}

	}
	
	/**
	 * makes the game re-begin
	 */
	public void reset() {
		
		for (int i = 0; i < diceArray.length; i++) {
			
			//diceArray[i] = new GVdie();
			diceArray[i].setBlank();
		}
		
		credits = 10;
		message = "";
		clearAllBets();
		
	}
	
	/**
	 * makes sure number of bets is greater than current credits
	 * @return false if number of bets is greater than current credits
	 */
	public boolean enoughCredits() {
		
		int numBets = 0;
		for (int i = 0; i < bets.length; i++) {
			
			if (bets[i] == true) {
				
				numBets ++;
				
			}
			
		}
		if (numBets <= this.credits) {
			
			return true;
			
		}
		
		return false;
		
		
	}
	
	/**
	 * constructs string of dice values spaced out
	 * @return dice values
	 */
	public String diceToString () {
		
		String diceString = "";
		for (int i = 0; i < diceArray.length; i++) {
			
			if (i == 2) {
				
				diceString += diceArray[i].getValue();
				
			} else {
				
				diceString += diceArray[i].getValue() + ", ";
				
			}

		}
		
		return diceString;
		
	}
	
	/**
	 * for testing the code, given an argument of dice values, 
	 * rolls die until result matches argument, and checks and
	 * clears all bets; also, checks if credits are enough for 
	 * bets
	 * @param values
	 */
	public void testRoll(int [] values) {
		
		if (this.enoughCredits() == true) {

			int i = 0;
			for (int value : values) {
				
				if (value < 1 || value > 6) {
					value = 1;
				}
				
				GVdie die = diceArray[i];
				
				int rolledDie = 0;
				die.roll();
				while(rolledDie != value) {
					
					die.roll();
					rolledDie = die.getValue();
					
				}
			    
				i++;
			
			}
			
			this.checkAllBets();
			this.clearAllBets();
			
		} else {
			
			this.message = "You don't have enough credits to cover the bets.";
			
		}

		
	}

	
}