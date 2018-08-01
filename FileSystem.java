import java.util.*;

public class FileSystem {
    public static void main (String[] args) {
        HashMap<String, INode> filetoINode = new HashMap<>(); // key: filename, value: iNode

        boolean[] usedStatus = new boolean[100]; // false if unused. true if used

        Scanner in = new Scanner(System.in);
        String input = in.next();
        readInput(input);

        for (int i = 0; i < usedStatus.length; i++) {
            usedStatus[i] = false;
        }

        input = in.next();
        readCommand(input);




    }

    public static void readInput (String input) {
        if (input.equals("FM")) {
            // do stuff
        }

        if (input.equals("q")) {
            // quit
        }
    }

    public static void readCommand(String input) {
        if (input.startsWith("DF")) { // delete file

        }

        if (input.startsWith("DB")) { // delete block

        }

        if (input.startsWith("NF")) { //  new file

        }
        if (input.startsWith("MF")) { // add block

        }


    }
}
