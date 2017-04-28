package src; /**
 * Created by dillonenge on 2/13/17.
 */
import java.util.Scanner;

public class Comms {
    static Scanner kb;

    public static String waitForInput() {
        kb = new Scanner(System.in);
        System.out.print("You: ");
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

    public static char assessSentance(String input){
        kb = new Scanner(input);
        while(kb.hasNext()){
            String word = kb.next();
            if(word.equalsIgnoreCase("where")){
                return '@';
            } if(word.equalsIgnoreCase("what")){
                return '?';
            } if(word.equalsIgnoreCase("when")){
                return ':';
            } if(word.equalsIgnoreCase("who")){
                return '*';
            } if(word.equalsIgnoreCase("how")){
                return '%';
            }

        }
        return '-';
    }

    public static boolean parseFor(String keyWordType, String input){
        //TODO write body scanning premade files of different types and checking if the input is in the file
        return true;
    }
}
