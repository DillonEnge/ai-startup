import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileManipulator {
	
	public static void storeInput(String input, String previousOutput) throws IOException{
		Path file = Paths.get("Phrases.txt");
		String code = Comms.createCode(input, previousOutput);
		String storedPhrase = code + input;
		if(!findOutput(code).equals(code + storedPhrase)){
			List<String> lines = Arrays.asList(storedPhrase);
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
		String temp = null;
		Random rdm = new Random();
		rdm.nextInt(3);
		while(file.hasNextLine()){
			String possibleResponse = file.nextLine().trim();
			if(possibleResponse.length() > 2 && possibleResponse.trim().substring(0, 2).equals(code) && rdm.nextInt(2) == 1){
				 temp = possibleResponse.substring(2, possibleResponse.length());
				 break;
			}
		}
		return temp;
	}
}
