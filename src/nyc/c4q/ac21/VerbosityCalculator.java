package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args){

       try{
           //Load file into String
           String tales = new Scanner(new File("/Users/c4q-george/IdeaProjects/VerbosityCalculator/tales.txt")).useDelimiter("\\Z").next();
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

           double verbocity = wordCount/periodCount;

           System.out.println(verbocity);


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
