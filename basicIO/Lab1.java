import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Basic input/output scanner. Takes the input and reprints string by string 
 * as well as counting how many lines/words/chars are input in total by the user.
 *
 * @author Jasmine Williams
 * @version 1.31.23
 */
public class Lab1
{
    /**
     * The main method - entry point of the assignment.
     *
     * @param  args  Command line arguments.
     * @throws Exception if any error occurs during file operations.
     */
    public static void main (String[] args) throws Exception{ 
        //there should be no exception to exist, therefore we throw exception

        //scans whatever the user types, will check the line
        Scanner one = new Scanner(System.in);
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0; 
        FileWriter fwObject = new FileWriter("Lab01.txt");        
        BufferedWriter bwWriter = new BufferedWriter(fwObject);

        // variable that stores the value of each line input by user
        String inputLine = one.nextLine();

        System.err.println("entering loop:");
        while(!inputLine.equals("")){
            // scans whatever the user types, but will focus on the words
            Scanner two = new Scanner(inputLine);
            lineCount++; //while loop indicates that it will increase by one
            fwObject.write(inputLine + "\n");
            System.err.println("continuing to loop >>"+inputLine+"<<");
            do{
                // variable that rescans and stores the value of each string 
                String inputWord = two.next();
                // do while loop indicate that each word will increase this by one 
                wordCount++;
                charCount += inputWord.length();
                // outputs each string that scanner two picks up
                System.out.println(inputWord); 

            }while(two.hasNext());
            inputLine = one.nextLine();
        }
        System.err.println("exiting loop.");
        // ensures that all the white space is accounted for since there will not be whitespace
        // at the end of each sentence
        charCount += wordCount-lineCount;

        System.out.println("=============================");
        System.out.println("Line Count: "+lineCount);
        System.out.println("Word Count: "+wordCount);
        System.out.println("Char Count: "+charCount);

        fwObject.write("============================="+ "\n"+
            "Line Count: "+lineCount + "\n"+
            "Word Count: "+wordCount + "\n"+
            "Char Count: "+charCount + "\n");
        // indicates that the transcribed file has come to an end
        fwObject.close(); 
        bwWriter.close();  
    } 
}
