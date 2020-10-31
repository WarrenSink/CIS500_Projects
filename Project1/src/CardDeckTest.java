import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CardDeckTest {

	@Test
	public void test_constructor() {
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		CardDeck deck = new CardDeck();
		assertEquals(52, deck.size());
		for (String rank : ranks) {
			for (String suit : suits) {
				assertTrue(deck.contains(new Card(rank,suit)));
			}
		}
	}
	
	@Test
	public void test_shuffle() {
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		CardDeck deck = new CardDeck();
		deck.shuffle();
		assertEquals(52, deck.size());
		for (String rank : ranks) {
			for (String suit : suits) {
				assertTrue(deck.contains(new Card(rank,suit)));
			}
		}
	}

	@Test
	public void test_deal_1() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> cards = deck.deal(5);
		assertEquals(5, cards.size());
		assertEquals(47, deck.size());
		for (Card card : cards) {
			assertFalse(deck.contains(card));
		}
	}
	
	@Test
	public void test_deal_2() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> cards = deck.deal(0);
		assertNull(cards);
	}
	
	@Test
	public void test_deal_3() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> cards = deck.deal(-1);
		assertNull(cards);
	}
	
	@Test
	public void test_deal_4() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> cards = deck.deal(deck.size() + 1);
		assertNull(cards);
	}
	
	@Test
	public void test_deal_5() {
		CardDeck deck = new CardDeck();
		ArrayList<Card> cards = deck.deal(deck.size());
		assertEquals(52, cards.size());
		assertEquals(0, deck.size());
		assertTrue(deck.isEmpty());
	}
	
	@Test
	public void test_toString() {
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suits = {"C", "D", "H", "S"};
		String expected = "[";
		for (String rank : ranks) {
			for (String suit : suits) {
				expected = expected.concat(rank + suit + ", ");
			}
		}
		expected = expected.substring(0, expected.length() - 2) + "]";
		CardDeck deck = new CardDeck();
		assertEquals(expected, deck.toString());
	}
}
