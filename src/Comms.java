package src; /**
 * Created by dillonenge on 2/13/17.
 */
import java.util.Scanner;

public class Comms {
    static Scanner kb = new Scanner(System.in);

    public static String waitForInput() {
        String input = kb.nextLine();
        return input;

    }

    public static String createCode(String input, String previousOutput) {
        String code;
        code = getLastCharacter(previousOutput) + getLastCharacter(input) + assessSentance(input);
        return code;

    }

    public static String getLastCharacter(String s) {
        return s.substring(s.length() - 1, s.length());
    }

    public static String assessSentance(String input){
        //TODO write body
        return null;
    }

    public static boolean parseFor(String keyWordType, String input){
        //TODO write body scanning premade files of different types and checking if the input is in the file
        return true;
    }
}
