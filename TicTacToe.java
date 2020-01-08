import java.util.Scanner;

public class tictactoe {
	
	//responsible for displaying the board to the screen
	public static void displayBoard(String[] board) {
		System.out.println( board[0] + "  |  " + board[1] + "  |  " + board[2]);
		System.out.println("--------------");
		System.out.println( board[3] + "  |  " + board[4] + "  |  " + board[5]);
		System.out.println("--------------");
		System.out.println( board[6] + "  |  " + board[7] + "  |  " + board[8]);
	}
	
	//places a specified letter to a specific location and returns a new board
	public static String[] updateBoard(String letter, String[] existingBoard, String updatedVal) {
		for(int i = 0; i<existingBoard.length; i++) {
			if(existingBoard[i].equals(letter)) {
				existingBoard[i] = updatedVal;
			}
		}
		return existingBoard;
	}
	
	//validates input to check if user inputs correct terms
	public static boolean validateBoard(String letter, String[] board) {
		if(letter.equals("x") || letter.equals("y")) {
			return false;
		}
		for(String i:board) {
			if(i.equals(letter)) {
				return true;
			}
		}
		return false;
	}
	
	//checks if anybody had won
	public static boolean checkWin(String[] board) {
		//all rows cols diagonals with index 0
		if(board[0] == board[1] && board[1] == board[2]) {
			return true;
		}
		if(board[0] == board[4] && board[4] == board[8]) {
			return true;
		}
		if(board[0] == board[3] && board[3] == board[6]) {
			return true;
		}
		
		//all rows cols diagonals with index 1
		if(board[1] == board[4] && board[4] == board[7]) {
			return true;
		}
		
		//all rows cols diagonals with index 2
		if(board[2] == board[4] && board[4] == board[6]) {
			return true;
		}
		if(board[2] == board[5] && board[5] == board[8]) {
			return true;
		}
		
		//all rows cols diagonals with index 3
		if(board[3] == board[4] && board[4] == board[5]) {
			return true;
		}
		
		//all rows cols diagonals with index 6
		if(board[6] == board[7] && board[7] == board[8]) {
			return true;
		}
		
		//if nobody won
		return false;
	}
	
	
	//checks if the game is a draw
	public static boolean checkDraw(String[] board) {
		for(String alphabet: board) {
			if(!alphabet.equals("x") && !alphabet.contentEquals("y")) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		//board
		String[] board = new String[]{"a","b","c","d","e","f","g","h","i"};
		
		//user input
		Scanner userinput = new Scanner(System.in);
		
		//responsible for turns
		String letter = "x";
		
		//game introduction with rules
		System.out.println(
				"TIC-TAC-TOE\n"
				+ "----------\n"+
						"Just Your standard rules!"
		);
		System.out.println("----------------------------------------------------------");
		
		//number of moves played
		int numberOfTurns = 1;
		
		//actual game loop
		while(true) {
			//prints the turn number and board and player name
			System.out.println("Turn:" + numberOfTurns);
			System.out.println("");
			displayBoard(board);
			System.out.println(letter + "'s turn!");
			
			//gets user input on where to place piece
			String letterSelected = "";
			while(validateBoard(letterSelected, board) == false) {
				System.out.println("Enter the letter in which you want to place your piece!");
				letterSelected = userinput.next();
			}
			
			//updates the board to place the piece at specified location
			board = updateBoard(letterSelected, board, letter);
			
			//checks if three pieces are in a row, column, or diagonal or if game is a draw
			if(checkWin(board)) {
				displayBoard(board);
				System.out.println("WooHoo! " + letter + " is the winner");
				break;
			}
			if(checkDraw(board)) {
				System.out.println("----------------------------------------------------------");
				displayBoard(board);
				System.out.println("It's a Draw!");
				break;
			}
			
			//switches turns - letters can be changed with NO additional coding
			if(letter.equals("x")) {
				letter = "o";
			} else {
				letter = "x";
			}
			
			//prints a divider and adds one to number of turns.
			System.out.println("----------------------------------------------------------");
			numberOfTurns++;
		}
		
		//closes user input - save data.
		userinput.close();
	}
}
