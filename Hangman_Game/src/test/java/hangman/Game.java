package hangman;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private int guesses = 10;
	private static Scanner input = new Scanner(System.in);

	public void start() throws IOException {
		
		String names[];
		names = new String[] {"Erik","Love","Think"};
		
		int rnd = new Random().nextInt(names.length);
		String secretWord = names[rnd]; 
		
		
		String dashes = new String(new char[secretWord.length()]).replace("\0", "-");
		System.out.println("================================================================");
		System.out.println("========================== GAME START: =========================");
		System.out.println("================================================================");
		specificWord(dashes);
		String choice = getChoice(dashes);
		StringBuilder incorrectChar = new StringBuilder();

		while (!choice.equals("C") && guesses > 0) {
			switch (choice) {
			case "A":

				while (guesses > 0) {

					StringBuilder str = null;
					if (!dashes.equals(secretWord)) {
						System.out.print("Enter letter :");
					}
					char c = input.next().charAt(0);
					if (secretWord.contains(c + "")) {
						for (int i = 0; i < secretWord.length(); i++) {
							if (secretWord.charAt(i) != dashes.charAt(i) && secretWord.charAt(i) == c) {
								str = new StringBuilder(dashes);
								str.setCharAt(i, c);
								dashes = str.toString();
							}
						}
						specificWord(dashes);
					} else {
						incorrectChar.append(c + ",");
						guesses--;
						getOpportunities();
					}

					if (dashes.equals(secretWord)) {
						System.out.println("\n===============================================================");
						System.out.println("============================ YOU WIN ==========================");
						System.out.println("===============================================================");
						break;
					} else {
						if (guesses == 0) {
							System.out.println("\n==============================================================");
							System.out
									.println("===>>>           INCORRECT LETTERS : [" + incorrectChar + "]          ");
							System.out.println("==============================================================");
							specificWord(secretWord);
							gameOver();
							break;
						}
					}
				}
				break;
			case "B":
				String c = null;
				Boolean win = false;
				
				while (guesses > 0 && !win) {

					StringBuilder str = null;
					System.out.print("Enter word :");

					c = input.next();
					if (secretWord.toUpperCase().equals(c.toUpperCase())) {
						System.out.println("\n===============================================================");
						System.out.println("============================ YOU WIN ==========================");
						System.out.println("===============================================================");
						win = true;
						guesses=0;
						break;
					} else {
						guesses--;
						getOpportunities();
					}
				}
				if (guesses == 0 && !secretWord.toUpperCase().equals(c.toUpperCase())) {
					gameOver();
					break;
				}
				break;

			}
		}

		System.out.println("Good Bye !");
	}

	private void specificWord(String dashes) {
		System.out.println("\n==============================================================");
		System.out.println("===>>>           SPECIFIC WORD : [" + dashes + "]          ");
		System.out.println("==============================================================\n");
	}

	private void getOpportunities() {
		System.out.println("*******************************************");
		System.out.println("**        " + guesses + " opportunities remain         **");
		System.out.println("*******************************************");
	}

	private static String getChoice(String dashes) {

		String choice = "";

		while (!choice.equals("A") && !choice.equals("B") && !choice.equals("C")) {

			System.out.println("[A]. Guess for a specific letter ");
			System.out.println("[B]. Guess for the whole word ");
			System.out.println("[C]. Exit");
			if (input.hasNext()) {
				choice = input.next();
			}
			choice = choice.toUpperCase();
		}
		return choice;
	}

	private void gameOver() {
		System.out.println("===============================================================");
		System.out.println("========================== GAME OVER  =========================");
		System.out.println("===============================================================");
	}


}
