//Start by isBuring - return true
public class TaylorsAI {
	public static String aIGuess(char[][] guesses) {
		int row, col;
		String guess;
		char a = 0;
		if (isLit(guesses) == true) {
			// guess all around the X
			for (row = 0; row < guesses.length; row++) {
				for (col = 0; col < guesses.length; col++)
					if (guesses[row][col] == 'X') {
						// Makes sure it wont go out of index
						if (col < 9 && guesses[row][col + 1] == '.') {
							a = (char) ((int) 'A' + row);
							return guess = a + Integer.toString(col + 2);
						}
						if (col > 0 && guesses[row][col - 1] == '.') {
							a = (char) ((int) 'A' + row);
							return guess = a + Integer.toString(col);
						}
						if (row < guesses.length - 1 && guesses[row + 1][col] == '.') {
							a = (char) ((int) 'A' + row + 1);
							return guess = a + Integer.toString(col + 1);
						}
						if (row > 0 && guesses[row - 1][col] == '.') {
							a = (char) ((int) 'A' + row - 1);
							return guess = a + Integer.toString(col + 1);
						}

					}
			}

		}
		
		if(guesses[2][2] == '.')
			return "C3";
		if(guesses[3][3] == '.')
			return "D4";
		if(guesses[4][4] == '.')
			return "E5";
		if(guesses[5][5] == '.')
			return "F6";
		if(guesses[6][6] == '.')
			return "G7";
		if(guesses[7][7] == '.')
			return "H8";
	
		
	
		if(guesses[1][5] == '.')
			return "B6";
		if(guesses[2][6] == '.')
			return "C7";
		if(guesses[3][7] == '.')
			return "D8";
		if(guesses[4][8] == '.')
			return "E9";

		
		if(guesses[5][1] == '.')
			return "F2";
		if(guesses[6][2] == '.')
			return "G3";
		if(guesses[7][3] == '.')
			return "H4";
		if(guesses[8][4] == '.')
			return "I5";
	
		if(guesses[3][4] == '.')
			return "D5";
		if(guesses[3][5] == '.')
			return "D6";
		if(guesses[4][5] == '.')
			return "E6";
		if(guesses[5][4] == '.')
			return "F5";
		if(guesses[5][3] == '.')
			return "F4";
		
		if(guesses[8][8] == '.')
			return "I9";
		if(guesses[9][9] == '.')
			return "J10";
		if(guesses[0][0] == '.')
			return "A1";
		if(guesses[1][1] == '.')
			return "B2";
		if(guesses[2][5] == '.')
			return "C6";
		if(guesses[2][4] == '.')
			return "C5";

			
		
		int parity = size(guesses);
		int colCount = 0;
		// figure out how to save last guess
		for (row = 0; row < guesses.length; row+=4)
		{
			for (col = 0; col < guesses.length; col += parity) {
				if (guesses[row][col] == '.') {
					colCount++;
					if (colCount > parity) {

						a = (char) ((int) 'A' + row);
						return guess = a + Integer.toString(col + 1);
					}
				}
			}
		}
	
		
		
		if(BattleShipTools.getMoves() < 20){
			do{
		
			row = (int) (Math.random() * 10);
			col = row;
			//int randomNum = startOfRange+rand.nextInt((endOfRange-startOfRange)/2) *2;
		} while (guesses[row][col] != '.');

		a = (char) ((int) 'A' + row);

		return guess = a + Integer.toString(col + 1);
	}else{
		do{
			row = (int) (Math.random() * 10);
			col = (int) (Math.random() * 10);
			//int randomNum = startOfRange+rand.nextInt((endOfRange-startOfRange)/2) *2;
		} while (guesses[row][col] != '.');

		a = (char) ((int) 'A' + row);

		return guess = a + Integer.toString(col + 1);
	}
		
	}

	/*
	 * public static boolean oneRight(char[][] guess) { int row, col; for (row =
	 * 0; row < guess.length; row++) { for (col = 0; col < guess.length; col++)
	 * if (guess[row][col] < 10) { // Check to the right if (guess[row][col + 1]
	 * == '.') {
	 * 
	 * return true; } } } return false; }
	 * 
	 * public static boolean oneLeft(char[][] guess) { int row, col; for (row =
	 * 0; row < guess.length; row++) { for (col = 0; col < guess.length; col++)
	 * if (guess[row][col] > 0) { // Check to the left if (guess[row][col - 1]
	 * == '.') { return true; } }
	 * 
	 * } return false; } public static boolean oneUp(char[][] guess) { int row,
	 * col; for (row = 0; row < guess.length; row++) { for (col = 0; col <
	 * guess.length; col++) if (row < guess.length - 1) { // Check below if
	 * (guess[row + 1][col] == '.') { return true; } }
	 * 
	 * } return false; } public static boolean oneDown(char[][] guess) { int
	 * row, col; for (row = 0; row < guess.length; row++) { for (col = 0; col <
	 * guess.length; col++) if (guess[row][col] > 0) { // Check to the left if
	 * (guess[row][col - 1] == '.') { return true; } }
	 * 
	 * } return false; }
	 */
	public static int size(char[][] search) {
		int row, col;
		int parity = 2;
		for (row = 0; row < search.length; row++) {
			for (col = 0; col < search.length; col++) {
				if (search[row][col] == 4) {
					return parity = 4;
				} else if (search[row][col] == 3) {
					return parity = 3;
				} else
					return parity = 2;
			}
		}
		return parity;
	}

	public static boolean isLit(char[][] search) {
		int row, col;
		for (row = 0; row < search.length; row++) {
			for (col = 0; col < search.length; col++)
				if (search[row][col] == 'X') {
					return true;
				}
		}
		return false;
	}
	public static int moves(int a){
		int moves = a;
		return moves;
	}

}
