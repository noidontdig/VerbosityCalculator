package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {

    public static void verbosityCalc(String filePATH){
        double verbosity=0;

        try{
            //Load file into String
            String tales = new Scanner(new File(filePATH)).useDelimiter("\\Z").next();
            //Convert string to string array, easy way to count tokens split by a space
            String[] stringArray = tales.split(" ");
            //getting the size of the array and indirectly the number of words
            int wordCount = stringArray.length;
            //period count initialization
            int periodCount=0;

            // Loop through array and look for periods in the contents.
            // This can produce artifacts but unless I build special exceptions for Mr. Mrs. etc.
            for(int i = 0; i<wordCount; i++){
                if (stringArray[i].contains(".")){
                    periodCount++;
                }
            }
            double dWordCount = (double)wordCount;
            double dperiodCount= (double)periodCount;

            verbosity = dWordCount/dperiodCount;
            String deciVerb = Double.toString(verbosity).substring(0,5);
            System.out.println(deciVerb);


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args){

        verbosityCalc("/Users/c4q-george/ideaprojects/verbositycalculator/moby.txt");
    }

}
