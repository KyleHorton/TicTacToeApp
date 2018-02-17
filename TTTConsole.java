import java.util.Scanner;

/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * 
 * @author relkharboutly
 * @date 1/5/2017
 * 
 *       Edited by Kyle Horton
 * @date 1/31/208
 */
public class TTTConsole {

	public static Scanner in = new Scanner(System.in); // the input Scanner
	public static TicTacToe TTTboard = new TicTacToe();

	/** The entry main method (the program starts here) */
	public static void main(String[] args) {

		int currentState = TicTacToe.PLAYING; // current state of game
		int userMove = 0; // holds the location the user inputs
		String userInput; // user input
		String restart; // used to restart game
		TTTboard.printBoard();

		System.out.println("Welcome to TicTacToe!" + "\n");

		// game loop
		do {

			/**
			 * get player input here and call setMove(). user should input a
			 * number between 0-8
			 */

			System.out.println("Enter a number 0-8!");

			// converts user input to an integer
			userInput = in.next();
			userMove = Integer.parseInt(userInput);

			// all happens as long as user gives a valid number
			if (userMove >= 0 && userMove < 9) {
				TTTboard.setMove(TTTboard.getCurrPlayer(), userMove);
				TTTboard.printBoard();
				currentState = TTTboard.checkForWinner();
				if (currentState == ITicTacToe.CROSS_WON) {
					System.out.println("'X' won! Bye!");
					System.out.println("Press 'q' to play again!");
					restart = in.next();
					if (restart.equals("q")) {
						TTTboard.setCurrPlayer(0);
						TTTboard.setTurns(0);
						TTTboard.clearBoard();
						main(args);
					} else if (!restart.equals("q")) {
						System.out.println("Thanks for playing!");
						System.exit(0);
					}

				} else if (currentState == ITicTacToe.TIE) {
					System.out.println("It's a TIE! Bye!");
					System.out.println("Press 'q' to play again!");
					restart = in.next();
					if (restart.equals("q")) {
						TTTboard.setCurrPlayer(0);
						TTTboard.setTurns(0);
						TTTboard.clearBoard();
						main(args);
					} else if (!restart.equals("q")) {
						System.out.println("Thanks for playing!");
						System.exit(0);
					}
				}

			} else {
				System.out.println("Invalid spot!!!!");
				main(args);
				
			}

			TTTboard.setMove(TTTboard.getCurrPlayer(), TTTboard.getComputerMove());
			System.out.println("Now it's the computer's turn!");
			TTTboard.printBoard();
			// Print message if game-over
			currentState = TTTboard.checkForWinner();

			if (currentState == ITicTacToe.NOUGHT_WON) {
				System.out.println("'O' won! Bye!");
				System.out.println("Press 'q' to play again!");
				restart = in.next();
				if (restart.equals("q")) {
					TTTboard.setCurrPlayer(0);
					TTTboard.setTurns(0);
					TTTboard.clearBoard();
					main(args);
				} else if (!restart.equals("q")) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				}
			}

		} while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q"))); // repeat
																					// if
																					// not
																					// game-over
	}

}