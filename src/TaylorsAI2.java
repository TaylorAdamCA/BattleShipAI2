
public class TaylorsAI2 {
	public static int[][] chance = new int[10][10];

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
		if (guesses[1][1] == '.')
			return "B2";
		if (guesses[1][8] == '.')
			return "B9";
		if (guesses[8][1] == '.')
			return "I2";
		if (guesses[8][8] == '.')
			return "I9";
		if (guesses[2][2] == '.')
			return "C3";
		if (guesses[2][7] == '.')
			return "C8";
		if (guesses[7][2] == '.')
			return "H3";
		if (guesses[7][7] == '.')
			return "H8";
		if (guesses[3][1] == '.')
			return "D2";
		if (guesses[3][7] == '.')
			return "D8";
		if (guesses[6][1] == '.')
			return "G2";
		if (guesses[6][7] == '.')
			return "G8";
		if (guesses[4][2] == '.')
			return "E3";
		if (guesses[4][7] == '.')
			return "E8";
		if (guesses[3][3] == '.')
			return "D4";
		if (guesses[3][6] == '.')
			return "D7";
		if (guesses[2][4] == '.')
			return "C5";
		if (guesses[6][3] == '.')
			return "G4";
		if (guesses[8][6] == '.')
			return "I7";
		if (guesses[8][3] == '.')
			return "I4";

		return check2(guesses);

	}

	/*
	 * "I4"; if(guesses[6][6] == '.') return "G7"; if(guesses[7][4] == '.')
	 * return "H5"; if(guesses[4][4] == '.') return "E5"; if(guesses[5][2] ==
	 * '.') return "F3"; if(guesses[5][5] == '.') return "F6"; if(guesses[5][8]
	 * == '.') return "F9"; if(guesses[2][5] == '.') return "C6";
	 * if(guesses[7][9] == '.') return "H10"; if(guesses[0][2] == '.') return
	 * "A3"; if(guesses[0][7] == '.') return "A8"; if(guesses[0][2] == '.')
	 * return "A3"; if(guesses[2][9] == '.') return "C10"; if(guesses[9][2] ==
	 * '.') return "J3"; if(guesses[9][7] == '.') return "J8"; if(guesses[2][0]
	 * == '.') return "C1"; if(guesses[4][0] == '.') return "E1";
	 * if(guesses[4][9] == '.') return "E10"; if(guesses[9][5] == '.') return
	 * "J6"; if(guesses[7][0] == '.') return "H1"; if(guesses[5][1] == '.')
	 * return "F2"; if(guesses[5][7] == '.') return "F8"; if(guesses[7][4] ==
	 * '.') return "H5"; if(guesses[4][5] == '.') return "E6"; if(guesses[2][5]
	 * == '.') return "B6"; if(guesses[5][4] == '.') return "F5";
	 * if(guesses[0][0] == '.') return "A1"; if(guesses[9][0] == '.') return
	 * "J1"; if(guesses[9][9] == '.') return "J10"; if(guesses[0][9] == '.')
	 * return "A10"; if(guesses[4][3] == '.') return "E4";
	 */

	public static String check2(char[][] guesses) {
		int[] max = new int[2];
		int[][] chance = new int[10][10];
		char a = 0;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (col < 9) {
					if (guesses[row][col] == '.' && guesses[row][col + 1] == '.') {
						chance[row][col]++;
						chance[row][col + 1]++;
					}
				}
				if (row < 9) {
					if (guesses[row][col] == '.' && guesses[row + 1][col] == '.') {
						chance[row][col]++;
						chance[row + 1][col]++;
					}
				}
				if (col < 8) {
					if (guesses[row][col] == '.' && guesses[row][col + 1] == '.' && guesses[row][col + 2] == '.') {
						chance[row][col]++;
						chance[row][col + 1]++;
						chance[row][col + 2]++;
					}
				}
				if (row < 8) {
					if (guesses[row][col] == '.' && guesses[row + 1][col] == '.' && guesses[row + 2][col] == '.') {
						chance[row][col]++;
						chance[row + 1][col]++;
						guesses[row + 2][col]++;
					}
				}
				if (col < 7) {
					if (guesses[row][col] == '.' && guesses[row][col + 1] == '.' && guesses[row][col + 2] == '.'
							&& guesses[row][col + 3] == '.') {
						chance[row][col]++;
						chance[row][col + 1]++;
						chance[row][col + 2]++;
						guesses[row][col + 3]++;
					}
				}
				if (row < 7) {
					if (guesses[row][col] == '.' && guesses[row + 1][col] == '.' && guesses[row + 2][col] == '.'
							&& guesses[row + 3][col] == '.') {
						chance[row][col]++;
						chance[row + 1][col]++;
						guesses[row + 2][col]++;
						guesses[row + 3][col]++;
					}
				}
				if (col < 6) {
					if (guesses[row][col] == '.' && guesses[row][col + 1] == '.' && guesses[row][col + 2] == '.'
							&& guesses[row][col + 3] == '.' & guesses[row][col + 4] == '.') {
						chance[row][col]++;
						chance[row][col + 1]++;
						chance[row][col + 2]++;
						guesses[row][col + 3]++;
						guesses[row][col + 4]++;
					}
				}
				if (row < 6) {
					if (guesses[row][col] == '.' && guesses[row + 1][col] == '.' && guesses[row + 2][col] == '.'
							&& guesses[row + 3][col] == '.' && guesses[row + 4][col] == '.') {
						chance[row][col]++;
						chance[row + 1][col]++;
						guesses[row + 2][col]++;
						guesses[row + 3][col]++;
						guesses[row + 4][col]++;
					}
				}
			}
		}

		max = findMaxIndex(chance);
		if (guesses[max[0]][max[1]] == '.') {
			a = (char) ((int) 'A' + max[0]);
			return a + Integer.toString(max[1] + 1);
		}


		else{
		 int row = (int) (Math.random() * 10);
		 int col = (int) (Math.random() * 10);
		  
		  a = (char) ((int) 'A' + row);
		  
		  return a + Integer.toString(col + 1);
		}
	}

	public static int[] findMaxIndex(int[][] a) {
		int maxVal = 0;
		int[] arr = new int[2];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				if (a[row][col] > maxVal) {
					maxVal = a[row][col];
					arr[0] = row;
					arr[1] = col;
				}
			}
		}
		return arr;
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
