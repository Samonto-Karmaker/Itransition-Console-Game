import java.util.List;

public class TableGenerator {
    public static void displayHelpTable(List<String> moves) {
        int totalMoves = moves.size();

        // Print Header
        System.out.print(padRight("PC/User", 12));
        for (String move : moves) {
            System.out.print(padRight(move, 12));
        }
        System.out.println();

        // Print Rows
        for (int i = 0; i < totalMoves; i++) {
            System.out.print(padRight(moves.get(i), 12));
            for (int j = 0; j < totalMoves; j++) {
                if (i == j) System.out.print(padRight("Draw", 12));
                else {
                   int result = GameLogic.getResult(i, j, totalMoves);
                   if (result == 1) System.out.print(padRight("Win", 12));
                   else System.out.print(padRight("Lose", 12));
                }
            }
            System.out.println();
        }
    }

    private static String padRight(String s, int width) {
        return String.format("%-" + width + "s", s);
    }
}
