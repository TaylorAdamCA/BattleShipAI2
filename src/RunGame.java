import java.util.Arrays;
public class RunGame{
    public static void main(String[] args){
        final int DIMENSIONS = 10;
        int average = 0;
<<<<<<< HEAD
        int games = 100000;
=======
        int games = 10000;
>>>>>>> a0828ed9e594b1b143afbd172f63547c9345a06d
        for(int cases = 0; cases < games ; cases++){
        char[][] s1Guesses = new char[DIMENSIONS][DIMENSIONS];
        String[] history = new String[DIMENSIONS * DIMENSIONS];

        for(int row = 0; row < DIMENSIONS; row++){
            for(int col = 0; col < DIMENSIONS; col++){
                s1Guesses[row][col] = '.';
            }
        }
       
        int[][] gameBoard = new int[DIMENSIONS][DIMENSIONS];
        BattleShipTools.randomBoard(gameBoard);
       // BattleShipTools.problemBoard(gameBoard);
       // BattleShipTools.printBoard(gameBoard);
        int moves;

        for(moves = 1; moves < DIMENSIONS*DIMENSIONS+1; moves++){
            //copy array before passing to students
            char[][] s1Copy = Arrays.copyOf(s1Guesses, s1Guesses.length);

            String guess1 = TaylorsAI.aIGuess(s1Copy);
            BattleShipTools.addMoves();
            history[moves -1] = guess1;
            
            boolean p1 = BattleShipTools.updateGuess(s1Guesses,guess1,gameBoard);
            //break if the player won
            if(p1){
                break;
            }
            //printBoard(s1Guesses);
        }

        if(moves == DIMENSIONS * DIMENSIONS + 1){
            System.out.println("Out of Moves");
        }

        System.out.println("Completed in " + moves + " moves");
        average += moves;
        for(int i = 0; i < history.length; i++){
            if(i % 10 == 0)
               // System.out.println();
            if(history[i] != null){
               // System.out.print(history[i] + ", ");
            }
            
        }

        System.out.println();
        //BattleShipTools.printBoard(s1Guesses);
    }System.out.println("youre average is " + average/games);
    }
 
}


