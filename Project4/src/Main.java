import static org.junit.Assert.*;
public class Main {
	
	public static void main(String [] args) {
		
		Othello game = new Othello(4, 1, Disc.BLACK);
		System.out.println(game.toString());
		game.isValidMoveForDisc(0, 0, Disc.BLACK);
		System.out.println(game.isValidMoveForDisc(0, 0, Disc.BLACK));
		//assertFalse(game.isValidMoveForDisc(0, 0, Disc.BLACK));
		/*assertFalse(game.isValidMoveForDisc(0, 1, Disc.BLACK));
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
		assertFalse(game.isValidMoveForDisc(3, 3, Disc.WHITE));*/
	
		
	}

}
