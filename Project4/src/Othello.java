/**
 * Othello class implements the logic of the game.
 * 
 * @author Nandigam & Warren Sink
 *
 */
public class Othello {
	
	// game board as a two-dimensional array of discs
	private Disc[][] board;
	
	// who's turn is it next?
	private int turn;
	
	// player 1's disc color
	private Disc player1Disc;
	
	// player 2 disc color
	private Disc player2Disc;
	
	// current player's disc
	private Disc currentDisc;
	
	private final int minBound = 0;
		
	/**
	 * Constructs a newly initialized Othello object with the specified values.
	 * 
	 * @param boardSize size of board
	 * @param startPlayer player to start the game
	 * @param disc disc color of the start player
	 */
	public Othello(int boardSize, int startPlayer, Disc disc) {
		if (boardSize < 4 || boardSize > 8 || boardSize % 2 != 0) {
			throw new IllegalArgumentException("Board size is not valid.");
		}
		
		if (startPlayer < 1 || startPlayer > 2) {
			throw new IllegalArgumentException("Player number is not valid.");
		}
		
		turn = startPlayer;
		currentDisc = disc;
		if (startPlayer == 1) {
			player1Disc = disc;
			player2Disc = disc == Disc.WHITE ? Disc.BLACK : Disc.WHITE;
		} else {
			player2Disc = disc;
			player1Disc = disc == Disc.WHITE ? Disc.BLACK : Disc.WHITE;
		}
		
		// instantiate and initialize the board to initial configuration
		setupBoard(boardSize);
	}
	
