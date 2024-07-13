public class GameLogic {
    /**
     * Determines the result of the game based on the computer's move, the user's move, and the total number of moves.
     *
     * @param computerMove the index of the computer's move
     * @param userMove the index of the user's move
     * @param totalMoves the total number of possible moves
     * @return an integer indicating the result: -1 if the computer wins, 1 if the user wins, 0 if it's a draw
     */
    public static int getResult(int computerMove, int userMove, int totalMoves) {
        // Calculate half of the total number of moves (rounded down)
        int half = totalMoves / 2;

        // Determine the result using a circular comparison:
        // - Calculate the difference between the user's move and the computer's move, adjusted by half the total moves.
        // - Normalize this difference using modulo to ensure it wraps around the circular list of moves.
        // - Subtract half the total moves to account for the winning/losing positions.
        // - Use Integer.signum to return -1 if the computer wins, 1 if the user wins, or 0 if it's a draw.
        return Integer.signum((userMove - computerMove + half + totalMoves) % totalMoves - half);
    }

    public static void printResult(int result) {
        if (result == -1) System.out.println("You lose!");
        else if (result == 1) System.out.println("You win!");
        else System.out.println("Draw");
    }
}
