package src; /**
 * Created by dillonenge on 2/13/17.
 */

import java.io.IOException;


public class MainDriver {
    static int timesLooped = 0;
    static String systemOutput = "Hi.";
    static String userInput;
    public static void main(String[] args) throws IOException {
        System.out.println("Rules for using ai: " + "\n"
                +  "Always type in full, complete sentences " + "\n"
                +  "avoiding any complex sentances at the beginning" + "\n"
                +  "and making sure to end your sentances" + "\n"
                +  "using the appropriate character ex. ?!." + "\n");
        while(true){
            userInput = Comms.waitForInput().trim();
            if(timesLooped != 0 && userInput.equals("stop")){
                break;
            }
            if(userInput.equals("incorrect")) {
                System.out.println("What would've made sense?");
                FileManipulator.storeInput(Comms.waitForInput().trim(), systemOutput);
                continue;
            }
            if(userInput.equals("alt")){
                System.out.println("What could be an alternative response to this?");
                FileManipulator.storeInput(Comms.waitForInput().trim(), systemOutput);
                continue;
            }
            if(FileManipulator.findOutput(Comms.createCode(userInput, systemOutput)) == null) {
                System.out.println("What would be a proper response to this?");
                systemOutput = Comms.waitForInput().trim();
                System.out.println(systemOutput);
                FileManipulator.storeInput(systemOutput, userInput);
            } else {
                systemOutput = FileManipulator.findOutput(Comms.createCode(userInput, systemOutput));
                System.out.println("Ai: " + systemOutput);
                FileManipulator.storeInput(userInput, systemOutput);
            }

            timesLooped++;
        }

    }

}

