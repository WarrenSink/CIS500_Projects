import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The CardDeck class represents a deck of 52 Card objects.
 * 
 * @author Nandigam
 *
 */
public class CardDeck {

	private ArrayList<Card> deck;
	
	/**
	 * Constructs a new CardDeck object with 52 Card objects in its deck.
	 */
	public CardDeck() {
		// COMPLETE THIS METHOD
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		
		deck = new ArrayList<Card>();
		
		for (String rank : ranks) {
			for (String suit : suits) {
				
				//construct new card object for this loop
				var card = new Card(rank, suit);
				
				//add new card object to deck
				
				deck.add(card);
				
				
			}
		}
		deck.toString();
	}
	
	/**
	 * Shuffles the cards in the deck.
	 */
	//Objects of class ArrayList have shuffle method
	public void shuffle() {
		// COMPLETE THIS METHOD  
		Collections.shuffle(this.deck) ;
	}
	
	/**
	 * Returns the number of cards currently in the deck.
	 * 
	 * @return the number of cards currently in the deck
	 */
	public int size() {
		int numberOfCards = deck.size();
		return numberOfCards;
	}
	
	/**
	 * Tests if the deck of cards is empty.
	 * 
	 * @return true if the deck is empty, false otherwise
	 */
	public boolean isEmpty() {
		// COMPLETE THIS METHOD
		int deckSize = deck.size();
		
		if (deckSize > 0) {
			
			return false;
			
		} else {
			
			return true;
			
		}
	}
	
	/**
	 * Tests if the argument Card object is in the deck.
	 * 
	 * @param c Card object whose membership in the deck is tested
	 * 
	 * @return true if the card is in the deck, false otherwise
	 */
	public boolean contains(Card c) {
		// COMPLETE THIS METHOD
		int count = 0;
		
		for (Card card : deck) {
			
			if (c.equals(card)){
				
				count += 1;
				
			} else {
				
				continue;
				
			}
		}
		
		//test if the count is equal to 1 (i.e. the card exists in the deck without another copy)
		if (count == 1) {
				
			return true;
				
		} else if (count == 0){ //test if card was not found
				
			return false;
				
		} else { //test if card was found more than once
				
			System.out.println("Same card exists more than once in deck.");
			return true;
				
		}
			
	}
	
	/**
	 * Removes n cards from the end/top of the deck and returns these cards in an ArrayList.
	 * If n is less than 1 or n is greater than the current deck size, it returns null.
	 * 
	 * @param n number of cards to deal from the deck
	 * 
	 * @return cards removed from the deck
	 */
	public ArrayList<Card> deal(int n) {
		// COMPLETE THIS METHOD
		//constructs new Card object "dealt" 
		ArrayList<Card> dealt = new ArrayList<Card>();
		
		//to get back the number of cards in the deck
		int deckSize = deck.size();
		
		
		if (n < 1){ //if input is 0
			
			return null;
			
		} else if (n > deckSize){ //if input is greater than the length of the deck
			
			return null;
			
		} else { //if input is between 1 and number of cards in the deck
			
			//looping through cards in deck
			for (int i = deckSize - 1; i > (deckSize - 1) - n; i--) {
				
				//constructing a new card each time we access another card in the deck
				Card card = deck.get(i);
				
				//adding the card to ArrayList dealt
				dealt.add(card);
				//removing the card from deck so copy doesn't exist
				deck.remove(card);
				
			}

		}
		
        // to get back the dealt cards when calling method
		return dealt;
	}
	
	@Override
	public String toString() {
		
		//assigning "" here to the string prevents null from being printed before cards
		String deckString = "";
		//gets the number of cards in the deck
		int deckSize = deck.size();
		
		
		//counter-loop going  from beginning of deck to end
		for (int i = 0; i < deckSize; i++){
			
			if (i == 0) {
				
				Card card = deck.get(i);
				String cardString = card.toString();
				deckString += "[" + cardString + ", ";
				
			} else if (i == (deckSize - 1)) {
				
				Card card = deck.get(i);
				String cardString = card.toString();
				deckString += cardString + "]";
				
			} else {
				
				//
				Card card = deck.get(i);
				String cardString = card.toString();
				deckString += cardString + ", ";
				
			}
			
			
		}
		
		//to get back the deck in a string
		return deckString;
	}
 }
