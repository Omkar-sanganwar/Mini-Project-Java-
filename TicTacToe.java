package om;

import java.util.Scanner;

public class TicTacToe {

	private static final int BOARD_SIZE = 3;
	private char[][] board;
	private char currentPlayer;

	public TicTacToe() {
		board = new char[BOARD_SIZE][BOARD_SIZE];
		currentPlayer = 'X';
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = ' ';
			}
		}
	}

	private void printBoard() {
		System.out.println("  1 2 3");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j]);
				if (j < BOARD_SIZE - 1)
					System.out.print("|");
			}
			System.out.println();
			if (i < BOARD_SIZE - 1) {
				System.out.println("  -----");
			}
		}
	}

	private boolean isBoardFull() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkWin() {
		// Check rows
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer
					&& board[i][2] == currentPlayer) {
				return true;
			}
		}
		// Check columns
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer
					&& board[2][i] == currentPlayer) {
				return true;
			}
		}
		// Check diagonals
		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer
				&& board[2][2] == currentPlayer) {
			return true;
		}
		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer
				&& board[2][0] == currentPlayer) {
			return true;
		}
		return false;
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			printBoard();
			System.out.println("Player " + currentPlayer + "'s turn.");
			System.out.print("Enter row and column (1-3) separated by space: ");
			int row = scanner.nextInt() - 1;
			int col = scanner.nextInt() - 1;

			if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
				System.out
						.println("Invalid input. Please enter numbers between 1 and 3.");
				continue;
			}

			if (board[row][col] != ' ') {
				System.out
						.println("Cell already occupied. Choose another cell.");
				continue;
			}

			board[row][col] = currentPlayer;

			if (checkWin()) {
				printBoard();
				System.out.println("Player " + currentPlayer + " wins!");
				break;
			}

			if (isBoardFull()) {
				printBoard();
				System.out.println("It's a draw!");
				break;
			}

			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		}
		scanner.close();
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.playGame();
	}
}
