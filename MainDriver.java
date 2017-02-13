import java.io.IOException;


public class MainDriver {
	static int timesLooped = 0;
	static String systemOutput = "";
	static String userInput = "";
	public static void main(String[] args) throws IOException {
		System.out.println("Rules for using ai: " + "\n" +  "Always type in full, complete sentances " + "\n" +  "avoiding any complex sentances at the beginning" + "\n" +  "and making sure to end your sentances" + "\n" +  "using the appropriate character ex. ?!." + "\n");
		while(!userInput.equals("stop")){
			if(FileManipulator.findOutput(Comms.createCode(userInput, systemOutput)) == null){
				System.out.println("What would be a proper response to this?");
				systemOutput = Comms.waitForInput().trim();
			} else {
				systemOutput = FileManipulator.findOutput(Comms.createCode(userInput, systemOutput));
				System.out.println(systemOutput);
				userInput = Comms.waitForInput().trim();
			}
			if(userInput.equals("stop")){
				continue;
			}
			if(userInput.equals("incorrect")){
				System.out.println("What would've made sense?");
				FileManipulator.storeInput(Comms.waitForInput().trim(), systemOutput);
				continue;
			}
			
			FileManipulator.storeInput(userInput, systemOutput);
			timesLooped++;
		}
	}

}
