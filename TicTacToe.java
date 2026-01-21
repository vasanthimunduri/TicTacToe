import java.util.Scanner;

public class TicTacToe {

    // 3x3 character array to store the game board
    static char[][] board = new char[3][3];

    // Scanner object to take input from users
    static Scanner sc = new Scanner(System.in);

    // Variables to store player names
    static String playerX;
    static String playerO;

    public static void main(String[] args) {

        // Display game title and instructions
        System.out.println("=== Welcome to Tic Tac Toe ===");
        System.out.println("Instructions:");
        System.out.println("Enter row and column values between 0 and 2");
        System.out.println("Example input: 1 2");
        System.out.println();

        // Taking Player 1 name (X)
        System.out.print("Enter Player 1 name (X): ");
        playerX = sc.nextLine();

        // Taking Player 2 name (O)
        System.out.print("Enter Player 2 name (O): ");
        playerO = sc.nextLine();

        boolean playAgain;

        // Loop allows the game to restart if players choose yes
        do {
            initializeBoard(); // Reset board before every game
            playGame();        // Start the game

            // Ask players if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
            sc.nextLine(); // Clear input buffer
        } while (playAgain);

        // Exit message
        System.out.println("Game ended. Thank you for playing!");
    }

    // This method initializes the board with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    // This method controls the overall game flow
    static void playGame() {
        char currentPlayer = 'X'; // X always starts first
        int moves = 0;            // Counts number of moves
        boolean gameOver = false;

        // Game continues until someone wins or game becomes draw
        while (!gameOver) {
            printBoard(); // Display current board

            // Decide current player's name based on symbol
            String currentPlayerName =
                    (currentPlayer == 'X') ? playerX : playerO;

            // Show whose turn it is
            System.out.println(currentPlayerName + "'s turn (" + currentPlayer + ")");

            int row, col;

            // Loop until player enters a valid move
            while (true) {
                System.out.print("Enter row and column: ");
                row = sc.nextInt();
                col = sc.nextInt();

                // Check whether the move is valid
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer; // Place symbol on board
                    break;
                } else {
                    System.out.println("Invalid move. Cell is either occupied or out of range.");
                }
            }

            moves++; // Increment move count

            // Check if current player has won
            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("WINNER: " + currentPlayerName);
                gameOver = true;
            }
            // If all cells are filled and no winner, game is draw
            else if (moves == 9) {
                printBoard();
                System.out.println("GAME DRAW. No player won.");
                gameOver = true;
            }
            // Switch player turn
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    // This method checks whether the entered move is valid
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&          // Row should be in range
               col >= 0 && col < 3 &&          // Column should be in range
               board[row][col] == ' ';         // Cell should be empty
    }

    // This method checks all possible winning conditions
    static boolean checkWinner(char player) {

        // Check all rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player &&
                 board[i][1] == player &&
                 board[i][2] == player) ||
                (board[0][i] == player &&
                 board[1][i] == player &&
                 board[2][i] == player))
                return true;
        }

        // Check both diagonals
        return (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) ||
               (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player);
    }

    // This method prints the current state of the game board
    static void printBoard() {
        System.out.println("\nCurrent Board:");
        System.out.println("  0   1   2");

        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
        System.out.println();
    }
}
