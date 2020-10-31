import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// carry out some tests on Card class
		
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		String expected = "[";
		for (String rank : ranks) {
			for (String suit : suits) {
				expected = expected.concat(rank + suit + ", ");
			}
		}
		expected = expected.substring(0, expected.length() - 2) + "]";
		CardDeck deck1 = new CardDeck();
		System.out.println(expected);
		System.out.println(deck1.toString());
		
		
		Card c1 = new Card("5","C");
		Card c2 = new Card("5","C");
		Card c3 = new Card("A","H");
		System.out.println(c1.getRank() + c1.getSuit());
		System.out.println(c1);
		System.out.println(c2.getRank() + c2.getSuit());
		System.out.println(c2);
		System.out.println(c3.getRank() + c3.getSuit());
		System.out.println(c3);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		
		try {
			c1 = new Card("0","S");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			c2 = new Card("A","P");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
        
		// carry out some tests on CardDeck class
		CardDeck deck = new CardDeck();
		System.out.println("Number of cards in the deck: " + deck.size());
		System.out.println(deck.isEmpty());
		System.out.println("Original deck: " + deck);
		deck.shuffle();
		System.out.println("Shuffled deck: " + deck);
		
		ArrayList<Card> cards = deck.deal(5);
		System.out.println("Number of cards in the deck: " + deck.size());
		if (cards != null) {
			for (Card card : cards) {
				System.out.println(card);
				System.out.println("Is the card " + card + " in the deck now? " + deck.contains(card));
			}
		}
		
		cards = deck.deal(0);
		if (cards == null) {
			System.out.println("No cards dealt.");
		} else {
			System.out.println("Something went wrong with the deal.");
		}
		
		cards = deck.deal(deck.size()+1);
		if (cards == null) {
			System.out.println("No cards dealt.");
		} else {
			System.out.println("Something went wrong with the deal.");
		}
				
		System.out.println(deck.size());
		
		cards = deck.deal(deck.size());
		if (cards != null) {
			System.out.println("Number of cards dealt: " + cards.size());
		}
		System.out.println("Cards dealt: " + cards);
		System.out.println("Number of cards remaining in the deck: " + deck.size());
	}
}
