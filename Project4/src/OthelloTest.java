import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

/**
 * OthelloTest class defines a set of unit tests for Othello class.
 * 
 * @author Nandigam
 *
 */
public class OthelloTest {

	@Test
	public void test_constructor() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		assertEquals(4, game.getBoardSize());
		assertEquals(1, game.getTurn());
		assertEquals(Disc.BLACK, game.getPlayer1Disc());
		assertEquals(Disc.WHITE, game.getPlayer2Disc());
		assertEquals(Disc.BLACK, game.getCurrentPlayerDisc());
		String expected = "1 2 3 4\n1 - - - -\n2 - B W -\n3 - W B -\n4 - - - -";
		assertEquals(expected, game.toString().trim());
	}
	
	@Test
	public void test_isGameOver() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		assertFalse(game.isGameOver());
	}
	
	@Test
	public void test_isBoardFull() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		game.placeDiscAt(1,3);
	    game.placeDiscAt(0,3);
	    game.placeDiscAt(0,2);
	    game.placeDiscAt(0,1);
	    game.placeDiscAt(3,0);
	    game.placeDiscAt(3,2);
	    game.placeDiscAt(1,0);
	    game.placeDiscAt(2,0);
	    game.placeDiscAt(3,1);
	    game.placeDiscAt(3,3);
	    game.setNextTurn();
	    game.placeDiscAt(0,0);
	    game.setNextTurn();
	    game.placeDiscAt(2,3);
	    assertTrue(game.isBoardFull());
	}
	
	@Test
	public void test_isValidMoveAvailableForDisc_1() {
		Othello game = new Othello(4, 1, Disc.WHITE);
		assertTrue(game.isValidMoveAvailableForDisc(Disc.WHITE));
		assertTrue(game.isValidMoveAvailableForDisc(Disc.BLACK));
	}
	
	@Test
	public void test_isValidMoveAvailableForDisc_2() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		game.placeDiscAt(1,3);
	    game.placeDiscAt(0,3);
	    game.placeDiscAt(0,2);
	    game.placeDiscAt(0,1);
	    game.placeDiscAt(3,0);
	    game.placeDiscAt(3,2);
	    game.placeDiscAt(1,0);
	    game.placeDiscAt(2,0);
	    game.placeDiscAt(3,1);
	    game.placeDiscAt(3,3);
	    assertFalse(game.isValidMoveAvailableForDisc(Disc.BLACK));
	    game.setNextTurn();
	    game.placeDiscAt(0,0);
	    assertFalse(game.isValidMoveAvailableForDisc(Disc.BLACK));
	    game.setNextTurn();
	    game.placeDiscAt(2,3);
	    assertTrue(game.isBoardFull());
	    assertTrue(game.isGameOver());
	    assertEquals(Winner.PLAYER2, game.whoWon());
	}
	
	@Test
	public void test_isValidMoveForDisc_1() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		assertFalse(game.isValidMoveForDisc(0, 0, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(0, 1, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(0, 3, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(1, 0, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(2, 3, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(3, 0, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(3, 2, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(3, 3, Disc.BLACK));
		assertFalse(game.isValidMoveForDisc(0, 0, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(0, 2, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(0, 3, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(1, 3, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(2, 0, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(3, 0, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(3, 1, Disc.WHITE));
		assertFalse(game.isValidMoveForDisc(3, 3, Disc.WHITE));
	}
	
	@Test
	public void test_isValidMoveForDisc_2() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		assertTrue(game.isValidMoveForDisc(0, 2, Disc.BLACK));
		assertTrue(game.isValidMoveForDisc(1, 3, Disc.BLACK));
		assertTrue(game.isValidMoveForDisc(2, 0, Disc.BLACK));
		assertTrue(game.isValidMoveForDisc(3, 1, Disc.BLACK));
		assertTrue(game.isValidMoveForDisc(0, 1, Disc.WHITE));
		assertTrue(game.isValidMoveForDisc(1, 0, Disc.WHITE));
		assertTrue(game.isValidMoveForDisc(2, 3, Disc.WHITE));
		assertTrue(game.isValidMoveForDisc(3, 2, Disc.WHITE));
	}
	
	@Test
	public void test_4_x_4_board_play() {
		Othello game = new Othello(4, 1, Disc.BLACK);
		game.placeDiscAt(1,3);
	    game.placeDiscAt(0,3);
	    game.placeDiscAt(0,2);
	    game.placeDiscAt(0,1);
	    game.placeDiscAt(3,0);
	    game.placeDiscAt(3,2);
	    game.placeDiscAt(1,0);
	    game.placeDiscAt(2,0);
	    game.placeDiscAt(3,1);
	    game.placeDiscAt(3,3);
	    game.setNextTurn();
	    game.placeDiscAt(0,0);
	    game.setNextTurn();
	    game.placeDiscAt(2,3);
	    assertTrue(game.isGameOver());
	    assertEquals(Winner.PLAYER2, game.whoWon());
	}
	
	@Test
	public void test_6_x_6_board_play() {
		Othello game = new Othello(6, 2, Disc.WHITE);
		game.placeDiscAt(2,1);
	    game.placeDiscAt(1,3);
	    game.placeDiscAt(2,4);
	    game.placeDiscAt(3,5);
	    game.placeDiscAt(4,4);
	    game.placeDiscAt(2,0);
	    game.placeDiscAt(1,1);
	    game.placeDiscAt(0,1);
	    game.placeDiscAt(0,0);
	    game.placeDiscAt(4,1);
	    game.placeDiscAt(2,5);
	    game.placeDiscAt(4,3);
	    game.placeDiscAt(4,2);
	    game.placeDiscAt(4,5);
	    game.placeDiscAt(5,5);
	    game.placeDiscAt(1,2);
	    game.placeDiscAt(4,0);
	    game.placeDiscAt(5,3);
	    game.placeDiscAt(1,4);
	    game.placeDiscAt(0,3);
	    game.placeDiscAt(0,2);
	    game.placeDiscAt(5,0);
	    game.placeDiscAt(3,1);
	    game.placeDiscAt(0,5);
	    game.placeDiscAt(3,4);
	    game.placeDiscAt(5,4);
	    game.placeDiscAt(5,1);
	    game.placeDiscAt(1,0);
	    game.placeDiscAt(0,4);
	    game.placeDiscAt(5,2);
	    game.placeDiscAt(3,0);
	    game.setNextTurn();
	    game.placeDiscAt(1,5);
	    assertTrue(game.isGameOver());
	    assertEquals(Winner.PLAYER2, game.whoWon());
	}
	
	@Test
	public void test_8_x_8_board_play() {
		Othello game = new Othello(8, 1, Disc.BLACK);
		game.placeDiscAt(5,3);
	    game.placeDiscAt(5,2);
	    game.placeDiscAt(3,5);
	    game.placeDiscAt(2,5);
	    game.placeDiscAt(4,2);
	    game.placeDiscAt(3,6);
	    game.placeDiscAt(3,7);
	    game.placeDiscAt(3,2);
	    game.placeDiscAt(1,6);
	    game.placeDiscAt(0,7);
	    game.placeDiscAt(4,1);
	    game.placeDiscAt(5,4);
	    game.placeDiscAt(6,3);
	    game.placeDiscAt(6,2);
	    game.placeDiscAt(6,1);
	    game.placeDiscAt(7,2);
	    game.placeDiscAt(7,1);
	    game.placeDiscAt(2,3);
	    game.placeDiscAt(3,1);
	    game.placeDiscAt(2,4);
	    game.placeDiscAt(6,5);
	    game.placeDiscAt(6,0);
	    game.placeDiscAt(1,4);
	    game.placeDiscAt(2,6);
	    game.placeDiscAt(7,3);
	    game.placeDiscAt(5,5);
	    game.placeDiscAt(4,5);
	    game.placeDiscAt(4,6);
	    game.placeDiscAt(4,7);
	    game.placeDiscAt(2,0);
	    game.placeDiscAt(5,1);
	    game.placeDiscAt(6,4);
	    game.placeDiscAt(3,0);
	    game.placeDiscAt(2,2);
	    game.placeDiscAt(1,2);
	    game.placeDiscAt(5,6);
	    game.placeDiscAt(5,7);
	    game.placeDiscAt(0,2);
	    game.placeDiscAt(2,7);
	    game.placeDiscAt(6,6);
	    game.placeDiscAt(7,4);
	    game.placeDiscAt(7,5);
	    game.placeDiscAt(6,7);
	    game.placeDiscAt(7,0);
	    game.placeDiscAt(0,6);
	    game.placeDiscAt(5,0);
	    game.placeDiscAt(4,0);
	    game.placeDiscAt(7,6);
	    game.placeDiscAt(2,1);
	    game.placeDiscAt(1,5);
	    game.placeDiscAt(1,3);
	    game.placeDiscAt(7,7);
	    game.placeDiscAt(0,5);
	    game.placeDiscAt(1,7);
	    game.placeDiscAt(0,3);
	    game.placeDiscAt(0,4);
	    game.placeDiscAt(1,0);
	    game.placeDiscAt(0,1);
	    game.placeDiscAt(1,1);
	    game.placeDiscAt(0,0);
	    assertTrue(game.isGameOver());
	    assertEquals(Winner.PLAYER2, game.whoWon());
	}
}
