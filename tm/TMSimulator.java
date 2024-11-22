package tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Austin Hunt
 * The TMSimulator class simulates the execution of a Turing Machine.
 */
public class TMSimulator {

    /**
     * The main method to run the Turing Machine simulation.
     *
     * @param args the command line arguments, where args[0] is the file path to the Turing Machine definition and input
     */
    public static void main(String[] args) {
        try {
            TM tm = createTMFromInput(args[0]);
            System.out.println(tm.simulateTM());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        }
    }

    /**
     * Creates a Turing Machine from the input file.
     *
     * @param filePath the path to the input file
     * @return the Turing Machine
     * @throws FileNotFoundException if the file is not found
     */
    private static TM createTMFromInput(String filePath) throws FileNotFoundException {
        Scanner file = new Scanner(new File(filePath));
        String input = "0";

        int numStates = file.nextInt();
        int numSymbols = file.nextInt();

        LinkedList<String> transitionList = new LinkedList<>();
        String currLine;
        file.nextLine();
        while(file.hasNextLine()){
            currLine = file.nextLine();
            if(currLine.charAt(1) == ',') transitionList.add(currLine);
            else{
                input = currLine;
                break;
            }
        }


        file.close();
        return new TM(numStates, numSymbols, transitionList, input);
    }


}