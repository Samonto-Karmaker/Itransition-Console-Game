import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                List<String> moves = CommandLineParser.parseArgs(args);
                int computerMove_index = random_move(moves.size());
                String computerMove = moves.get(computerMove_index);
                String hmac = HMACGenerator.getHMAC(computerMove);

                System.out.println("HMAC: " + hmac);
                display_menu(moves);

                System.out.print("Enter your move: ");
                String userMove = scanner.nextLine();
                if (userMove.equals("0")) {
                    System.out.println("Have a nice day!");
                    break;
                }
                if (userMove.equals("?")) {
                    TableGenerator.displayHelpTable(moves);
                    continue;
                }
                try {
                    int userMove_index = Integer.parseInt(userMove) - 1;
                    System.out.println("Your move: " + moves.get(userMove_index));
                    System.out.println("Computer move: " + computerMove);
                    int result = GameLogic.getResult(computerMove_index, userMove_index, moves.size());
                    GameLogic.printResult(result);
                } catch (Exception e) {
                    System.out.println("Invalid move: Move must be '?' or number from 0 to " + moves.size());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void display_menu(List<String> moves) {
        System.out.println("Available moves: ");
        System.out.println("0 - Exit");
        for (int i = 1; i <= moves.size(); i++) {
            System.out.println(i + " - " + moves.get(i - 1));
        }
        System.out.println("? - Help");
    }
    private static int random_move(int n) {
        return new SecureRandom().nextInt(n);
    }
}