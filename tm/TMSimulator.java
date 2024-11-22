package tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TMSimulator {

    public static void main(String[] args) {
        try {
            TM tm = createTMFromInput(args[0]);
            System.out.println((tm.fullSimulate()?"Halt and Accept" : "Reject"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            return;
        }
    }

    private static TM createTMFromInput(String filePath) throws FileNotFoundException {
        Scanner file = new Scanner(new File(filePath));

        int numStates = file.nextInt();
        int numSymbols = file.nextInt();

        LinkedList<String> transitionList = new LinkedList<>();
        String currLine;
        String input = "";
        file.nextLine();
        while(file.hasNextLine()){
            currLine = file.nextLine();
            if(currLine.length() > 1 && currLine.charAt(1) == ',') transitionList.add(currLine);
            else input = currLine;
        }

        file.close();
        return new TM(numStates, numSymbols, transitionList, input);
    }
}
