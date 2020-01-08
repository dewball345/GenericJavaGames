import java.util.Scanner;
import java.util.Random;

public class GuesserGame {
	//determines if guess was right and returns true/false and prints output based on guess
	public static boolean outputGuess(int guess, int guessedNum) {
		if(guess > guessedNum) {
			System.out.println("Your guess was too high!");
		} else if(guess < guessedNum) {
			System.out.println("Your guess was too low!");
		} else {
			System.out.println("Your guess was right");
			return true;
		}
		return false;
	}
	
	//determines if user wants to play again
	public static boolean willPlay(String output){
		if(output.equals("y")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		//initialization
		System.out.println("GUESS THE NUMBER\n");
		System.out.println("A game by abhiraam eranti");
		Scanner userInput = new Scanner(System.in);
		Random random = new Random();
		int compNum = Math.abs(random.nextInt(999)+1);
		
		//main game loop
		while(true) {
			System.out.print("Enter a number: ");
			int guess = userInput.nextInt();
			if(outputGuess(guess, compNum)) {
				System.out.print("Do you want to play again? [y/any other key]: ");
				String willPlayOutput = userInput.next();
				if(willPlay(willPlayOutput)) {
					System.out.println("Okay Then!");
				} else {
					break;
				}
			} 
		}
		System.out.print("DONE!");
		userInput.close();
	}

}
