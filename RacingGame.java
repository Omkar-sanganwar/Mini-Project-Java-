package om;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

	private static final int TRACK_LENGTH = 50; // Length of the race track
	private int player1Position;
	private int player2Position;
	private Random random;

	public RacingGame() {
		player1Position = 0;
		player2Position = 0;
		random = new Random();
	}

	private void printTrack() {
		System.out.println("Track:");
		for (int i = 0; i < TRACK_LENGTH; i++) {
			if (i == player1Position && i == player2Position) {
				System.out.print("B"); // Both players in the same position
			} else if (i == player1Position) {
				System.out.print("1"); // Player 1
			} else if (i == player2Position) {
				System.out.print("2"); // Player 2
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	private void movePlayer(int player) {
		int move = random.nextInt(3) + 1; // Random move between 1 and 3
		if (player == 1) {
			player1Position += move;
			if (player1Position > TRACK_LENGTH)
				player1Position = TRACK_LENGTH;
		} else {
			player2Position += move;
			if (player2Position > TRACK_LENGTH)
				player2Position = TRACK_LENGTH;
		}
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		boolean gameRunning = true;

		while (gameRunning) {
			printTrack();
			System.out.println("Press Enter to advance both players...");
			scanner.nextLine(); // Wait for user input

			movePlayer(1);
			movePlayer(2);

			if (player1Position >= TRACK_LENGTH
					&& player2Position >= TRACK_LENGTH) {
				printTrack();
				System.out.println("It's a draw!");
				gameRunning = false;
			} else if (player1Position >= TRACK_LENGTH) {
				printTrack();
				System.out.println("Player 1 wins!");
				gameRunning = false;
			} else if (player2Position >= TRACK_LENGTH) {
				printTrack();
				System.out.println("Player 2 wins!");
				gameRunning = false;
			}
		}

		scanner.close();
	}

	public static void main(String[] args) {
		RacingGame game = new RacingGame();
		game.playGame();
	}
}

