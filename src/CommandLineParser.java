import java.util.*;

public class CommandLineParser {

    public static List<String> parseArgs(String[] args) {
        validateArgsList(args);
        return new ArrayList<>(Arrays.asList(args));
    }

    private static void validateArgsList(String[] args) {
        if (args == null || args.length == 0) throw new IllegalArgumentException("Error: no moves given");
        if (args.length < 3) throw new IllegalArgumentException("Error: at least three moves required");
        if (args.length % 2 == 0) throw new IllegalArgumentException("Error: even number of moves required");

        Set<String> set = new HashSet<>(Arrays.asList(args));
        if (set.size() != args.length) throw new IllegalArgumentException("Error: all moves must be unique");
    }
}
