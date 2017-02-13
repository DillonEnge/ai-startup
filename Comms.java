import java.util.Scanner;

public class Comms {
	static Scanner kb = new Scanner(System.in);
	public static String waitForInput(){
		String input = kb.nextLine();
		return input;
		
	}
	
	public static String createCode(String input, String previousOutput){
		String code = null;
		if(MainDriver.timesLooped != 0){
			code = getLastCharacter(input) + getLastCharacter(previousOutput);
		}else {
			code = "11";
		}
		return code;
		
	}
	
	public static String getLastCharacter(String s){
		return s.substring(s.length()-1, s.length());
	}
}
