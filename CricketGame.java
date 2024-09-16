
package om;

import java.util.Random;
import java.util.Scanner;

public class CricketGame {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalOvers = 2;
		int ballsPerOver = 6;
		int totalScore = 0;
		int totalWickets = 0;

		System.out.println("Welcome to the 2-Over Cricket Game!");

		for (int over = 1; over <= totalOvers; over++) {
			System.out.println("Over " + over + ":");
			for (int ball = 1; ball <= ballsPerOver; ball++) {
				System.out.println("Press Enter to bowl...");
				scanner.nextLine();

				int run = random.nextInt(8); // Random score between 0 to 7 (7
												// representing a wicket)
				if (run == 7) {
					totalWickets++;
					System.out
							.println("Wicket! Total Wickets: " + totalWickets);
				} else {
					totalScore += run;
					System.out.println("Runs scored: " + run
							+ " | Total Score: " + totalScore);
				}

				// End the game if all wickets are down
				if (totalWickets == 10) {
					System.out.println("All wickets down! Innings Over.");
					break;
				}
			}

			if (totalWickets == 10) {
				break;
			}
		}

		System.out.println("Innings Complete!");
		System.out.println("Final Score of IND Vs PAK = " + totalScore + "/" + totalWickets);
	}
}
