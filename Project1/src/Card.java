/**
 * The Card class represents a card in deck of playing cards.
 * 
 * @author Nandigam
 *
 */

public class Card {

	// "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
	private String rank;
	
	// "C", "D", "H", "S"
	private String suit;
	
	/**
	 * Constructs a new Card object with specified rank and suit values.
	 * 
	 * this is a constructor...
	 * no return method specified...
	 * setRank, setSuit do the work;
	 * 
	 * @param rank rank of card
	 * @param suit suit of card
	 */
	public Card(String rank, String suit) {
				
		this.setRank(rank);
		this.setSuit(suit);
		this.toString();
		
	}


	/**
	 * Returns the rank of this Card object.
	 * 
	 * @return the rank of this Card object
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Sets the rank of this Card object to the argument value.
	 * 
	 * @param rank rank of the card
	 * 
	 * @throws IllegalArgumentException if argument value is not valid
	 */
	private void setRank(String rank) throws IllegalArgumentException {
		// COMPLETE THIS METHOD
		//declare boolean
		boolean validRank;
		
		//tests if rank is valid 
		validRank = isValidRank(rank);
		
		if (validRank == true) { // boolean is tested for whether it's true
			
			this.rank = rank;
			
		} else { // otherwise, it's false
			
			throw new IllegalArgumentException("Rank is not valid.");
			
		}
	}

	/**
	 * Tests if the argument value is a valid rank.
	 * 
	 * @param rank value for rank
	 * 
	 * @return true if the argument value is a valid rank; false otherwise
	 */
	private boolean isValidRank(String rank) {
		// COMPLETE THIS METHOD
		
		//rank, a string, is tested for all the valid values rank can be equal to 
		switch(rank) {
		
		case "A":
			
			return true;
			
        case "2":
			
        	return true;
			
        case "3":
        	
        	return true;
        	
        case "4":
        	
        	return true;
        	
        case "5":
        	
        	return true;
        	
        case "6":
        	
        	return true;
        	
        case "7":
        	
        	return true;
        	
        case "8":
        	
        	return true;
        	
        case "9":
        	
        	return true;
        	
        case "10":
        	
        	return true;
        	
        case "J":
        	
        	return true;
        	
        case "Q":
        	
        	return true;
        	
        case "K":
        	
        	return true;
        	
        default:
        	
        	//if rank is not value
        	return false;
        
		
		}
	}
	
	/**
	 * Returns the suit of this Card object.
	 * 
	 * @return the suit of this Card object
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Sets the suit of this Card object to the argument value.
	 * 
	 * @param suit suit of the card
	 * 
	 * @throws IllegalArgumentException if argument value is not valid
	 */
	private void setSuit(String suit) throws IllegalArgumentException {
		// COMPLETE THIS METHOD
		boolean validSuit;
		
		validSuit = isValidSuit(suit);
		
		if (validSuit == true) {
			
			this.suit = suit;
			
		} else {
			
			throw new IllegalArgumentException("Suit is not valid.");
			
		}
		
	}

	/**
	 * Tests if the argument value is a valid suit.
	 * 
	 * @param suit value for suit
	 * 
	 * @return true if the argument value is a valid suit; false otherwise
	 */
	private boolean isValidSuit(String suit) {
		// COMPLETE THIS METHOD
		switch(suit){
		
		case "C":
			
			return true;
			
		case "D":
			
			return true;
			
		case "H":
			
			return true;
			
		case "S":
			
			return true;
			
		default:
			
			return false;
		
		}
		
}
	
	@Override
	public String toString() {
		// COMPLETE THIS METHOD
		String rankSuit;
		rankSuit = this.rank + this.suit;
		return rankSuit;
	}

	
	//"content equality" = if two cards are the same
	@Override
	public boolean equals(Object obj) {
		// COMPLETE THIS METHOD
		
		//check if the argument is a reference to this object
        if (this == obj){
            
            return true;
        
        }
        
        //check if the argument has the correct type
        if (!(obj instanceof Card)) {
        	
        	return false;
        	
        }
        
        //cast the argument to the correct type
        Card other = (Card) obj;
        
        //check if ranks are equal
        if (!rank.equals(other.rank)){
            
            return false;
        
        }
        
        //check if suits are equal
        if (!suit.equals(other.suit)){
            
            return false;
        
        }
        
        return true;
		
		
	}
	

	//ignore
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	
}
