package om;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		@SuppressWarnings("unused")
		String userInput;
		boolean keepRunning = true;

		while (keepRunning) {
			System.out.println("Simple Calculator");
			System.out.println("Select operation:");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");

			System.out.print("Enter choice (1-5): ");
			int choice = scanner.nextInt();

			if (choice == 5) {
				keepRunning = false;
				System.out.println("Exiting the calculator.");
				break;
			}

			System.out.print("Enter first number: ");
			double num1 = scanner.nextDouble();
			System.out.print("Enter second number: ");
			double num2 = scanner.nextDouble();

			double result = 0;
			switch (choice) {
			case 1:
				result = num1 + num2;
				System.out.println("Result: " + result + "\n");
				break;
			case 2:
				result = num1 - num2;
				System.out.println("Result: " + result + "\n");
				break;
			case 3:
				result = num1 * num2;
				System.out.println("Result: " + result + "\n");
				break;
			case 4:
				if (num2 != 0) {
					result = num1 / num2;
					System.out.println("Result: " + result + "\n");
				} else {
					System.out
							.println("Error: Division by zero is not allowed.");
				}
				break;
			default:
				System.out
						.println("Invalid choice. Please select a valid operation.");
				break;
			}
		}

		scanner.close();
	}
}
