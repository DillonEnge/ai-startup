package src; /**
 * Created by dillonenge on 2/13/17.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileManipulator {

    public static void storeInput(String input, String previousOutput) throws IOException{
        Path file = Paths.get("Phrases.txt");
        String code = Comms.createCode(previousOutput, input);
        String storedPhrase = code + input;
        List<String> lines = Arrays.asList(storedPhrase);
        if(!stringIsFoundInFile(storedPhrase)) {
            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }

    }

    public static String findOutput(String code) throws FileNotFoundException{
        File phrases = new File("Phrases.txt");
        Scanner file = new Scanner(phrases);
        String returnOutput = null;
        returnOutput = parseFor(code, file);
        file.close();

        return returnOutput;

    }

    public static String parseFor(String code, Scanner file){
        ArrayList<String> temp = new ArrayList<>();
        while(file.hasNextLine()){
            String possibleResponse = file.nextLine().trim();
            if (possibleResponse.length() > 3 && possibleResponse.trim().substring(0, 3).equals(code)) {
                temp.add(possibleResponse.substring(3, possibleResponse.length()));
            }
        }
        Random rdm = new Random();
        if(temp.size() > 0) {
            return temp.get(rdm.nextInt(temp.size()));
        } else return null;
    }

    public static boolean stringIsFoundInFile(String fullString)throws IOException{
        File phrases = new File("Phrases.txt");
        Scanner file = new Scanner(phrases);
        while (file.hasNextLine()){
            if(file.nextLine().equals(fullString)){
                return true;
            }
        }
        return false;
    }

    public static void log(String input){

    }
}
