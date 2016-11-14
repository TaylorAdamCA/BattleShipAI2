//Start by isBuring - return true
public class TaylorsAI {
	private static String lastGuess = "A0";
	public static void lastGuess(String a){
		lastGuess = a;
	}
	public static int getLastGuessLetter(){
	int a = (int)lastGuess.charAt(0);
	return a - 'A';
	}
	public static int getLastGuessNumber(){
		return lastGuess.charAt(1);
	}
	
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
							guess = a + Integer.toString(col + 2);
							TaylorsAI.lastGuess(guess);
							return guess;
						}
						if (col > 0 && guesses[row][col - 1] == '.') {
							a = (char) ((int) 'A' + row);
							guess = a + Integer.toString(col);
							TaylorsAI.lastGuess(guess);
							return guess;
						}
						if (row < guesses.length - 1 && guesses[row + 1][col] == '.') {
							a = (char) ((int) 'A' + row + 1);
							 guess = a + Integer.toString(col + 1);
							 TaylorsAI.lastGuess(guess);
								return guess;
						}
						if (row > 0 && guesses[row - 1][col] == '.') {
							a = (char) ((int) 'A' + row - 1);
							 guess = a + Integer.toString(col + 1);
							 TaylorsAI.lastGuess(guess);
								return guess;
						}

					}
			}

		}
		int parity = size(guesses);
		int colCount = 0;
		for (row = TaylorsAI.getLastGuessLetter(); row < guesses.length; row+=parity)
		{
			for (col = TaylorsAI.getLastGuessNumber(); col < guesses.length; col += parity) {
				if (guesses[row][col] == '.') {
					colCount++;
					if (colCount > parity) {

						a = (char) ((int) 'A' + row);
						 guess = a + Integer.toString(col + 1);
						 TaylorsAI.lastGuess(guess);
							return guess;
					}
				}
			}
		}
		do {
			row = (int) (Math.random() * 10);
			col = (int) (Math.random() * 10);
		} while (guesses[row][col] != '.');

		a = (char) ((int) 'A' + row);

		guess = a + Integer.toString(col + 1);
		TaylorsAI.lastGuess(guess);
		return guess;
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

}
//hello