	/**
	 * Instantiates and initializes the game board to initial configuration.
	 * 
	 * @param size board size
	 */
	private void setupBoard(int size) {
		
		this.board = new Disc[size][size];
		// COMPLETE THIS METHOD
		Disc currentDisc = getCurrentPlayerDisc();
		int halfway = (board.length / 2) - 1;
		int halfwayIncre = halfway + 1;
		
		
		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board.length; j++) {
				
				board[i][j] = null;
				
			}
			
		}
		
        if (currentDisc == Disc.BLACK) {
			
			placeDiscAt(halfway, halfway);
			placeDiscAt(halfway, halfwayIncre);
			placeDiscAt(halfwayIncre, halfwayIncre);			
			placeDiscAt(halfwayIncre, halfway);
			
			
			
		} else {
			
			placeDiscAt(halfway, halfwayIncre);
			placeDiscAt(halfway, halfway);
			placeDiscAt(halfwayIncre, halfway);
			placeDiscAt(halfwayIncre, halfwayIncre);
			
		} 
		
		
		
	}
	
	/**
	 * Returns the size of the board.
	 * 
	 * @return board size
	 */
	public int getBoardSize() {
		return board.length;
	}
	
	/**
	 * Returns the number of current player.
	 * 
	 * @return number of current player
	 */
	public int getTurn() {
		return turn;
	}
	
	/**
	 * Returns the disc of player 1.
	 * 
	 * @return disc of player 1
	 */
	public Disc getPlayer1Disc() {
		return player1Disc;
	}

	/**
	 * Returns the disc of player 2.
	 * 
	 * @return disc of player 2
	 */
	public Disc getPlayer2Disc() {
		return player2Disc;
	}
	
	/**
	 * Return the disc of the current player.
	 * 
	 * @return disc of the current player
	 */
	public Disc getCurrentPlayerDisc() {
		return currentDisc;
	}
	
	/**
	 * gets disc object from the board
	 * @param row
	 * @param column
	 * @return
	 */
	private Disc getDisc(int row, int column) {
		
		return board[row][column];
		
	}
	
	/**
	 * checks whether the spot on a board does not have a board
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean isSpotBlank(int row, int column){
		
		if (getDisc(row, column) == null) {
			
			return true;
			
		}
		return false;
		
	}
	
	/**
	 * checks whether disc is white
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean isDiscWhite(int row, int column){
		
		if (getDisc(row, column) == Disc.WHITE) {
			
			return true;
			
		}
		return false;
		
	}
	
	/**
	 * checks whether disc is black
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean isDiscBlack(int row, int column){
		
		if (getDisc(row, column) == Disc.BLACK) {
			
			return true;
			
		}
		return false;
		
	}

	/**
	 * Sets turn and currentDisc fields for next turn.
	 */
	public void setNextTurn() {
		// COMPLETE THIS METHOD
		if (turn == 1) {
			
			turn = 2;
			currentDisc = getPlayer2Disc();
				
		} else {
			
			turn = 1;
			currentDisc = getPlayer1Disc();
			
		}
	}
	
	/**
	 * Returns true if placing the disc at specified row and column is valid, otherwise false.
	 * 
	 * @param row row number
	 * @param col column number
	 * @param disc disc to place at position row,col
	 * 
	 * @return true if placing a disc at specified position is valid, false otherwise
	 */
	public boolean isValidMoveForDisc(int row, int col, Disc disc) {
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		int maxBound = board.length - 1;
		if (row < minBound || col < minBound || row > maxBound || col > maxBound) {
			return false;
		}
		
		if (!(isSpotBlank(row, col))) {
			return false;
		}
		
		if (!(discCount() + 1 < 5)) {
			
			switch (disc) {
			
			case BLACK:
				
				//examining spaces immediately beside the spot of interest = 8 spots
				//not including the spot of interest
				for (int i = -1; i < 2; i++) {
					
					for (int j = -1; j < 2; j++) {
						
						if (row + i < minBound || 
							col + j < minBound || 
							row + i > maxBound || 
							col + j > maxBound ||
							isSpotBlank(row+i, col+j) || 
							isDiscBlack(row+i, col+j)) {
							
							continue;
							
						} else {
							
							boolean streakWhite = true;
							int m = row+i;
							int n = col+j;
							while(streakWhite == true) {
								
								m = m + i;
								n = n + j;
								
								if (m < minBound || 
									n < minBound || 
									m > maxBound || 
									n > maxBound || 
									isSpotBlank(m, n)) {
									
									break;
									
								} else if (isDiscBlack(m, n)) {
									
									System.out.println("sadFace()");
									return true;
									
								} 

								
							}
							
						}					

						
					}
					
					
				}
				return false;
				
			case WHITE:	
				
				//examining spaces immediately beside the spot of interest = 8 spots
				//not including the spot of interest
				for (int i = -1; i < 2; i++) {
					
					for (int j = -1; j < 2; j++) {
						
						if (row + i < minBound || 
							col + j < minBound || 
						    row + i > maxBound || 
						    col + j > maxBound ||
						    isSpotBlank(row+i, col+j) || 
							isDiscWhite(row+i, col+j)) {
							
							continue;
							
						} else {
							
							boolean streakBlack = true;
							int m = row + i;
							int n = col + j;
							while(streakBlack == true) {
								
								m = m + i;
								n = n + j;
								
								if (m < minBound || 
									n < minBound || 
									m > maxBound || 
									n > maxBound || 
									isSpotBlank(m, n)) {
									
									break;
									
								} else if (isDiscWhite(m, n)) {
									
									return true;
									
								} 

								
							}
							
						}					

						
					}
					
					
				}
				return false;
				
			default:
				
				return false;
			
			
			}

		  } else {
			  
			  return true;
			  
		  }
			
		}
		

	
	/**
	 * Returns true if a valid move is available for the disc specified, false otherwise.
	 * 
	 * @param disc disc
	 * 
	 * @return true if a valid move is available for the disc specified, false otherwise
	 */
	public boolean isValidMoveAvailableForDisc(Disc disc) {
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		
		switch (disc) {
		
		case BLACK:
			
			for (int i = 0; i < board.length; i++) {
				
				for (int j = 0; j < board.length; j++) {
					
					if (!(isDiscBlack(i,j)) || isSpotBlank(i,j)) {
						
						continue;
						
					} else {
						
						Disc discBLACK = getDisc(i,j);
						for (int m = 0; m < board.length; m++) {
							
							for (int n = 0; n < board.length; n++) {
								
								if (!(isValidMoveForDisc(m,n,discBLACK))) {
									
									continue;
									
								} else {
									
									return true;
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			return false;
			
		case WHITE:
			
			for (int i = 0; i < board.length; i++) {
				
				for (int j = 0; j < board.length; j++) {
					
					if (!(isDiscWhite(i,j)) || isSpotBlank(i,j)) {
						
						continue;
						
					} else {
						
						Disc discWHITE = getDisc(i,j);
						for (int m = 0; m < board.length; m++) {
							
							for (int n = 0; n < board.length; n++) {
								
								if (!(isValidMoveForDisc(m,n,discWHITE))) {
									
									continue;
									
								} else {
									
									return true;
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
			return false;
			
		default:
			
			return false;
		
		}

		
	}
	
	/**
	 * Places the disc of the current player at position row,col if a valid move is available
	 * and flips the opponent discs as needed.
	 * 
	 * @param row row to place the disc at
	 * @param col column to place the disc at
	 */
	public void placeDiscAt(int row, int col) {
		// KEEP THIS CHECK
		// return if this is not a valid move
		if(!isValidMoveForDisc(row,col,currentDisc)) {
			return;
		}
		// TO DO: COMPLETE THIS PART OF THE METHOD
		int mPH = 0;
		int nPH = 0;
		int maxBound = board.length - 1;
		board[row][col] = currentDisc;
		
		if (!(discCount() < 5)) {
			
			switch (currentDisc) {
			
			case BLACK:
				
				//examining spaces immediately beside the spot of interest = 8 spots
				//not including the spot of interest then proceeding with nested while 
				//loop to examine streaks of opposite colored discs
				for (int i = -1; i < 2; i++) {
					
					for (int j = -1; j < 2; j++) {
						if (row + i < minBound || col + j < minBound || row + i > maxBound || col + j > maxBound ||
								isDiscBlack(row+i, col+j) || isSpotBlank(row+i, col+j)) {
							
							continue;
							
						} else {
							
							boolean streakWhite = true;
							int count = 0;
							int m = row + i;
							int n = col + j;
							while(streakWhite == true) {
								
								m = m + i;
								n = n + j;
								
								if (m < minBound || n < minBound || m > maxBound || n > maxBound || 
									isSpotBlank(m, n)) {
									
									break;
									
								} else if (isDiscBlack(m, n)) {
									
									mPH = m;
									nPH = n;
									count ++;
									streakWhite = false;
									
								} else {
									
									count ++;
									
								}
								
							}
							
							if (streakWhite == false && count > 0 && isDiscBlack(mPH, nPH)) {
								while (count > 0) {
									board[m-i][n-j] = currentDisc;
									m -= i;
									n -= j;
									count --;
								}
								
							}
							
						}					

						
					}
					
					
				}
				break;
				
			case WHITE:	
				
				//examining spaces immediately beside the spot of interest = 8 spots
				//not including the spot of interest then proceeding with nested while 
				//loop to examine streaks of opposite colored discs
				for (int i = -1; i < 2; i++) {
					
					for (int j = -1; j < 2; j++) {
						
						if (row + i < minBound || col + j < minBound || row + i > maxBound || col + j > maxBound ||
								isSpotBlank(row+i, col+j) || isDiscWhite(row+i, col+j)) {
							
							continue;
							
						} else {
							
							boolean streakBlack = true;
							int count = 0;
							int m = row + i;
							int n = col + j; 
							while(streakBlack == true) {
								
								m = m + i;
								n = n + j;
								if (m < minBound || n < minBound || m > maxBound || n > maxBound || 
									isSpotBlank(m, n)) {
									
									break;
									
								} else if (isDiscWhite(m, n)) {
									
									mPH = m;
									nPH = n;
									count ++;
									streakBlack = false;
									
								} else {
									
									count ++;
									
								}

							}
							
							if (streakBlack == false && count > 0 && isDiscWhite(mPH, nPH)) {
								while (count > 0) {
									board[m-i][n-j] = currentDisc;
									m -= i;
									n -= j;
									count --;
								}
								
							}
							
						}					

						
					}
					
					
				}
				break;
				
			default:
				
				break;
			
			}
			
		}
		
		// KEEP THIS CODE
		// prepare for next turn
		if (!isGameOver()) {
			setNextTurn();
		}
	}
	
	/**
	 * Returns true if the board is full, false otherwise.
	 * 
	 * @return true if the board is full, false otherwise
	 */
	public boolean isBoardFull() {
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		int boardSize = getBoardSize();
		
		for (int i = 0; i < boardSize; i++) {
			
			for (int j = 0; j < boardSize; j++) {
				
				if (isSpotBlank(i,j)) {
					
					return false;
					
				}
				
			}
			
		}
		return true;
		
	}
	
	/**
	 * Returns true if the game is over, false otherwise. Game is over if the board is full
	 * or no valid move is available for both players.
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean isGameOver() {
		return isBoardFull() || (isValidMoveAvailableForDisc(Disc.WHITE) == false &&
									isValidMoveAvailableForDisc(Disc.BLACK) == false);
	}
	
	public int discBlackCount() {
		
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		int countBLACK = 0;
		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board.length; j++) {
				
				if (!(isSpotBlank(i,j))) {
					
					if (isDiscBlack(i,j)) {
						
						countBLACK ++;
						
					} 
					
				} else {
					
					continue;
					
				}
				
			}
			
		}
		return countBLACK;
		
	}
	
	public int discWhiteCount() {
		
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
        int countWHITE = 0;
		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board.length; j++) {
				
				if (!(isSpotBlank(i,j))) {
					
					if (isDiscWhite(i,j)) {
						
						countWHITE ++;
						
					} 
					
				} else {
					
					continue;
					
				}
				
			}
			
		}
		return countWHITE;
		
	}
	
	public int discCount() {
	
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		int countBLACK = discBlackCount();
		int countWHITE = discWhiteCount();

		return countBLACK + countWHITE;
		
	}
	
	/**
	 * Determines and returns the winner or tie information. If the game is not over, returns null.
	 * 
	 * @return winner or tie information
	 */
	public Winner whoWon() {
		if (!isGameOver()) {
			return null;
		}
		
		// REPLACE NEXT LINE WITH YOUR IMPLEMENTATION
		int countBLACK = discBlackCount();
		int countWHITE = discWhiteCount();
		
		if (countWHITE == countBLACK) {
			
			return Winner.TIE;
			
		} else if (countWHITE > countBLACK) {
			
			if (player1Disc == Disc.WHITE) {
				
				return Winner.PLAYER1;
				
			} else {
				
				return Winner.PLAYER2;
				
			}
			
		} else {
			
			if (player1Disc == Disc.BLACK) {
				
				return Winner.PLAYER1;
				
			} else {
				
				return Winner.PLAYER2;
				
			}

			
		}
		
		
	}
	
	/**
	 * Returns a String object representing this game board.
	 * 
	 * @return a string representation of the value of this object
	 */
	public String toString() {
		String str = "\n  ";
		for (int i = 1; i <= board.length; i++) {
			str += i + " ";
		}
		str = str.stripTrailing() + "\n";
		for (int i = 0; i < board.length; i++) {
			str += (i+1) + " ";
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == Disc.WHITE) {
					str += "W ";
				} else if (board[i][j] == Disc.BLACK) {
					str += "B ";
				} else {
					str += "- ";
				}
			}
			str = str.stripTrailing() + "\n";
		}
		return str;
	}
}
