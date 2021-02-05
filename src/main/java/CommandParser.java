import java.util.List;
import java.util.Scanner;

public class CommandParser {
    public String[] parse(Scanner in) {
        return in.nextLine().split(" " , 2);
    }
}
