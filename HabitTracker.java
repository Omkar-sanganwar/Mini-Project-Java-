package om;

import java.util.Scanner;

public class HabitTracker {

	private static final int TOTAL_DAYS = 21;
	private boolean[] progress = new boolean[TOTAL_DAYS];

	public void markDay(int day) {
		if (day < 1 || day > TOTAL_DAYS) {
			System.out
					.println("Invalid day. Please enter a number between 1 and "
							+ TOTAL_DAYS);
			return;
		}
		progress[day - 1] = true;
		System.out.println("Day " + day + " marked as completed.");
	}

	public void generateReport() {
		int completedDays = 0;
		for (boolean day : progress) {
			if (day) {
				completedDays++;
			}
		}
		double completionRate = (completedDays / (double) TOTAL_DAYS) * 100;

		System.out.println("Habit Tracker Report:");
		System.out.println("Total Days: " + TOTAL_DAYS);
		System.out.println("Completed Days: " + completedDays);
		System.out.println("Completion Rate: "
				+ String.format("%.2f", completionRate) + "%");

		System.out.print("Progress: ");
		for (boolean day : progress) {
			System.out.print((day ? "*" : ".") + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HabitTracker habitTracker = new HabitTracker();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Mark Day as Completed");
			System.out.println("2. Generate Report");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();

			if (choice == 1) {
				System.out
						.print("Enter day number to mark as completed (1-21): ");
				int day = scanner.nextInt();
				habitTracker.markDay(day);
			} else if (choice == 2) {
				habitTracker.generateReport();
			} else if (choice == 3) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}
}
