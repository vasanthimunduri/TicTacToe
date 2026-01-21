#Tic Tac Toe Game – Working Description

The Tic Tac Toe game is a command-line-based application developed using Java. It allows two players to play the game by taking turns on a 3×3 grid. One player uses the symbol X, and the other uses O. The game continues until one player wins or the game ends in a draw.

When the program starts, instructions are displayed to explain how the game should be played. The game then asks both players to enter their names. Player 1 is assigned the symbol X, and Player 2 is assigned the symbol O. An empty 3×3 game board is initialized before the game begins.

The game board is represented using a two-dimensional character array. Each cell in the board is initially empty. Players enter their move by providing the row and column numbers, which range from 0 to 2. After every valid move, the board is updated and displayed to show the current state of the game.

The game follows a turn-based approach. Player X always gets the first turn, and the turn alternates between the two players after each valid move. Input validation is implemented to ensure that the entered row and column values are within the valid range and that the selected cell is not already occupied. If an invalid move is entered, the player is prompted to enter the move again.

After each move, the program checks whether a winning condition is met. A player wins if three of their symbols appear consecutively in a row, column, or diagonal. If a winning condition is detected, the game announces the winner and ends.

If all nine cells are filled and no player satisfies the winning condition, the game is declared a draw. A message is displayed indicating that the game has ended without a winner.

Once the game is completed, the program asks whether the players want to play another round. If the players choose to continue, the board is reset and a new game starts. Otherwise, the program terminates.
